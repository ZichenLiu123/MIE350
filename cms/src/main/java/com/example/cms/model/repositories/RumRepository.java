package com.example.cms.model.repositories;

import com.example.cms.model.entities.Rum;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface RumRepository extends JpaRepository<Rum, Long> {

    // Find rum by specific flavour
    @Query(value = "SELECT * FROM rum WHERE flavour = :rumFlavour", nativeQuery = true)
    List<Rum> findByFlavour(@Param("rumFlavour") String rumFlavour);




}
