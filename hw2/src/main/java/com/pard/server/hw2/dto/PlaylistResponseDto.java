package com.pard.server.hw2.dto;

import lombok.*;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PlaylistResponseDto {
    private String title;
    private String producer;
    private int duration;
}
