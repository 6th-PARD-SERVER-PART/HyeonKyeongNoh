package com.pard.server.seminar6.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class ProductRes {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ProductAll {
        private Integer id;
        private String name;
        private Integer price;
        private Integer count;
        private boolean sellable;
    }
}
