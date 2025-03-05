package com.example.cms.model.repositories;

import com.example.cms.model.entities.Spirit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpiritRepository extends JpaRepository<Spirit, Long> {

    // Search for spirits by name (case-insensitive search)
    @Query(value = "SELECT * FROM spirits s " +
            "WHERE LOWER(s.spirit_name) LIKE LOWER(CONCAT('%', :searchTerm, '%'))", nativeQuery = true)
    List<Spirit> searchByName(@Param("searchTerm") String searchTerm);

    // Find spirits by their type (Whisky, Brandy, Vodka, etc.)
    @Query(value = "SELECT * FROM spirits WHERE spirit_type = :spiritType", nativeQuery = true)
    List<Spirit> findBySpiritType(@Param("spiritType") String spiritType);

    // Get all aged spirits (Whisky, Brandy) where age is greater than a certain
    // number
    @Query(value = "SELECT * FROM spirits WHERE age >= :minAge", nativeQuery = true)
    List<Spirit> findAgedSpirits(@Param("minAge") Integer minAge);

    // Get all spirits with a specific barrel type
    @Query(value = "SELECT * FROM spirits WHERE barrel_type = :barrelType", nativeQuery = true)
    List<Spirit> findByBarrelType(@Param("barrelType") String barrelType);

    // Find spirits with specific flavors (used for Vodka, Rum)
    @Query(value = "SELECT * FROM spirits WHERE flavor = :flavor", nativeQuery = true)
    List<Spirit> findByFlavor(@Param("flavor") String flavor);
}
