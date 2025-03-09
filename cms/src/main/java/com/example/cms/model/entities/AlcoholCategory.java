package com.example.cms.model.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "category")
public class AlcoholCategory {
    @Id
    private long category_id;

    @NotEmpty
    private String category_name;
}
