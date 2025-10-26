package com.gallery.artgallery.repository;

import com.gallery.artgallery.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Integer> {

    Optional<Artist> findByArtistId(Integer artistId);

    Optional<Artist> findByArtistName(String artistName);
}