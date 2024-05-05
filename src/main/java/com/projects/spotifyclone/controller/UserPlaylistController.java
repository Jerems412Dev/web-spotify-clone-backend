package com.projects.spotifyclone.controller;

import com.projects.spotifyclone.dto.UserPlaylistDTO;
import com.projects.spotifyclone.service.UserPlaylistService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userplaylists")
public class UserPlaylistController {
    private final UserPlaylistService userplaylistservice;

    public UserPlaylistController(UserPlaylistService userplaylistservice) {
        this.userplaylistservice = userplaylistservice;
    }

    @PostMapping("/createuserplaylist")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<String> createUserPlaylist(@RequestBody UserPlaylistDTO playlist) {
        return new ResponseEntity<>(userplaylistservice.createUserPlaylist(playlist), HttpStatus.OK);
    }

    @GetMapping("/findbynameplaylist/{nameplaylist}")
    public ResponseEntity<UserPlaylistDTO> findByNamePlaylist(@PathVariable("nameplaylist") String nameplaylist) {
        return new ResponseEntity<>(userplaylistservice.findByNamePlaylist(nameplaylist), HttpStatus.OK);
    }

    @GetMapping("/findbyidplaylist/{idplaylist}")
    public ResponseEntity<UserPlaylistDTO> findByIdPlaylist(@PathVariable("idplaylist") long idplaylist) {
        return new ResponseEntity<>(userplaylistservice.findByIdPlaylist(idplaylist), HttpStatus.OK);
    }

    @GetMapping("/findbyusername/{username}")
    public ResponseEntity<List<UserPlaylistDTO>> findByUsername(@PathVariable("username") String username) {
        return new ResponseEntity<>(userplaylistservice.findByUsername(username), HttpStatus.OK);
    }

    @GetMapping("/existsbynameplaylist/{nameplaylist}")
    public ResponseEntity<Boolean> existsByNamePlaylist(@PathVariable("nameplaylist") String nameplaylist) {
        return new ResponseEntity<>(userplaylistservice.existsByNamePlaylist(nameplaylist), HttpStatus.OK);
    }

    @GetMapping("/deletebytracksanduserplaylist/{titletrack}/{id}")
    public ResponseEntity<Boolean> deleteByTracksAndUserPlaylist(@PathVariable("titletrack") String titletrack,@PathVariable("id") long id) {
        return new ResponseEntity<>(userplaylistservice.deleteByTracksAndUserPlaylist(titletrack,id), HttpStatus.OK);
    }
}
