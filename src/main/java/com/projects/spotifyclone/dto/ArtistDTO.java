package com.projects.spotifyclone.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArtistDTO {
    private long idArtist;
    private String nameArtist;
    private String profilePicture;
    private String coverPicture;
    private List<CategoryDTO> categories;
}
