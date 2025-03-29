package com.example.cms.model.repositories;

import com.example.cms.model.entities.Beer;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BeerRepository extends JpaRepository<Beer, Long> {
//    @Query(value = "SELECT * FROM BEER b JOIN alcohol a ON b.id = a.id \n" +
//            "WHERE beertype = :beerType AND top1flavor = :flavour AND price < :price ORDER BY price", nativeQuery = true)
//    List<Beer> findBeer(@Param("beerType") String beerType, @Param("flavour") String flavour, @Param("price") Integer price);

    @Query(value = "SELECT price FROM beer b JOIN alcohol a ON b.id = a.id WHERE b.beertype = :beerType AND a.top1flavor = :flavor ORDER BY price", nativeQuery = true)
    List<Double> findPricesByTypeAndFlavor(@Param("beerType") String beerType, @Param("flavor") String flavor);

    @Query(value = "SELECT * FROM beer b JOIN alcohol a ON b.id = a.id WHERE b.beertype = :beerType AND a.top1flavor = :flavor AND a.price <= :price ORDER BY a.price LIMIT 3", nativeQuery = true)
    List<Beer> findBeer(@Param("beerType") String beerType, @Param("flavor") String flavor, @Param("price") Double price);
}
