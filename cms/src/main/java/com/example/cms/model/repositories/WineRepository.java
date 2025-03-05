package com.example.cms.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.cms.model.entities.Wine;

@Repository
public interface WineRepository extends JpaRepository<Wine, Long> {

    // Search for wine by name (case-insensitive)
    @Query(value = "SELECT * FROM wine w WHERE LOWER(w.spirit_name) LIKE LOWER(CONCAT('%', :searchTerm, '%'))",
            nativeQuery = true)
    List<Wine> searchByName(@Param("searchTerm") String searchTerm);

    // Find wine by specific type (e.g., Red, White, Rosé)
    @Query(value = "SELECT * FROM wine WHERE type = :wineType", nativeQuery = true)
    List<Wine> findByType(@Param("wineType") String wineType);

    // Get all aged wines (where age is greater than a certain number)
    @Query(value = "SELECT * FROM wine WHERE age >= :minAge", nativeQuery = true)
    List<Wine> findAgedWines(@Param("minAge") Integer minAge);
}
