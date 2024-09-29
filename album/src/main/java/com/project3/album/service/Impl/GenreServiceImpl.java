package com.project3.album.service.Impl;

import com.project3.album.model.Genre;
import com.project3.album.repository.GenreRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.project3.album.service.GenreService;


import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;

    public GenreServiceImpl(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public List<Genre> findAllGenres() {
        return genreRepository.findAll();
    }

    @Override
    public Optional<Genre> getGenreById(int id) {
        return genreRepository.findById(id);
    }

    @Override
    public void deleteGenreById(int id) {
        genreRepository.deleteById(id);
    }

    @Override
    public void addNewGenre(Genre genre) {
        genreRepository.save(genre);
    }

    @Override
    public long getGenreCount() {
        return genreRepository.count();
    }
}
