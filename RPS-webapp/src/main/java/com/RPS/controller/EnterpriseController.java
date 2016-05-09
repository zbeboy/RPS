package com.RPS.controller;

import com.RPS.model.EnterpriseDto;
import com.RPS.service.EnterpriseService;
import com.RPS.service.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by lenovo on 2016-05-09.
 */
@Controller
public class EnterpriseController {

    @Resource
    private EnterpriseService enterpriseService;

    @Resource
    private UsersService usersService;

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
     * @param enterpriseDto
     * @param session
     * @return
     */
    @RequestMapping("/enterprise/updateFirmWriter")
    public String saveFirmWriter(EnterpriseDto enterpriseDto,HttpSession session){
        EnterpriseDto enterpriseDto1 = enterpriseService.findByUsername(usersService.getUserBySession().getUsername());
        if(!ObjectUtils.isEmpty(enterpriseDto1)){
            enterpriseDto.setId(enterpriseDto1.getId());
            enterpriseDto.setUsername(usersService.getUserBySession().getUsername());
            enterpriseService.update(enterpriseDto);
            session.setAttribute("users",enterpriseDto);
        }
        return "redirect:/enterprise/firmWriter";
    }
}
