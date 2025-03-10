package com.example.cms.model.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "spirit")
public class Spirit {
    @Id
    private Long id;

    @OneToOne (cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id")
    @MapsId
    private Alcohol alcohol;

    @ManyToOne
    @JoinColumn(name = "spirit_type_id", nullable = false)
    private SpiritType spiritType;
}