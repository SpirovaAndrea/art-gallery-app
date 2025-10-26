package com.gallery.artgallery.repository;

import com.gallery.artgallery.model.ReviewView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ReviewViewRepository extends JpaRepository<ReviewView, Integer> {

    List<ReviewView> findByArtworkId(Integer artworkId);

    List<ReviewView> findByRating(Integer rating);
}