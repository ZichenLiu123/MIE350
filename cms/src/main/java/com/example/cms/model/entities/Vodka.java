package com.example.cms.model.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "vodka")
public class Vodka{
    @Id
    private long vodka_id;

    @Nullable
    private String flavor;
    
}
