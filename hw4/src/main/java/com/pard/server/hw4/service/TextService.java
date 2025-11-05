package com.pard.server.hw4.service;

import com.pard.server.hw4.dto.TextReq;
import com.pard.server.hw4.dto.TextRes;
import com.pard.server.hw4.entity.Text;
import com.pard.server.hw4.repo.LikeJPARepo;
import com.pard.server.hw4.repo.TextJPARepo;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter
@Setter
public class TextService {
    private final TextJPARepo textJPARepo;
    private final LikeJPARepo likeJPARepo;

    public TextService(TextJPARepo textJPARepo, LikeJPARepo likeJPARepo) {
        this.textJPARepo = textJPARepo;
        this.likeJPARepo = likeJPARepo;
    }

    public void save(TextReq.TextInfo req){
        Text text = Text.builder()
                .userId(req.getUserId())
                .textTitle(req.getTextTitle())
                .textBody(req.getTextBody())
                .build();
        textJPARepo.save(text);
    }

    public TextRes.text readTitleBody(Long textId) {
        Text user = textJPARepo.findByTextId(textId)
                .orElseThrow(() -> new RuntimeException("Text not found with ID: " + textId));
        return TextRes.text.builder()
                .textTitle(user.getTextTitle())
                .textBody(user.getTextBody())
                .build();
    }

    public List<TextRes.text> readAllTitleBody(Long userId) {
        List<Text> foundTexts = textJPARepo.findAllByUserIdWithUser(userId);

        return foundTexts.stream()
                .map(text ->
                        TextRes.text.builder()
                                .textTitle(text.getTextTitle())
                                .textBody(text.getTextBody())
                                .build()
                )
                .toList();
    }

    @Transactional
    public void updateTitle(Long textId, String newTitle) {
        Text text = textJPARepo.findByTextId(textId)
                .orElseThrow(()->new RuntimeException("Text not found with ID: "+textId));
        text.updateTitle(newTitle);
    }

    @Transactional
    public void updateLikes(Long textId, int var) {
        Text text = textJPARepo.findByTextId(textId)
                .orElseThrow(()->new RuntimeException("Text not found with ID: "+textId));
        text.updateLikes(var);
    }

    @Transactional
    public void updateBody(Long textId, String newBody) {
        Text text = textJPARepo.findByTextId(textId)
                .orElseThrow(()->new RuntimeException("Text not found with ID: "+textId));
        text.updateBody(newBody);
    }

    public void deleteById(Long textId){
        textJPARepo.deleteById(textId);
    }

    public void deleteAllByUserId(Long userId) {
        List<Text> texts = textJPARepo.findAllByUserIdWithUser(userId);
        for (Text text : texts) {
            likeJPARepo.deleteAllByTextId(text.getTextId());
            textJPARepo.deleteById(text.getTextId());
        }
    }
}

