package com.example.cms.model.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "beer")
public class Beer{
    @Id
    private long id;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    @MapsId
    private Alcohol alcohol;

    private String beerType;
    private String beerOrigin;
}
