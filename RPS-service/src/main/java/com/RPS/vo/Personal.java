package com.RPS.vo;

/**
 * Created by Administrator on 2016/5/9.
 */
public class Personal {
    private String headImgUrl;
    private String username;
    private String realName;
    private int sex;

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Personal{" +
                "headImgUrl='" + headImgUrl + '\'' +
                ", username='" + username + '\'' +
                ", realName='" + realName + '\'' +
                ", sex=" + sex +
                '}';
    }
}
