package com.projects.spotifyclone.controller;

import com.projects.spotifyclone.dto.CategoryDTO;
import com.projects.spotifyclone.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private final CategoryService categoryservice;

    public CategoryController(CategoryService categoryservice) {
        this.categoryservice = categoryservice;
    }

    @PostMapping("/createcategory")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<String> createCategory(@RequestBody CategoryDTO category) {
        return new ResponseEntity<>(categoryservice.createCategory(category), HttpStatus.OK);
    }

    @GetMapping("/findbynamecategory/{namecategory}")
    public ResponseEntity<CategoryDTO> findAlbumByNameCategory(@PathVariable("namecategory") String namecategory) {
        return new ResponseEntity<>(categoryservice.findByNameCategory(namecategory), HttpStatus.OK);
    }

    @GetMapping("/findbyidcategory/{idcategory}")
    public ResponseEntity<CategoryDTO> findByIdCategory(@PathVariable("idcategory") long idcategory) {
        return new ResponseEntity<>(categoryservice.findByIdCategory(idcategory), HttpStatus.OK);
    }

    @GetMapping("/findbytitlealbum/{titlealbum}")
    public ResponseEntity<List<CategoryDTO>> findByTitleAlbum(@PathVariable("titlealbum") String titlealbum) {
        return new ResponseEntity<>(categoryservice.findByTitleAlbum(titlealbum), HttpStatus.OK);
    }

    @GetMapping("/findbynameartist/{nameartist}")
    public ResponseEntity<List<CategoryDTO>> findByNameArtist(@PathVariable("nameartist") String nameartist) {
        return new ResponseEntity<>(categoryservice.findByNameArtist(nameartist), HttpStatus.OK);
    }

    @GetMapping("/findByNamePlaylist/{nameplaylist}")
    public ResponseEntity<List<CategoryDTO>> findByNamePlaylist(@PathVariable("nameplaylist") String nameplaylist) {
        return new ResponseEntity<>(categoryservice.findByNamePlaylist(nameplaylist), HttpStatus.OK);
    }

    @GetMapping("/findByNamePlaylist/{namecategory}")
    public ResponseEntity<Boolean> categoryExist(@PathVariable("namecategory") String namecategory) {
        return new ResponseEntity<>(categoryservice.categoryExist(namecategory), HttpStatus.OK);
    }
}
