package com.RPS.model;

import java.util.Date;

public class ResumeDto {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resume.id
     *
     * @mbggenerated Tue May 10 17:14:15 CST 2016
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resume.title
     *
     * @mbggenerated Tue May 10 17:14:15 CST 2016
     */
    private String title;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resume.education
     *
     * @mbggenerated Tue May 10 17:14:15 CST 2016
     */
    private String education;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resume.real_name
     *
     * @mbggenerated Tue May 10 17:14:15 CST 2016
     */
    private String realName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resume.sex
     *
     * @mbggenerated Tue May 10 17:14:15 CST 2016
     */
    private Integer sex;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resume.age
     *
     * @mbggenerated Tue May 10 17:14:15 CST 2016
     */
    private Integer age;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resume.tel_no
     *
     * @mbggenerated Tue May 10 17:14:15 CST 2016
     */
    private String telNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resume.username
     *
     * @mbggenerated Tue May 10 17:14:15 CST 2016
     */
    private String username;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resume.is_show
     *
     * @mbggenerated Tue May 10 17:14:15 CST 2016
     */
    private Boolean isShow;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resume.is_pass
     *
     * @mbggenerated Tue May 10 17:14:15 CST 2016
     */
    private Integer isPass;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resume.resume_img
     *
     * @mbggenerated Tue May 10 17:14:15 CST 2016
     */
    private String resumeImg;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resume.job_interview
     *
     * @mbggenerated Tue May 10 17:14:15 CST 2016
     */
    private String jobInterview;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resume.create_time
     *
     * @mbggenerated Tue May 10 17:14:15 CST 2016
     */
    private Date createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resume.id
     *
     * @return the value of resume.id
     *
     * @mbggenerated Tue May 10 17:14:15 CST 2016
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resume.id
     *
     * @param id the value for resume.id
     *
     * @mbggenerated Tue May 10 17:14:15 CST 2016
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resume.title
     *
     * @return the value of resume.title
     *
     * @mbggenerated Tue May 10 17:14:15 CST 2016
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resume.title
     *
     * @param title the value for resume.title
     *
     * @mbggenerated Tue May 10 17:14:15 CST 2016
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resume.education
     *
     * @return the value of resume.education
     *
     * @mbggenerated Tue May 10 17:14:15 CST 2016
     */
    public String getEducation() {
        return education;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resume.education
     *
     * @param education the value for resume.education
     *
     * @mbggenerated Tue May 10 17:14:15 CST 2016
     */
    public void setEducation(String education) {
        this.education = education == null ? null : education.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resume.real_name
     *
     * @return the value of resume.real_name
     *
     * @mbggenerated Tue May 10 17:14:15 CST 2016
     */
    public String getRealName() {
        return realName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resume.real_name
     *
     * @param realName the value for resume.real_name
     *
     * @mbggenerated Tue May 10 17:14:15 CST 2016
     */
    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resume.sex
     *
     * @return the value of resume.sex
     *
     * @mbggenerated Tue May 10 17:14:15 CST 2016
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resume.sex
     *
     * @param sex the value for resume.sex
     *
     * @mbggenerated Tue May 10 17:14:15 CST 2016
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resume.age
     *
     * @return the value of resume.age
     *
     * @mbggenerated Tue May 10 17:14:15 CST 2016
     */
    public Integer getAge() {
        return age;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resume.age
     *
     * @param age the value for resume.age
     *
     * @mbggenerated Tue May 10 17:14:15 CST 2016
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resume.tel_no
     *
     * @return the value of resume.tel_no
     *
     * @mbggenerated Tue May 10 17:14:15 CST 2016
     */
    public String getTelNo() {
        return telNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resume.tel_no
     *
     * @param telNo the value for resume.tel_no
     *
     * @mbggenerated Tue May 10 17:14:15 CST 2016
     */
    public void setTelNo(String telNo) {
        this.telNo = telNo == null ? null : telNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resume.username
     *
     * @return the value of resume.username
     *
     * @mbggenerated Tue May 10 17:14:15 CST 2016
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resume.username
     *
     * @param username the value for resume.username
     *
     * @mbggenerated Tue May 10 17:14:15 CST 2016
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resume.is_show
     *
     * @return the value of resume.is_show
     *
     * @mbggenerated Tue May 10 17:14:15 CST 2016
     */
    public Boolean getIsShow() {
        return isShow;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resume.is_show
     *
     * @param isShow the value for resume.is_show
     *
     * @mbggenerated Tue May 10 17:14:15 CST 2016
     */
    public void setIsShow(Boolean isShow) {
        this.isShow = isShow;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resume.is_pass
     *
     * @return the value of resume.is_pass
     *
     * @mbggenerated Tue May 10 17:14:15 CST 2016
     */
    public Integer getIsPass() {
        return isPass;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resume.is_pass
     *
     * @param isPass the value for resume.is_pass
     *
     * @mbggenerated Tue May 10 17:14:15 CST 2016
     */
    public void setIsPass(Integer isPass) {
        this.isPass = isPass;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resume.resume_img
     *
     * @return the value of resume.resume_img
     *
     * @mbggenerated Tue May 10 17:14:15 CST 2016
     */
    public String getResumeImg() {
        return resumeImg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resume.resume_img
     *
     * @param resumeImg the value for resume.resume_img
     *
     * @mbggenerated Tue May 10 17:14:15 CST 2016
     */
    public void setResumeImg(String resumeImg) {
        this.resumeImg = resumeImg == null ? null : resumeImg.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resume.job_interview
     *
     * @return the value of resume.job_interview
     *
     * @mbggenerated Tue May 10 17:14:15 CST 2016
     */
    public String getJobInterview() {
        return jobInterview;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resume.job_interview
     *
     * @param jobInterview the value for resume.job_interview
     *
     * @mbggenerated Tue May 10 17:14:15 CST 2016
     */
    public void setJobInterview(String jobInterview) {
        this.jobInterview = jobInterview == null ? null : jobInterview.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resume.create_time
     *
     * @return the value of resume.create_time
     *
     * @mbggenerated Tue May 10 17:14:15 CST 2016
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resume.create_time
     *
     * @param createTime the value for resume.create_time
     *
     * @mbggenerated Tue May 10 17:14:15 CST 2016
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}