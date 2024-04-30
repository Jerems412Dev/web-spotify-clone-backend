package com.projects.spotifyclone.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "albums")
public class AlbumEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idAlbum;
    private String titleAlbum;
    private String profilePicture;

    //All relationships

    @ManyToOne
    @JoinColumn(name="artist_id")
    private ArtistEntity artist;

    @OneToMany(mappedBy = "album")
    private List<TrackEntity> tracks;

    @ManyToMany(mappedBy = "albums")
    private List<UserEntity> users;

    //relation for categories
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "album_category",
            joinColumns = @JoinColumn(name = "category_id", referencedColumnName = "idCategory"),
            inverseJoinColumns = @JoinColumn(name = "album_id",
                    referencedColumnName = "idAlbum"))
    private List<CategoryEntity> categories;
}
