package org.example.example.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.example.dto.UserDTO;
import org.example.example.exceptions.RepoException;
import org.example.example.models.User;
import org.example.example.service.ExampleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
@RequiredArgsConstructor
public class Controller {
    private final ExampleService service;


    @ResponseBody
    @GetMapping
    public ResponseEntity<User> showUser(String login){
        try{
            User user = service.findUser(login);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping
    public ResponseEntity<String> addUser(@Valid @RequestBody UserDTO dto){
        //400
        try{
            return new ResponseEntity<>(service.addUser(dto) + "", HttpStatus.OK);
        }
        catch (RepoException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }



}