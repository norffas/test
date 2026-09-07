package org.example.example.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.example.dto.PostModelDTO;
import org.example.example.models.GetModel;
import org.example.example.models.PostModel;
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
    public ResponseEntity<GetModel> returnString(){
        GetModel model = service.getResponse();
        return new ResponseEntity<>(model, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<PostModel> postMethod(@Valid @RequestBody PostModelDTO dto){
        PostModel model = service.postMethod(dto);
        return new ResponseEntity<>( model, HttpStatus.OK);
    }



}