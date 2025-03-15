package com.example.cms.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlcoholDto {
    private Long id;
    private String category; // find by name of category instead of number
    private Long amount;
    private String name;
    private Long price;
    private Double abv;
    private String top1Flavor;
    private String top2Flavor;
    private String top3Flavor;
}
