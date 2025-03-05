package com.example.cms.model.repositories;

import com.example.cms.model.entities.Rum;
import com.example.cms.model.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RumRepository extends JpaRepository<Rum, Long> {


}
