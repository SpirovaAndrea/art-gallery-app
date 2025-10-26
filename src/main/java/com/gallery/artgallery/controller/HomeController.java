package com.gallery.artgallery.controller;

import com.gallery.artgallery.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

    @Autowired
    private CartService cartService;

    @GetMapping("/")
    public String home(Model model, HttpSession session) {
        model.addAttribute("cartSize", cartService.getCartSize());

        String loggedInUser = (String) session.getAttribute("loggedInUser");
        model.addAttribute("loggedInUser", loggedInUser);

        return "home";
    }

    @GetMapping("/home")
    public String homePage(Model model, HttpSession session) {
        model.addAttribute("cartSize", cartService.getCartSize());
        String loggedInUser = (String) session.getAttribute("loggedInUser");
        model.addAttribute("loggedInUser", loggedInUser);
        return "home";
    }
}