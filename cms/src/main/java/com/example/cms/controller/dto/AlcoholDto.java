package com.example.cms.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlcoholDto {
    private long id;
    private long category_id;
    private long amount;
    private String name;
    private long price;
    private Double abv;
    private String top1Flavor;
    private String top2Flavor;
    private String top3Flavor;
}
