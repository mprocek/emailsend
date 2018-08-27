package pl.marekprocek.emailsend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Component
public class Email {

    @Autowired
    private JavaMailSender javaMailSender;

    public void send(String to, String title, String content){
        MimeMessage mail = javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            helper.setTo(to);
            helper.setReplyTo("marekjava@o2.pl");
            helper.setFrom("marekjava@o2.pl");
            helper.setSubject(title);
            helper.setText(content);
        } catch(MessagingException e){
            e.printStackTrace();
        }

        javaMailSender.send(mail);
    }

}
