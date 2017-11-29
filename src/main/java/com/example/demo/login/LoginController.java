package com.example.demo.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/login")
public class LoginController {

    @Autowired
    UserRepository userRepository;


    @PostMapping("")
    public String login(@RequestBody UserEntity user) {
        if ("".equalsIgnoreCase(user.getUsername()) || "".equalsIgnoreCase(user.getPassword())) {
            return "Username or password cannot be blank";
        }

        UserEntity userFound = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        if (null == userFound) {
            return "Wrong username or password";
        }

        return "Successful";
    }
}
