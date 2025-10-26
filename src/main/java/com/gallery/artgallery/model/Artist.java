package com.gallery.artgallery.model;

import jakarta.persistence.*;

@Entity
@Table(name = "artist")
public class Artist {

    @Id
    @Column(name = "artistid")
    private Integer artistId;

    @Column(name = "galleryadminid", length = 20)
    private String galleryAdminId;

    @Column(name = "password", length = 30, nullable = false)
    private String password;

    @Column(name = "artistname", length = 30, nullable = false)
    private String artistName;

    @Column(name = "portfoliolink", length = 50, nullable = false)
    private String portfolioLink;

    @Column(name = "countryoforigin", length = 50, nullable = false)
    private String countryOfOrigin;

    // Constructors
    public Artist() {
    }

    public Artist(Integer artistId, String galleryAdminId, String password,
                  String artistName, String portfolioLink, String countryOfOrigin) {
        this.artistId = artistId;
        this.galleryAdminId = galleryAdminId;
        this.password = password;
        this.artistName = artistName;
        this.portfolioLink = portfolioLink;
        this.countryOfOrigin = countryOfOrigin;
    }

    // Getters and Setters
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getPortfolioLink() {
        return portfolioLink;
    }

    public void setPortfolioLink(String portfolioLink) {
        this.portfolioLink = portfolioLink;
    }

    public String getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(String countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "artistId=" + artistId +
                ", artistName='" + artistName + '\'' +
                ", countryOfOrigin='" + countryOfOrigin + '\'' +
                '}';
    }
}