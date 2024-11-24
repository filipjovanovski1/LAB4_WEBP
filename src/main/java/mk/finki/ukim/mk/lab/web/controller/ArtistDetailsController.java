package mk.finki.ukim.mk.lab.web.controller;

import mk.finki.ukim.mk.lab.model.Artist;
import mk.finki.ukim.mk.lab.service.ArtistService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/artistDetails")
public class ArtistDetailsController {
    private final ArtistService artistService;

    public ArtistDetailsController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @GetMapping("{artistId}")
    public String getArtistDetail(@PathVariable Long artistId, Model model){
        Artist artist = artistService.findById(artistId);
        model.addAttribute("artist", artist);
        return "artistDetails";
    }
}
