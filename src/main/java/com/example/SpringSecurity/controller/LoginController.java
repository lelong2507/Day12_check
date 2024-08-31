package com.example.SpringSecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.SpringSecurity.model.User;
import com.example.SpringSecurity.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String handleViewHomePage() {
        return "index";
    }

    @GetMapping("/show-register")
    public String handleShowRegisForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "components/register";
    }

    @GetMapping("/show-login")
    public String handleShowLogin(Model model) {
        model.addAttribute("user", new User());
        return "components/login";
    }

    @PostMapping("/register")
    public String handleRegister(User user) {
        userService.addUser(user);
        return "redirect:/login";
    }

    @PostMapping("/login")
    public String handleLogin(@RequestParam("userName") String userName, @RequestParam("passWord") String passWord,
            HttpSession session, Model model) {
        User user = userService.login(userName, passWord);
        System.out.println(user);
        if (user != null) {
            session.setAttribute("user", user);
            session.setAttribute("firstName", user.getFirstName());
            session.setAttribute("roleUser", user.getRole().getName());
            session.setMaxInactiveInterval(30 * 60);
            return "redirect:/";
        } else {
            return "redirect:/login?error";
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public String handleLogOut(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

}
