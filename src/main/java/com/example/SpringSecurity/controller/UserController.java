package com.example.SpringSecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.SpringSecurity.model.User;
import com.example.SpringSecurity.service.UserService;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String handleViewHomePage() {
        return "index";
    }

    @GetMapping("/show-list")
    public String handleShowList(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        System.out.println(user);
        if (user != null) {
            System.out.println(user);
            List<User> userList = userService.showList();
            model.addAttribute("userList", userList);
            return "components/show-list";
        }

        return "redirect:/login";
    }

    
}
