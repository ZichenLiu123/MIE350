package com.example.cms.model.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "liquors")
public class Liquors extends Alcohol{
    @NotNull
    private String aroma;
}
