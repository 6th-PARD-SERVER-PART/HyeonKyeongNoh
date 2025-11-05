package com.pard.server.hw4.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class LikeRes {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class like {
        private Long userId;
        private Long textId;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class likeUser {
        private Long userId;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class likeText {
        private String textId;
    }
}
