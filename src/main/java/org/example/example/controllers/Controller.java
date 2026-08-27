package org.example.example.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Calendar;

@RestController
@RequestMapping()
public class Controller {

    @GetMapping
    public String returnString() throws InterruptedException {
        Thread.sleep(1000);
        return "{\"login\":\"Login1\",\"status\":\"ok\"}";
    }

    @PostMapping
    public String postMethod(String login, String password) throws InterruptedException {
        Thread.sleep(1000);
        LocalDateTime date = LocalDateTime.now();
        return "{\"login\":\"" + login + "\",\"password\":\" " + password + "\",\"date\":\"" + date + "\"}";
    }

}
