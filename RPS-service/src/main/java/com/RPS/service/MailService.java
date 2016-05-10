package com.RPS.service;

import com.RPS.model.UsersDto;

/**
 * Created by Administrator on 2016/5/10.
 */
public interface MailService {
    /**
     * 发送邮件
     * @param to
     * @param subject
     * @param content
     * @param isMultipart
     * @param isHtml
     */
    void sendEmail(String to, String from,String subject, String content, boolean isMultipart, boolean isHtml);

    /**
     * 发送激活邮件
     * @param usersDto
     * @param baseUrl
     */
    void sendActivationEmail(UsersDto usersDto, String baseUrl);

    /**
     * 发送账号创建成功邮件
     * @param usersDto
     * @param baseUrl
     */
    void sendCreationEmail(UsersDto usersDto, String baseUrl);

    /**
     * 发送密码重置邮件
     * @param usersDto
     * @param baseUrl
     */
    void sendPasswordResetMail(UsersDto usersDto, String baseUrl);
}
