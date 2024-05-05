package com.projects.spotifyclone.controller;

import com.projects.spotifyclone.dto.ArtistDTO;
import com.projects.spotifyclone.service.ArtistService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artists")
public class ArtistController {
    private final ArtistService artistservice;

    public ArtistController(ArtistService artistservice) {
        this.artistservice = artistservice;
    }

    @PostMapping("/createartist")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<String> createArtist(@RequestBody ArtistDTO artist) {
        return new ResponseEntity<>(artistservice.createArtist(artist), HttpStatus.OK);
    }

    @GetMapping("/findartistbyusername/{username}")
    public ResponseEntity<List<ArtistDTO>> findArtistByUsername(@PathVariable("username") String username) {
        return new ResponseEntity<>(artistservice.findArtistByUsername(username), HttpStatus.OK);
    }

    @GetMapping("/findbycategoryname/{categoryname}")
    public ResponseEntity<List<ArtistDTO>> findByCategoryName(@PathVariable("categoryname") String categoryname) {
        return new ResponseEntity<>(artistservice.findByCategoryName(categoryname), HttpStatus.OK);
    }

    @GetMapping("/searchartist/{containing}")
    public ResponseEntity<List<ArtistDTO>> searchArtist(@PathVariable("containing") String containing) {
        return new ResponseEntity<>(artistservice.searchArtist(containing), HttpStatus.OK);
    }

    @GetMapping("/artistexist/{nameartist}")
    public ResponseEntity<Boolean> artistExist(@PathVariable("nameartist") String nameartist) {
        return new ResponseEntity<>(artistservice.artistExist(nameartist), HttpStatus.OK);
    }

    @GetMapping("/artistexistincategory/{nameartist}/{namecategory}")
    public ResponseEntity<Boolean> artistExistInCategory(@PathVariable("nameartist") String nameartist,@PathVariable("namecategory") String namecategory) {
        return new ResponseEntity<>(artistservice.artistExistInCategory(nameartist,namecategory), HttpStatus.OK);
    }

    @GetMapping("/deleteartistuser/{username}/{nameartist}")
    public ResponseEntity<Boolean> deleteArtistUser(@PathVariable("username") String username,@PathVariable("nameartist") String nameartist) {
        return new ResponseEntity<>(artistservice.deleteArtistUser(username,nameartist), HttpStatus.OK);
    }

    @GetMapping("/favartistbyuser/{iduser}/{idartist}")
    public ResponseEntity<String> favArtistByUser(@PathVariable("iduser") long iduser,@PathVariable("idartist") long idartist) {
        return new ResponseEntity<>(artistservice.favArtistByUser(iduser,idartist), HttpStatus.OK);
    }

    @GetMapping("/findartistbynameartist/{nameartist}")
    public ResponseEntity<ArtistDTO> findByNameArtist(@PathVariable("nameartist") String nameartist) {
        return new ResponseEntity<>(artistservice.findByNameArtist(nameartist), HttpStatus.OK);
    }


}
