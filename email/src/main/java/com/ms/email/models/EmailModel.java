package com.ms.email.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import com.ms.email.enums.StatusEmail;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmailModel {
    
    private UUID emailID;
    private UUID userID;
    private String emailFrom;
    private String emailTo;
    private String subject;
    private String text;
    private LocalDateTime senDateTime;
    private StatusEmail statusEmail;
}
