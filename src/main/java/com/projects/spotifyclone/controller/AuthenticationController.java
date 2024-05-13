package com.projects.spotifyclone.controller;

import com.projects.spotifyclone.dto.LoginDTO;
import com.projects.spotifyclone.dto.RegisterDTO;
import com.projects.spotifyclone.dto.UserDTO;
import com.projects.spotifyclone.security.JwtService;
import com.projects.spotifyclone.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin()
@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthenticationController {
    private UserService userService;
    private AuthenticationManager authenticationManager;
    private JwtService jwtService;

    @PostMapping("/register")
    public ResponseEntity<Map<String,String>> register(@RequestBody RegisterDTO user){
        Map<String, String> response = new HashMap<>();
        response.put("response", userService.addUser(user));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String,String>> login(@RequestBody LoginDTO login) {
        Authentication authenticate = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(login.getUsername(),login.getPassword()));
        if(authenticate.isAuthenticated()) {
            String token = jwtService.generateToken(login);
            Map<String, String> response = new HashMap<>();
            response.put("token", token);
            return ResponseEntity.ok().body(response);
        }else {
            throw new UsernameNotFoundException("invalid User Request");
        }
    }
}
