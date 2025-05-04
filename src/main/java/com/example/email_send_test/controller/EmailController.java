package com.example.email_send_test.controller;

import com.example.email_send_test.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    EmailService emailService;
    @Autowired
    public EmailController(EmailService emailService){
        this.emailService=emailService;
    }

    @GetMapping("/email/send")
    public ResponseEntity<?> sendEmail(){
        emailService.sendEmail();
        return new ResponseEntity<>("Correo enviado con éxito", HttpStatus.OK);
    }

    @GetMapping("/email/sendTemplate")
    public ResponseEntity<?> sendEmailTemplate(){
        emailService.sendEmailTemplate();
        return new ResponseEntity<>("Correo con plantilla enviado con éxito", HttpStatus.OK);
    }

}
