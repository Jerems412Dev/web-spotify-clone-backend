package com.projects.spotifyclone.dto;

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
    private List<TrackDTO> tracks;
}
