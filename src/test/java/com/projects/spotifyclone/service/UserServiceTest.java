package com.projects.spotifyclone.service;

import com.projects.spotifyclone.dto.UserDTO;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static com.projects.spotifyclone.entity.RoleEntity.USER;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void addUser() {
        /*UserDTO user = new UserDTO();
        user.setProfileName("jerems");
        user.setUsername("jeremyobiang412@gmail.com");
        user.setGender("Male");
        user.setCountry("Gabon");
        user.setBirth("04-25-2002");
        user.setRole(USER);
        userService.addUser(user);*/
    }
}
