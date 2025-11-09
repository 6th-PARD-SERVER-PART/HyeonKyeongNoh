package com.pard.server.seminar6.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class ProductReq {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ProductInfo{
        private String name;
        private String color;
        private Integer price;
        private Integer count;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ColorNum {
        private String color;
        private Integer count;
    }
}
