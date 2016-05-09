package com.RPS.controller;

import com.RPS.commons.WorkBook;
import com.RPS.model.*;
import com.RPS.service.*;
import com.RPS.util.MD5Utils;
import com.RPS.vo.PersonalPasswordVo;
import com.RPS.vo.RegistVo;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Application home page and login.
 */
@Controller
public class MainController {

    @Resource
    private UsersService usersService;

    @Resource
    private AuthoritiesService authoritiesService;

    @Resource
    private PersonalService personalService;

    @Resource
    private EnterpriseService enterpriseService;

    @Resource
    private ResumeService resumeService;

    /**
     * root
     *
     * @return
     */
    @RequestMapping("/")
    public String root() {
        return "redirect:/index";
    }

    /**
     * Home page.
     */
    @RequestMapping("/index")
    public String index(ModelMap modelMap, HttpServletRequest request) {
        List<ResumeDto> newResumes = resumeService.findAllAndPage(0, 3, null);
        List<ResumeDto> allResumes = resumeService.findAllAndPage(0, 10, null);
        modelMap.addAttribute("newResumes", newResumes);
        modelMap.addAttribute("allResumes", allResumes);
        UsersDto usersDto = usersService.getUserBySession();
        if (StringUtils.isNotBlank(usersDto.getUsername())) {
            UsersDto usersDto1 = usersService.findByUsername(usersDto.getUsername());
            if (usersDto1.getUserType().equals(WorkBook.USERS_PER)) {
                PersonalDto personalDto = personalService.findByUsername(usersDto.getUsername());
                HttpSession httpSession = request.getSession();
                httpSession.setAttribute("users", personalDto);
            } else if (usersDto1.getUserType().equals(WorkBook.USERS_ENTER)) {
                EnterpriseDto enterpriseDto = enterpriseService.findByUsername(usersDto.getUsername());
                HttpSession httpSession = request.getSession();
                httpSession.setAttribute("users", enterpriseDto);
            }
        }
        return "index";
    }

    /**
     * login page.
     *
     * @return
     */
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * regist page.
     *
     * @return
     */
    @RequestMapping("/regist")
    public String register() {
        return "regist";
    }

    /**
     * validate email
     */
    @RequestMapping("/validateEmail")
    @ResponseBody
    public Map<String, Object> validateEmail(@RequestParam("email") String email) {
        Map<String, Object> map = new HashMap<>();
        if (StringUtils.isNotEmpty(email)) {
            UsersDto usersDto = usersService.findByUsername(email);
            if (ObjectUtils.isEmpty(usersDto)) {
                map.put("ok", "");
            } else {
                map.put("error", "该邮箱已注册!");
            }
        } else {
            map.put("error", "参数异常!");
        }
        return map;
    }

    @RequestMapping("/validatePassword")
    @ResponseBody
    public Map<String, Object> validatePassword(@RequestParam("oldPassword") String oldPassword) {
        Map<String, Object> map = new HashMap<>();
        if (StringUtils.isNotBlank(oldPassword)) {
            String oldPwd = MD5Utils.md5(StringUtils.trim(oldPassword));
            System.out.println(usersService.getUserBySession().getPassword());
            if (oldPwd.equals(usersService.getUserBySession().getPassword())) {
                map.put("ok", "");
            } else {
                map.put("error", "密码错误!");
            }
        } else {
            map.put("error", "参数异常!");
        }
        return map;
    }

