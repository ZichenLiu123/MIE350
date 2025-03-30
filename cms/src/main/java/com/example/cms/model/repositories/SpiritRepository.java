package com.example.cms.model.repositories;


import com.example.cms.model.entities.Spirit;
import com.example.cms.model.entities.Wine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpiritRepository extends JpaRepository<Spirit, Long> {
    @Query(value = "SELECT * FROM SPIRIT s JOIN alcohol a ON s.id = a.id WHERE s.spirit_type_id = :spiritType AND a.top1flavor = :flavor AND a.price <= :price ORDER BY price", nativeQuery = true)
    List<Spirit> findSpirit(@Param("spiritType") Long spiritType, @Param("flavor") String flavor, @Param("price") Double price);

    @Query(value = "SELECT price FROM SPIRIT s JOIN alcohol a ON s.id = a.id WHERE s.spirit_type_id = :spiritType AND a.top1flavor = :flavor ORDER BY price", nativeQuery = true)
    List<Double> findPricesByTypeAndFlavor(@Param("spiritType") Long spiritType, @Param("flavor") String flavor);
}
