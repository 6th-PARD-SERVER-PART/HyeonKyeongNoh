package com.pard.server.hw5.controller;

import com.pard.server.hw5.dto.LikeReq;
import com.pard.server.hw5.service.LikeService;
import com.pard.server.hw5.service.TextService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/like")
@RequiredArgsConstructor
public class LikeController {
    private final LikeService likeService;
    private final TextService textService;

    //좋아요 생성 or 삭제
    @PostMapping("")
    public void saveOrDelete(@RequestBody LikeReq.LikeInfo req){
        if(likeService.existLike(req)==0){
        likeService.save(req);
        textService.updateLikes(req.getTextId(),1);
        }
        else{
            likeService.deleteBypressId(req.getUserId(),req.getTextId());
            textService.updateLikes(req.getTextId(),-1);
        }
    }
}
