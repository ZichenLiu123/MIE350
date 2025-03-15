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
@Table(name = "liquors")
public class Liquors{
    @Id
    private long id;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    @MapsId
    private Alcohol alcohol;

    private String aroma;
}
