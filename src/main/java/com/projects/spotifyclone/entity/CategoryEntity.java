package com.projects.spotifyclone.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "categories")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCategory;
    private String nameCategory;

    //All relationships

    @ManyToMany(mappedBy = "categories")
    private List<TrackEntity> tracks;

    @ManyToMany(mappedBy = "categories")
    private List<ArtistEntity> artists;

    @ManyToMany(mappedBy = "categories")
    private List<AlbumEntity> albums;

    @ManyToMany(mappedBy = "categories")
    private List<SpotifyPlaylistEntity> spotifyplaylists;
}
