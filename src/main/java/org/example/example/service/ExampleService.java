package org.example.example.service;

import lombok.RequiredArgsConstructor;
import org.example.example.dto.UserDTO;

import org.example.example.exceptions.ServiceException;
import org.example.example.models.User;
import org.example.example.repo.DataBaseWorkerRepo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class ExampleService {
    private final DataBaseWorkerRepo repo;
    Random random = new Random();
    @Value("${startValue}")
    int start;
    @Value("${endValue}")
    int end;

    public User findUser(String login){
        pause();
        Optional<User> userBox = repo.showUser(login);
        if(userBox.isPresent())
            return userBox.get();
        else
            throw new ServiceException("User not found");
    }

    public int addUser(UserDTO dto){
        pause();
        LocalDateTime date = LocalDateTime.now();
        User user = new User(dto.getLogin(), dto.getPassword(), date, dto.getEmail());
        return repo.addUser(user);
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
