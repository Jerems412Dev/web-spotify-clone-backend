package com.projects.spotifyclone.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "artists")
public class ArtistEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idArtist;
    private String nameArtist;
    private String profilePicture;

    //All relationships

    @OneToMany(mappedBy = "artist")
    private List<AlbumEntity> albums;

    @ManyToMany(mappedBy = "artists")
    private List<UserEntity> users;

    @ManyToMany(mappedBy = "artists")
    private List<TrackEntity> tracks;

    //relation for category
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "artist_category",
            joinColumns = @JoinColumn(name = "category_id", referencedColumnName = "idCategory"),
            inverseJoinColumns = @JoinColumn(name = "artist_id",
                    referencedColumnName = "idArtist"))
    private List<CategoryEntity> categories;
}
