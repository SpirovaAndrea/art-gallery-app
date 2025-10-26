package com.gallery.artgallery.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Immutable;
import java.time.LocalDateTime;

@Entity
@Immutable
@Table(name = "view_exhibitions_page")
public class ExhibitionView {

    @Id
    @Column(name = "exhibitionid")
    private Integer exhibitionId;

    @Column(name = "exhibition_title")
    private String exhibitionTitle;

    @Column(name = "startdate")
    private LocalDateTime startDate;

    @Column(name = "enddate")
    private LocalDateTime endDate;

    @Column(name = "admin_email")
    private String adminEmail;

    @Column(name = "admin_role")
    private String adminRole;

    @Column(name = "total_artworks")
    private Long totalArtworks;

    @Column(name = "participating_artists")
    private Long participatingArtists;

    // Constructors
    public ExhibitionView() {
    }

    // Getters
    public Integer getExhibitionId() {
        return exhibitionId;
    }

    public String getExhibitionTitle() {
        return exhibitionTitle;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public String getAdminRole() {
        return adminRole;
    }

    public Long getTotalArtworks() {
        return totalArtworks;
    }

    public Long getParticipatingArtists() {
        return participatingArtists;
    }

    @Override
    public String toString() {
        return "ExhibitionView{" +
                "exhibitionId=" + exhibitionId +
                ", exhibitionTitle='" + exhibitionTitle + '\'' +
                ", totalArtworks=" + totalArtworks +
                '}';
    }
}