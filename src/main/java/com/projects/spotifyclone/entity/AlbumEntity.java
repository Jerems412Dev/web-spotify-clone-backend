package com.projects.spotifyclone.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    private String releaseDate;

    //All relationships

    @ManyToOne
    @JoinColumn(name="artist_id")
    private ArtistEntity artist;

    @OneToMany(mappedBy = "album")
    private List<TrackEntity> tracks;

    @ManyToMany(mappedBy = "albums")
    private Set<UserEntity> users = new HashSet<>();

    //relation for categories
    @ManyToMany
    private List<CategoryEntity> categories;
}
