package email.emailsending.model;

import email.emailsending.responsestatus.EmailType;

import javax.persistence.*;

@Entity
@Table(name = "T_SYSTEM_MESSAGE")

public class Email {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String subject;
	private String content;
	private Boolean enabled = Boolean.TRUE;
	private EmailType emailType;

//	private SystemMessageType type;




}
