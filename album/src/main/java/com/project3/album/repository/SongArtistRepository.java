package com.project3.album.repository;


import com.project3.album.model.SongArtist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongArtistRepository extends JpaRepository<SongArtist, Integer> {
}
