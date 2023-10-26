package com.aakriti.mvcIntermediate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service
public class AppEmailServiceImpl implements AppEmailService {

	@Autowired
	private JavaMailSenderImpl javaMailSenderImpl;
	
	public void sendMail(String loverName, String userEmail, String result) {
//		this is the email which we want to send to someone
		SimpleMailMessage newEmail = new SimpleMailMessage();
		newEmail.setTo(userEmail);
		newEmail.setSubject("calculator Application result  ");
		newEmail.setText("Hi " + loverName + "The result predicted by App is " + result);
 
//		for sending the email we need the instance of javaMailSender
		javaMailSenderImpl.send(newEmail);
		
	}

}
