package com.pard.server.hw5.controller;

import com.pard.server.hw5.dto.UserReq;
import com.pard.server.hw5.dto.UserRes;
import com.pard.server.hw5.service.LikeService;
import com.pard.server.hw5.service.TextService;
import com.pard.server.hw5.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final TextService textService;
    private final LikeService likeService;

    @RestController
    public class HomeController {

        @GetMapping("/home")
        public Map<String, Object> home(Authentication authentication) {
            if (authentication != null && authentication.getPrincipal() instanceof OAuth2User) {
                OAuth2User oauth2User = (OAuth2User) authentication.getPrincipal();
                return oauth2User.getAttributes();
            }
            return Map.of("message", "로그인 안 됨");
        }
    }

    @PostMapping("")
    public void save(@RequestBody UserReq.UserInfo req){
        userService.save(req);
    }

    @PatchMapping("/Email/{userId}/{newEmail}")
    public void updateEmail(@PathVariable Long userId, @PathVariable String newEmail, @RequestBody UserReq.UserInfo req){
        userService.updateEmail(userId,newEmail);
    }

    @PatchMapping("/Name/{userId}/{newName}")
    public void updateName(@PathVariable Long userId, @PathVariable String newName, @RequestBody UserReq.UserInfo req){
        userService.updateName(userId,newName);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> readName(@PathVariable("userId") Long userId){
        try{
            UserRes.nameEmail nameEmail = userService.readNameEmail(userId);
            return ResponseEntity.ok(nameEmail);
        }catch (RuntimeException e)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteById(@PathVariable Long userId){
        try{
            likeService.deleteAllByUserId(userId);
            textService.deleteAllByUserId(userId);
            userService.deleteById(userId);
            return ResponseEntity.ok("successfully deleted");
        }catch(RuntimeException e)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

}
