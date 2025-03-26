package com.example.cms.model.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.cms.model.entities.Non_Alcoholic;

@Repository
public interface Non_AlcoholicRepository extends JpaRepository<Non_Alcoholic, Long> {

    @Query(value = "SELECT * FROM non_alcoholic WHERE LOWER(name) LIKE LOWER(CONCAT('%', :searchTerm, '%'))",
    nativeQuery = true) 
    List<Non_Alcoholic> searchByName(@Param("searchTerm") String searchTerm);
    
    @Query(value = "SELECT * FROM non_alcoholic WHERE price < :maxPrice", nativeQuery = true) 
    List<Non_Alcoholic> findUnderPrice(@Param("maxPrice") BigDecimal maxPrice);

    //Added recommendation
    @Query(value = "SELECT * FROM non_alcoholic n JOIN alcohol a ON n.id = a.id WHERE alcoholicEquivalent = :alcoholicEquivalent AND top1flavor = :flavor AND price < :price AND isCarbonated = :isCarbonated ORDER BY price", nativeQuery = true)
    List<Non_Alcoholic> non_alcoholicRec(@Param("price") Double price, @Param("flavor") String flavor, @Param("isCarbonated") Boolean carbonate, @Param("alcoholicEquivalent") String alcoholicEquivalent);
    
    
    List<Non_Alcoholic> findByIsCarbonatedTrue();
    List<Non_Alcoholic> findByIsCarbonatedFalse();
    List<Non_Alcoholic> findByAlcoholicEquivalentContainingIgnoreCase(String alcoholicEquivalent);
}