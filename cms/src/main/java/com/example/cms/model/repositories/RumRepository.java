package com.example.cms.model.repositories;

import com.example.cms.model.entities.Rum;
import com.example.cms.model.entities.Tequila;
import com.example.cms.model.entities.Wine;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface RumRepository extends JpaRepository<Rum, Long> {

    // Search for rum by name (case-insensitive)
    @Query(value = "SELECT * FROM rum r WHERE LOWER(r.name) LIKE LOWER(CONCAT('%', :searchTerm, '%'))",
            nativeQuery = true)
    List<Rum> searchByName(@Param("searchTerm") String searchTerm);

    // Find tequila by specific type 
    @Query(value = "SELECT * FROM rum WHERE flavour = :rumFlavour", nativeQuery = true)
    List<Rum> findByFlavour(@Param("rumFlavour") String rumFlavour);




}
