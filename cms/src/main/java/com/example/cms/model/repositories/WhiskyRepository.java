package com.example.cms.model.repositories;

import com.example.cms.model.entities.Whisky;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WhiskyRepository extends JpaRepository<Whisky, Long> {

}
