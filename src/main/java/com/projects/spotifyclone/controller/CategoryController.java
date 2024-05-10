package com.projects.spotifyclone.controller;

import com.projects.spotifyclone.dto.CategoryDTO;
import com.projects.spotifyclone.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryservice;

    public CategoryController(CategoryService categoryservice) {
        this.categoryservice = categoryservice;
    }

    @PostMapping(value = "/createcategory", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<String> createCategory(@RequestBody CategoryDTO category) {
        return ResponseEntity.ok().body(categoryservice.createCategory(category));
    }

    @PostMapping(value = "/createcategories", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<String> createCategories(@RequestBody List<CategoryDTO> categorie) {
        return ResponseEntity.ok().body(categoryservice.createCategories(categorie));
    }

    @GetMapping(value = "/findbynamecategory/{namecategory}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CategoryDTO> findAlbumByNameCategory(@PathVariable("namecategory") String namecategory) {
        return ResponseEntity.ok().body(categoryservice.findByNameCategory(namecategory));
    }

    @GetMapping(value = "/findbyidcategory/{idcategory}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CategoryDTO> findByIdCategory(@PathVariable("idcategory") long idcategory) {
        return ResponseEntity.ok().body(categoryservice.findByIdCategory(idcategory));
    }

    @GetMapping(value = "/findbytitlealbum/{titlealbum}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CategoryDTO>> findByTitleAlbum(@PathVariable("titlealbum") String titlealbum) {
        return ResponseEntity.ok().body(categoryservice.findByTitleAlbum(titlealbum));
    }

    @GetMapping(value = "/findbynameartist/{nameartist}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CategoryDTO>> findByNameArtist(@PathVariable("nameartist") String nameartist) {
        return ResponseEntity.ok().body(categoryservice.findByNameArtist(nameartist));
    }

    @GetMapping(value = "/findbynameplaylist/{nameplaylist}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CategoryDTO>> findByNamePlaylist(@PathVariable("nameplaylist") String nameplaylist) {
        return ResponseEntity.ok().body(categoryservice.findByNamePlaylist(nameplaylist));
    }

    @GetMapping(value = "/categoryexist/{namecategory}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> categoryExist(@PathVariable("namecategory") String namecategory) {
        return ResponseEntity.ok().body(categoryservice.categoryExist(namecategory));
    }
}
