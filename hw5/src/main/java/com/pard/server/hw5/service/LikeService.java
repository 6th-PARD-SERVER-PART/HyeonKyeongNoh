package com.pard.server.hw5.service;

import com.pard.server.hw5.dto.LikeReq;
import com.pard.server.hw5.entity.Like;
import com.pard.server.hw5.repo.LikeJPARepo;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
public class LikeService {
    private final LikeJPARepo likeJPARepo;

    public LikeService(LikeJPARepo likeJPARepo) {
        this.likeJPARepo = likeJPARepo;
    }

    public void save(LikeReq.LikeInfo req){
        Like like = Like.builder()
                .userId(req.getUserId())
                .textId(req.getTextId())
                .build();
        likeJPARepo.save(like);
    }

    //특정 게시글  -> 특정 like 찾기
    public int existLike(LikeReq.LikeInfo req) {
        int jud = likeJPARepo.findByLike(req.getUserId(),req.getTextId());
        return jud;
    }

    public void deleteBypressId(Long userId, Long textId) {

        likeJPARepo.deleteByUserIdAndTextId(userId,textId);
    }

    public void deleteAllByUserId(Long userId){

        likeJPARepo.deleteAllByUserId(userId);
    }

    public void deleteByTextId(Long textId){

        likeJPARepo.deleteAllByTextId(textId);
    }
    }