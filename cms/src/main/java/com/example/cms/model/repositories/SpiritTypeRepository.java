package com.example.cms.model.repositories;


import com.example.cms.model.entities.Spirit;
import com.example.cms.model.entities.SpiritType;
import com.example.cms.model.entities.Wine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpiritTypeRepository extends JpaRepository<SpiritType, Long> {
    
}
