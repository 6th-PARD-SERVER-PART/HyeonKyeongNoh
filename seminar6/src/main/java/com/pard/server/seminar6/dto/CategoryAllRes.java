package com.pard.server.seminar6.dto;

import lombok.Getter;

@Getter
public class CategoryAllRes {
    private String name;
    private Integer price;
    private Integer count;
    private Boolean sellable;

    public CategoryAllRes(String name, Integer price, Long count, Boolean sellable) {
        this.name = name;
        this.price = price;
        this.count = count.intValue();
        this.sellable = sellable;
    }
}