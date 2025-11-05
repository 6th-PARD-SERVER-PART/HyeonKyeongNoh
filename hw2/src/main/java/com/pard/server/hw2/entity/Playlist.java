package com.pard.server.hw2.entity;

import com.pard.server.hw2.service.PlaylistService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor

@Builder
public class Playlist {
    private long  playlistId;
    private String title;
    private String producer;
    private String genre;
    private int duration;

    public void updateTitle(String title) {
        this.title = title;
    }
}
