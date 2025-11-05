package com.pard.server.hw3.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Text {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long textId;
    private Long userId;
    @Column(length = 100, nullable = false, unique = true)
    private String textTitle;
    @Column(nullable = false)
    private String textBody;

    public void updateTitle(String newTitle){
        this.textTitle= newTitle;
    }

    public void updateBody(String newBody){
        this.textBody= newBody;
    }
}
