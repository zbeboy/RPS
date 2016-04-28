package com.RPS.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Locale;

/**
 * Application home page and login.
 */
@Controller
public class MainController {

    /**
     * root
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
    public String index() {
        return "index";
    }

    /**
     * login page.
     * @return
     */
    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    /**
     * regist page.
     * @return
     */
    @RequestMapping("/regist")
    public String register(){
        return "regist";
    }
    /**
     * User zone index.
     */
    @RequestMapping("/user/index")
    public String userIndex() {
        return "user/index";
    }

    /**
     * Administration zone index.
     */
    @RequestMapping("/admin/index")
    public String adminIndex() {
        return "admin/index";
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
        model.addAttribute("loginError", true);
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
