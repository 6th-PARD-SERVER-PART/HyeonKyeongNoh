package com.pard.server.hw3.dto;

import lombok.*;

public class TextRes {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class text {
        private String textTitle;
        private String textBody;
    }

//    public static class textUser {
//        private String UserId;
//    }
}
