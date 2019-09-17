package com.springboot.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class MimeMail {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendMail() {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);
            helper.setFrom("1010098203@qq.com");
            helper.setTo("1010098203@qq.com");
            helper.setSubject("Mime邮件主题");
            helper.setText("Mime邮件正文");
            javaMailSender.send(message);
        }catch (MessagingException e) {
            e.printStackTrace();
        }

    }
}
