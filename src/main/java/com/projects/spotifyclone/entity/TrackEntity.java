package com.projects.spotifyclone.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "tracks")
public class TrackEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idTrack;
    private String titleTrack;
    private String duration;
    private String profilePicture;
}
