package com.example.SpringSecurity.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.SpringSecurity.model.Role;
import com.example.SpringSecurity.model.User;
import com.example.SpringSecurity.repository.RoleRepository;
import com.example.SpringSecurity.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void addUser(User user) {
        Role userRole = roleRepository.findByName("USER");

        user.setRole(userRole);
        user.setPassWord(passwordEncoder.encode(user.getPassWord()));
        userRepository.save(user);
    }

    @Override
    public List<User> showList() {
        return userRepository.findAll();
    }

    @Override
    public User login(String userName, String passWord) {
        User user = userRepository.findByUserName(userName);

        if (user != null && passwordEncoder.matches(passWord, user.getPassWord())) {
            return user;
        }

        return null;
    }

    @Override
    public void deleteUser(int id) {
        Optional<User> getUserById = userRepository.findById(id);
        if (getUserById.isPresent()) {
            User user = getUserById.get();
            userRepository.delete(user);
        }
    }

}
