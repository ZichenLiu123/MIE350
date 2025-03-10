package com.example.cms.model.repositories;

import com.example.cms.model.entities.Rum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RumRepository extends JpaRepository<Rum, Long> {


}
