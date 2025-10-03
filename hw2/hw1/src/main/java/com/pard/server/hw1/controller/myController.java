package com.pard.server.hw1.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/effectors")
public class myController {
    public Map<String, Integer> pedalboard = new HashMap<>();

    @PostMapping("/set/{effectorName}/{levelValue}")
    public String findEffector(@PathVariable String effectorName, @PathVariable int levelValue) {
        pedalboard.put(effectorName, levelValue);
        return "post successful";
    }

    @GetMapping("/get/{effectorName}")
    public String findEffector(@PathVariable String effectorName) {
        int levelValue=-1;
        if (pedalboard.containsKey(effectorName)) {
            levelValue = pedalboard.get(effectorName);
        }
        return effectorName + " level = " + levelValue;
    }

    @PatchMapping("/update/{effectorName}/{levelValue}")
    public String updateEffector(@PathVariable String effectorName,  @PathVariable int levelValue) {
        if (pedalboard.containsKey(effectorName)) {
            pedalboard.put(effectorName, levelValue);
            return "update successful";
        }
        return "update failed";
    }

    @DeleteMapping("/delete/{effectorName}")
    public String deleteEffector(@PathVariable String effectorName) {
        if (pedalboard.containsKey(effectorName)) {
            pedalboard.remove(effectorName);
            return "delete successful";
        }
        return "delete failed";
    }

    @RequestMapping("/pedalboard")
    public Map<String,Integer> pedalboard(){
        return pedalboard;
    }

}
