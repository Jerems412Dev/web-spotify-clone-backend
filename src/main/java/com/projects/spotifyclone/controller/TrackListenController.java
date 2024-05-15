package com.projects.spotifyclone.controller;

import com.projects.spotifyclone.dto.TrackListenDTO;
import com.projects.spotifyclone.service.TrackListenService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/tracklistens")
public class TrackListenController {
    private final TrackListenService tracklistenservice;

    public TrackListenController(TrackListenService tracklistenservice) {
        this.tracklistenservice = tracklistenservice;
    }

    @PostMapping(value = "/createlisten", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<Map<String,String>> createListen(@RequestBody TrackListenDTO track) {
        Map<String, String> response = new HashMap<>();
        track.setListenedAt(LocalDateTime.now());
        response.put("response",tracklistenservice.createListen(track));
        return ResponseEntity.ok().body(response);
    }

    @GetMapping(value = "/findlasttracklisten/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TrackListenDTO> findLastTrackListen(@PathVariable("username") String username) {
        Map<String, TrackListenDTO> response = new HashMap<>();
        response.put("TrackListen",tracklistenservice.findLastTrackListen(username));
        return ResponseEntity.ok().body(response.get("TrackListen"));
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
