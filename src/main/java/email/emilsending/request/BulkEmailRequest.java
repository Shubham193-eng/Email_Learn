//package com.emilsending.request;
//
//import com.emailsending.responsestatus.EmailType;
//import lombok.*;
//
//import javax.validation.constraints.Email;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotNull;
//import java.util.List;
//@Setter
//@Getter
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString
//public class BulkEmailRequest {
//    @NotBlank
//    @NotNull
//    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
//
//    private List<String> toList;
//    private String subject;
//    private String content;
//    private EmailType emailType;
//}
