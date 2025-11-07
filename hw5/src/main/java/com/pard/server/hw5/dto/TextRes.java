package com.pard.server.hw5.dto;

import lombok.*;

public class TextRes {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class text {
        private Long userId;
        private String textTitle;
        private String textBody;
    }
}
