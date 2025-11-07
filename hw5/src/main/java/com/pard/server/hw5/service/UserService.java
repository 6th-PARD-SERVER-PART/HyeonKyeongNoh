package com.pard.server.hw5.service;

import com.pard.server.hw5.dto.UserReq;
import com.pard.server.hw5.dto.UserRes;
import com.pard.server.hw5.entity.User;
import com.pard.server.hw5.repo.UserJPARepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService extends DefaultOAuth2UserService {

    private final UserJPARepo userJPARepo;

    @Override
    @Transactional
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        OAuth2User oAuth2User = super.loadUser(userRequest);
        Map<String, Object> attributes = oAuth2User.getAttributes();
        log.info("OAuth2 User Attributes: {}", attributes);

        String email = (String) attributes.get("email");
        String name = (String) attributes.get("name");

        User user = userJPARepo.findByEmail(email)
                .orElseGet(() -> userJPARepo.save(
                        User.builder()
                                .email(email)
                                .name(name)
                                .build()
                ));

        log.info("Logged in User: {}", user.getEmail());

        return oAuth2User;
    }

    @Transactional
    public void save(UserReq.UserInfo req) {
        userJPARepo.save(User.builder()
                .name(req.getName())
                .email(req.getEmail())
                .build());
    }

    @Transactional(readOnly = true)
    public UserRes.nameEmail readNameEmail(Long userId) {
        User user = userJPARepo.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + userId));
        return UserRes.nameEmail.builder()
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }

    @Transactional
    public void updateEmail(Long userId, String newEmail) {
        User user = userJPARepo.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + userId));
        user.updateEmail(newEmail);
    }

    @Transactional
    public void updateName(Long userId, String newName) {
        User user = userJPARepo.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found with ID: " + userId));
        user.updateName(newName);
    }

    @Transactional
    public void deleteById(Long userId) {
        userJPARepo.deleteById(userId);
    }
}