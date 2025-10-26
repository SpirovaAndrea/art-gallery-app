package com.gallery.artgallery.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Immutable;
import java.io.Serializable;

@Entity
@Immutable
@Table(name = "view_exhibition_artworks_full")
@IdClass(ExhibitionArtworkView.CompositeKey.class)
public class ExhibitionArtworkView {

    @Id
    @Column(name = "exhibitionid")
    private Integer exhibitionId;

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

    @Column(name = "artistid")
    private Integer artistId;

    @Column(name = "artist_name")
    private String artistName;

    @Column(name = "artist_country")
    private String artistCountry;

    @Column(name = "availability")
    private String availability;

    @Column(name = "image_url")
    private String imageUrl;

    // Constructors
    public ExhibitionArtworkView() {
    }

    // Getters
    public Integer getExhibitionId() {
        return exhibitionId;
    }

    public Integer getArtworkId() {
        return artworkId;
    }

    public String getArtworkTitle() {
        return artworkTitle;
    }

    public String getImageUrl() {
        return imageUrl;
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

    public Integer getArtistId() {
        return artistId;
    }

    public String getArtistName() {
        return artistName;
    }

    public String getArtistCountry() {
        return artistCountry;
    }

    public String getAvailability() {
        return availability;
    }

    public boolean isAvailable() {
        return "Available".equalsIgnoreCase(availability);
    }

    // Composite Key class
    public static class CompositeKey implements Serializable {
        private Integer exhibitionId;
        private Integer artworkId;

        public CompositeKey() {
        }

        public CompositeKey(Integer exhibitionId, Integer artworkId) {
            this.exhibitionId = exhibitionId;
            this.artworkId = artworkId;
        }

        // Getters, Setters, equals, hashCode
        public Integer getExhibitionId() {
            return exhibitionId;
        }

        public void setExhibitionId(Integer exhibitionId) {
            this.exhibitionId = exhibitionId;
        }

        public Integer getArtworkId() {
            return artworkId;
        }

        public void setArtworkId(Integer artworkId) {
            this.artworkId = artworkId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CompositeKey that = (CompositeKey) o;
            return exhibitionId.equals(that.exhibitionId) && artworkId.equals(that.artworkId);
        }

        @Override
        public int hashCode() {
            return exhibitionId.hashCode() + artworkId.hashCode();
        }
    }
}