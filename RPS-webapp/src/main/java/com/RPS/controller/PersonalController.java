package com.RPS.controller;

import com.RPS.data.AjaxData;
import com.RPS.data.PaginationData;
import com.RPS.model.*;
import com.RPS.service.*;
import com.RPS.util.MD5Utils;
import com.RPS.util.PaginationUtils;
import com.RPS.vo.Personal;
import com.RPS.vo.PersonalPasswordVo;
import com.RPS.vo.PersonalWriterVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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

    @Resource
    private MessageService messageService;

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
        return "redirect:/personal/personalCenter";
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
        resumeDtoWithBLOBs.setJobInterview(personalWriterVo.getJobInterview());
        resumeDtoWithBLOBs.setEducationSituation(personalWriterVo.getEducationSituation());
        resumeDtoWithBLOBs.setPracticalExperience(personalWriterVo.getPracticalExperience());
        resumeDtoWithBLOBs.setSelfEvaluation(personalWriterVo.getSelfEvaluation());
        resumeDtoWithBLOBs.setUsername(usersService.getUserBySession().getUsername());
        resumeDtoWithBLOBs.setIsShow(false);
        resumeDtoWithBLOBs.setIsPass(0);
        resumeDtoWithBLOBs.setCreateTime(new Date());
        resumeDtoWithBLOBs.setResumeImg(personalWriterVo.getResumeImg());
        resumeService.save(resumeDtoWithBLOBs);
        return "redirect:/personal/personalWriter";
    }

    /**
     * 我的简历
     * @return
     */
    @RequestMapping("/personal/personalMyResume")
    public String personalMyResume(){
        return "personal/personalmyresume";
    }

    /**
     * 我的简历数据
     * @param page
     * @return
     */
    @RequestMapping("/personal/personalMyResumeData")
    @ResponseBody
    public AjaxData personalMyResumeData(@RequestParam("page") int page){
        List<ResumeDto> resumeDtos = resumeService.findAllByUsernameAndPage(usersService.getUserBySession().getUsername(),page,15);
        PaginationUtils<ResumeDto> resumeDtoPaginationUtils = new PaginationUtils<>();
        Map<String,Object> map = resumeDtoPaginationUtils.paginationData(resumeDtos,page);
        return new AjaxData().success().mapData(map);
    }

    /**
     * 更改是否展示
     * @param id
     * @param isShow
     * @return
     */
    @RequestMapping("/personal/updateMyResumeToShow")
    @ResponseBody
    public AjaxData updateMyResumeToShow(@RequestParam("id") int id,@RequestParam("isShow") boolean isShow){
        ResumeDtoWithBLOBs resumeDtoWithBLOBs = resumeService.findById(id);
        resumeDtoWithBLOBs.setIsShow(isShow);
        resumeService.update(resumeDtoWithBLOBs);
        return new AjaxData().success().msg("更新成功!");
    }

    /**
     * 编辑
     * @param id
     * @param modelMap
     * @return
     */
    @RequestMapping("/personal/updateMyResumeToEdit")
    public String updateMyResumeToEdit(@RequestParam("id") int id, ModelMap modelMap){
        ResumeDto resumeDto = resumeService.findById(id);
        modelMap.addAttribute("resumeDto",resumeDto);
        return "personal/personalmyresumeedit";
    }

    /**
     * 更新制作简历
     * @param personalWriterVo
     * @return
     */
    @RequestMapping("/personal/updatePersonalWriter")
    public String updatePersonalWriter(PersonalWriterVo personalWriterVo){
        ResumeDtoWithBLOBs resumeDtoWithBLOBs = resumeService.findById(personalWriterVo.getId());
        resumeDtoWithBLOBs.setTitle(personalWriterVo.getTitle());
        resumeDtoWithBLOBs.setRealName(personalWriterVo.getRealName());
        resumeDtoWithBLOBs.setSex(personalWriterVo.getSex());
        resumeDtoWithBLOBs.setAge(personalWriterVo.getAge());
        resumeDtoWithBLOBs.setEducation(personalWriterVo.getEducation());
        resumeDtoWithBLOBs.setTelNo(personalWriterVo.getTelNo());
        resumeDtoWithBLOBs.setJobInterview(personalWriterVo.getJobInterview());
        resumeDtoWithBLOBs.setEducationSituation(personalWriterVo.getEducationSituation());
        resumeDtoWithBLOBs.setPracticalExperience(personalWriterVo.getPracticalExperience());
        resumeDtoWithBLOBs.setSelfEvaluation(personalWriterVo.getSelfEvaluation());
        resumeDtoWithBLOBs.setCreateTime(new Date());
        resumeDtoWithBLOBs.setIsPass(0);
        resumeDtoWithBLOBs.setResumeImg(personalWriterVo.getResumeImg());
        resumeService.update(resumeDtoWithBLOBs);
        return "redirect:/personal/personalMyResume";
    }

    /**
     * 查看
     * @param id
     * @param modelMap
     * @return
     */
    @RequestMapping("/personal/updateMyResumeToLook")
    public String updateMyResumeToLook(@RequestParam("id") int id,ModelMap modelMap){
        ResumeDtoWithBLOBs resumeDtoWithBLOBs = resumeService.findById(id);
        modelMap.addAttribute("resumeDtoWithBLOBs",resumeDtoWithBLOBs);
        return "personal/resumelook";
    }

    /**
     * 删除简历
     * @param id
     * @return
     */
    @RequestMapping("/personal/deleteMyResume")
    @ResponseBody
    public AjaxData deleteMyResume(@RequestParam("id") int id){
        resumeService.deleteById(id);
        return new AjaxData().success().msg("删除成功!");
    }

    /**
     * 消息界面
     * @return
     */
    @RequestMapping("/personal/personalmsg")
    public String personalmsg(){
        List<MessageDto> messageDtos = messageService.findByAcceptUserAndIsSee(usersService.getUserBySession().getUsername(),false);
        messageDtos.forEach(m->{
            m.setIsSee(true);
            messageService.update(m);
        });
        return "personal/personalmsg";
    }

    /**
     * 接收信息
     * @return
     */
    @RequestMapping("/personal/acceptMessage")
    @ResponseBody
    public AjaxData acceptMessage(@RequestParam("page") int page){
        List<MessageDto> messageDtos = messageService.findByAcceptUserAndPage(usersService.getUserBySession().getUsername(),page,15);
        PaginationUtils<MessageDto> resumeDtoPaginationUtils = new PaginationUtils<>();
        Map<String,Object> map = resumeDtoPaginationUtils.paginationData(messageDtos,page);
        return new AjaxData().success().mapData(map);
    }

    /**
     * 未看消息数
     * @return
     */
    @RequestMapping("/personal/isSeeMessage")
    @ResponseBody
    public AjaxData isSeeMessage(){
        int count = messageService.findByAcceptUserAndIsSeeCount(usersService.getUserBySession().getUsername(),false);
        return new AjaxData().success().obj(count);
    }

    /**
     * 删除消息信息
     * @return
     */
    @RequestMapping("/personal/deleteMessage")
    @ResponseBody
    public AjaxData deleteMessage(@RequestParam("id") int id){
        messageService.deleteById(id);
        return new AjaxData().success().msg("删除消息成功!");
    }

    /**
     * 批量删除消息
     * @param ids
     * @return
     */
    @RequestMapping("/personal/batchDeleteMessage")
    @ResponseBody
    public AjaxData batchDelete(String ids){
        String[] temp = ids.split(",");
        for(String s:temp){
            messageService.deleteById(Integer.parseInt(s));
        }

        return new AjaxData().success().msg("批量删除成功!");
    }
}
