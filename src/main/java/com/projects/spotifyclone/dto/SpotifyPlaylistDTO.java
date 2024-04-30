package com.projects.spotifyclone.dto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SpotifyPlaylistDTO {
    private long idSpotifyPlaylist;
    private String namePlaylist;
    private String description;
    private String profilePicture;

    //All relationships

    @ManyToMany(mappedBy = "spotifyplaylists")
    private List<UserDTO> users;

    @ManyToMany(mappedBy = "spotifyplaylists")
    private List<TrackDTO> tracks;

    //relation for category
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "spotifyplaylist_category",
            joinColumns = @JoinColumn(name = "category_id", referencedColumnName = "idCategory"),
            inverseJoinColumns = @JoinColumn(name = "spotifyplaylist_id",
                    referencedColumnName = "idSpotifyPlaylist"))
    private List<CategoryDTO> categories;
}
