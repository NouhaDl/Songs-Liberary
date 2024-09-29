package com.project3.album.service.Impl;

import com.project3.album.model.Artist;
import com.project3.album.repository.ArtistRepository;
import com.project3.album.service.ArtistService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ArtistServiceImpl implements ArtistService {

   private final ArtistRepository artistRepository;

    public ArtistServiceImpl(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }
  @Override
   public List<Artist> findAllArtists(){
       return artistRepository.findAll();
    }

    @Override
    public Optional<Artist> getArtistById(int id){
       return artistRepository.findById(id);
    }

    @Override
    public void deleteArtistById(int id){
       artistRepository.deleteById(id);
    }

    @Override
    public long getArtistCount(){
       return artistRepository.count();
    }


}
