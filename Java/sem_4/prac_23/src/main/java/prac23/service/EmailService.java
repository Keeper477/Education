package prac23.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;
    @Value("${spring.mail.username}")
    private String setFrom;
    @Value("${ADDRESS.TO}")
    private String setTo;
    @Async
    public void sendMail(String subject, String text){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(setFrom);
        message.setTo(setTo);
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);
    }
}
