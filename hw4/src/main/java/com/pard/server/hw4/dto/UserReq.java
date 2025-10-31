package com.pard.server.hw4.dto;

import lombok.*;

public class UserReq {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserInfo{
        private String id;
        private String name;
        private String email;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserName {
        private String name;
    }


}
