package com.RPS.model;

public class ResumeDtoWithBLOBs extends ResumeDto {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resume.education_situation
     *
     * @mbggenerated Wed Apr 27 21:55:11 CST 2016
     */
    private String educationSituation;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resume.practical_experience
     *
     * @mbggenerated Wed Apr 27 21:55:11 CST 2016
     */
    private String practicalExperience;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column resume.self_evaluation
     *
     * @mbggenerated Wed Apr 27 21:55:11 CST 2016
     */
    private String selfEvaluation;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resume.education_situation
     *
     * @return the value of resume.education_situation
     *
     * @mbggenerated Wed Apr 27 21:55:11 CST 2016
     */
    public String getEducationSituation() {
        return educationSituation;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resume.education_situation
     *
     * @param educationSituation the value for resume.education_situation
     *
     * @mbggenerated Wed Apr 27 21:55:11 CST 2016
     */
    public void setEducationSituation(String educationSituation) {
        this.educationSituation = educationSituation == null ? null : educationSituation.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resume.practical_experience
     *
     * @return the value of resume.practical_experience
     *
     * @mbggenerated Wed Apr 27 21:55:11 CST 2016
     */
    public String getPracticalExperience() {
        return practicalExperience;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resume.practical_experience
     *
     * @param practicalExperience the value for resume.practical_experience
     *
     * @mbggenerated Wed Apr 27 21:55:11 CST 2016
     */
    public void setPracticalExperience(String practicalExperience) {
        this.practicalExperience = practicalExperience == null ? null : practicalExperience.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column resume.self_evaluation
     *
     * @return the value of resume.self_evaluation
     *
     * @mbggenerated Wed Apr 27 21:55:11 CST 2016
     */
    public String getSelfEvaluation() {
        return selfEvaluation;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column resume.self_evaluation
     *
     * @param selfEvaluation the value for resume.self_evaluation
     *
     * @mbggenerated Wed Apr 27 21:55:11 CST 2016
     */
    public void setSelfEvaluation(String selfEvaluation) {
        this.selfEvaluation = selfEvaluation == null ? null : selfEvaluation.trim();
    }
}