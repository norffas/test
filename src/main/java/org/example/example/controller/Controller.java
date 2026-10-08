package org.example.example.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.example.dto.UserDTO;
import org.example.example.exceptions.RepoException;
import org.example.example.exceptions.ServiceException;
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
    @GetMapping("/user")
    public ResponseEntity<User> showUser(String login){
        try{
            User user = service.findUser(login);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (ServiceException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch(RepoException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/randomString")
    public ResponseEntity<String> getRandomString(){
        try{
            return new ResponseEntity<>(service.getString(), HttpStatus.OK);
        }
        catch (ServiceException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<String> addUser(@Valid @RequestBody UserDTO dto){
        try{
            return new ResponseEntity<>(service.addUser(dto) + "", HttpStatus.OK);
        }
        catch (ServiceException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }



}