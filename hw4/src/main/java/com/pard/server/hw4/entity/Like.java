package com.pard.server.hw4.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "Likes")
@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long textId;
    private Long userId;
}
