package org.example.example.controllers;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import org.example.example.dto.PostModelDTO;
import org.example.example.model.GetModel;
import org.example.example.model.PostModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.Random;

@RestController
@RequestMapping()
public class Controller {
    Random random = new Random();
    @Value("${startValue}")
    int start;
    @Value("${endValue}")
    int end;

    @ResponseBody
    @GetMapping
    public ResponseEntity<GetModel> returnString() throws InterruptedException {
        pause();
        return new ResponseEntity<>(new GetModel("login1", "status"), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<PostModel> postMethod(@Valid @RequestBody PostModelDTO dto) throws InterruptedException {
        pause();
        LocalDateTime date = LocalDateTime.now();
        return new ResponseEntity<>( new PostModel(dto.getLogin(), dto.getPassword(), date), HttpStatus.OK);
    }

    public void pause() throws InterruptedException {
        Thread.sleep(random.nextInt(start) + end - start);
    }

}
//response entity
//убрать дублирование кода
//application properties
//параметризовать значения задержки
// тип даты
//переоформить скрипты
//jdk jre
//jolokia 2