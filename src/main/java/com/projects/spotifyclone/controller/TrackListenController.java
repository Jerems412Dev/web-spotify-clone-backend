package com.projects.spotifyclone.controller;

import com.projects.spotifyclone.dto.TrackDTO;
import com.projects.spotifyclone.dto.TrackListenDTO;
import com.projects.spotifyclone.service.TrackListenService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tracklistens")
public class TrackListenController {
    private final TrackListenService tracklistenservice;

    public TrackListenController(TrackListenService tracklistenservice) {
        this.tracklistenservice = tracklistenservice;
    }

    @GetMapping("/findlasttracklisten/{username}")
    public ResponseEntity<TrackDTO> findLastTrackListen(@PathVariable("username") String username) {
        return new ResponseEntity<>(tracklistenservice.findLastTrackListen(username), HttpStatus.OK);
    }

    @GetMapping("/findbyuserandtrack/{username}/{titletrack}")
    public ResponseEntity<List<TrackListenDTO>> findByUserAndTrack(@PathVariable("username") String username,@PathVariable("titletrack") String titletrack) {
        return new ResponseEntity<>(tracklistenservice.findByUserAndTrack(username,titletrack), HttpStatus.OK);
    }

    @GetMapping("/findbyuserandtracknot/{username}/{titletrack}")
    public ResponseEntity<List<TrackListenDTO>> findByUserAndTrackNot(@PathVariable("username") String username,@PathVariable("titletrack") String titletrack) {
        return new ResponseEntity<>(tracklistenservice.findByUserAndTrackNot(username,titletrack), HttpStatus.OK);
    }

    @GetMapping("/existsbyuserandtrack/{username}/{titletrack}")
    public ResponseEntity<Boolean> existsByUserAndTrack(@PathVariable("username") String username,@PathVariable("titletrack") String titletrack) {
        return new ResponseEntity<>(tracklistenservice.existsByUserAndTrack(username,titletrack), HttpStatus.OK);
    }
}
