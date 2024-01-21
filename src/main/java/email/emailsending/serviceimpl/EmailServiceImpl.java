package email.emailsending.serviceimpl;

import javax.jws.soap.SOAPBinding;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import email.emailsending.repository.UserRepository;
import email.emailsending.responsestatus.EmailType;
import email.emilsending.request.EmailRequest;

import email.emailsending.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class EmailServiceImpl implements EmailService {
	@Autowired
	private JavaMailSender javaMailSender;
	@Autowired
	private TemplateEngine templateEngine;
	@Autowired
	private UserRepository userRepository;




	@Override
	public void sendTemplateEmail(EmailRequest emailRequest) throws MessagingException {
		sendEmail(emailRequest, EmailType.TEMPLATE);
	}

	@Override
	public void sendTextEmail(EmailRequest emailRequest) throws MessagingException {
		sendEmail(emailRequest,EmailType.TEXT);
	}

	@Override
	public void sendHtmlEmail(EmailRequest emailRequest) throws MessagingException {
		Context context=new Context();
		context.setVariable("message",emailRequest.getMsgBody());
		String process = templateEngine.process("Welcome", context);
		MimeMessage mimeMessage=javaMailSender.createMimeMessage();
		MimeMessageHelper helper= new MimeMessageHelper(mimeMessage,true);
		helper.setTo(emailRequest.getRecipient());
		helper.setSubject(emailRequest.getSubject());
		helper.setText(process,true);
		javaMailSender.send(mimeMessage);
	}

	private void sendEmail(EmailRequest emailRequest, EmailType emailType) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(emailRequest.getRecipient());
		message.setSubject(emailRequest.getSubject());
		message.setText(emailRequest.getMsgBody());
		javaMailSender.send(message);

		// Save the email to the database
		emailRequest.setEmailType(emailType);
		//userRepository.save(emailRequest);
	}

}


