package com.example.cms.model.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "rum")
public class Rum {
    @Id
    private Long id;

    @OneToOne
    @JoinColumn(name = "id")
    @MapsId
    private Spirit spirit;

    @Nullable
    private String flavour;
}
