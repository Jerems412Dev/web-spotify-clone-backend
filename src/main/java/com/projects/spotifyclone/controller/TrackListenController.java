package com.projects.spotifyclone.controller;

import com.projects.spotifyclone.dto.TrackDTO;
import com.projects.spotifyclone.dto.TrackListenDTO;
import com.projects.spotifyclone.service.TrackListenService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/tracklistens")
public class TrackListenController {
    private final TrackListenService tracklistenservice;

    public TrackListenController(TrackListenService tracklistenservice) {
        this.tracklistenservice = tracklistenservice;
    }

    @GetMapping(value = "/findlasttracklisten/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TrackDTO> findLastTrackListen(@PathVariable("username") String username) {
        return ResponseEntity.ok().body(tracklistenservice.findLastTrackListen(username));
    }

    @GetMapping(value = "/findbyuserandtrack/{username}/{titletrack}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TrackListenDTO>> findByUserAndTrack(@PathVariable("username") String username,@PathVariable("titletrack") String titletrack) {
        return ResponseEntity.ok().body(tracklistenservice.findByUserAndTrack(username,titletrack));
    }

    @GetMapping(value = "/findbyuserandtracknot/{username}/{titletrack}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TrackListenDTO>> findByUserAndTrackNot(@PathVariable("username") String username,@PathVariable("titletrack") String titletrack) {
        return ResponseEntity.ok().body(tracklistenservice.findByUserAndTrackNot(username,titletrack));
    }

    @GetMapping(value = "/existsbyuserandtrack/{username}/{titletrack}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> existsByUserAndTrack(@PathVariable("username") String username,@PathVariable("titletrack") String titletrack) {
        return ResponseEntity.ok().body(tracklistenservice.existsByUserAndTrack(username,titletrack));
    }
}
