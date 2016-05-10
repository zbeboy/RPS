package com.RPS.model;

public class UsersDto {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.username
     *
     * @mbggenerated Tue May 10 17:14:15 CST 2016
     */
    private String username;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.password
     *
     * @mbggenerated Tue May 10 17:14:15 CST 2016
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.enabled
     *
     * @mbggenerated Tue May 10 17:14:15 CST 2016
     */
    private Boolean enabled;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.is_active
     *
     * @mbggenerated Tue May 10 17:14:15 CST 2016
     */
    private Boolean isActive;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.active_key
     *
     * @mbggenerated Tue May 10 17:14:15 CST 2016
     */
    private String activeKey;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.reset_key
     *
     * @mbggenerated Tue May 10 17:14:15 CST 2016
     */
    private String resetKey;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.user_type
     *
     * @mbggenerated Tue May 10 17:14:15 CST 2016
     */
    private String userType;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.username
     *
     * @return the value of users.username
     *
     * @mbggenerated Tue May 10 17:14:15 CST 2016
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.username
     *
     * @param username the value for users.username
     *
     * @mbggenerated Tue May 10 17:14:15 CST 2016
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.password
     *
     * @return the value of users.password
     *
     * @mbggenerated Tue May 10 17:14:15 CST 2016
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.password
     *
     * @param password the value for users.password
     *
     * @mbggenerated Tue May 10 17:14:15 CST 2016
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.enabled
     *
     * @return the value of users.enabled
     *
     * @mbggenerated Tue May 10 17:14:15 CST 2016
     */
    public Boolean getEnabled() {
        return enabled;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.enabled
     *
     * @param enabled the value for users.enabled
     *
     * @mbggenerated Tue May 10 17:14:15 CST 2016
     */
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.is_active
     *
     * @return the value of users.is_active
     *
     * @mbggenerated Tue May 10 17:14:15 CST 2016
     */
    public Boolean getIsActive() {
        return isActive;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.is_active
     *
     * @param isActive the value for users.is_active
     *
     * @mbggenerated Tue May 10 17:14:15 CST 2016
     */
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.active_key
     *
     * @return the value of users.active_key
     *
     * @mbggenerated Tue May 10 17:14:15 CST 2016
     */
    public String getActiveKey() {
        return activeKey;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.active_key
     *
     * @param activeKey the value for users.active_key
     *
     * @mbggenerated Tue May 10 17:14:15 CST 2016
     */
    public void setActiveKey(String activeKey) {
        this.activeKey = activeKey == null ? null : activeKey.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.reset_key
     *
     * @return the value of users.reset_key
     *
     * @mbggenerated Tue May 10 17:14:15 CST 2016
     */
    public String getResetKey() {
        return resetKey;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.reset_key
     *
     * @param resetKey the value for users.reset_key
     *
     * @mbggenerated Tue May 10 17:14:15 CST 2016
     */
    public void setResetKey(String resetKey) {
        this.resetKey = resetKey == null ? null : resetKey.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.user_type
     *
     * @return the value of users.user_type
     *
     * @mbggenerated Tue May 10 17:14:15 CST 2016
     */
    public String getUserType() {
        return userType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.user_type
     *
     * @param userType the value for users.user_type
     *
     * @mbggenerated Tue May 10 17:14:15 CST 2016
     */
    public void setUserType(String userType) {
        this.userType = userType == null ? null : userType.trim();
    }
}