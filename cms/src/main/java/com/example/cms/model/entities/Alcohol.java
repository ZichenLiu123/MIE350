package com.example.cms.model.entities;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Alcohol {

    @Id
    private long id;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private AlcoholCategory category_id;

    @NotNull
    private long amount;

    @NotEmpty
    private String name;

    @NotNull
    private long price;

    @NotNull
    private Double abv;

    @NotNull
    private String top1Flavor;

    @NotNull
    private String top2Flavor;

    @NotNull
    private String top3Flavor;
}
