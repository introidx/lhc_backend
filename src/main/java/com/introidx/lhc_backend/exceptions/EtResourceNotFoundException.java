package com.introidx.lhc_backend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by PRAKASH RANJAN on 11-04-2022
 */

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EtResourceNotFoundException extends RuntimeException{

    public EtResourceNotFoundException(String message){
        super(message);
    }
}
