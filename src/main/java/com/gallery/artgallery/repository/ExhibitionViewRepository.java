package com.gallery.artgallery.repository;

import com.gallery.artgallery.model.ExhibitionView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ExhibitionViewRepository extends JpaRepository<ExhibitionView, Integer> {

    Optional<ExhibitionView> findByExhibitionId(Integer exhibitionId);

    // All exhibitions are fetched with findAll() - already provided by JpaRepository
}