package com.example.cms.model.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

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
    @JoinColumn(name = "alcohol_category_id")
    private AlcoholCategory alcohol_category;

    @Nullable
    private String food_type;
}