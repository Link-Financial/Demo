package com.steven.testnavin.response;

import org.springframework.http.HttpStatus;

public class HttpBaseResponse {

    private String text;
    private HttpStatus httpStatus;

    public HttpBaseResponse(String text, HttpStatus httpStatus) {
        this.text = text;
        this.httpStatus = httpStatus;
    }

    public String getText() {
        return text;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
