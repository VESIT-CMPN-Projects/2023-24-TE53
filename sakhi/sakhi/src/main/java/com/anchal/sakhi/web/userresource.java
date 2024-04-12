package com.anchal.sakhi.web;

import com.anchal.sakhi.service.userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200",allowCredentials = "true")
public class userresource {
    @Autowired
    com.anchal.sakhi.service.userservice userservice;

    @GetMapping("/dates/{userid}")
    public List<String> fetchalldates(@PathVariable int userid){

        return userservice.fetchalldates(userid);
    }

    @PostMapping("/dates")
    public void insertdate(@RequestBody Map<String,Object> body){

        userservice.insertdate(body);
    }
    @PostMapping("/register")
    public void registeruser(@RequestBody Map<String,Object> body){

        userservice.registeruser(body);
    }
    @PostMapping("/login")
    public void loginuser(@RequestBody Map<String,Object> body){

        userservice.loginuser(body);
    }
}
