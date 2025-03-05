package com.example.cms.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BeerDto {
    private Long id;
    private String name;
    private Long price;
    private String beerType;
    private String beerOrigin;
}
