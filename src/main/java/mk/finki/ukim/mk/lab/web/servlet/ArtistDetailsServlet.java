//package mk.finki.ukim.mk.lab.web.servlet;
//
//import mk.finki.ukim.mk.lab.service.ArtistService;
//import org.thymeleaf.context.WebContext;
//import org.thymeleaf.spring6.SpringTemplateEngine;
//import org.thymeleaf.web.IWebExchange;
//import org.thymeleaf.web.servlet.JakartaServletWebApplication;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.annotation.WebServlet;
//import java.io.IOException;
//
//@WebServlet(urlPatterns = "/artistDetails")
//public class ArtistDetailsServlet extends HttpServlet {
//    private final ArtistService artistService;
//    private final SpringTemplateEngine springTemplateEngine;
//
//    public ArtistDetailsServlet(ArtistService artistService, SpringTemplateEngine springTemplateEngine) {
//        this.artistService = artistService;
//        this.springTemplateEngine = springTemplateEngine;
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        IWebExchange webExchange = JakartaServletWebApplication.buildApplication(getServletContext()).buildExchange(request, response);
//        WebContext context = new WebContext(webExchange);
//        Long artistId = Long.parseLong(request.getParameter("artistId"));
//        context.setVariable("artist", artistService.findById(artistId));
//        springTemplateEngine.process("artistDetails.html", context, response.getWriter());
//    }
//}
