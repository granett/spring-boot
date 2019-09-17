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
public class HtmlInlineMail {

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
            //第二个参数是否启用html解析
            helper.setText("欢迎进入<a href=\"https://granett.github.io/\">我的主页</a><img src='cid:identifier1234'>",true);
            //内嵌一张图片
            FileSystemResource file = new FileSystemResource(new File("C:\\Users\\a\\Desktop\\avatar.jpg"));
            helper.addInline("identifier1234", file);
            javaMailSender.send(message);
        }catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
