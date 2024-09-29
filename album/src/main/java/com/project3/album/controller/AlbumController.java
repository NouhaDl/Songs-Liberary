package com.project3.album.controller;

import com.project3.album.model.Album;
import com.project3.album.service.AlbumService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/albums")
public class AlbumController {

    final AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping
    public String findAllAlbums(Model model) {
        var albumCount = albumService.getAlbumCount();
        List<Album> albums = albumService.findAllAlbums();
        model.addAttribute("count", albumCount);
        model.addAttribute("albums", albums);
        log.info("findAllAlbums called");

        return "albums";
    }

    @GetMapping("/deleteAlbum/{id}")
    public String deleteAlbumById(@PathVariable("id") int id, Model model) {
        var album = albumService.getAlbumById(id);
        model.addAttribute("album", album.get().getName());
        albumService.deleteAlbumById(id);
        log.info("deleteAlbumById " + id + " called");

        return "deleteAlbum";
    }

    @GetMapping("/addAlbum")
    public String addAlbum() {
        return "addAlbum";
    }
}
