package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.request.AuthRequest;
import com.example.utility.JwtUtility;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtility jwtUtil;

    @PostMapping("/login")
    public String login(@RequestBody AuthRequest request) {
    	System.out.println(request.getUsername() +
                request.getPassword()
       );
    	
    	try {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
    	}
    	catch(Exception e) {
    		System.out.println(e.getMessage());
    		throw e;
    	}
        
        return jwtUtil.generateToken(request.getUsername());
    }
}
