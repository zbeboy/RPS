package com.RPS.controller;

import com.RPS.data.AjaxData;
import com.RPS.model.MessageDto;
import com.RPS.model.ResumeDto;
import com.RPS.model.ResumeDtoWithBLOBs;
import com.RPS.service.MessageService;
import com.RPS.service.ResumeService;
import com.RPS.service.UsersService;
import com.RPS.util.PaginationUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/5/10.
 */
@Controller
public class AdminController {

    @Resource
    private ResumeService resumeService;

    @Resource
    private MessageService messageService;

    @Resource
    private UsersService usersService;

    /**
     * 审核简历
     * @return
     */
    @RequestMapping("/admin/adminExamine")
    public String adminExamine(){
        return "admin/adminexamine";
    }

    /**
     * 审核数据
     * @param page
     * @return
     */
    @RequestMapping("/admin/adminExamineData")
    @ResponseBody
    public AjaxData adminExamineData(@RequestParam("page") int page){
        List<ResumeDto> resumeDtos = resumeService.findAllByIsPassAndPage(page,15);
        PaginationUtils<ResumeDto> resumeDtoPaginationUtils = new PaginationUtils<>();
        Map<String,Object> map = resumeDtoPaginationUtils.paginationData(resumeDtos,page);
        return new AjaxData().success().mapData(map);
    }

    /**
     * 更新通过
     * @param id
     * @param isPass
     * @return
     */
    @RequestMapping("/admin/updateResumeToPass")
    @ResponseBody
    public AjaxData updateResumeToPass(@RequestParam("id") int id,@RequestParam("isPass") int isPass){
        ResumeDtoWithBLOBs resumeDtoWithBLOBs = resumeService.findById(id);
        resumeDtoWithBLOBs.setIsPass(isPass);
        resumeService.update(resumeDtoWithBLOBs);
        MessageDto messageDto = new MessageDto();
        messageDto.setUsername(usersService.getUserBySession().getUsername());
        messageDto.setAcceptUser(resumeDtoWithBLOBs.getUsername());
        messageDto.setCreateTime(new Date());
        messageDto.setIsSee(false);
        messageDto.setMessageTitle(resumeDtoWithBLOBs.getTitle());
        messageDto.setMessageContent("您的简历已审核通过!");
        messageService.save(messageDto);
        return new AjaxData().success().msg("更新成功!");
    }

    /**
     * 查看
     * @param id
     * @param modelMap
     * @return
     */
    @RequestMapping("/admin/adminLook")
    public String adminLook(@RequestParam("id") int id,ModelMap modelMap){
        ResumeDtoWithBLOBs resumeDtoWithBLOBs = resumeService.findById(id);
        modelMap.addAttribute("resumeDtoWithBLOBs",resumeDtoWithBLOBs);
        return "admin/adminlook";
    }

    /**
     * 删除简历
     * @param id
     * @return
     */
    @RequestMapping("/admin/deleteResume")
    @ResponseBody
    public AjaxData deleteResume(@RequestParam("id") int id){
        ResumeDtoWithBLOBs resumeDtoWithBLOBs = resumeService.findById(id);
        resumeService.deleteById(id);
        MessageDto messageDto = new MessageDto();
        messageDto.setUsername(usersService.getUserBySession().getUsername());
        messageDto.setAcceptUser(resumeDtoWithBLOBs.getUsername());
        messageDto.setIsSee(false);
        messageDto.setCreateTime(new Date());
        messageDto.setMessageTitle(resumeDtoWithBLOBs.getTitle());
        messageDto.setMessageContent("您的简历已被删除!");
        messageService.save(messageDto);
        return new AjaxData().success().msg("删除成功!");
    }
}
