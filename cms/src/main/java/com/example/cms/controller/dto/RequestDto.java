package com.example.cms.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestDto {
    private Long alcoholType;
    private String flavor;
    private Double price;
}
