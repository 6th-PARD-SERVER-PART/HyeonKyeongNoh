package com.pard.server.hw3.controller;

import com.pard.server.hw3.dto.TextReq;
import com.pard.server.hw3.dto.TextRes;
import com.pard.server.hw3.service.TextService;
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
// 1. 반환 타입을 ResponseEntity<?>로 변경하여 유연성을 확보합니다.
    public ResponseEntity<?> readAllUserText(@PathVariable("userId") Long userId) {
        try {
            List<TextRes.text> texts = textService.readAllTitleBody(userId);
            // 성공 시: ResponseEntity에 List를 담아 200 OK 상태로 반환
            return ResponseEntity.ok(texts);
        } catch (RuntimeException e) {
            // 실패 시: ResponseEntity에 에러 메시지를 담아 404 NOT FOUND 상태로 반환
            // 이제 강제 형변환이 필요 없습니다.
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

    @DeleteMapping("{textId}")
    public ResponseEntity<?> deleteById(@PathVariable Long textId){
        try{
            textService.deleteById(textId);
            return ResponseEntity.ok("successfully deleted");
        }catch(RuntimeException e)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

}
