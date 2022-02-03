package com.clinica.clinicaapp.service;

import com.clinica.clinicaapp.exceptions.SpringException;
import com.clinica.clinicaapp.model.NotificationEmail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


@Service
public class MailService {

    @Autowired
    private  JavaMailSender mailSender;
    @Autowired
    private  MailContentBuilder mailContentBuilder;
    public void sendMail(NotificationEmail notificationEmail){
        MimeMessagePreparator messagePreparator=mimeMessage ->{
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom("clinicaUNMSM@unmsm.com.pe");
            messageHelper.setTo(notificationEmail.getRecipient());
            messageHelper.setSubject(notificationEmail.getSubject());
            messageHelper.setText(mailContentBuilder.build(notificationEmail.getBody()),true);
        };
        try{
            mailSender.send(messagePreparator);
        }catch(MailException e){
            e.printStackTrace();
        }
    }
}
