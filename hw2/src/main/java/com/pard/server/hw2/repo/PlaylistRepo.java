package com.pard.server.hw2.repo;

import com.pard.server.hw2.entity.Playlist;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PlaylistRepo {
    public Map<Long, Playlist> playlistRepo = new HashMap<>();

    public void save(Playlist playlist) {
        playlistRepo.put(playlist.getPlaylistId(),playlist);
    }

    public Playlist findById(long playlistId) {
        return playlistRepo.get(playlistId);
    }

    public void deleteById(long playlistId) {
        playlistRepo.remove(playlistId);
    }

    public List<Playlist> findAll() {
        return playlistRepo.values().stream().toList();
    }
}
