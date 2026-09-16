package org.example.example.repo;

import org.example.example.exceptions.RepoException;
import org.example.example.models.User;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public class DataBaseWorkerRepo {
    String url = "jdbc:postgresql://192.168.0.108:5433/example_DB";
    String login = "admin";
    String password = "admin";

    public Optional<User> showUser(String login){
        Optional user = Optional.empty();
        try(Connection connect = connectBase();
            PreparedStatement selectQuery = connect.prepareStatement("SELECT table_1.login, table_1.password, table_1.date, table_2.email " +
                    "FROM table_1 join table_2 on table_1.login = table_2.login " +
                    "where table_1.login = ?");
        ){
            selectQuery.setString(1, login);
            ResultSet result = selectQuery.executeQuery();
            if(result.next()){
                String userLogin = result.getString(1);
                String password = result.getString(2);
                LocalDateTime date = result.getObject(3, LocalDateTime.class);
                String userEmail = result.getString(4);
                user = Optional.of(new User(userLogin, password, date, userEmail));
            }
            return user;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int addUser(User user){
        String login = user.getLogin();
        String password = user.getPassword();
        LocalDateTime date = user.getDate();
        String email = user.getEmail();
        try(Connection connect = connectBase();
            PreparedStatement insertQuery = connect.prepareStatement("" +
                    "INSERT INTO table_2(login, email) VALUES (?, ?); " +
                    "INSERT INTO table_1(login, password, date) VALUES (?, ?, ?)");
        ) {
            insertQuery.setString(3, login);
            insertQuery.setString(4, password);
            insertQuery.setObject(5, date);
            insertQuery.setString(1, login);
            insertQuery.setString(2, email);
            return insertQuery.executeUpdate();
        } catch (SQLException e) {
            throw new RepoException("User with this login is already exists");
        }
    }

    public Connection connectBase(){
        try{
            Connection connect = DriverManager.getConnection(url, login, password);
            return connect;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
