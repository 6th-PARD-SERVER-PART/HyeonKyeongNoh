package com.pard.server.hw4.service;

import com.pard.server.hw4.dto.UserReq;
import com.pard.server.hw4.dto.UserRes;
import com.pard.server.hw4.entity.User;
import com.pard.server.hw4.repo.UserJPARepo;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
public class UserService {
    private final UserJPARepo userJPARepo;

    public UserService(UserJPARepo userJPARepo) {
        this.userJPARepo = userJPARepo;
    }

    public void save(UserReq.UserInfo req){
        User user = User.builder()
                .name(req.getName())
                .email(req.getEmail())
                .build();
        userJPARepo.save(user);
    }

    public UserRes.nameEmail readNameEmail(Long userId) {
        User user = userJPARepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));
        return UserRes.nameEmail.builder()
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }

    @Transactional
    public void updateEmail(Long userId, UserReq.UserInfo req, String newEmail) {
        User user = userJPARepo.findById(userId)
                .orElseThrow(()->new RuntimeException("User not found with ID: "+userId));
        user.updateEmail(newEmail);
    }

    @Transactional
    public void updateName(Long userId, UserReq.UserInfo req, String newName) {
        User user = userJPARepo.findById(userId)
                .orElseThrow(()->new RuntimeException("User not found with ID: "+userId));
        user.updateName(newName);
    }

    public void deleteById(Long userId){
        userJPARepo.deleteById(userId);
    }
}
