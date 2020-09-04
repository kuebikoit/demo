package com.example.demo.controller;

import com.example.demo.service.SQSService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/messages")
public class MessageController {

    private final SQSService service;

    @Autowired
    public MessageController(SQSService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String sendMessage(@RequestBody String message) {
        log.info("Message is {}", message);
        service.sendMessage(message);

        return "SUCCESS";
    }
}
