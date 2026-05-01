package com.weedManager.Backend.Controllers;

import com.weedManager.Backend.DTOs.FormData;
import com.weedManager.Backend.Services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;


@RestController
@RequestMapping("/api")
public class FormController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/submit")
    public ResponseEntity<String> submitForm(@RequestBody FormData data) {
        data.setTime(LocalDateTime.now());
        String msg = "Message on: " + data.getTime() + "\n Query by \n Name: " + data.getName() + "\nMobile Number: " + data.getMobileno() + "\nEmail: " + data.getEmail() + "\nMessage: " + data.getQuery();
        emailService.sendEmail(msg);
        System.out.println("Data received: \n" + data);
        return ResponseEntity.ok("Email sent");
    }
}