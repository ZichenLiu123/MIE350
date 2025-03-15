package com.example.cms.model.repositories;

import com.example.cms.model.entities.Tequila;
import com.example.cms.model.entities.Wine;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TequilaRepository extends JpaRepository<Tequila, Long> {

    // Search for tequila by name (case-insensitive)
    @Query(value = "SELECT * FROM tequila t WHERE LOWER(t.name) LIKE LOWER(CONCAT('%', :searchTerm, '%'))",
            nativeQuery = true)
    List<Tequila> searchByName(@Param("searchTerm") String searchTerm);

    // Find tequila by specific type 
    @Query(value = "SELECT * FROM tequila WHERE type = :tequilaType", nativeQuery = true)
    List<Tequila> findByType(@Param("tequilaType") String tequilaType);

}
