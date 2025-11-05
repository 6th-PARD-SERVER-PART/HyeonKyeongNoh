package com.pard.server.hw3.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;

    @Column(length = 100, nullable = false, unique = true)
    private String email;

    private String password;

    public void updateName(String newName){
        this.name= newName;
    }

    public void updateEmail(String newEmail){
        this.email= newEmail;
    }
}
