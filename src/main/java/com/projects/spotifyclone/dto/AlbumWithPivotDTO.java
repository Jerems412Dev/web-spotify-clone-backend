package com.projects.spotifyclone.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlbumWithPivotDTO {
    private long idAlbum;
    private String titleAlbum;
    private String profilePicture;
    private String releaseDate;
    private ArtistDTO artist;
    private List<TrackDTO> tracks;
    private Set<UserDTO> users = new HashSet<>();
    private List<CategoryDTO> categories;
}
