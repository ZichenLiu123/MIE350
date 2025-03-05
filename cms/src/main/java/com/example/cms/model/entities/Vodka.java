package com.example.cms.model.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

import org.springframework.lang.Nullable;

@Entity
@NoArgsConstructor
@Getter
@Setter

public class Vodka extends Spirit {

    @Nullable
    private String flavor;
    
}
