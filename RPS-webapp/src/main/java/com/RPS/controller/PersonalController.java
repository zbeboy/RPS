package com.RPS.controller;

import com.RPS.data.AjaxData;
import com.RPS.model.PersonalDto;
import com.RPS.model.ResumeDtoWithBLOBs;
import com.RPS.model.UsersDto;
import com.RPS.service.PersonalService;
import com.RPS.service.ResumeService;
import com.RPS.service.UploadService;
import com.RPS.service.UsersService;
import com.RPS.util.MD5Utils;
import com.RPS.vo.Personal;
import com.RPS.vo.PersonalPasswordVo;
import com.RPS.vo.PersonalWriterVo;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/5/9.
 */
@Controller
public class PersonalController {

    @Resource
    private UploadService uploadService;

    @Resource
    private PersonalService personalService;

    @Resource
    private UsersService usersService;

    @Resource
    private ResumeService resumeService;

    /**
     * 普通用户中心
     * @return
     */
    @RequestMapping("/personal/personalCenter")
    public String personalCenter(){
        return "personal/personalcenter";
    }

    /**
     * 上传个人头像
     * @param multipartHttpServletRequest
     * @param request
     * @return
     */
    @RequestMapping("/personal/uploadPhoto")
    @ResponseBody
    public AjaxData upload(MultipartHttpServletRequest multipartHttpServletRequest, HttpServletRequest request) {
        String realPath = request.getSession().getServletContext().getRealPath("/");
        String lastPath = uploadService.upload(multipartHttpServletRequest, realPath + File.separator + "files" + File.separator + "img", request.getRemoteAddr());
        Map<String, Object> map = new HashMap<>();
        lastPath = lastPath .replaceAll("\\\\","/");
        lastPath = "/files/img"+lastPath.substring(lastPath.lastIndexOf("/"));
        map.put("lastPath", lastPath);
        return new AjaxData().success().mapData(map);
    }

    /**
     * 更新用户信息
     * @param personal
     * @return
     */
    @RequestMapping("/personal/updatePersonal")
    public String updatePersonal(Personal personal,HttpServletRequest request){
        PersonalDto personalDto = personalService.findByUsername(usersService.getUserBySession().getUsername());
        personalDto.setRealName(personal.getRealName());
        personalDto.setHeadImgUrl(personal.getHeadImgUrl());
        personalDto.setSex(personal.getSex());
        personalService.update(personalDto);
        HttpSession session = request.getSession();
        session.setAttribute("users",personalDto);
        return "redirect:/personalCenter";
    }

    /**
     * 修改密码
     * @return
     */
    @RequestMapping("/personal/personalPassword")
    public String personalPassword(){
        return "personal/personalpassword";
    }

    /**
     * 更新密码
     * @param personalPasswordVo
     * @param bindingResult
     * @return
     */
    @RequestMapping("/personal/updatePersonalPassword")
    public String updatePersonalPassword(@Valid PersonalPasswordVo personalPasswordVo, BindingResult bindingResult){
        if(!bindingResult.hasErrors()){
            UsersDto usersDto = usersService.findByUsername(usersService.getUserBySession().getUsername());
            usersDto.setPassword(MD5Utils.md5(personalPasswordVo.getOkPassword()));
            usersService.update(usersDto);
        }
        return "redirect:/personal/personalPassword";
    }

    /**
     * 制作简历
     * @return
     */
    @RequestMapping("/personal/personalWriter")
    public String personalWriter(){
        return "personal/personalwriter";
    }

    /**
     * 保存制作简历
     * @param personalWriterVo
     * @return
     */
    @RequestMapping("/personal/savePersonalWriter")
    public String savePersonalWriter(PersonalWriterVo personalWriterVo){
        ResumeDtoWithBLOBs resumeDtoWithBLOBs = new ResumeDtoWithBLOBs();
        resumeDtoWithBLOBs.setTitle(personalWriterVo.getTitle());
        resumeDtoWithBLOBs.setRealName(personalWriterVo.getRealName());
        resumeDtoWithBLOBs.setSex(personalWriterVo.getSex());
        resumeDtoWithBLOBs.setAge(personalWriterVo.getAge());
        resumeDtoWithBLOBs.setEducation(personalWriterVo.getEducation());
        resumeDtoWithBLOBs.setTelNo(personalWriterVo.getTelNo());
        resumeDtoWithBLOBs.setEducationSituation(personalWriterVo.getEducationSituation());
        resumeDtoWithBLOBs.setPracticalExperience(personalWriterVo.getPracticalExperience());
        resumeDtoWithBLOBs.setSelfEvaluation(personalWriterVo.getSelfEvaluation());
        resumeDtoWithBLOBs.setUsername(usersService.getUserBySession().getUsername());
        resumeDtoWithBLOBs.setIsShow(false);
        resumeDtoWithBLOBs.setIsPass(0);
        resumeDtoWithBLOBs.setCreateTime(new Date());
        resumeService.save(resumeDtoWithBLOBs);
        return "redirect:/personal/personalWriter";
    }
}
