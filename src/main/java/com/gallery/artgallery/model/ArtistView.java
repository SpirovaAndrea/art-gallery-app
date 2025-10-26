package com.gallery.artgallery.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Immutable;
import java.io.Serializable;

@Entity
@Immutable
@Table(name = "view_artists_page")
public class ArtistView implements Serializable {

    @Id
    @Column(name = "artistid")
    private Integer artistId;

    @Column(name = "artist_name")
    private String artistName;

    @Column(name = "portfolio_link")
    private String portfolioLink;

    @Column(name = "country")
    private String country;

    @Column(name = "phone_numbers")
    private String phoneNumbers;

    @Column(name = "total_artworks")
    private Long totalArtworks;

    @Column(name = "exhibitions_participated")
    private Long exhibitionsParticipated;

    // Constructors
    public ArtistView() {
    }

    // Getters
    public Integer getArtistId() {
        return artistId;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getPortfolioLink() {
        return portfolioLink;
    }

    public String getCountry() {
        return country;
    }

    public String getPhoneNumbers() {
        return phoneNumbers;
    }

    public Long getTotalArtworks() {
        return totalArtworks;
    }

    public Long getExhibitionsParticipated() {
        return exhibitionsParticipated;
    }

    @Override
    public String toString() {
        return "ArtistView{" +
                "artistId=" + artistId +
                ", artistName='" + artistName + '\'' +
                ", country='" + country + '\'' +
                ", totalArtworks=" + totalArtworks +
                '}';
    }
}