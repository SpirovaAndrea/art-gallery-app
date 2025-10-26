package com.gallery.artgallery.model;

import jakarta.persistence.*;

@Entity
@Table(name = "buyer")
public class Buyer {

    @Id
    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "username", length = 30, nullable = false)
    private String username;

    @Column(name = "password", length = 30, nullable = false)
    private String password;

    @Column(name = "paymentdetails", length = 100, nullable = false)
    private String paymentDetails;

    // Constructors
    public Buyer() {
    }

    public Buyer(String email, String username, String password, String paymentDetails) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.paymentDetails = paymentDetails;
    }

    // Getters and Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(String paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", paymentDetails='" + paymentDetails + '\'' +
                '}';
    }
}