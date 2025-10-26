package com.gallery.artgallery.service;

import com.gallery.artgallery.model.CartItem;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import java.util.ArrayList;
import java.util.List;

@Service
@SessionScope  // Each user session gets its own cart
public class CartService {

    private final List<CartItem> cartItems = new ArrayList<>();

    // Add item to cart
    public void addToCart(CartItem item) {
        // Check if item already exists in cart
        boolean exists = cartItems.stream()
                .anyMatch(cartItem -> cartItem.getArtworkId().equals(item.getArtworkId()));

        if (!exists) {
            cartItems.add(item);
        }
    }

    // Remove item from cart
    public void removeFromCart(Integer artworkId) {
        cartItems.removeIf(item -> item.getArtworkId().equals(artworkId));
    }

    // Get all items in cart
    public List<CartItem> getCartItems() {
        return new ArrayList<>(cartItems);
    }

    // Get total number of items
    public int getCartSize() {
        return cartItems.size();
    }

    // Calculate total price
    public int getTotalPrice() {
        return cartItems.stream()
                .mapToInt(CartItem::getPrice)
                .sum();
    }

    // Clear the cart
    public void clearCart() {
        cartItems.clear();
    }

    // Check if artwork is in cart
    public boolean isInCart(Integer artworkId) {
        return cartItems.stream()
                .anyMatch(item -> item.getArtworkId().equals(artworkId));
    }
}