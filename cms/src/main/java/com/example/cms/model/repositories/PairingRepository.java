package com.example.cms.model.repositories;

import com.example.cms.model.entities.Alcohol;
import com.example.cms.model.entities.Pairing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PairingRepository extends JpaRepository<Pairing, Long> {

    // Modified method to return just IDs
    @Query(value = "SELECT a.id FROM alcohol a WHERE a.id IN " +
            "(SELECT a2.id FROM PAIRING_TABLE p " +
            "JOIN CATEGORY c ON p.alcohol_category_id = c.CATEGORY_ID " +
            "JOIN alcohol a2 ON c.CATEGORY_ID = a2.CATEGORY_ID " +
            "WHERE a2.top1flavor = :flavor AND p.food_type = :food_type) " +
            "ORDER BY a.price LIMIT 3", nativeQuery = true)
    List<Long> findPairingFoodIds(@Param("flavor") String flavor, @Param("food_type") String food_type);
}
