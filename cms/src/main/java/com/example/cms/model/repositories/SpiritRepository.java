package com.example.cms.model.repositories;


import com.example.cms.model.entities.Spirit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpiritRepository extends JpaRepository<Spirit, Long> {

}
