package com.example.cms.model.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@MappedSuperclass
@NoArgsConstructor
@Getter
@Setter
public abstract class Alcohol {

    @Id
    private long id;

    @NotEmpty
    private String name;

    @NotNull
    private long price;

    @NotNull
    private long amount;
}
