package com.pard.server.hw3.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class UserRes {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class name {
        private String name;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class nameEmail {
        private String name;
        private String email;
    }
}

