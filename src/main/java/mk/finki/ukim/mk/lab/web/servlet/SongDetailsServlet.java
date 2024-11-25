//package mk.finki.ukim.mk.lab.web.servlet;
//
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import mk.finki.ukim.mk.lab.model.Artist;
//import mk.finki.ukim.mk.lab.model.Song;
//import mk.finki.ukim.mk.lab.service.ArtistService;
//import mk.finki.ukim.mk.lab.service.SongService;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.spring6.SpringTemplateEngine;
//import org.thymeleaf.web.IWebExchange;
//import org.thymeleaf.web.servlet.JakartaServletWebApplication;
//import java.io.IOException;
//
//@WebServlet(urlPatterns = "/songDetails")
//public class SongDetailsServlet extends HttpServlet {
//    private final SongService songService;
//    private final ArtistService artistService;
//    private final SpringTemplateEngine springTemplateEngine;
//
//    public SongDetailsServlet(SongService songService, ArtistService artistService, SpringTemplateEngine springTemplateEngine) {
//        this.songService = songService;
//        this.artistService = artistService;
//        this.springTemplateEngine = springTemplateEngine;
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        Long songId = Long.parseLong(request.getParameter("trackID"));
//        Long artistId = Long.parseLong(request.getParameter("artistID"));
//
//        Song song = songService.findById(songId);
//        Artist artist = artistService.findById(artistId);
//
//        songService.addArtistToSong(artist, song);
//
//        IWebExchange webExchange = JakartaServletWebApplication.buildApplication(getServletContext()).buildExchange(request, response);
//        WebContext context = new WebContext(webExchange);
//        context.setVariable("song", song);
//        springTemplateEngine.process("songDetails.html", context, response.getWriter());
//    }
//}