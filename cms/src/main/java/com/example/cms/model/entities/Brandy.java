package com.example.cms.model.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "brandy")
public class Brandy extends Alcohol {
    @Nullable
    private Integer age;

    @Nullable
    private String barrelType;
    
}
