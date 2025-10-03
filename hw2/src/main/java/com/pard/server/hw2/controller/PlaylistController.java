package com.pard.server.hw2.controller;

import com.pard.server.hw2.dto.PlaylistDto;
import com.pard.server.hw2.dto.PlaylistResponseDto;
import com.pard.server.hw2.service.PlaylistService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/playlist")
public class PlaylistController {
    private final PlaylistService playlistService;

    @PostMapping("")
    public String save(@RequestBody PlaylistDto playlistDto) {
        playlistService.savePlaylist(playlistDto);
        return "succesfully saved";
    }

    @GetMapping("/playlistId")
    public PlaylistDto findById(@PathVariable Long playlistId){
        return playlistService.findById(playlistId);
    }

    @GetMapping("/{playlistId}/TitleAndProducerAndDuration")
    public PlaylistResponseDto findTitleAndProducerAndDuration(@PathVariable Long playlistId){
        return playlistService.findByTitleAndProducerAndDuration(playlistId);
    }
    //dto를 또 안 만든다(?)

    @PatchMapping("/{playlistId}")
    public String updateById(@PathVariable Long playlistId,@RequestBody PlaylistDto playlistDto){
        playlistService.updatePlaylist(playlistId,playlistDto);
        return "수정완료~";
    }

    @DeleteMapping("{studentId}")
    public String deleteById(@PathVariable Long playlistId){
        playlistService.deleteById(playlistId);
        return "삭제완료~";
    }

    @GetMapping("")
    public List<PlaylistDto> findAll(){
        return playlistService.findAll();
    }
}
