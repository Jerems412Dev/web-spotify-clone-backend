package com.projects.spotifyclone.controller;

import com.projects.spotifyclone.dto.ArtistDTO;
import com.projects.spotifyclone.service.ArtistService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin()
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

    @GetMapping(value = "/findartistbyusername/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ArtistDTO>> findArtistByUsername(@PathVariable("username") String username) {
        return ResponseEntity.ok().body(artistservice.findArtistByUsername(username));
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
    public ResponseEntity<String> favArtistByUser(@PathVariable("iduser") long iduser,@PathVariable("idartist") long idartist) {
        return ResponseEntity.ok().body(artistservice.favArtistByUser(iduser,idartist));
    }

    @GetMapping(value = "/findartistbynameartist/{nameartist}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ArtistDTO> findByNameArtist(@PathVariable("nameartist") String nameartist) {
        return ResponseEntity.ok().body(artistservice.findByNameArtist(nameartist));
    }

}
