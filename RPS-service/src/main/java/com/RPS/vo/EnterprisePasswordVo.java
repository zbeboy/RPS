package com.RPS.vo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Created by Administrator on 2016/5/10.
 */
public class EnterprisePasswordVo {
    @NotNull
    @Pattern(regexp = "^\\w{6,}$")
    private String oldPassword;
    @NotNull
    @Pattern(regexp = "^\\w{6,}$")
    private String newPassword;
    @NotNull
    @Pattern(regexp = "^\\w{6,}$")
    private String okPassword;

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getOkPassword() {
        return okPassword;
    }

    public void setOkPassword(String okPassword) {
        this.okPassword = okPassword;
    }

    @Override
    public String toString() {
        return "EnterprisePasswordVo{" +
                "oldPassword='" + oldPassword + '\'' +
                ", newPassword='" + newPassword + '\'' +
                ", okPassword='" + okPassword + '\'' +
                '}';
    }
}
