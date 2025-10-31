package com.pard.server.hw4.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class User {
    @Id
    @Column(nullable = false, unique = true)
    private Long id;
    @Column(nullable = false)
    private String name;

    @Column(length = 100, nullable = false, unique = true)
    private String email;

    public void updateName(String newName){
        this.name= newName;
    }

    public void updateEmail(String newEmail){
        this.email= newEmail;
    }
}
