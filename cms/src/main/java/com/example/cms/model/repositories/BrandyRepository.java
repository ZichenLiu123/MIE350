package com.example.cms.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.cms.model.entities.Brandy;

@Repository
public interface BrandyRepository extends JpaRepository<Brandy, Long> {

    // Search for brandy by name (case-insensitive)
    @Query(value = "SELECT * FROM brandy b WHERE LOWER(b.spirit_name) LIKE LOWER(CONCAT('%', :searchTerm, '%'))",
            nativeQuery = true)
    List<Brandy> searchByName(@Param("searchTerm") String searchTerm);

    // Find brandy by age
    @Query(value = "SELECT * FROM brandy WHERE age >= :minAge", nativeQuery = true)
    List<Brandy> findByMinimumAge(@Param("minAge") Integer minAge);

    // Find brandy stored in a specific barrel type
    @Query(value = "SELECT * FROM brandy WHERE barrel_type = :barrelType", nativeQuery = true)
    List<Brandy> findByBarrelType(@Param("barrelType") String barrelType);
}
