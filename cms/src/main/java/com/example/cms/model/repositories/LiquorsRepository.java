package com.example.cms.model.repositories;

import com.example.cms.model.entities.Liquors;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface LiquorsRepository extends JpaRepository<Liquors, Long> {
    @Query(value = "SELECT * FROM liquors WHERE LOWER(name) LIKE LOWER(CONCAT('%', :searchTerm, '%'))",
    nativeQuery = true) 
    List<Liquors> searchByName(@Param("searchTerm") String searchTerm);
    
    @Query(value = "SELECT * FROM liquors WHERE price < :maxPrice", nativeQuery = true) 
    List<Liquors> findUnderPrice(@Param("maxPrice") BigDecimal maxPrice);

    List<Liquors> findByAromaContainingIgnoreCase(String aroma);

}
