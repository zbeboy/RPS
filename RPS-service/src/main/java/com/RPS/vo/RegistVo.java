package com.RPS.vo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Created by Administrator on 2016/4/29.
 */
public class RegistVo {
    @NotNull
    @Pattern(regexp = "^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+")
    private String email;
    @NotNull
    @Pattern(regexp = "^\\w{6,}$")
    private String password;
    @NotNull
    @Pattern(regexp = "^\\w{6,}$")
    private String cpassword;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCpassword() {
        return cpassword;
    }

    public void setCpassword(String cpassword) {
        this.cpassword = cpassword;
    }

    @Override
    public String toString() {
        return "RegistVo{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", cpassword='" + cpassword + '\'' +
                '}';
    }
}
