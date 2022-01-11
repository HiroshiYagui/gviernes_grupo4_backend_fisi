package com.freecode.redditclone.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CitaDto {
    private long PostId;
    private String subredditName;
    private String postName;
    private String url;
    private String Description;
}

