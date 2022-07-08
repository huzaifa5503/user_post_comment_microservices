package com.microservice.comment.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Generic Response
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Response {

    private String message;
    private Boolean isSuccess;
    private String respCode;
    private Object data;
}
