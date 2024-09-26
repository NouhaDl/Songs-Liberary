package com.project3.album.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class SongGenre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable=false, nullable=false)
    private  int id;

    @OneToMany
    @JoinColumn(name="genre_id", nullable = false)
    private Genre genre;

    @OneToMany
    @JoinColumn (name="song_id", nullable = false)
    private Song song;

}
