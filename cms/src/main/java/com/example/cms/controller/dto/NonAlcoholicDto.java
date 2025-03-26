package com.example.cms.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NonAlcoholicDto {
    private Boolean isCarbonated;
    private String alcoholicEquivalent;
    private String flavour;
    private Double price;
}
