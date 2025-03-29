package com.example.cms.model.repositories;

import com.example.cms.model.entities.Alcohol;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface AlcoholRepository extends JpaRepository<Alcohol, Long> {

    // return alcohol category by name
    @Query(value = "SELECT c.category_id FROM category c WHERE LOWER(c.category_name) = LOWER(:searchTerm)",
            nativeQuery = true)
    Long findCategory(@Param("searchTerm") String searchTerm);

    // Search for alcohol by name (case-insensitive)
    @Query(value = "SELECT * FROM alcohol a WHERE LOWER(a.name) LIKE LOWER(CONCAT('%', :searchTerm, '%'))",
            nativeQuery = true)
    List<Alcohol> searchByName(@Param("searchTerm") String searchTerm);

    // Search for tequila by name (case-insensitive)
    @Query(value = "SELECT * FROM alcohol a WHERE LOWER(a.name) LIKE LOWER(CONCAT('%', :searchTerm, '%')) AND a.id >= 430 AND a.id <= 440",
            nativeQuery = true)
    List<Alcohol> searchByNameTequila(@Param("searchTerm") String searchTerm);

    // Search for rum by name (case-insensitive)
    @Query(value = "SELECT * FROM alcohol a WHERE LOWER(a.name) LIKE LOWER(CONCAT('%', :searchTerm, '%')) AND a.id >= 330 AND a.id <= 343",
            nativeQuery = true)
    List<Alcohol> searchByNameRum(@Param("searchTerm") String searchTerm);

    @Query(value = "SELECT * FROM alcohol WHERE category_id = :categoryId AND top1Flavor = :top1Flavor", nativeQuery = true)
    List<Alcohol> findByCategoryIdAndTop1Flavor(@Param("categoryId") Long categoryId, @Param("top1Flavor") String top1Flavor);

}
