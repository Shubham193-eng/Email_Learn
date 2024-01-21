package email.emailsending.controller;

import javax.mail.MessagingException;

import email.emailsending.model.Email;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import email.emailsending.service.EmailService;
import email.emilsending.request.EmailRequest;



@RestController
@RequestMapping("/email")

public class EmailController {
	@Autowired
	private EmailService emailService;
	@Autowired
	private Email email;
	@PostMapping("/send")
	public ResponseEntity<String> sendTextEmail(@RequestBody EmailRequest emailRequest) throws MessagingException {
		emailService.sendTextEmail(emailRequest);
		return ResponseEntity.status(HttpStatus.OK).body("Email send successfully");
	}

	@PostMapping("/send/html")
	public ResponseEntity<String> sendHtmlEmail(@RequestBody EmailRequest emailRequest) throws MessagingException {
		emailService.sendHtmlEmail(emailRequest);
		return ResponseEntity.ok("HTML Email sent successfully!");
	}
	@PostMapping("/send/template")
	public ResponseEntity<String> sendTemplateEmail(@RequestBody EmailRequest emailRequest) throws MessagingException {
		emailService.sendTemplateEmail(emailRequest);
		return ResponseEntity.ok("Template Email sent successfully!");
	}

}