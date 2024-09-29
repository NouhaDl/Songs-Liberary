package com.project3.album.service;

import com.project3.album.model.Genre;

import java.util.List;
import java.util.Optional;

public interface GenreService {
    List<Genre> findAllGenres();  // Correction du nom pour correspondre à l'implémentation
    Optional<Genre> getGenreById(int id);
    void deleteGenreById(int id);
    void addNewGenre(Genre genre);
    long getGenreCount();
}
