package com.example.cms.model.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "pairing_table")
public class Pairing{
    @Id
    private long id;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private AlcoholCategory category;

    @ManyToOne
    @JoinColumn(name = "food_id")
    private Food food;

    @NotNull
    private Integer recommend_Rank;

    private String match_flavour;
}