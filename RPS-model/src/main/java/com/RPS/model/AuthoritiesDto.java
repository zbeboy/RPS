package com.RPS.model;

public class AuthoritiesDto {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column authorities.username
     *
     * @mbggenerated Mon May 09 17:34:08 CST 2016
     */
    private String username;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column authorities.authority
     *
     * @mbggenerated Mon May 09 17:34:08 CST 2016
     */
    private String authority;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column authorities.username
     *
     * @return the value of authorities.username
     *
     * @mbggenerated Mon May 09 17:34:08 CST 2016
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column authorities.username
     *
     * @param username the value for authorities.username
     *
     * @mbggenerated Mon May 09 17:34:08 CST 2016
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column authorities.authority
     *
     * @return the value of authorities.authority
     *
     * @mbggenerated Mon May 09 17:34:08 CST 2016
     */
    public String getAuthority() {
        return authority;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column authorities.authority
     *
     * @param authority the value for authorities.authority
     *
     * @mbggenerated Mon May 09 17:34:08 CST 2016
     */
    public void setAuthority(String authority) {
        this.authority = authority == null ? null : authority.trim();
    }
}