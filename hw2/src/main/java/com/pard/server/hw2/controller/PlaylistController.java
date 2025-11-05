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

    @PatchMapping("/{playlistId}/{title}")
    public String updateById(@PathVariable Long playlistId,@PathVariable String title,@RequestBody PlaylistDto playlistDto){
        playlistService.updatePlaylist(playlistId,title,playlistDto);
        return "succesfully updated";
    }

    @DeleteMapping("{playlistId}")
    public String deleteById(@PathVariable Long playlistId){
        playlistService.deleteById(playlistId);
        return "succesfully deleted";
    }

    @GetMapping("")
    public List<PlaylistDto> findAll(){
        return playlistService.findAll();
    }
}
