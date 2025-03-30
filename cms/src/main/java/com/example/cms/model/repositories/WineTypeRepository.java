package com.example.cms.model.repositories;

import com.example.cms.model.entities.WineType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WineTypeRepository extends JpaRepository<WineType, Long> {
}
