package com.projects.spotifyclone.controller;

import com.projects.spotifyclone.dto.UserDTO;
import com.projects.spotifyclone.security.JwtService;
import com.projects.spotifyclone.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthenticationController {
    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/register")
    public String register(@RequestBody UserDTO user){
        return userService.addUser(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody UserDTO user) {
        Authentication authenticate = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
        if(authenticate.isAuthenticated()) {
            return jwtService.generateToken(user);
        }else {
            throw new UsernameNotFoundException("invalid User Request");
        }
    }
}
