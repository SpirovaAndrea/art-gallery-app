package com.gallery.artgallery.controller;

import com.gallery.artgallery.model.ArtistView;
import com.gallery.artgallery.model.ArtworkDetailView;
import com.gallery.artgallery.service.CartService;
import com.gallery.artgallery.service.GalleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
public class ArtistController {

    @Autowired
    private GalleryService galleryService;

    @Autowired
    private CartService cartService;

    @GetMapping("/artists")
    public String artists(Model model, HttpSession session) {
        List<ArtistView> artists = galleryService.getAllArtists();

        model.addAttribute("artists", artists);
        model.addAttribute("cartSize", cartService.getCartSize());

        String loggedInUser = (String) session.getAttribute("loggedInUser");
        model.addAttribute("loggedInUser", loggedInUser);

        return "artists";
    }

    @GetMapping("/artist/{id}")
    public String artistDetail(@PathVariable Integer id, Model model, HttpSession session) {
        Optional<ArtistView> artist = galleryService.getArtistById(id);

        if (artist.isPresent()) {
            List<ArtworkDetailView> artworks = galleryService.getArtworksByArtist(id);

            model.addAttribute("artist", artist.get());
            model.addAttribute("artworks", artworks);
            model.addAttribute("cartSize", cartService.getCartSize());

            String loggedInUser = (String) session.getAttribute("loggedInUser");
            model.addAttribute("loggedInUser", loggedInUser);

            return "artist-detail";
        } else {
            return "redirect:/artists";
        }
    }
}