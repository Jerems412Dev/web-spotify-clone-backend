package com.projects.spotifyclone.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrackDTO {
    private long idTrack;
    private String titleTrack;
    private String duration;
    private String profilePicture;
    private AlbumDTO album;
    private List<ArtistDTO> artists;
    private List<UserDTO> users;
    private List<CategoryDTO> categories;
    private List<SpotifyPlaylistDTO> spotifyplaylists;
    private List<UserPlaylistDTO> userplaylists;
}
