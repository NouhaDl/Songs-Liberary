package com.project3.album.repository;

import com.project3.album.model.SongAlbum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongAlbumRepository extends JpaRepository<SongAlbum, Integer> {
}
