package mk.finki.ukim.mk.lab.web.controller;

import org.springframework.ui.Model;
import mk.finki.ukim.mk.lab.service.AlbumService;
import mk.finki.ukim.mk.lab.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/songs")
public class SongController {
    private final SongService songService;
    private final AlbumService albumService;

    public SongController(SongService songService, AlbumService albumService) {
        this.songService = songService;
        this.albumService = albumService;
    }

    @GetMapping
    public String getSongsPage(@RequestParam(required=false) String error, Model model){
        model.addAttribute("error", error);
        model.addAttribute("songs", songService.listSongs());
        model.addAttribute("albums", albumService.findAll());
        return "listSongs";
    }
}
