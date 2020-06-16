package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


public class Responses {
    private Responses() {
        throw new UnsupportedOperationException();
    }

    public static ResponseEntity ok() {
        return new ResponseEntity(HttpStatus.OK);
    }

    public static ResponseEntity notFound() {
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    public static <T> ResponseEntity<T> ok(T model) {
        return new ResponseEntity<T>(model, HttpStatus.OK);
    }
}
