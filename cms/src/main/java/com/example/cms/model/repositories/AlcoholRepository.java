package com.example.cms.model.repositories;

import com.example.cms.model.entities.Alcohol;
import com.example.cms.model.entities.AlcoholCategory;
import com.example.cms.model.entities.Wine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlcoholRepository extends JpaRepository<Alcohol, Long> {

    // return alcohol category by name
    @Query(value = "SELECT c.category_id FROM category c WHERE LOWER(c.category_name) = LOWER(:searchTerm)",
            nativeQuery = true)
    Long findCategory(@Param("searchTerm") String searchTerm);
}
