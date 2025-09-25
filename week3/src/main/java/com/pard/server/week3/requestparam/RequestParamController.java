package com.pard.server.week3.requestparam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class RequestParamController {

    @RequestMapping("/v1")
    public String param1(@RequestParam("name") String myName, @RequestParam("age") int myAge){
        return "Request param 1번 : " + myName + " 나이 " + myAge;
    }

    @RequestMapping("/v2")
    public String param2(@RequestParam String name, @RequestParam int age){
        return "Request param 2번 : " + name + " 나이 " + age;
    }

    @RequestMapping("/v3")
    public String param3(String name, int age){
        return "Request param 3번 : " + name + " 나이 " + age;
    }

    @RequestMapping("/v4")
    public String requestParam4(
            @RequestParam(required = true) String name,
            @RequestParam(required = false) Integer age){
        return "requestParamV4 연습 name : " + name + " age : " + age;
    }

    @RequestMapping("/default")
    public String requestParamDefault(
            @RequestParam(required = true, defaultValue = "guest") String name,
            @RequestParam(required = false, defaultValue = "-1") int age){
        return "requestParamV5 연습 : " + "name : " + name + " age : " + age;
    }

    @RequestMapping("/map")
    public String requestParamMap(@RequestParam Map<String, String> paramMap){
        return "requestParamV6 연습 name : " + paramMap.get("name") + " age : " + paramMap.get("age");
    }
}