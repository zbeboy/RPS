package com.RPS.controller;

import com.RPS.commons.WorkBook;
import com.RPS.data.AjaxData;
import com.RPS.model.*;
import com.RPS.service.*;
import com.RPS.util.MD5Utils;
import com.RPS.util.PaginationUtils;
import com.RPS.util.RandomUtil;
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
import java.util.ArrayList;
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

    @Resource
    private MailService mailService;

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
    public String index(ModelMap modelMap) {
        List<ResumeDto> newResumes = resumeService.findAllAndPage(0, 3, null);
        List<ResumeDto> allResumes = resumeService.findAllAndPage(0, 10, null);
        modelMap.addAttribute("newResumes", newResumes);
        modelMap.addAttribute("allResumes", allResumes);
        return "index";
    }

    /**
     * resume
     * @param id
     * @return
     */
    @RequestMapping("/resume")
    public String resume(@RequestParam("id") int id ,ModelMap modelMap){
        ResumeDtoWithBLOBs resumeDtoWithBLOBs = resumeService.findById(id);
        modelMap.addAttribute("resumeDtoWithBLOBs",resumeDtoWithBLOBs);
        return "user/resume";
    }

    /**
     * 搜索简历
     * @return
     */
    @RequestMapping("/searchResume")
    public String personalMyResume( String title,ModelMap modelMap){
        modelMap.addAttribute("title",title);
        return "user/searchresume";
    }

    /**
     * 搜索简历数据
     * @param page
     * @param title
     * @return
     */
    @RequestMapping("/searchResumeData")
    @ResponseBody
    public AjaxData personalMyResume(@RequestParam("page") int page, String title){
        List<ResumeDto> allResumes = resumeService.findAllAndPage(page, 20, title);
        PaginationUtils<ResumeDto> resumeDtoPaginationUtils = new PaginationUtils<>();
        Map<String,Object> map = resumeDtoPaginationUtils.paginationData(allResumes,page);
        return new AjaxData().success().mapData(map);
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

    /**
     * 检验原来的密码
     * @param oldPassword
     * @return
     */
    @RequestMapping("/validatePassword")
    @ResponseBody
    public Map<String, Object> validatePassword(@RequestParam("oldPassword") String oldPassword) {
        Map<String, Object> map = new HashMap<>();
        if (StringUtils.isNotBlank(oldPassword)) {
            String oldPwd = MD5Utils.md5(StringUtils.trim(oldPassword));
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
    public String userRegister(@Valid RegistVo registVo, BindingResult bindingResult, ModelMap modelMap,HttpServletRequest request) {
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
            usersDto.setIsActive(false);
            usersDto.setActiveKey(RandomUtil.generateActivationKey());
            usersDto.setResetKey(RandomUtil.generateResetKey());
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

            String path = request.getContextPath();
            String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
            mailService.sendActivationEmail(usersDto,basePath);

            modelMap.addAttribute("msg", "注册成功!已将激活邮件发至您的邮箱!");
        } else {
            modelMap.addAttribute("msg", "验证信息有误!");
        }
        return "login";
    }

    /**
     * 检验激活
     * @param username
     * @return
     */
    @RequestMapping("/validateActive")
    @ResponseBody
    public AjaxData validateActive(@RequestParam("username") String username){
        UsersDto usersDto = usersService.findByUsername(username);
        if(!ObjectUtils.isEmpty(usersDto)){
            if(usersDto.getIsActive()){
                return new AjaxData().success().msg("账号已激活!");
            }  else {
                return new AjaxData().fail().msg("账号未激活!");
            }
        } else {
            return new AjaxData().fail().msg("参数异常!");
        }
    }

    /**
     * 重新激活
     * @param username
     * @return
     */
    @RequestMapping("/againActive")
    @ResponseBody
    public AjaxData againActive(@RequestParam("username") String username,HttpServletRequest request){
        UsersDto usersDto = usersService.findByUsername(username);
        if(!ObjectUtils.isEmpty(usersDto)){
            String path = request.getContextPath();
            String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
            mailService.sendActivationEmail(usersDto,basePath);
            return new AjaxData().success().msg("发送成功!");
        } else {
            return  new AjaxData().fail().msg("账号不存在!");
        }
    }

    /**
     * 激活账号
     * @param username
     * @param activeKey
     * @param modelMap
     * @param request
     * @return
     */
    @RequestMapping("/activation")
    public String activation(@RequestParam("username") String username,@RequestParam("activeKey") String activeKey,ModelMap modelMap,HttpServletRequest request){
        UsersDto usersDto = usersService.findByUsername(username);
        if(!ObjectUtils.isEmpty(usersDto)){
            if(usersDto.getActiveKey().equals(activeKey)){
                usersDto.setIsActive(true);
                usersDto.setActiveKey(RandomUtil.generateActivationKey());
                usersService.update(usersDto);
                String path = request.getContextPath();
                String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
                mailService.sendCreationEmail(usersDto,basePath);
                modelMap.addAttribute("msg","账号:"+username+"激活成功!");
            } else {
                modelMap.addAttribute("msg","激活码不正确,不能激活!");
            }
        } else {
            modelMap.addAttribute("msg","账号不存在!");
        }
        return "user/yanzhengsuccess";
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
    public String adminIndex(HttpServletRequest request,ModelMap modelMap) {
        UsersDto usersDto = usersService.getUserBySession();
        PersonalDto personalDto = personalService.findByUsername(usersDto.getUsername());
        HttpSession session = request.getSession();
        session.setAttribute("users", personalDto);

        List<ResumeDto> newResumes = resumeService.findAllAndPage(0, 3, null);
        List<ResumeDto> allResumes = resumeService.findAllAndPage(0, 10, null);
        modelMap.addAttribute("newResumes", newResumes);
        modelMap.addAttribute("allResumes", allResumes);

        return "admin/index";
    }

    /**
     * Enterprise zone index.
     */
    @RequestMapping("/enterprise/index")
    public String enterpriseIndex(HttpServletRequest request,ModelMap modelMap) {
        UsersDto usersDto = usersService.getUserBySession();
        EnterpriseDto enterpriseDto = enterpriseService.findByUsername(usersDto.getUsername());
        HttpSession session = request.getSession();
        session.setAttribute("users", enterpriseDto);

        List<ResumeDto> newResumes = resumeService.findAllAndPage(0, 3, null);
        List<ResumeDto> allResumes = resumeService.findAllAndPage(0, 10, null);
        modelMap.addAttribute("newResumes", newResumes);
        modelMap.addAttribute("allResumes", allResumes);

        return "enterprise/index";
    }

    /**
     * Personal zone index.
     */
    @RequestMapping("/personal/index")
    public String personalIndex(HttpServletRequest request,ModelMap modelMap) {
        UsersDto usersDto = usersService.getUserBySession();
        PersonalDto personalDto = personalService.findByUsername(usersDto.getUsername());
        HttpSession session = request.getSession();
        session.setAttribute("users", personalDto);

        List<ResumeDto> newResumes = resumeService.findAllAndPage(0, 3, null);
        List<ResumeDto> allResumes = resumeService.findAllAndPage(0, 10, null);
        modelMap.addAttribute("newResumes", newResumes);
        modelMap.addAttribute("allResumes", allResumes);

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
