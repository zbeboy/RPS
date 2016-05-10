package com.RPS.service;

import com.RPS.commons.WorkBook;
import com.RPS.model.UsersDto;
import com.RPS.util.RandomUtil;
import org.apache.commons.lang3.CharEncoding;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AliasFor;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;

/**
 * Created by Administrator on 2016/5/10.
 */
@Service("mailService")
public class MailServiceImpl implements MailService {
    private final Logger log = LoggerFactory.getLogger(MailService.class);

    @Resource
    private JavaMailSenderImpl javaMailSender;

    @Async
    @Override
    public void sendEmail(String to,String from, String subject, String content, boolean isMultipart, boolean isHtml) {
        log.debug("Send e-mail[multipart '{}' and html '{}'] to '{}' with subject '{}' and content={}",
                isMultipart, isHtml, to, subject, content);

        // Prepare message using a Spring helper
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper message = new MimeMessageHelper(mimeMessage, isMultipart, CharEncoding.UTF_8);
            message.setTo(to);
            message.setFrom(from);
            message.setSubject(subject);
            message.setText(content, isHtml);
            javaMailSender.send(mimeMessage);
            log.debug("Sent e-mail to User '{}'", to);
        } catch (Exception e) {
            log.warn("E-mail could not be sent to user '{}', exception is: {}", to, e.getMessage());
        }
    }

    @Async
    @Override
    public void sendActivationEmail(UsersDto usersDto, String baseUrl) {
        log.debug("Sending activation e-mail to '{}'", usersDto.getUsername());
        String link = "<a href='"+baseUrl+"/activation?username="+usersDto.getUsername()+"&activeKey="+usersDto.getActiveKey()+"' >激活链接</a>";
        sendEmail(usersDto.getUsername(),WorkBook.MAIL_FROM, "个人简历制作系统账号激活\n",
                "请点击激活链接 : \n"+link, false, true);
    }

    @Async
    @Override
    public void sendCreationEmail(UsersDto usersDto, String baseUrl) {
        sendEmail(usersDto.getUsername(),WorkBook.MAIL_FROM, "个人简历制作系统账号创建\n",
                "恭喜您,您的账号:"+usersDto.getUsername()+"已经创建成功!", false, false);
    }

    @Async
    @Override
    public void sendPasswordResetMail(UsersDto usersDto, String baseUrl) {
        sendEmail(usersDto.getUsername(), WorkBook.MAIL_FROM,"个人简历制作系统重置密码\n",
                "这是您的验证码:"+ usersDto.getResetKey()+"!", false, false);
    }
}
