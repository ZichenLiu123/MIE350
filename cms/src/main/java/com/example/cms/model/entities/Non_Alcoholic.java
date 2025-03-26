package com.example.cms.model.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name="non_alcoholic")
@NoArgsConstructor
@Getter
@Setter

public class Non_Alcoholic {
    @Id
    private Long id;

    @OneToOne
    @JoinColumn(name = "id")
    @MapsId
    private Alcohol alcohol;

    private Boolean isCarbonated;
    private String alcoholicEquivalent;
}
