package org.example.example.repo;

import org.example.example.exceptions.FileException;
import org.example.example.models.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Random;

@Repository
public class FileWorker {
    @Value("${pathToFileForRead}")
    String pathToRead;
    @Value("${pathToFileForWrite}")
    String pathToWrite;
    @Value("${distanceStart}")
    int start;
    @Value("${distanceEnd}")
    int end;


    public String readRandomLine(){
        Random random = new Random();
        int rand = random.nextInt(start, end);
        try(BufferedReader reader = Files.newBufferedReader(Path.of(pathToRead))){
            String line;
            int i = 0;
            while((line = reader.readLine()) != null){
                if(i == rand)
                    break;
                i++;
            }
            return line;
        }
        catch(NoSuchFileException e){
            throw new FileException("Файл не найден", e);
        } catch (IOException e) {
            throw new FileException("Ошибка чтения файла", e);
        }
    }

    public void addEntity(User user){
        try(BufferedWriter writer = Files.newBufferedWriter(Path.of(pathToWrite),
                StandardOpenOption.CREATE, StandardOpenOption.APPEND)){
            writer.write(user.getLogin() + " " + user.getEmail() + " " + user.getDate() + " " + user.getPassword() + "\n");
        }
        catch (IOException e){
            throw new FileException("Ошибка записи файла", e);
        }
    }
}
