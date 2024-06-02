package com.projects.spotifyclone.controller;

import com.projects.spotifyclone.dto.SpotifyPlaylistDTO;
import com.projects.spotifyclone.service.SpotifyPlaylistService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/spotifyplaylists")
public class SpotifyPlaylistController {
    private final SpotifyPlaylistService spotifyplaylistservice;

    public SpotifyPlaylistController(SpotifyPlaylistService spotifyplaylistservice) {
        this.spotifyplaylistservice = spotifyplaylistservice;
    }

    @PostMapping(value = "/createspotifyplaylist", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<String> createSpotifyPlaylist(@RequestBody SpotifyPlaylistDTO playlist) {
        return ResponseEntity.ok().body(spotifyplaylistservice.createSpotifyPlaylist(playlist));
    }

    @PostMapping(value = "/createspotifyplaylists", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<String> createSpotifyPlaylists(@RequestBody List<SpotifyPlaylistDTO> playlists) {
        return ResponseEntity.ok().body(spotifyplaylistservice.createSpotifyPlaylists(playlists));
    }

    @GetMapping(value = "/findbynameplaylist/{nameplaylist}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SpotifyPlaylistDTO> findByNamePlaylist(@PathVariable("nameplaylist") String nameplaylist) {
        return ResponseEntity.ok().body(spotifyplaylistservice.findByNamePlaylist(nameplaylist));
    }

    @GetMapping(value = "/findrandom10playlist", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SpotifyPlaylistDTO>> findRandom10Playlist() {
        return ResponseEntity.ok().body(spotifyplaylistservice.findRandom10Playlist());
    }

    @GetMapping(value = "/findbyidplaylist/{idplaylist}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SpotifyPlaylistDTO> findByIdPlaylist(@PathVariable("idplaylist") long idplaylist) {
        return ResponseEntity.ok().body(spotifyplaylistservice.findByIdPlaylist(idplaylist));
    }

    @GetMapping(value = "/findbynamecategory/{namecategory}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SpotifyPlaylistDTO>> findByNameCategory(@PathVariable("namecategory") String namecategory) {
        return ResponseEntity.ok().body(spotifyplaylistservice.findByNameCategory(namecategory));
    }

    @GetMapping(value = "/findbyusername/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SpotifyPlaylistDTO>> findByUsername(@PathVariable("username") String username) {
        return ResponseEntity.ok().body(spotifyplaylistservice.findByUsername(username));
    }

    @GetMapping(value = "/searchspotifyplaylist/{containing}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SpotifyPlaylistDTO>> searchSpotifyPlaylist(@PathVariable("containing") String containing) {
        return ResponseEntity.ok().body(spotifyplaylistservice.searchSpotifyPlaylist(containing));
    }

    @GetMapping(value = "/playlistexist/{nameplaylist}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> playlistExist(@PathVariable("nameplaylist") String nameplaylist) {
        return ResponseEntity.ok().body(spotifyplaylistservice.playlistExist(nameplaylist));
    }

    @GetMapping(value = "/deletebyusernameandnameplaylist/{username}/{nameplaylist}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> deleteByUsernameAndNamePlaylist(@PathVariable("username") String username,@PathVariable("nameplaylist") String nameplaylist) {
        return ResponseEntity.ok().body(spotifyplaylistservice.deleteByUsernameAndNamePlaylist(username,nameplaylist));
    }
}
