package com.projects.spotifyclone.controller;

import com.projects.spotifyclone.dto.AlbumDTO;
import com.projects.spotifyclone.dto.ArtistDTO;
import com.projects.spotifyclone.service.AlbumService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/albums")
@AllArgsConstructor
public class AlbumController {
    private AlbumService albumservice;

    @PostMapping("/createalbum")
    @ResponseStatus(code = HttpStatus.CREATED)
    public String createAlbum() {
        //return albumservice.createAlbum(album,artist);
        return "bien";
    }

}
