package com.projects.spotifyclone.controller;

import com.projects.spotifyclone.dto.ArtistDTO;
import com.projects.spotifyclone.service.ArtistService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/artists")
public class ArtistController {
    private final ArtistService artistservice;

    public ArtistController(ArtistService artistservice) {
        this.artistservice = artistservice;
    }

    @PostMapping(value = "/createartist", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<String> createArtist(@RequestBody ArtistDTO artist) {
        return ResponseEntity.ok().body(artistservice.createArtist(artist));
    }

    @PostMapping(value = "/createartists", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<String> createArtists(@RequestBody List<ArtistDTO> artists) {
        return ResponseEntity.ok().body(artistservice.createArtists(artists));
    }

    @GetMapping(value = "/findartistbyusername/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ArtistDTO>> findArtistByUsername(@PathVariable("username") String username) {
        return ResponseEntity.ok().body(artistservice.findArtistByUsername(username));
    }

    @GetMapping(value = "/findrandom10artist", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ArtistDTO>> findRandom10() {
        return ResponseEntity.ok().body(artistservice.findRandom10());
    }

    @GetMapping(value = "/findbycategoryname/{categoryname}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ArtistDTO>> findByCategoryName(@PathVariable("categoryname") String categoryname) {
        return ResponseEntity.ok().body(artistservice.findByCategoryName(categoryname));
    }

    @GetMapping(value = "/searchartist/{containing}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ArtistDTO>> searchArtist(@PathVariable("containing") String containing) {
        return ResponseEntity.ok().body(artistservice.searchArtist(containing));
    }

    @GetMapping(value = "/artistexist/{nameartist}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> artistExist(@PathVariable("nameartist") String nameartist) {
        return ResponseEntity.ok().body(artistservice.artistExist(nameartist));
    }

    @GetMapping(value = "/artistexistincategory/{nameartist}/{namecategory}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> artistExistInCategory(@PathVariable("nameartist") String nameartist,@PathVariable("namecategory") String namecategory) {
        return ResponseEntity.ok().body(artistservice.artistExistInCategory(nameartist,namecategory));
    }

    @GetMapping(value = "/deleteartistuser/{username}/{nameartist}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> deleteArtistUser(@PathVariable("username") String username,@PathVariable("nameartist") String nameartist) {
        return ResponseEntity.ok().body(artistservice.deleteArtistUser(username,nameartist));
    }

    @GetMapping(value = "/favartistbyuser/{iduser}/{idartist}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String,String>> favArtistByUser(@PathVariable("iduser") long iduser,@PathVariable("idartist") long idartist) {
        Map<String, String> response = new HashMap<>();
        response.put("response",artistservice.favArtistByUser(iduser,idartist));
        return ResponseEntity.ok().body(response);
    }

    @GetMapping(value = "/findartistbynameartist/{nameartist}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArtistDTO> findByNameArtist(@PathVariable("nameartist") String nameartist) {
        return ResponseEntity.ok().body(artistservice.findByNameArtist(nameartist));
    }

    @GetMapping(value = "/existsbynameartistandusername/{nameartist}/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> existsByNameArtistAndUsername(@PathVariable("nameartist") String nameartist,@PathVariable("username") String username) {
        return ResponseEntity.ok().body(artistservice.existsByNameArtistAndUsername(nameartist,username));
    }

}
