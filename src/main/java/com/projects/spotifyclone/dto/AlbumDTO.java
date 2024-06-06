package com.projects.spotifyclone.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlbumDTO {
    private long idAlbum;
    private String titleAlbum;
    private String profilePicture;
    private String releaseDate;
    private ArtistDTO artist;
    private List<CategoryDTO> categories;
}
