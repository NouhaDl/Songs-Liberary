package com.project3.album.repository;

import com.project3.album.model.SongGenre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongGenreRepository extends JpaRepository<SongGenre, Integer> {
}
