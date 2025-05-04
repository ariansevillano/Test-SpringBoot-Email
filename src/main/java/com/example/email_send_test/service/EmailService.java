package com.example.email_send_test.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service

public class EmailService {
    private JavaMailSender javaMailSender;
    private TemplateEngine templateEngine;
    @Autowired
    public EmailService (JavaMailSender javaMailSender, TemplateEngine templateEngine){
        this.javaMailSender=javaMailSender;
        this.templateEngine=templateEngine;
    }

    public void sendEmail(){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("ariansevillano1@gmail.com");
        message.setTo("2123110074@untels.edu.pe");
        message.setSubject("Email de prueba, envío simple");
        message.setText("Contenido del email de prueba");

        javaMailSender.send(message);
    }

    public void sendEmailTemplate(){
        MimeMessage message = javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message,true);
            Context context = new Context();
            String htmlText =  templateEngine.process("Email-Template",context);
            helper.setFrom("ariansevillano1@gmail.com");
            helper.setTo("2123110074@untels.edu.pe");
            helper.setSubject("Prueba envío email simple");
            helper.setText(htmlText,true);

            javaMailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
