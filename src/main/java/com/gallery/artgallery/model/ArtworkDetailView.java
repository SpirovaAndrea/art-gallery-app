package com.gallery.artgallery.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "view_artwork_details")
public class ArtworkDetailView {

    @Id
    @Column(name = "artworkid")
    private Integer artworkId;

    @Column(name = "artwork_title")
    private String artworkTitle;

    @Column(name = "price")
    private Integer price;

    @Column(name = "description")
    private String description;

    @Column(name = "art_type")
    private String artType;

    @Column(name = "typeid")
    private Integer typeId;

    @Column(name = "artistid")
    private Integer artistId;

    @Column(name = "artist_name")
    private String artistName;

    @Column(name = "artist_portfolio")
    private String artistPortfolio;

    @Column(name = "artist_country")
    private String artistCountry;

    @Column(name = "artist_phones")
    private String artistPhones;

    @Column(name = "availability")
    private String availability;

    @Column(name = "purchased_by")
    private String purchasedBy;

    @Column(name = "showcased_in_exhibitions")
    private String showcasedInExhibitions;

    @Column(name = "image_url")
    private String imageUrl;

    // Constructors
    public ArtworkDetailView() {
    }

    // Getters
    public Integer getArtworkId() {
        return artworkId;
    }

    public String getArtworkTitle() {
        return artworkTitle;
    }

    public Integer getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getArtType() {
        return artType;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Integer getArtistId() {
        return artistId;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getArtistPortfolio() {
        return artistPortfolio;
    }

    public String getArtistCountry() {
        return artistCountry;
    }

    public String getArtistPhones() {
        return artistPhones;
    }

    public String getAvailability() {
        return availability;
    }

    public String getPurchasedBy() {
        return purchasedBy;
    }

    public String getShowcasedInExhibitions() {
        return showcasedInExhibitions;
    }

    public boolean isAvailable() {
        return "Available".equalsIgnoreCase(availability);
    }

    @Override
    public String toString() {
        return "ArtworkDetailView{" +
                "artworkId=" + artworkId +
                ", artworkTitle='" + artworkTitle + '\'' +
                ", price=" + price +
                ", artistName='" + artistName + '\'' +
                ", availability='" + availability + '\'' +
                '}';
    }
}