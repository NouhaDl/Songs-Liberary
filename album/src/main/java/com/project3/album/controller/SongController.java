package com.project3.album.controller;

import com.project3.album.model.Song;
import com.project3.album.service.SongService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.List;

@Slf4j
@Controller
public class SongController {

    final SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }

    @GetMapping("/songs")
    public String findAllSongs(Model model) {
        List<Song> songs = songService.findAllSongs();
        var songCount = songs.size();
        model.addAttribute("count", songCount);
        model.addAttribute("songs", songs);
        log.info("findAllSongs called");

        return "songs";
    }

    @GetMapping("/delete/{id}")
    public String deleteSongById(@PathVariable("id") int id, Model model) {
        var song = songService.getSongById(id);
        if (song.isPresent()) {
            model.addAttribute("song", song.get().getName());
            songService.deleteSongById(id);
            log.info("deleteSongById " + id + " called");
        } else {
            log.warn("Song with id " + id + " not found.");
            return "error";
        }
        return "deleteSong";
    }

    @RequestMapping("/addSongForm")
    public ModelAndView addSongForm() {
        return new ModelAndView("addSongForm", "song", new Song());
    }

    @RequestMapping(value = "/addSongForm", method = RequestMethod.POST)
    public String handleSongForm(@Valid @ModelAttribute("song") Song song, BindingResult bindingResult) throws SQLException {
        log.info("handleSongForm called");
        if (bindingResult.hasErrors()) {
            log.info("inside bindingResult.hasErrors()");
            return "addSongForm";
        }
        log.info("id: {}", song.getId());
        log.info("name: {}", song.getName());
        log.info("date: {}", song.getDate());
        log.info("duration: {}", song.getDuration());

        songService.addNewSong(song);
        log.info("song " + song.getName() + " added. It has an id: " + song.getId());
        return "songs";
    }
}
