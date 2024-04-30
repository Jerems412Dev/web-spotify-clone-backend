package com.projects.spotifyclone.dto;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserPlaylistDTO {
    private long idUserPlaylist;
    private String namePlaylist;
    private String description;
    private String profilePicture;

    //All relationships

    @ManyToOne
    @JoinColumn(name="user_id")
    private UserDTO user;

    @ManyToMany(mappedBy = "userplaylists")
    private List<TrackDTO> tracks;
}
