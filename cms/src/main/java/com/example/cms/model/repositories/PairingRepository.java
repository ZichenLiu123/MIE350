package com.example.cms.model.repositories;

import com.example.cms.model.entities.Pairing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PairingRepository extends JpaRepository<Pairing, Long> {

}
