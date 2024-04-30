package com.projects.spotifyclone.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "spotifyplaylists")
public class SpotifyPlaylistEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idSpotifyPlaylist;
    private String namePlaylist;
    private String description;
    private String profilePicture;

    //All relationships

    @ManyToMany(mappedBy = "spotifyplaylists")
    private List<UserEntity> users;

    @ManyToMany(mappedBy = "spotifyplaylists")
    private List<TrackEntity> tracks;

    //relation for category
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "spotifyplaylist_category",
            joinColumns = @JoinColumn(name = "category_id", referencedColumnName = "idCategory"),
            inverseJoinColumns = @JoinColumn(name = "spotifyplaylist_id",
                    referencedColumnName = "idSpotifyPlaylist"))
    private List<CategoryEntity> categories;
}
