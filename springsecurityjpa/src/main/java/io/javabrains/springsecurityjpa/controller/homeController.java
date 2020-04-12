package io.javabrains.springsecurityjpa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class homeController {
    @GetMapping ("/home")
    public String  home(){
        return "Welcome";
    }



    @GetMapping ("/user")
    public String  user(){
        return "welcome User";
    }

    @GetMapping ("/admin")
    public String  admin(){
        return "Welcome admin";
    }
}
