package com.pard.server.hw3.dto;

import lombok.*;

public class TextReq {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TextInfo{
        private Long userId;
        private String textTitle;
        private String textBody;
    }
}
