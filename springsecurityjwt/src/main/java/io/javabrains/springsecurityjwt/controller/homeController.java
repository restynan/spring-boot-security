package io.javabrains.springsecurityjwt.controller;

import io.javabrains.springsecurityjwt.models.AtheticationRequest;
import io.javabrains.springsecurityjwt.models.AuthenticationRespose;
import io.javabrains.springsecurityjwt.services.MyUserDetailsService;
import io.javabrains.springsecurityjwt.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
public class homeController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Qualifier("use")
    @Autowired
    UserDetailsService userDetailsService;
    @Autowired
    JwtUtil jwttokenutil;


    @GetMapping("/")
    public String index() {
        return "welcome";
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AtheticationRequest atheticationRequest) throws Exception{

       try {
           authenticationManager.authenticate(
                   new UsernamePasswordAuthenticationToken(atheticationRequest.getUsername(), atheticationRequest.getPassword())
           );
       } catch (BadCredentialsException e) {
           throw new Exception("Incorect User name or password",e);
       }

       final UserDetails userDetails = userDetailsService.loadUserByUsername(atheticationRequest.getUsername());


final String jwt =  jwttokenutil.generateToken(userDetails) ;
return ResponseEntity.ok( new AuthenticationRespose(jwt));
    }
}