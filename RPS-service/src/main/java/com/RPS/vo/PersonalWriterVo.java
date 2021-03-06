package com.RPS.vo;

/**
 * Created by Administrator on 2016/5/9.
 */
public class PersonalWriterVo {
    private int id;
    private String title;
    private String realName;
    private int sex;
    private int age;
    private String education;
    private String telNo;
    private String jobInterview;
    private String educationSituation;
    private String practicalExperience;
    private String selfEvaluation;
    private String resumeImg;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public String getJobInterview() {
        return jobInterview;
    }

    public void setJobInterview(String jobInterview) {
        this.jobInterview = jobInterview;
    }

    public String getEducationSituation() {
        return educationSituation;
    }

    public void setEducationSituation(String educationSituation) {
        this.educationSituation = educationSituation;
    }

    public String getPracticalExperience() {
        return practicalExperience;
    }

    public void setPracticalExperience(String practicalExperience) {
        this.practicalExperience = practicalExperience;
    }

    public String getSelfEvaluation() {
        return selfEvaluation;
    }

    public void setSelfEvaluation(String selfEvaluation) {
        this.selfEvaluation = selfEvaluation;
    }

    public String getResumeImg() {
        return resumeImg;
    }

    public void setResumeImg(String resumeImg) {
        this.resumeImg = resumeImg;
    }

    @Override
    public String toString() {
        return "PersonalWriterVo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", realName='" + realName + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", education='" + education + '\'' +
                ", telNo='" + telNo + '\'' +
                ", jobInterview='" + jobInterview + '\'' +
                ", educationSituation='" + educationSituation + '\'' +
                ", practicalExperience='" + practicalExperience + '\'' +
                ", selfEvaluation='" + selfEvaluation + '\'' +
                ", resumeImg='" + resumeImg + '\'' +
                '}';
    }
}
