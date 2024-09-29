package com.project3.album.service;

import com.project3.album.model.Artist;

import java.util.List;
import java.util.Optional;

public interface ArtistService {
    List<Artist> findAllArtists();
    Optional<Artist> getArtistById(int id);
    void deleteArtistById(int id);
    long getArtistCount();
}
