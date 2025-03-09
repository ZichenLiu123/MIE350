package com.example.cms.model.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "wine_type")
public class WineType {
    @Id
    private long id;

    @NotEmpty
    private String name;
}