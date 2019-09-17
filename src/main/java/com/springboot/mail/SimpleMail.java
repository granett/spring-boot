package com.springboot.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service
public class SimpleMail {

    @Autowired
    private MailSender mailSender;

    public void sendMail() {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom("1010098203@qq.com");
        msg.setTo("1010098203@qq.com");
        msg.setSubject("普通邮件主题");
        msg.setText("普通邮件正文");
        System.out.println(msg.toString());
        try{
            mailSender.send(msg);
        }catch (MailException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
