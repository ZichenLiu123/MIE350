package com.example.cms.model.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "whisky")
public class Whisky{
    @Id
    private long whisky_id;

    @Nullable
    private Integer age;

    @Nullable
    private String barrelType;
}
