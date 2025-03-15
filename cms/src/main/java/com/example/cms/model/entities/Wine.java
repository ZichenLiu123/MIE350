package com.example.cms.model.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import org.springframework.lang.Nullable;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "wine")
public class Wine{
    @Id
    private Long id;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    @MapsId
    private Alcohol alcohol;

    @ManyToOne
    @JoinColumn(name = "wine_type_id", nullable = false)
    private WineType wineType;

    @Nullable
    private Integer age;
}
