package com.project3.album.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",updatable = false, nullable = false)
    private int id;

    @Column(name="nama")
    private String name;

    @Column(name = "date")
   private LocalDate date;

    @Column(name="duration")
    private Double duration;

    @OneToMany(mappedBy="song", cascade= CascadeType.ALL, orphanRemoval = true)
    private Set<SongGenre> songGenre;

    @OneToMany(mappedBy = "song", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<SongArtist> songArtistSet;

    @OneToMany(mappedBy= "song", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<SongAlbum> songAlbum;

    }


