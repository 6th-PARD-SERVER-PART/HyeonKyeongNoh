package com.pard.server.hw2.service;

import com.pard.server.hw2.dto.PlaylistDto;
import com.pard.server.hw2.dto.PlaylistResponseDto;
import com.pard.server.hw2.entity.Playlist;
import com.pard.server.hw2.repo.PlaylistRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlaylistService {
    private final PlaylistRepo playlistRepo;

    public void savePlaylist(PlaylistDto playlistDto) {
        Playlist playlist = Playlist.builder()
                .playlistId(playlistDto.getPlaylistId())
                                .title(playlistDto.getTitle())
                                        .genre(playlistDto.getGenre())
                                                .producer(playlistDto.getProducer())
                                                        .duration(playlistDto.getDuration())
                                                                .build();
        playlistRepo.save(playlist);
    }

    public PlaylistDto findById(Long playlistId) {
        Playlist playlist = playlistRepo.findById(playlistId);
        
        return PlaylistDto.builder()
                .title(playlist.getTitle())
                .genre(playlist.getGenre())
                .producer(playlist.getProducer())
                .duration(playlist.getDuration())
                .build();

    }

    public PlaylistResponseDto findByTitleAndProducerAndDuration(Long playlistId) {
        Playlist playlist = playlistRepo.findById(playlistId);

        return PlaylistResponseDto.builder()
                .title(playlist.getTitle())
                .producer(playlist.getProducer())
                .duration(playlist.getDuration())
                .build();
    }

    public void updatePlaylist(Long playlistId, String title, PlaylistDto playlistDto){
        Playlist playlist = playlistRepo.findById(playlistId);

        playlist.updateTitle(title);
        playlistRepo.save(playlist);
    }

    public void deleteById(Long playlistId){
        playlistRepo.deleteById(playlistId);
    }

    public List<PlaylistDto> findAll(){
        List<PlaylistDto> playlistDtos = new ArrayList<>();

        playlistRepo.findAll().forEach(playlist -> {
            PlaylistDto playlistDto = PlaylistDto.builder()
                    .playlistId(playlist.getPlaylistId())
                    .title(playlist.getTitle())
                    .genre(playlist.getGenre())
                    .producer(playlist.getProducer())
                    .duration(playlist.getDuration())
                    .build();
            playlistDtos.add(playlistDto);
        });
        return playlistDtos;
    }
}

