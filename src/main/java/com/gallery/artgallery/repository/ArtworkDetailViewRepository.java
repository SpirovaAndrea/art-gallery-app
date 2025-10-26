package com.gallery.artgallery.repository;

import com.gallery.artgallery.model.ArtworkDetailView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.List;

@Repository
public interface ArtworkDetailViewRepository extends JpaRepository<ArtworkDetailView, Integer> {

    Optional<ArtworkDetailView> findByArtworkId(Integer artworkId);

    List<ArtworkDetailView> findByArtistId(Integer artistId);

    List<ArtworkDetailView> findByAvailability(String availability);
}