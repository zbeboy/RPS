package com.RPS.vo;

import com.RPS.model.ResumeDto;

/**
 * Created by lenovo on 2016-05-09.
 */
public class PersonalMyResumeDataVo {
    private int id;
    private String title;
    private String createTime;
    private boolean isShow;
    private int isPass;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public boolean isShow() {
        return isShow;
    }

    public void setShow(boolean show) {
        isShow = show;
    }

    public int getIsPass() {
        return isPass;
    }

    public void setIsPass(int isPass) {
        this.isPass = isPass;
    }

    @Override
    public String toString() {
        return "PersonalMyResumeDataVo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", createTime='" + createTime + '\'' +
                ", isShow=" + isShow +
                ", isPass=" + isPass +
                '}';
    }
}
