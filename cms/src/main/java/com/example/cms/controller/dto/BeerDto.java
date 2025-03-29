package com.example.cms.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BeerDto {
    private Double price;
    private String beerType;
    private String beerOrigin;
    private String flavour;
}
