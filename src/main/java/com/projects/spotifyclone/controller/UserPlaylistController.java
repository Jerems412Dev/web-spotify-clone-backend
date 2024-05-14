package com.projects.spotifyclone.controller;

import com.projects.spotifyclone.dto.UserPlaylistDTO;
import com.projects.spotifyclone.service.UserPlaylistService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/userplaylists")
public class UserPlaylistController {
    private final UserPlaylistService userplaylistservice;

    public UserPlaylistController(UserPlaylistService userplaylistservice) {
        this.userplaylistservice = userplaylistservice;
    }

    @PostMapping(value = "/createuserplaylist", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<String> createUserPlaylist(@RequestBody UserPlaylistDTO playlist) {
        return ResponseEntity.ok().body(userplaylistservice.createUserPlaylist(playlist));
    }

    @GetMapping(value = "/findbynameplaylist/{nameplaylist}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserPlaylistDTO> findByNamePlaylist(@PathVariable("nameplaylist") String nameplaylist) {
        return ResponseEntity.ok().body(userplaylistservice.findByNamePlaylist(nameplaylist));
    }

    @GetMapping(value = "/findbyidplaylist/{idplaylist}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserPlaylistDTO> findByIdPlaylist(@PathVariable("idplaylist") long idplaylist) {
        return ResponseEntity.ok().body(userplaylistservice.findByIdPlaylist(idplaylist));
    }

    @GetMapping(value = "/findbyusername/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserPlaylistDTO>> findByUsername(@PathVariable("username") String username) {
        return ResponseEntity.ok().body(userplaylistservice.findByUsername(username));
    }

    @GetMapping(value = "/existsbynameplaylist/{nameplaylist}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> existsByNamePlaylist(@PathVariable("nameplaylist") String nameplaylist) {
        return ResponseEntity.ok().body(userplaylistservice.existsByNamePlaylist(nameplaylist));
    }

    @GetMapping(value = "/deletebytracksanduserplaylist/{titletrack}/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> deleteByTracksAndUserPlaylist(@PathVariable("titletrack") String titletrack,@PathVariable("id") long id) {
        return ResponseEntity.ok().body(userplaylistservice.deleteByTracksAndUserPlaylist(titletrack,id));
    }
}
