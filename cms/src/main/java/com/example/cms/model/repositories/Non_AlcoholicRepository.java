package com.example.cms.model.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import com.example.cms.model.entities.Non_Alcoholic;
import com.example.cms.model.entities.Wine;

@Repository
public interface Non_AlcoholicRepository extends JpaRepository<Non_Alcoholic, Long> {

    @Query(value = "SELECT * FROM non_alcoholic WHERE LOWER(name) LIKE LOWER(CONCAT('%', :searchTerm, '%'))",
    nativeQuery = true) 
    List<Non_Alcoholic> searchByName(@Param("searchTerm") String searchTerm);
    
    @Query(value = "SELECT * FROM non_alcoholic WHERE price < :maxPrice", nativeQuery = true) 
    List<Non_Alcoholic> findUnderPrice(@Param("maxPrice") BigDecimal maxPrice);

    @Query(value = "SELECT * FROM NON_ALCOHOLIC n JOIN alcohol a ON n.id = a.id WHERE ISCARBONATED = :iscarbonated AND ALCOHOLICEQUIVALENT = :alcoholicequivalent AND top1flavor = :flavor AND price < :price ORDER BY price", nativeQuery = true)
    List<Non_Alcoholic> findNonAlcohol(@Param("iscarbonated") Boolean iscarbonated, @Param("alcoholicequivalent") String alcoholicequivalent, @Param("flavor") String flavor, @Param("price") Double price);
    
    List<Non_Alcoholic> findByIsCarbonatedTrue();
    List<Non_Alcoholic> findByIsCarbonatedFalse();
    List<Non_Alcoholic> findByAlcoholicEquivalentContainingIgnoreCase(String alcoholicEquivalent);
}