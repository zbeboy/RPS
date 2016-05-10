package com.RPS.controller;

import com.RPS.data.AjaxData;
import com.RPS.model.EnterpriseDto;
import com.RPS.model.ResumeDto;
import com.RPS.model.ResumeDtoWithBLOBs;
import com.RPS.model.UsersDto;
import com.RPS.service.EnterpriseService;
import com.RPS.service.MailService;
import com.RPS.service.ResumeService;
import com.RPS.service.UsersService;
import com.RPS.util.MD5Utils;
import com.RPS.vo.EnterprisePasswordVo;
import com.RPS.vo.FirmWriterVo;
import com.RPS.vo.PersonalPasswordVo;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * Created by lenovo on 2016-05-09.
 */
@Controller
public class EnterpriseController {

    @Resource
    private EnterpriseService enterpriseService;

    @Resource
    private UsersService usersService;

    @Resource
    private MailService mailService;

    @Resource
    private ResumeService resumeService;

    /**
     * 填写信息
     * @return
     */
    @RequestMapping("/enterprise/firmWriter")
    public String firmWriter(){
        return "enterprise/firmwriter";
    }

    /**
     * 更新企业信息
     * @param firmWriterVo
     * @param session
     * @return
     */
    @RequestMapping("/enterprise/updateFirmWriter")
    public String saveFirmWriter(FirmWriterVo firmWriterVo, HttpSession session){
        EnterpriseDto enterpriseDto = enterpriseService.findByUsername(usersService.getUserBySession().getUsername());
        if(!ObjectUtils.isEmpty(enterpriseDto)){
            enterpriseDto.setRealName(firmWriterVo.getRealName());
            enterpriseDto.setEnterpriseAddress(firmWriterVo.getEnterpriseAddress());
            enterpriseDto.setEnterpriseIndustry(firmWriterVo.getEnterpriseIndustry());
            enterpriseDto.setEnterpriseIntroduce(firmWriterVo.getEnterpriseIntroduce());
            enterpriseDto.setEnterprisePerson(firmWriterVo.getEnterprisePerson());
            enterpriseDto.setEnterprisePhone(firmWriterVo.getEnterprisePhone());
            enterpriseDto.setEnterpriseScale(firmWriterVo.getEnterpriseScale());
            enterpriseService.update(enterpriseDto);
            session.setAttribute("users",enterpriseDto);
        }
        return "redirect:/enterprise/firmWriter";
    }

    /**
     * 修改密码
     * @return
     */
    @RequestMapping("enterprise/firmPassword")
    public String firmPassword(){
        return "enterprise/firmpassword";
    }

    /**
     * 更新密码
     * @param enterprisePasswordVo
     * @param bindingResult
     * @return
     */
    @RequestMapping("/enterprise/updateEnterprisePassword")
    public String updatePersonalPassword(@Valid EnterprisePasswordVo enterprisePasswordVo, BindingResult bindingResult){
        if(!bindingResult.hasErrors()){
            UsersDto usersDto = usersService.findByUsername(usersService.getUserBySession().getUsername());
            usersDto.setPassword(MD5Utils.md5(enterprisePasswordVo.getOkPassword()));
            usersService.update(usersDto);
        }
        return "redirect:/enterprise/firmPassword";
    }

    /**
     * 发送面试
     * @param resumeId
     * @return
     */
    @RequestMapping("/enterprise/sendInterview")
    @ResponseBody
    public AjaxData sendInterview(@RequestParam("resumeId") int resumeId){
        UsersDto usersDto = usersService.getUserBySession();
        if(!ObjectUtils.isEmpty(usersDto)){
            ResumeDtoWithBLOBs resumeDtoWithBLOBs = resumeService.findById(resumeId);
            EnterpriseDto enterpriseDto = enterpriseService.findByUsername(usersDto.getUsername());
            mailService.sendEmail(resumeDtoWithBLOBs.getUsername(),usersDto.getUsername(),
                    "面试通知",
                    "您好!\n 我是:"+enterpriseDto.getRealName()+"公司的HR,现邀请您到我公司面试，面试地址:"+enterpriseDto.getEnterpriseAddress()+"",false,false);
            return new AjaxData().success().msg("发送成功!");
        } else {
            return new AjaxData().fail().msg("请先登录!");
        }
    }
}
