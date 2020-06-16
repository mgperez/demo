package com.example.demo.controller.base;

import com.example.demo.Responses;
import com.example.demo.dto.ResultDTO;
import com.example.demo.exception.OptException;
import com.example.demo.repository.UserRepository;
import com.example.demo.entity.User;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.ResourceAccessException;

/**
 * Exception handling
 *
 * https://github.com/mfischbo/BustaMail/blob/master/parent/bustamail-common/src/main/java/de/mfischbo/bustamail/common/web/BaseApiController.java
 *
 */
@Slf4j
public class BaseApiController<User> {

    private UserRepository userRepository = new UserRepository();

    protected ResponseEntity<ResultDTO> defaultFallback(Throwable e) {
        String errorMsg;
        String code = "300";
        if (e instanceof OptException) {
            errorMsg = e.getMessage();
        } else if (e instanceof ResourceAccessException) {
            errorMsg = "Node connection failed";
            code = "500";
        } else {
            errorMsg = "Service error";
            code = "500";
        }
        ResponseEntity<ResultDTO> resultDto = new ResponseEntity<ResultDTO>(
                new ResultDTO().result(code).errorMsg(errorMsg), HttpStatus.OK);
        log.error("**** An exception occurs ****", e);
        return resultDto;
    }

    protected ResponseEntity<User> update(String id, User object, String resume) {
        return Responses.notFound();
    }
}
