package com.project3.album.controller;

import com.project3.album.model.Artist;
import com.project3.album.service.ArtistService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Slf4j
@Controller
public class ArtistController {

    final ArtistService artistService;
     public ArtistController(ArtistService artistService){
         this.artistService = artistService;
     }
    @GetMapping("/artists")
    public String findAllSongs(Model model) {
        var artistCount = artistService.getArtistCount();
        var artists = (List<Artist>) artistService.findAllArtists();
        model.addAttribute("count", artistCount);
        model.addAttribute("artists", artists);
        log.info("findAllArtists called");

        return "artists";
    }

    @GetMapping("/deleteArtist/{id}")
    public String deleteArtistById(@PathVariable("id") int id, Model model) {
        var artist = artistService.getArtistById(id);
        model.addAttribute("artist", artist.get().getName());
        artistService.deleteArtistById(id);
        log.info("deleteArtistById " + id + " called");

        return "deleteArtist";
    }

    @GetMapping("/addArtist")
    public String addArtist() {

        return "addArtist";
    }
}

