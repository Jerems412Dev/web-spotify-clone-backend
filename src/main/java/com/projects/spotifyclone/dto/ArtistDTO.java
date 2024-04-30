package com.projects.spotifyclone.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArtistDTO {
    private long idArtist;
    private String nameArtist;
    private String profilePicture;

    //All relationships

    @OneToMany(mappedBy = "artist")
    private List<AlbumDTO> albums;

    @ManyToMany(mappedBy = "artists")
    private List<UserDTO> users;

    @ManyToMany(mappedBy = "artists")
    private List<TrackDTO> tracks;

    //relation for category
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "artist_category",
            joinColumns = @JoinColumn(name = "category_id", referencedColumnName = "idCategory"),
            inverseJoinColumns = @JoinColumn(name = "artist_id",
                    referencedColumnName = "idArtist"))
    private List<CategoryDTO> categories;
}
