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
    public String returnString(){
        return "{\"login\":\"Login1\",\"status\":\"ok\"}";
    }

    @PostMapping
    public String postMethod(String login, String password){
        LocalDateTime date = LocalDateTime.now();
        return "{\"login\":\"" + login + "\",\"password\":\" " + password + "\",\"date\":\"" + date + "}";
    }

}
