package com.springboot.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class AttachmentsMail {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendMail() {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            //是否发送的邮件是富文本（附件，图片，html等）
            MimeMessageHelper helper = new MimeMessageHelper(message,true);
            helper.setFrom("1010098203@qq.com");
            helper.setTo("13810402077@163.com");
            helper.setSubject("附件和Html邮件主题");
            helper.setText("有附件，注意查收！");
            //增加一个附件
            FileSystemResource file = new FileSystemResource(new File("C:\\Users\\a\\Desktop\\test.excel"));
            helper.addAttachment("test.excel", file);
            javaMailSender.send(message);
        }catch (MessagingException e) {
            e.printStackTrace();
        }

    }
}
