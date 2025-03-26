package com.example.cms.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Non_alcoholicDto {
    private String flavor;
    private Double price;
    private Boolean isCarbonated;
    private String alcoholicEquivalent;
}