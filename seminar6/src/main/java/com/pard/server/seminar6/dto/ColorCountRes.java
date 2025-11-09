package com.pard.server.seminar6.dto;

import lombok.Getter;

@Getter
public class ColorCountRes {
    String color;
    int count;

    public ColorCountRes(String color, Long count) {
        this.color = color;
        this.count = count.intValue();
    }

    public ColorCountRes(String color, Integer count) {
        this.color = color;
        this.count = count;
    }
}
