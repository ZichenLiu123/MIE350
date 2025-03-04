package com.example.cms.model.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotEmpty;

@MappedSuperclass
@NoArgsConstructor
@Getter
@Setter
public abstract class Alcohol {

    @Id
    private long id;

    @NotEmpty
    private String name;

    @NotEmpty
    private long price;

    @NotEmpty
    private long amount;
}
