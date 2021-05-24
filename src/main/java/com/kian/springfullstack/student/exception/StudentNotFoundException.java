package com.kian.springfullstack.student.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND) //exception http status der bei fehlermeldung ausgegebn werden soll
public class StudentNotFoundException extends RuntimeException {

    public StudentNotFoundException (String s) {
        super(s);
    }
}
