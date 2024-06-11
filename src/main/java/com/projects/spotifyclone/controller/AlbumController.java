package com.projects.spotifyclone.controller;

import com.projects.spotifyclone.dto.AlbumDTO;
import com.projects.spotifyclone.service.AlbumService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/albums")
public class AlbumController {
    private final AlbumService albumservice;

    public AlbumController(AlbumService albumservice) {
        this.albumservice = albumservice;
    }

    @PostMapping(value = "/createalbum", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<String> createAlbum(@RequestBody AlbumDTO album) {
        return ResponseEntity.ok().body(albumservice.createAlbum(album));
    }

    @PostMapping(value = "/createalbums", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<String> createAlbums(@RequestBody List<AlbumDTO> albums) {
        return ResponseEntity.ok().body(albumservice.createAlbums(albums));
    }

    @GetMapping(value = "/findalbumbyusername/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AlbumDTO>> findAlbumByUsername(@PathVariable("username") String username) {
        return ResponseEntity.ok().body(albumservice.findAlbumByUsername(username));
    }

    @GetMapping(value = "/findrandom10album", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AlbumDTO>> findRandom10() {
        return ResponseEntity.ok().body(albumservice.findRandom10());
    }

    @GetMapping(value = "/findbycategoryname/{categoryname}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AlbumDTO>> findByCategoryName(@PathVariable("categoryname") String categoryname) {
        return ResponseEntity.ok().body(albumservice.findByCategoryName(categoryname));
    }

    @GetMapping(value = "/searchalbum/{containing}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AlbumDTO>> searchAlbum(@PathVariable("containing") String containing) {
        return ResponseEntity.ok().body(albumservice.searchAlbum(containing));
    }

    @GetMapping(value = "/albumexist/{titlealbum}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> albumExist(@PathVariable("titlealbum") String titlealbum) {
        return ResponseEntity.ok().body(albumservice.albumExist(titlealbum));
    }

    @GetMapping(value = "/albumexistincategory/{titlealbum}/{namecategory}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> albumExistInCategory(@PathVariable("titlealbum") String titlealbum,@PathVariable("namecategory") String namecategory) {
        return ResponseEntity.ok().body(albumservice.albumExistInCategory(titlealbum,namecategory));
    }

    @GetMapping(value = "/deletealbumuser/{username}/{titlealbum}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> deleteAlbumUser(@PathVariable("username") String username,@PathVariable("titlealbum") String titlealbum) {
        return ResponseEntity.ok().body(albumservice.deleteAlbumUser(username,titlealbum));
    }

    @GetMapping(value = "/findbytitlealbum/{titlealbum}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AlbumDTO> findByTitleAlbum(@PathVariable("titlealbum") String titlealbum) {
        return ResponseEntity.ok().body(albumservice.findByTitleAlbum(titlealbum));
    }

    @GetMapping(value = "/existsbyidalbumandusername/{idalbum}/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> existsByIdAlbumAndUsername(@PathVariable("idalbum") long idalbum,@PathVariable("username") String username) {
        return ResponseEntity.ok().body(albumservice.existsByIdAlbumAndUsername(idalbum,username));
    }

    @GetMapping(value = "/favalbumbyuser/{iduser}/{idalbum}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String,String>> favAlbumByUser(@PathVariable("iduser") int iduser, @PathVariable("idalbum") int idalbum) {
        Map<String, String> response = new HashMap<>();
        response.put("message", albumservice.favAlbumByUser(iduser, idalbum));
        return ResponseEntity.ok().body(response);
    }

}
