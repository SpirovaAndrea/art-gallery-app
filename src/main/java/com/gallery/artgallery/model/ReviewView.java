package com.gallery.artgallery.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "view_artwork_reviews")
public class ReviewView {

    @Id
    @Column(name = "reviewid")
    private Integer reviewId;

    @Column(name = "artworkid")
    private Integer artworkId;

    @Column(name = "artwork_title")
    private String artworkTitle;

    @Column(name = "feedback")
    private String feedback;

    @Column(name = "rating")
    private Integer rating;

    @Column(name = "reviewer_name")
    private String reviewerName;

    @Column(name = "reviewer_email")
    private String reviewerEmail;

    // Constructors
    public ReviewView() {
    }

    // Getters
    public Integer getReviewId() {
        return reviewId;
    }

    public Integer getArtworkId() {
        return artworkId;
    }

    public String getArtworkTitle() {
        return artworkTitle;
    }

    public String getFeedback() {
        return feedback;
    }

    public Integer getRating() {
        return rating;
    }

    public String getReviewerName() {
        return reviewerName;
    }

    public String getReviewerEmail() {
        return reviewerEmail;
    }

    // Helper method to get stars as string (for display)
    public String getStars() {
        return "★".repeat(rating) + "☆".repeat(5 - rating);
    }

    @Override
    public String toString() {
        return "ReviewView{" +
                "reviewId=" + reviewId +
                ", artworkId=" + artworkId +
                ", rating=" + rating +
                ", reviewerName='" + reviewerName + '\'' +
                '}';
    }
}