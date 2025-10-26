package com.gallery.artgallery.controller;

import com.gallery.artgallery.model.CartItem;
import com.gallery.artgallery.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import jakarta.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/cart")
    public String viewCart(Model model, HttpSession session) {
        // Check if user is logged in
        String loggedInUser = (String) session.getAttribute("loggedInUser");
        if (loggedInUser == null) {
            return "redirect:/login";
        }

        List<CartItem> cartItems = cartService.getCartItems();
        int totalPrice = cartService.getTotalPrice();

        model.addAttribute("cartItems", cartItems);
        model.addAttribute("totalPrice", totalPrice);
        model.addAttribute("cartSize", cartService.getCartSize());
        model.addAttribute("loggedInUser", loggedInUser);

        return "cart";
    }

    @PostMapping("/cart/remove/{artworkId}")
    public String removeFromCart(@PathVariable Integer artworkId, RedirectAttributes redirectAttributes) {
        cartService.removeFromCart(artworkId);
        redirectAttributes.addFlashAttribute("success", "Item removed from cart!");
        return "redirect:/cart";
    }

    @PostMapping("/cart/clear")
    public String clearCart(RedirectAttributes redirectAttributes) {
        cartService.clearCart();
        redirectAttributes.addFlashAttribute("success", "Cart cleared!");
        return "redirect:/cart";
    }
}