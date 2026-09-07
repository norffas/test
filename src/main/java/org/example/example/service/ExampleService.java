package org.example.example.service;

import org.example.example.dto.PostModelDTO;
import org.example.example.exceptions.ServiceException;
import org.example.example.models.GetModel;
import org.example.example.models.PostModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
public class ExampleService {
    Random random = new Random();
    @Value("${startValue}")
    int start;
    @Value("${endValue}")
    int end;

    public GetModel getResponse(){
        pause();
        GetModel model = new GetModel("login1", "status");
        return model;
    }

    public PostModel postMethod(PostModelDTO dto){
        pause();
        LocalDateTime date = LocalDateTime.now();
        PostModel model = new PostModel(dto.getLogin(), dto.getPassword(), date);
        return model;
    }

    private void pause(){
        try{
            Thread.sleep(random.nextInt(start) + end - start);
        }
        catch (InterruptedException e){
            throw new ServiceException("pause error");
        }
    }
}
