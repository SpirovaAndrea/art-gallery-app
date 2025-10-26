package com.gallery.artgallery.repository;

import com.gallery.artgallery.model.ArtistView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ArtistViewRepository extends JpaRepository<ArtistView, Integer> {

    Optional<ArtistView> findByArtistId(Integer artistId);

    // All artists are fetched with findAll() - already provided by JpaRepository
}