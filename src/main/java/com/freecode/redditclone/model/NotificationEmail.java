package com.freecode.redditclone.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class NotificationEmail {
    private String subject;
    private String recipient;
    private String body;
}
