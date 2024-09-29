package com.project3.album.service.Impl;


import com.project3.album.model.Album;
import com.project3.album.repository.AlbumRepository;
import com.project3.album.service.AlbumService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class AlbumServiceImpl implements AlbumService {

   private final AlbumRepository albumRepository;

   public AlbumServiceImpl(AlbumRepository albumRepository) {
       this.albumRepository = albumRepository;
   }
       @Override
               public List<Album> findAllAlbums(){
           return(List<Album>) albumRepository.findAll();
       }
       @Override
    public Optional<Album> getAlbumById(int id){
       return albumRepository.findById(id);
   }

   @Override
    public void deleteAlbumById(int id){
       albumRepository.deleteById(id);
   }

   @Override
    public long getAlbumCount(){
       return albumRepository.count();
   }
}
