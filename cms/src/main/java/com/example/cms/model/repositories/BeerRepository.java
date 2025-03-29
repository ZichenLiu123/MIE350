package com.example.cms.model.repositories;

import com.example.cms.model.entities.Beer;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BeerRepository extends JpaRepository<Beer, Long> {
    @Query(value = "SELECT * FROM BEER b JOIN alcohol a ON b.id = a.id WHERE beertype = :beerType AND beerOrigin = :beerOrigin AND top1flavor = :flavor AND price < :price ORDER BY price", nativeQuery = true)
    List<Beer> findBeer(@Param("beerType") String beerType, @Param("beerOrigin") String beerOrigin, @Param("flavor") String flavor, @Param("price") Double price);
}
