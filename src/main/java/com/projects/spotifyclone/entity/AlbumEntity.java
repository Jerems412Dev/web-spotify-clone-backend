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
    @ManyToMany
    private List<CategoryEntity> categories;
}
