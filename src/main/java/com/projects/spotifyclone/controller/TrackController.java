package com.projects.spotifyclone.controller;

import com.projects.spotifyclone.dto.TrackDTO;
import com.projects.spotifyclone.service.TrackService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/tracks")
public class TrackController {
    private final TrackService trackservice;

    public TrackController(TrackService trackservice) {
        this.trackservice = trackservice;
    }

    @PostMapping(value = "/createtrack", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<String> createTrack(@RequestBody TrackDTO track) {
        return ResponseEntity.ok().body(trackservice.createTrack(track));
    }

    @PostMapping(value = "/createtracks", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<String> createTracks(@RequestBody List<TrackDTO> tracks) {
        return ResponseEntity.ok().body(trackservice.createTracks(tracks));
    }

    @GetMapping(value = "/findtrackbytitle/{titletrack}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TrackDTO> findTrackByTitle(@PathVariable("titletrack") String titletrack) {
        return ResponseEntity.ok().body(trackservice.findTrackByTitle(titletrack));
    }

    @GetMapping(value = "/findtrackbyId/{idtrack}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TrackDTO> findTrackById(@PathVariable("idtrack") long idtrack) {
        return ResponseEntity.ok().body(trackservice.findTrackById(idtrack));
    }

    @GetMapping(value = "/findtrackbyusername/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TrackDTO>> findTrackByUsername(@PathVariable("username") String username) {
        return ResponseEntity.ok().body(trackservice.findTrackByUsername(username));
    }

    @GetMapping(value = "/findrandom10track", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TrackDTO>> findRandom10() {
        return ResponseEntity.ok().body(trackservice.findRandom10());
    }

    @GetMapping(value = "/findtrackbytitlealbum/{titlealbum}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TrackDTO>> findTrackByTitleAlbum(@PathVariable("titlealbum") String titlealbum) {
        return ResponseEntity.ok().body(trackservice.findTrackByTitleAlbum(titlealbum));
    }

    @GetMapping(value = "/findtrackbynameartist/{nameartist}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TrackDTO>> findTrackByNameArtist(@PathVariable("nameartist") String nameartist) {
        return ResponseEntity.ok().body(trackservice.findTrackByNameArtist(nameartist));
    }

    @GetMapping(value = "/findbynamecategory/{nameCategory}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TrackDTO>> findByNameCategory(@PathVariable("nameCategory") String nameCategory) {
        return ResponseEntity.ok().body(trackservice.findByNameCategory(nameCategory));
    }

    @GetMapping(value = "/findbyiduserplaylist/{idplaylist}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TrackDTO>> findByIdUserPlaylist(@PathVariable("idplaylist") long idplaylist) {
        return ResponseEntity.ok().body(trackservice.findByIdUserPlaylist(idplaylist));
    }

    @GetMapping(value = "/findbyiduserplaylistnot/{idplaylist}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TrackDTO>> findByIdUserPlaylistNot(@PathVariable("idplaylist") long idplaylist) {
        return ResponseEntity.ok().body(trackservice.findByIdUserPlaylistNot(idplaylist));
    }

    @GetMapping(value = "/findbyidspotifyplaylist/{idplaylist}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TrackDTO>> findByIdSpotifyPlaylist(@PathVariable("idplaylist") long idplaylist) {
        return ResponseEntity.ok().body(trackservice.findByIdSpotifyPlaylist(idplaylist));
    }

    @GetMapping(value = "/findbyidspotifyplaylistnot/{idplaylist}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TrackDTO>> findByIdSpotifyPlaylistNot(@PathVariable("idplaylist") long idplaylist) {
        return ResponseEntity.ok().body(trackservice.findByIdSpotifyPlaylistNot(idplaylist));
    }

    @GetMapping(value = "/findBytitletrackcontaining/{search}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TrackDTO>> findByTitleTrackContaining(@PathVariable("search") String search) {
        return ResponseEntity.ok().body(trackservice.findByTitleTrackContaining(search));
    }

    @GetMapping(value = "/existsByTitleTrack/{titletrack}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> existsByTitleTrack(@PathVariable("titletrack") String titletrack) {
        return ResponseEntity.ok().body(trackservice.existsByTitleTrack(titletrack));
    }

    @GetMapping(value = "/existsbyidtrackandusername/{idtrack}/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> existsByIdTrackAndUsersUsername(@PathVariable("idtrack") long idtrack,@PathVariable("username") String username) {
        return ResponseEntity.ok().body(trackservice.existsByIdTrackAndUsersUsername(idtrack,username));
    }

    @GetMapping(value = "/deletebyusertrack/{iduser}/{idtrack}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> deleteByUserTrack(@PathVariable("iduser") int iduser,@PathVariable("idtrack") int idtrack) {
        return ResponseEntity.ok().body(trackservice.deleteByUserAndTrack(iduser,idtrack));
    }

    @GetMapping(value = "/favtrackbyuser/{iduser}/{idtrack}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String,String>> favTrackByUser(@PathVariable("iduser") int iduser, @PathVariable("idtrack") int idtrack) {
        Map<String, String> response = new HashMap<>();
        response.put("message",trackservice.favTrackByUser(iduser,idtrack));
        return ResponseEntity.ok().body(response);
    }

}
