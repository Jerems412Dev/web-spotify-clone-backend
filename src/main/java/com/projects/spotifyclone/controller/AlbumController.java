package com.projects.spotifyclone.controller;

import com.projects.spotifyclone.dto.AlbumDTO;
import com.projects.spotifyclone.service.AlbumService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/albums")
public class AlbumController {
    private final AlbumService albumservice;

    public AlbumController(AlbumService albumservice) {
        this.albumservice = albumservice;
    }

    @PostMapping("/createalbum")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<String> createAlbum(@RequestBody AlbumDTO album) {
        return new ResponseEntity<>(albumservice.createAlbum(album), HttpStatus.OK);
    }

    @GetMapping("/findalbumbyusername/{username}")
    public ResponseEntity<List<AlbumDTO>> findAlbumByUsername(@PathVariable("username") String username) {
        return new ResponseEntity<>(albumservice.findAlbumByUsername(username), HttpStatus.OK);
    }

    @GetMapping("/findbycategoryname/{categoryname}")
    public ResponseEntity<List<AlbumDTO>> findByCategoryName(@PathVariable("categoryname") String categoryname) {
        return new ResponseEntity<>(albumservice.findByCategoryName(categoryname), HttpStatus.OK);
    }

    @GetMapping("/searchalbum/{containing}")
    public ResponseEntity<List<AlbumDTO>> searchAlbum(@PathVariable("containing") String containing) {
        return new ResponseEntity<>(albumservice.searchAlbum(containing), HttpStatus.OK);
    }

    @GetMapping("/albumexist/{titlealbum}")
    public ResponseEntity<Boolean> albumExist(@PathVariable("titlealbum") String titlealbum) {
        return new ResponseEntity<>(albumservice.albumExist(titlealbum), HttpStatus.OK);
    }

    @GetMapping("/albumexistincategory/{titlealbum}/{namecategory}")
    public ResponseEntity<Boolean> albumExistInCategory(@PathVariable("titlealbum") String titlealbum,@PathVariable("namecategory") String namecategory) {
        return new ResponseEntity<>(albumservice.albumExistInCategory(titlealbum,namecategory), HttpStatus.OK);
    }

    @GetMapping("/deletealbumuser/{username}/{titlealbum}")
    public ResponseEntity<Boolean> deleteAlbumUser(@PathVariable("username") String username,@PathVariable("titlealbum") String titlealbum) {
        return new ResponseEntity<>(albumservice.deleteAlbumUser(username,titlealbum), HttpStatus.OK);
    }

    @GetMapping("/favalbumbyuser/{iduser}/{idalbum}")
    public ResponseEntity<String> favAlbumByUser(@PathVariable("iduser") long iduser,@PathVariable("idalbum") long idalbum) {
        return new ResponseEntity<>(albumservice.favAlbumByUser(iduser,idalbum), HttpStatus.OK);
    }

    @GetMapping("/findbytitlealbum/{titlealbum}")
    public ResponseEntity<AlbumDTO> findByTitleAlbum(@PathVariable("titlealbum") String titlealbum) {
        return new ResponseEntity<>(albumservice.findByTitleAlbum(titlealbum), HttpStatus.OK);
    }

}
