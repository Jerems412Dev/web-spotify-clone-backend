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
    private String coverPicture;

    //All relationships

    @OneToMany(mappedBy = "artist")
    private List<AlbumEntity> albums;

    @ManyToMany(mappedBy = "artists")
    private List<UserEntity> users;

    @ManyToMany(mappedBy = "artists")
    private List<TrackEntity> tracks;

    //relation for category
    @ManyToMany
    private List<CategoryEntity> categories;
}
