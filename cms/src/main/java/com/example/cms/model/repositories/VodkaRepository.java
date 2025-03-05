package com.example.cms.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.cms.model.entities.Vodka;

@Repository
public interface VodkaRepository extends JpaRepository<Vodka, Long> {

    // Search for vodka by name (case-insensitive)
    @Query(value = "SELECT * FROM vodka v WHERE LOWER(v.spirit_name) LIKE LOWER(CONCAT('%', :searchTerm, '%'))",
            nativeQuery = true)
    List<Vodka> searchByName(@Param("searchTerm") String searchTerm);

    // Find vodka by specific flavor
    @Query(value = "SELECT * FROM vodka WHERE flavor = :flavor", nativeQuery = true)
    List<Vodka> findByFlavor(@Param("flavor") String flavor);

    // Get all vodka types that match a keyword in their flavor
    @Query(value = "SELECT * FROM vodka v WHERE LOWER(v.flavor) LIKE LOWER(CONCAT('%', :keyword, '%'))",
            nativeQuery = true)
    List<Vodka> searchByFlavor(@Param("keyword") String keyword);
}
