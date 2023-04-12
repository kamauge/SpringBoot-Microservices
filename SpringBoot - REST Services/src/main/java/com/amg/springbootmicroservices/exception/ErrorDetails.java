package com.amg.springbootmicroservices.exception;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ErrorDetails {
    private LocalDateTime timeStamp;
    private String errorCode;
    private String message;
    private String path;
}
