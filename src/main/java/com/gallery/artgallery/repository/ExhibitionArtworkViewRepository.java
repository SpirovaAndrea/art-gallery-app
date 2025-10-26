package com.gallery.artgallery.repository;

import com.gallery.artgallery.model.ExhibitionArtworkView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ExhibitionArtworkViewRepository extends JpaRepository<ExhibitionArtworkView, ExhibitionArtworkView.CompositeKey> {

    List<ExhibitionArtworkView> findByExhibitionId(Integer exhibitionId);
}