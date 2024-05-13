package com.projects.spotifyclone.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrackListenDTO {
    private Long id;
    private UserDTO user;
    private TrackDTO track;
    private String listenedAt;
}
