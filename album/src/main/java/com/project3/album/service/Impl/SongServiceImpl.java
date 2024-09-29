package com.project3.album.service.Impl;


import com.project3.album.model.Song;
import com.project3.album.repository.SongRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.project3.album.service.SongService;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class SongServiceImpl implements SongService{

    private final SongRepository songRepository;
    public SongServiceImpl(SongRepository songRepository){
        this.songRepository = songRepository;
    }

    @Override
    public List<Song> findAllSongs() {
        return (List<Song>) songRepository.findAll();
    }

    @Override
    public Optional<Song> getSongById(int id) {
        return songRepository.findById(id);
    }

    @Override
    public void deleteSongById(int id) {
        songRepository.deleteById(id);
    }

    @Override
    public void addNewSong(Song song) {
        log.info("addNewSong called");
        songRepository.save(song);
    }

    @Override
    public long getSongCount() {
        return songRepository.count();
    }
}
