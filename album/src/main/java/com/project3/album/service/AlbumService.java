package com.project3.album.service;

import com.project3.album.model.Album;

import java.util.List;
import java.util.Optional;

public interface AlbumService {

    List<Album> findAllAlbums();
    Optional<Album> getAlbumById(int id);
    void deleteAlbumById(int id);
    long getAlbumCount();

}
