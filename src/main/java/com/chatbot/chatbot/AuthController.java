package com.chatbot.chatbot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    @Autowired
    UserRepository userRepo;

    // 🔥 REGISTER
    @GetMapping("/register")
    public String register(@RequestParam String username,
                           @RequestParam String password) {

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        userRepo.save(user);

        return "User registered successfully!";
    }

    // 🔥 LOGIN
    @GetMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password) {

        User user = userRepo.findByUsername(username);

        if(user != null && user.getPassword().equals(password)) {
            return "success:" + user.getId();   // 🔥 ADD THIS
        } else {
            return "fail";
        }
    }
}