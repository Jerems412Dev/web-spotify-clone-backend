package com.projects.spotifyclone.controller;

import com.projects.spotifyclone.dto.TrackDTO;
import com.projects.spotifyclone.service.TrackService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tracks")
public class TrackController {
    private final TrackService trackservice;

    public TrackController(TrackService trackservice) {
        this.trackservice = trackservice;
    }

    @PostMapping("/createtrack")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<String> createTrack(@RequestBody TrackDTO track) {
        return new ResponseEntity<>(trackservice.createTrack(track), HttpStatus.OK);
    }

    @GetMapping("/findtrackbytitle/{titletrack}")
    public ResponseEntity<TrackDTO> findTrackByTitle(@PathVariable("titletrack") String titletrack) {
        return new ResponseEntity<>(trackservice.findTrackByTitle(titletrack), HttpStatus.OK);
    }

    @GetMapping("/findtrackbyId/{idtrack}")
    public ResponseEntity<TrackDTO> findTrackById(@PathVariable("idtrack") long idtrack) {
        return new ResponseEntity<>(trackservice.findTrackById(idtrack), HttpStatus.OK);
    }

    @GetMapping("/findtrackbyusername/{username}")
    public ResponseEntity<List<TrackDTO>> findTrackByUsername(@PathVariable("username") String username) {
        return new ResponseEntity<>(trackservice.findTrackByUsername(username), HttpStatus.OK);
    }

    @GetMapping("/findtrackbytitlealbum/{titlealbum}")
    public ResponseEntity<List<TrackDTO>> findTrackByTitleAlbum(@PathVariable("titlealbum") String titlealbum) {
        return new ResponseEntity<>(trackservice.findTrackByTitleAlbum(titlealbum), HttpStatus.OK);
    }

    @GetMapping("/findtrackbynameartist/{nameartist}")
    public ResponseEntity<List<TrackDTO>> findTrackByNameArtist(@PathVariable("nameartist") String nameartist) {
        return new ResponseEntity<>(trackservice.findTrackByNameArtist(nameartist), HttpStatus.OK);
    }

    @GetMapping("/findbynamecategory/{nameCategory}")
    public ResponseEntity<List<TrackDTO>> findByNameCategory(@PathVariable("nameCategory") String nameCategory) {
        return new ResponseEntity<>(trackservice.findByNameCategory(nameCategory), HttpStatus.OK);
    }

    @GetMapping("/findbyiduserplaylist/{idplaylist}")
    public ResponseEntity<List<TrackDTO>> findByIdUserPlaylist(@PathVariable("idplaylist") long idplaylist) {
        return new ResponseEntity<>(trackservice.findByIdUserPlaylist(idplaylist), HttpStatus.OK);
    }

    @GetMapping("/findbyiduserplaylistnot/{idplaylist}")
    public ResponseEntity<List<TrackDTO>> findByIdUserPlaylistNot(@PathVariable("idplaylist") long idplaylist) {
        return new ResponseEntity<>(trackservice.findByIdUserPlaylistNot(idplaylist), HttpStatus.OK);
    }

    @GetMapping("/findbyidspotifyplaylist/{idplaylist}")
    public ResponseEntity<List<TrackDTO>> findByIdSpotifyPlaylist(@PathVariable("idplaylist") long idplaylist) {
        return new ResponseEntity<>(trackservice.findByIdSpotifyPlaylist(idplaylist), HttpStatus.OK);
    }

    @GetMapping("/findbyidspotifyplaylistnot/{idplaylist}")
    public ResponseEntity<List<TrackDTO>> findByIdSpotifyPlaylistNot(@PathVariable("idplaylist") long idplaylist) {
        return new ResponseEntity<>(trackservice.findByIdSpotifyPlaylistNot(idplaylist), HttpStatus.OK);
    }

    @GetMapping("/findBytitletrackcontaining/{search}")
    public ResponseEntity<List<TrackDTO>> findByTitleTrackContaining(@PathVariable("search") String search) {
        return new ResponseEntity<>(trackservice.findByTitleTrackContaining(search), HttpStatus.OK);
    }

    @GetMapping("/existsByTitleTrack/{titletrack}")
    public ResponseEntity<Boolean> existsByTitleTrack(@PathVariable("titletrack") String titletrack) {
        return new ResponseEntity<>(trackservice.existsByTitleTrack(titletrack), HttpStatus.OK);
    }

    @GetMapping("/existsbytitletrackandusername/{titletrack}/{username}")
    public ResponseEntity<Boolean> existsByTitleTrackAndUsername(@PathVariable("titletrack") String titletrack,@PathVariable("username") String username) {
        return new ResponseEntity<>(trackservice.existsByTitleTrackAndUsername(titletrack,username), HttpStatus.OK);
    }

    @GetMapping("/deletebyusernameandtitletrack/{username}/{titletrack}")
    public ResponseEntity<Boolean> deleteByUsernameAndTitleTrack(@PathVariable("username") String username,@PathVariable("titletrack") String titletrack) {
        return new ResponseEntity<>(trackservice.deleteByUsernameAndTitleTrack(username,titletrack), HttpStatus.OK);
    }

}
