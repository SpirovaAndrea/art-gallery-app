package com.gallery.artgallery.model;

import jakarta.persistence.*;

@Entity
@Table(name = "artwork")
public class Artwork {

    @Id
    @Column(name = "artworkid")
    private Integer artworkId;

    @Column(name = "artistid")
    private Integer artistId;

    @Column(name = "galleryadminid", length = 20)
    private String galleryAdminId;

    @Column(name = "typeid")
    private Integer typeId;

    @Column(name = "email_buyer", length = 50)
    private String emailBuyer;

    @Column(name = "title", length = 30, nullable = false)
    private String title;

    @Column(name = "price", nullable = false)
    private Integer price;

    @Column(name = "description", length = 150, nullable = false)
    private String description;

    // Constructors
    public Artwork() {
    }

    public Artwork(Integer artworkId, Integer artistId, String galleryAdminId,
                   Integer typeId, String emailBuyer, String title, Integer price, String description) {
        this.artworkId = artworkId;
        this.artistId = artistId;
        this.galleryAdminId = galleryAdminId;
        this.typeId = typeId;
        this.emailBuyer = emailBuyer;
        this.title = title;
        this.price = price;
        this.description = description;
    }

    // Getters and Setters
    public Integer getArtworkId() {
        return artworkId;
    }

    public void setArtworkId(Integer artworkId) {
        this.artworkId = artworkId;
    }

    public Integer getArtistId() {
        return artistId;
    }

    public void setArtistId(Integer artistId) {
        this.artistId = artistId;
    }

    public String getGalleryAdminId() {
        return galleryAdminId;
    }

    public void setGalleryAdminId(String galleryAdminId) {
        this.galleryAdminId = galleryAdminId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getEmailBuyer() {
        return emailBuyer;
    }

    public void setEmailBuyer(String emailBuyer) {
        this.emailBuyer = emailBuyer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Artwork{" +
                "artworkId=" + artworkId +
                ", title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}