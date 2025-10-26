package com.gallery.artgallery.controller;

import com.gallery.artgallery.model.ArtworkDetailView;
import com.gallery.artgallery.model.ExhibitionView;
import com.gallery.artgallery.service.CartService;
import com.gallery.artgallery.service.GalleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.gallery.artgallery.model.ExhibitionArtworkView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
public class ExhibitionController {

    @Autowired
    private GalleryService galleryService;

    @Autowired
    private CartService cartService;

    @GetMapping("/exhibitions")
    public String exhibitions(Model model, HttpSession session) {
        List<ExhibitionView> exhibitions = galleryService.getAllExhibitions();

        model.addAttribute("exhibitions", exhibitions);
        model.addAttribute("cartSize", cartService.getCartSize());

        String loggedInUser = (String) session.getAttribute("loggedInUser");
        model.addAttribute("loggedInUser", loggedInUser);

        return "exhibitions";
    }

    @GetMapping("/exhibition/{id}")
    public String exhibitionDetail(@PathVariable Integer id, Model model, HttpSession session) {
        Optional<ExhibitionView> exhibition = galleryService.getExhibitionById(id);

        if (exhibition.isPresent()) {
            // NEW: Get artworks showcased in this exhibition
            List<ExhibitionArtworkView> artworks = galleryService.getArtworksInExhibition(id);

            model.addAttribute("exhibition", exhibition.get());
            model.addAttribute("artworks", artworks);
            model.addAttribute("cartSize", cartService.getCartSize());

            String loggedInUser = (String) session.getAttribute("loggedInUser");
            model.addAttribute("loggedInUser", loggedInUser);

            return "exhibition-detail";
        } else {
            return "redirect:/exhibitions";
        }
    }
}