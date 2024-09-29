package com.project3.album.controller;

import com.project3.album.model.Genre;
import com.project3.album.service.GenreService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.util.List;

@Slf4j
@RestController

public class GenreController {
    final GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }
    @GetMapping("/genres")
    public String findAllGenres(Model model){
        var genreCount = genreService.getGenreCount();
        var genres = (List<Genre>) genreService.findAllGenres();
        model.addAttribute("count", genreCount);
        model.addAttribute("genres", genres);
        log.info("findAllGenres called");

        return "genres";
    }

    @GetMapping("/deleteGenre/{id}")
    public String deleteGenreById(@PathVariable("id") int id, Model model){
       var genre = genreService.getGenreById(id);
       model.addAttribute("genre", genre.get().getName());
       genreService.deleteGenreById(id);
       log.info("deletedGenreById" + id + "called");

       return "deletedGenre";
    }

    @RequestMapping("/addGenre")
    public ModelAndView addGenreFrom() {
        return new ModelAndView("addGenre", "genre", new Genre());

    }

    @RequestMapping(value="/addGenre", method= RequestMethod.POST)
    public String handleGenreFrom(@Valid @ModelAttribute("genre") Genre genre, BindingResult bindingResult) throws SQLException{
        log.info("handleGenreFrom called");
        if(bindingResult.hasErrors()) {
            log.info("inside bindingResult.hasErrors()");
            return "addSongFrom";
        }
        genreService.addNewGenre(genre);
        log.info("genre " + genre.getName() + "added. It has an id : " + genre.getId());
        return "genres";
        }
    }


