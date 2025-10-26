package com.gallery.artgallery.repository;

import com.gallery.artgallery.model.Artwork;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ArtworkRepository extends JpaRepository<Artwork, Integer> {

    Optional<Artwork> findByArtworkId(Integer artworkId);

    List<Artwork> findByArtistId(Integer artistId);

    List<Artwork> findByEmailBuyerIsNull();

    List<Artwork> findByEmailBuyer(String emailBuyer);
}