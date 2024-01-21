package email.emilsending.request;

import email.emailsending.responsestatus.EmailType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class EmailRequest {

    @NotBlank
	@NotNull
	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
    private String recipient;
	private String msgBody;
	private String subject;
	private String attachment;
	private List<String> toList;
	private EmailType emailType;
}
