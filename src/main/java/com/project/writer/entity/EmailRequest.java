package com.project.writer.entity;

import lombok.Data;

@Data
public class EmailRequest {
    private String emailContent;
    private String tone;
}
