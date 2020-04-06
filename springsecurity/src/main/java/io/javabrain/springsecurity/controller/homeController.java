package io.javabrain.springsecurity.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class homeController {
    @RequestMapping("/home")
    public String  home(){
        return "Welcome";
    }
    @RequestMapping("/user")
    public String  user(){
        return "welcome User";
    }
    @RequestMapping("/admin")
    public String  admin(){
        return "Welcome admin";
    }
}