    /**
     * user register
     */
    @RequestMapping("/userRegister")
    public String userRegister(@Valid RegistVo registVo, BindingResult bindingResult, ModelMap modelMap) {
        if (!bindingResult.hasErrors() && StringUtils.equals(registVo.getPassword(), registVo.getCpassword())) {
            String username = StringUtils.trim(registVo.getEmail());
            UsersDto usersDto = new UsersDto();
            usersDto.setUsername(username);
            usersDto.setPassword(MD5Utils.md5(StringUtils.trim(registVo.getPassword())));
            usersDto.setEnabled(true);
            if (registVo.getUserType().equals("USERS_PER")) {
                usersDto.setUserType(WorkBook.USERS_PER);
            } else if (registVo.getUserType().equals("USERS_ENTER")) {
                usersDto.setUserType(WorkBook.USERS_ENTER);
            }

            usersService.save(usersDto);

            AuthoritiesDto authoritiesDto = new AuthoritiesDto();
            authoritiesDto.setUsername(username);
            if (registVo.getUserType().equals("USERS_PER")) {
                authoritiesDto.setAuthority(WorkBook.RPS_PER);
            } else if (registVo.getUserType().equals("USERS_ENTER")) {
                authoritiesDto.setAuthority(WorkBook.RPS_ENTER);
            }
            authoritiesService.save(authoritiesDto);

            if (registVo.getUserType().equals("USERS_PER")) {
                PersonalDto personalDto = new PersonalDto();
                personalDto.setUsername(username);
                personalDto.setRealName("无名");
                personalDto.setSex(0);
                personalService.save(personalDto);
            } else if (registVo.getUserType().equals("USERS_ENTER")) {
                EnterpriseDto enterpriseDto = new EnterpriseDto();
                enterpriseDto.setUsername(username);
                enterpriseDto.setRealName("无名");
                enterpriseService.save(enterpriseDto);
            }
            modelMap.addAttribute("msg", "注册成功!");
        } else {
            modelMap.addAttribute("msg", "验证信息有误!");
        }
        return "login";
    }

    /**
     * 主界面
     *
     * @return
     */
    @RequestMapping("/mainLayOut")
    public String mainLayOut() {
        if (usersService.isCurrentUserInRole(WorkBook.RPS_ADMIN)) {
            return "redirect:/admin/index";
        } else if (usersService.isCurrentUserInRole(WorkBook.RPS_ENTER)) {
            return "redirect:/enterprise/index";
        } else if (usersService.isCurrentUserInRole(WorkBook.RPS_PER)) {
            return "redirect:/personal/index";
        } else {
            return "redirect:/index";
        }
    }

    /**
     * Administration zone index.
     */
    @RequestMapping("/admin/index")
    public String adminIndex(HttpServletRequest request) {
        UsersDto usersDto = usersService.getUserBySession();
        PersonalDto personalDto = personalService.findByUsername(usersDto.getUsername());
        HttpSession session = request.getSession();
        session.setAttribute("users", personalDto);
        return "admin/index";
    }

    /**
     * Enterprise zone index.
     */
    @RequestMapping("/enterprise/index")
    public String enterpriseIndex(HttpServletRequest request) {
        UsersDto usersDto = usersService.getUserBySession();
        EnterpriseDto enterpriseDto = enterpriseService.findByUsername(usersDto.getUsername());
        HttpSession session = request.getSession();
        session.setAttribute("users", enterpriseDto);
        return "enterprise/index";
    }

    /**
     * Personal zone index.
     */
    @RequestMapping("/personal/index")
    public String personalIndex(HttpServletRequest request) {
        UsersDto usersDto = usersService.getUserBySession();
        PersonalDto personalDto = personalService.findByUsername(usersDto.getUsername());
        HttpSession session = request.getSession();
        session.setAttribute("users", personalDto);
        return "personal/index";
    }

    /**
     * Shared zone index.
     */
    @RequestMapping("/shared/index")
    public String sharedIndex() {
        return "shared/index";
    }

    /**
     * Login form with error.
     */
    @RequestMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("msg", "用户名或密码错误!");
        return "login";
    }

    /**
     * About form.
     */
    @RequestMapping("/about")
    public String about(Model model) {
        return "about";
    }

    /**
     * Simulation of an exception.
     */
    @RequestMapping("/simulateError")
    public void simulateError() {
        throw new RuntimeException("This is a simulated error message");
    }

    /**
     * Error page.
     */
    @RequestMapping("/error")
    public String error(HttpServletRequest request, Model model) {
        model.addAttribute("errorCode", "Error " + request.getAttribute("javax.servlet.error.status_code"));
        Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
        StringBuilder errorMessage = new StringBuilder();
        errorMessage.append("<ul>");
        while (throwable != null) {
            errorMessage.append("<li>").append(escapeTags(throwable.getMessage())).append("</li>");
            throwable = throwable.getCause();
        }
        errorMessage.append("</ul>");
        model.addAttribute("errorMessage", errorMessage.toString());
        return "error";
    }

    /**
     * Substitute 'less than' and 'greater than' symbols by its HTML entities.
     */
    private String escapeTags(String text) {
        if (text == null) {
            return null;
        }
        return text.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
    }
}
