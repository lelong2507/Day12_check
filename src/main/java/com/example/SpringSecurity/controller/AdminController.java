package com.example.SpringSecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.SpringSecurity.model.User;
import com.example.SpringSecurity.service.UserService;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @PostMapping("/delete/{id}")
    public String handleDeleteUser(@PathVariable("id") String id) {
        try {
            int idUser = Integer.parseInt(id);
            System.out.println(idUser);
            userService.deleteUser(idUser);
        } catch (NumberFormatException e) {
            System.out.println(e);
        }

        return "redirect:/";
    }

}
