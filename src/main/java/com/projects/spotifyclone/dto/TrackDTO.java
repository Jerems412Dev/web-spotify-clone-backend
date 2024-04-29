package com.projects.spotifyclone.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrackDTO {
    private long idTrack;
    private String titleTrack;
    private String duration;
    private String profilePicture;
}
