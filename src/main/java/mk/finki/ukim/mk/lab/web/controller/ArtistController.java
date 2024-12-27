package mk.finki.ukim.mk.lab.web.controller;

import mk.finki.ukim.mk.lab.model.Song;
import mk.finki.ukim.mk.lab.service.ArtistService;
import mk.finki.ukim.mk.lab.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/artists")
public class ArtistController {
    private final ArtistService artistService;
    private final SongService songService;

    public ArtistController(ArtistService artistService, SongService songService) {
        this.artistService = artistService;
        this.songService = songService;
    }

    @GetMapping
    public String getArtistsPage(Model model) {
        model.addAttribute("artists", artistService.listArtists());
        return "artists";
    }

    @GetMapping("/add")
    public String addArtistPage(@RequestParam Long songId, Model model) {
        Song song = songService.findById(songId);
        model.addAttribute("songId", songId);
        model.addAttribute("song", song);
        model.addAttribute("artists", artistService.listArtists());
        return "artistsList";
    }

    @GetMapping("/search")
    public String getSearchArtist(@RequestParam Long songId, @RequestParam String query, Model model) {
        model.addAttribute("artists", artistService.searchArtists(query));
        model.addAttribute("songId", songId);
        return "search-artist";
    }
}
