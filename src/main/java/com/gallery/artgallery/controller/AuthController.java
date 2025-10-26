package com.gallery.artgallery.controller;

import com.gallery.artgallery.model.Buyer;
import com.gallery.artgallery.service.GalleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import jakarta.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class AuthController {

    @Autowired
    private GalleryService galleryService;

    @GetMapping("/login")
    public String loginPage(HttpSession session, Model model) {
        // If already logged in, redirect to home
        if (session.getAttribute("loggedInUser") != null) {
            return "redirect:/";
        }
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email,
                        @RequestParam String password,
                        HttpSession session,
                        RedirectAttributes redirectAttributes) {

        if (galleryService.authenticateBuyer(email, password)) {
            Optional<Buyer> buyer = galleryService.getBuyerByEmail(email);

            if (buyer.isPresent()) {
                session.setAttribute("loggedInUser", buyer.get().getUsername().trim());
                session.setAttribute("loggedInEmail", email);
                redirectAttributes.addFlashAttribute("success", "Welcome back, " + buyer.get().getUsername().trim() + "!");
                return "redirect:/";
            }
        }

        redirectAttributes.addFlashAttribute("error", "Invalid email or password!");
        return "redirect:/login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session, RedirectAttributes redirectAttributes) {
        session.invalidate();
        redirectAttributes.addFlashAttribute("success", "You have been logged out!");
        return "redirect:/";
    }
}