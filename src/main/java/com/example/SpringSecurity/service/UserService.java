package com.example.SpringSecurity.service;

import java.util.List;

import com.example.SpringSecurity.model.User;

public interface UserService {
    void addUser(User user);

    List<User> showList();

    User login(String userName, String passWord);

    void deleteUser(int id);
}
