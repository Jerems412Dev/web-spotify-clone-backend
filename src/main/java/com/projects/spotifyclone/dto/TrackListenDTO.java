package com.projects.spotifyclone.dto;

import com.projects.spotifyclone.entity.TrackEntity;
import com.projects.spotifyclone.entity.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrackListenDTO {
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "music_id")
    private TrackEntity track;

    private String listenedAt;
}
