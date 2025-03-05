package com.example.cms.model.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;


@Entity
@NoArgsConstructor
@Getter
@Setter

public class Spirit extends Alcohol{
    @NotNull
    private String type;
}
