package com.projects.spotifyclone.controller;

import com.projects.spotifyclone.dto.SpotifyPlaylistDTO;
import com.projects.spotifyclone.service.SpotifyPlaylistService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/spotifyplaylists")
public class SpotifyPlaylistController {
    private final SpotifyPlaylistService spotifyplaylistservice;

    public SpotifyPlaylistController(SpotifyPlaylistService spotifyplaylistservice) {
        this.spotifyplaylistservice = spotifyplaylistservice;
    }

    @PostMapping("/createspotifyplaylist")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<String> createSpotifyPlaylist(@RequestBody SpotifyPlaylistDTO playlist) {
        return new ResponseEntity<>(spotifyplaylistservice.createSpotifyPlaylist(playlist), HttpStatus.OK);
    }

    @GetMapping("/findbynameplaylist/{nameplaylist}")
    public ResponseEntity<SpotifyPlaylistDTO> findByNamePlaylist(@PathVariable("nameplaylist") String nameplaylist) {
        return new ResponseEntity<>(spotifyplaylistservice.findByNamePlaylist(nameplaylist), HttpStatus.OK);
    }

    @GetMapping("/findbyidplaylist/{idplaylist}")
    public ResponseEntity<SpotifyPlaylistDTO> findByIdPlaylist(@PathVariable("idplaylist") long idplaylist) {
        return new ResponseEntity<>(spotifyplaylistservice.findByIdPlaylist(idplaylist), HttpStatus.OK);
    }

    @GetMapping("/findbynamecategory/{namecategory}")
    public ResponseEntity<List<SpotifyPlaylistDTO>> findByNameCategory(@PathVariable("namecategory") String namecategory) {
        return new ResponseEntity<>(spotifyplaylistservice.findByNameCategory(namecategory), HttpStatus.OK);
    }

    @GetMapping("/findbyusername/{username}")
    public ResponseEntity<List<SpotifyPlaylistDTO>> findByUsername(@PathVariable("username") String username) {
        return new ResponseEntity<>(spotifyplaylistservice.findByUsername(username), HttpStatus.OK);
    }

    @GetMapping("/searchspotifyplaylist/{containing}")
    public ResponseEntity<List<SpotifyPlaylistDTO>> searchSpotifyPlaylist(@PathVariable("containing") String containing) {
        return new ResponseEntity<>(spotifyplaylistservice.searchSpotifyPlaylist(containing), HttpStatus.OK);
    }

    @GetMapping("/playlistexist/{nameplaylist}")
    public ResponseEntity<Boolean> playlistExist(@PathVariable("nameplaylist") String nameplaylist) {
        return new ResponseEntity<>(spotifyplaylistservice.playlistExist(nameplaylist), HttpStatus.OK);
    }

    @GetMapping("/deletebyusernameandnameplaylist/{username}/{nameplaylist}")
    public ResponseEntity<Boolean> deleteByUsernameAndNamePlaylist(@PathVariable("username") String username,@PathVariable("nameplaylist") String nameplaylist) {
        return new ResponseEntity<>(spotifyplaylistservice.deleteByUsernameAndNamePlaylist(username,nameplaylist), HttpStatus.OK);
    }
}
