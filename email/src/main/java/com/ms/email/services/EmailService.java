package com.ms.email.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.ms.email.enums.StatusEmail;
import com.ms.email.models.EmailModel;

@Service
public class EmailService {
    
    @Autowired
    private JavaMailSender javaMailSender;

    @Value(value = "${spring.mail.username}")
    private String emailFrom;

    public void sendEmail(EmailModel emailModel){
        try {
            emailModel.setSenDateTime(LocalDateTime.now());
            emailModel.setEmailFrom(emailFrom);

            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(emailModel.getEmailTo());
            message.setSubject(emailModel.getSubject());
            message.setText(emailModel.getText());
            
            javaMailSender.send(message);
            emailModel.setStatusEmail(StatusEmail.SENT);

        } catch (MailException e) {
            emailModel.setStatusEmail(StatusEmail.ERROR);
        }
    }
}
