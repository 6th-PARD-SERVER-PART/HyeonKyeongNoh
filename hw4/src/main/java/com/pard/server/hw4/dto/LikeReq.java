package com.pard.server.hw4.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class LikeReq {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class LikeInfo{
        private Long userId;
        private Long textId;
    }
}
