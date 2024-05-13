package com.projects.spotifyclone.service;

import com.projects.spotifyclone.dto.RegisterDTO;
import com.projects.spotifyclone.entity.UserEntity;
import com.projects.spotifyclone.security.UserPrincipal;
import com.projects.spotifyclone.mapper.UserMapper;
import com.projects.spotifyclone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private  PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> user = userRepository.findByUsername(username);
        return user.map(UserPrincipal::new)
                .orElseThrow(() -> new UsernameNotFoundException("UserName not found: " + username));
    }
    public String addUser(RegisterDTO register) {
        register.setPassword(passwordEncoder.encode(register.getPassword()));
        userMapper.toUserDTO(userRepository.save(userMapper.fromRegisterDTO(register)));
        return "user register successfully";
    }
}
