package com.pard.server.hw3.dto;

import lombok.*;

public class UserReq {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserInfo{
        private String name;
        private String email;
        private String password;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserName {
        private String name;
    }


}
