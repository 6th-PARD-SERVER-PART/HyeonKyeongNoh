package com.pard.server.hw5.controller;

import com.pard.server.hw5.dto.TextReq;
import com.pard.server.hw5.dto.TextRes;
import com.pard.server.hw5.service.LikeService;
import com.pard.server.hw5.service.TextService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/text")
@RequiredArgsConstructor
public class TextController {
    private final TextService textService;
    private final LikeService likeService;

    @PostMapping("")
    public void save(@RequestBody TextReq.TextInfo req){
        textService.save(req);
    }

    @PatchMapping("/title/{textId}/{newTitle}")
    public void updateTitle(@PathVariable Long textId, @PathVariable String newTitle){
        textService.updateTitle(textId,newTitle);
    }

    @PatchMapping("/body/{textId}/{newBody}")
    public void updateBody(@PathVariable Long textId, @PathVariable String newBody){
        textService.updateBody(textId,newBody);
    }

    @GetMapping("/textId/{textId}")
    public ResponseEntity<?> readText(@PathVariable("textId") Long textId){
        try{
            TextRes.text text = textService.readTitleBody(textId);
            return ResponseEntity.ok(text);
        }catch (RuntimeException e)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

    @GetMapping("/userTexts/{userId}")
    public ResponseEntity<?> readAllUserText(@PathVariable("userId") Long userId) {
        try {
            List<TextRes.text> texts = textService.readAllTitleBody(userId);
            return ResponseEntity.ok(texts);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

    @DeleteMapping("{textId}")
    public ResponseEntity<?> deleteById(@PathVariable Long textId){
        try{
            likeService.deleteByTextId(textId);
            textService.deleteById(textId);
            return ResponseEntity.ok("successfully deleted");
        }catch(RuntimeException e)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

}
