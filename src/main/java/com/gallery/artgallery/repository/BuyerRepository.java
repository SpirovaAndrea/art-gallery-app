package com.gallery.artgallery.repository;

import com.gallery.artgallery.model.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface BuyerRepository extends JpaRepository<Buyer, String> {

    Optional<Buyer> findByEmail(String email);

    Optional<Buyer> findByUsername(String username);

    boolean existsByEmailAndPassword(String email, String password);
}