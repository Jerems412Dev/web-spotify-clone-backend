package com.projects.spotifyclone.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlbumDTO {
    private long idAlbum;
    private String titleAlbum;
    private String profilePicture;
    private String releaseDate;
    private ArtistDTO artist;
}
