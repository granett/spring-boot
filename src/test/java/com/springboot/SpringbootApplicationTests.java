package com.springboot;

import com.springboot.mail.AttachmentsMail;
import com.springboot.mail.HtmlInlineMail;
import com.springboot.mail.MimeMail;
import com.springboot.mail.SimpleMail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootApplicationTests {

    @Autowired
    private SimpleMail simpleMail;

    @Test
    public void simpleMail() {
        simpleMail.sendMail();
    }

    @Autowired
    private MimeMail mimeMail;

    @Test
    public void MimeMail(){
        mimeMail.sendMail();
    }

    @Autowired
    private AttachmentsMail attachmentsMail;

    @Test
    public void AttachMail(){
        attachmentsMail.sendMail();
    }

    @Autowired
    private HtmlInlineMail htmlInlineMail;

    @Test
    public void htmlInlineMail(){
        htmlInlineMail.sendMail();
    }

}
