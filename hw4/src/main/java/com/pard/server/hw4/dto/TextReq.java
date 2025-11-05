package com.pard.server.hw4.dto;

import lombok.*;

public class TextReq {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TextInfo{
        private Long userId;
        private Long textId;
        private String textTitle;
        private String textBody;
    }
}
