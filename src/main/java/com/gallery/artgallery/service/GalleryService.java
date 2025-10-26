package com.gallery.artgallery.service;

import com.gallery.artgallery.model.*;
import com.gallery.artgallery.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class GalleryService {

    @Autowired
    private ExhibitionViewRepository exhibitionViewRepository;

    @Autowired
    private ArtistViewRepository artistViewRepository;

    @Autowired
    private ArtworkDetailViewRepository artworkDetailViewRepository;

    @Autowired
    private ReviewViewRepository reviewViewRepository;

    @Autowired
    private BuyerRepository buyerRepository;

    @Autowired
    private ExhibitionArtworkViewRepository exhibitionArtworkViewRepository;


    public List<ExhibitionView> getAllExhibitions() {
        return exhibitionViewRepository.findAll();
    }
    public List<ExhibitionArtworkView> getArtworksInExhibition(Integer exhibitionId) {
        return exhibitionArtworkViewRepository.findByExhibitionId(exhibitionId);
    }

    public Optional<ExhibitionView> getExhibitionById(Integer id) {
        return exhibitionViewRepository.findByExhibitionId(id);
    }


    public List<ArtistView> getAllArtists() {
        return artistViewRepository.findAll();
    }

    public Optional<ArtistView> getArtistById(Integer id) {
        return artistViewRepository.findByArtistId(id);
    }

    public List<ArtworkDetailView> getArtworksByArtist(Integer artistId) {
        return artworkDetailViewRepository.findByArtistId(artistId);
    }


    public List<ArtworkDetailView> getAllArtworks() {
        return artworkDetailViewRepository.findAll();
    }

    public Optional<ArtworkDetailView> getArtworkById(Integer id) {
        return artworkDetailViewRepository.findByArtworkId(id);
    }

    public List<ArtworkDetailView> getAvailableArtworks() {
        return artworkDetailViewRepository.findByAvailability("Available");
    }


    public List<ReviewView> getReviewsForArtwork(Integer artworkId) {
        return reviewViewRepository.findByArtworkId(artworkId);
    }


    public boolean authenticateBuyer(String email, String password) {
        return buyerRepository.existsByEmailAndPassword(email, password);
    }

    public Optional<Buyer> getBuyerByEmail(String email) {
        return buyerRepository.findByEmail(email);
    }
}