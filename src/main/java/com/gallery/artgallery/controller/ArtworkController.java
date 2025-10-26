package com.gallery.artgallery.controller;

import com.gallery.artgallery.model.ArtworkDetailView;
import com.gallery.artgallery.model.CartItem;
import com.gallery.artgallery.model.ReviewView;
import com.gallery.artgallery.service.CartService;
import com.gallery.artgallery.service.GalleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
public class ArtworkController {

    @Autowired
    private GalleryService galleryService;

    @Autowired
    private CartService cartService;

    @GetMapping("/artwork/{id}")
    public String artworkDetail(@PathVariable Integer id, Model model, HttpSession session) {
        Optional<ArtworkDetailView> artwork = galleryService.getArtworkById(id);

        if (artwork.isPresent()) {
            List<ReviewView> reviews = galleryService.getReviewsForArtwork(id);

            model.addAttribute("artwork", artwork.get());
            model.addAttribute("reviews", reviews);
            model.addAttribute("cartSize", cartService.getCartSize());
            model.addAttribute("isInCart", cartService.isInCart(id));

            String loggedInUser = (String) session.getAttribute("loggedInUser");
            model.addAttribute("loggedInUser", loggedInUser);

            return "artwork-detail";
        } else {
            return "redirect:/exhibitions";
        }
    }

    @PostMapping("/artwork/{id}/add-to-cart")
    public String addToCart(@PathVariable Integer id, RedirectAttributes redirectAttributes, HttpSession session) {
        // Check if user is logged in
        String loggedInUser = (String) session.getAttribute("loggedInUser");
        if (loggedInUser == null) {
            redirectAttributes.addFlashAttribute("error", "Please log in to add items to cart!");
            return "redirect:/login";
        }

        Optional<ArtworkDetailView> artwork = galleryService.getArtworkById(id);

        if (artwork.isPresent() && artwork.get().isAvailable()) {
            ArtworkDetailView artworkDetail = artwork.get();

            CartItem cartItem = new CartItem(
                    artworkDetail.getArtworkId(),
                    artworkDetail.getArtworkTitle(),
                    artworkDetail.getArtistName(),
                    artworkDetail.getPrice(),
                    artworkDetail.getArtType(),
                    artworkDetail.getDescription()
            );

            cartService.addToCart(cartItem);
            redirectAttributes.addFlashAttribute("success", "Artwork added to cart!");
        } else {
            redirectAttributes.addFlashAttribute("error", "Artwork not available!");
        }

        return "redirect:/artwork/" + id;
    }
}