package email.emailsending.service;

import email.emilsending.request.EmailRequest;

import javax.mail.MessagingException;


public interface EmailService {

	void sendHtmlEmail(EmailRequest emailRequest) throws MessagingException;

	void sendTemplateEmail(EmailRequest emailRequest) throws MessagingException;
	void  sendTextEmail(EmailRequest emailRequest) throws MessagingException;



}
