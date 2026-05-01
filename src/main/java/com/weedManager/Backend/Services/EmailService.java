package com.weedManager.Backend.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String message) {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo("rahuleblm9@gmail.com");
        mail.setSubject("Weed Management App");
        mail.setText(message);

        mailSender.send(mail);
    }
}