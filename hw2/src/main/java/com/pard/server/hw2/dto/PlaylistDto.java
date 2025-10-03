package com.pard.server.hw2.dto;

import com.pard.server.hw2.entity.Playlist;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Getter
@Service
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlaylistDto {
    private Long playlistId;
    private String title;
    private String producer;
    private String genre;
    private int duration;


}
