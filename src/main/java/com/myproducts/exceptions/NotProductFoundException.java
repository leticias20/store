package com.myproducts.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Not Product Found")
public class NotProductFoundException extends RuntimeException {

    public NotProductFoundException(String message) {
        super(message);
    }

}
