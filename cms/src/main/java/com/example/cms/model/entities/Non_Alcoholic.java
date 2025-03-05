package com.example.cms.model.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="non_alcoholic")
@NoArgsConstructor
@Getter
@Setter

public class Non_Alcoholic {
    @Id
    private Long id;

    @NotEmpty
    private String name;

    @NotNull
    private Long price;

    @NotNull
    private Long amount;

    private Boolean isCarbonated;
}
