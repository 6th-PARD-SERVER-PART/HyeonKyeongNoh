package com.pard.server.hw3.controller;

import com.pard.server.hw3.dto.UserReq;
import com.pard.server.hw3.dto.UserRes;
import com.pard.server.hw3.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("")
    public void save(@RequestBody UserReq.UserInfo req){
        userService.save(req);
    }

    @PatchMapping("/Email/{userId}/{newEmail}")
    public void updateEmail(@PathVariable Long userId, @PathVariable String newEmail, @RequestBody UserReq.UserInfo req){
        userService.updateEmail(userId,req,newEmail);
    }

    @PatchMapping("/Name/{userId}/{newName}")
    public void updateName(@PathVariable Long userId, @PathVariable String newName, @RequestBody UserReq.UserInfo req){
        userService.updateName(userId,req,newName);
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
            userService.deleteById(userId);
            return ResponseEntity.ok("successfully deleted");
        }catch(RuntimeException e)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

}
