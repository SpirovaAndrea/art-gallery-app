package com.gallery.artgallery.model;

public class CartItem {

    private Integer artworkId;
    private String artworkTitle;
    private String artistName;
    private Integer price;
    private String artType;
    private String description;

    // Constructors
    public CartItem() {
    }

    public CartItem(Integer artworkId, String artworkTitle, String artistName,
                    Integer price, String artType, String description) {
        this.artworkId = artworkId;
        this.artworkTitle = artworkTitle;
        this.artistName = artistName;
        this.price = price;
        this.artType = artType;
        this.description = description;
    }

    // Getters and Setters
    public Integer getArtworkId() {
        return artworkId;
    }

    public void setArtworkId(Integer artworkId) {
        this.artworkId = artworkId;
    }

    public String getArtworkTitle() {
        return artworkTitle;
    }

    public void setArtworkTitle(String artworkTitle) {
        this.artworkTitle = artworkTitle;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getArtType() {
        return artType;
    }

    public void setArtType(String artType) {
        this.artType = artType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "artworkId=" + artworkId +
                ", artworkTitle='" + artworkTitle + '\'' +
                ", price=" + price +
                '}';
    }
}