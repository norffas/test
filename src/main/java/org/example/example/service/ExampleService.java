package org.example.example.service;

import lombok.RequiredArgsConstructor;
import org.example.example.dto.UserDTO;

import org.example.example.exceptions.FileException;
import org.example.example.exceptions.RepoException;
import org.example.example.exceptions.ServiceException;
import org.example.example.models.User;
import org.example.example.repo.DataBaseWorkerRepo;
import org.example.example.repo.FileWorker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
@RequiredArgsConstructor
public class ExampleService {
    private final DataBaseWorkerRepo repo;
    private final FileWorker fileRepo;
    private final List<Object> list = new ArrayList<>();
    Random random = new Random();
    @Value("${startValue}")
    int start;
    @Value("${endValue}")
    int end;

    public User findUser(String login){
        pause();
        Optional<User> userBox = repo.showUser(login);
        if(userBox.isPresent()){
            User user = userBox.get();
            //fileRepo.addEntity(user);
            return user;
        }
        else
            throw new ServiceException("User not found");
    }

    public int addUser(UserDTO dto){
        pause();
        int result;
        LocalDateTime date = LocalDateTime.now();
        User user = new User(dto.getLogin(), dto.getPassword(), date, dto.getEmail());
        try{
            result = repo.addUser(user);
            //fileRepo.addEntity(user);
        }
        catch (RepoException | FileException e){
            throw new ServiceException(e.getMessage());
        }
        return result;
    }

    public String getString(){
        try{
            String result = fileRepo.readRandomLine();
            if(result == null)
                throw new ServiceException("Запрашиваемой строки в файле нет");
            return result;
        } catch (FileException e) {
            throw new ServiceException(e.getMessage(), e);
        }
    }

    public void newMethod(){
        for (int i = 0; i < 10000; i++) {
            String a = new String("qwerty" + i);
            list.add(a);
        }
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
