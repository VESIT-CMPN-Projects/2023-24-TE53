package com.anchal.sakhi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class userservice {
    @Autowired
    com.anchal.sakhi.repository.userrepository userrepository;

    public List<String> fetchalldates(int userid){
        List<String> datess=new ArrayList<>();
        List<Map<String,Object>> dates=userrepository.fetchalldates(userid);
        for(int i = 0; i < dates.size(); i++) {
            Map<String, Object> currDate = dates.get(i);
            Object dateValue = currDate.get("dates");
            if (dateValue != null) {
                datess.add(dateValue.toString());
            } else {
                // Handle the case where "dates" value is null
                // For example, you can skip adding it to the list or log a warning
                System.err.println("Warning: 'dates' value is null for entry " + i);
            }
        }

        System.out.println(datess);
        return datess;
    }

    public ResponseEntity<String> insertdate(Map<String,Object> body){
        String dates = (String) body.get("dates");
//        int cyclelength = (int) body.get("cyclelength");

        int noOfRows=userrepository.insertdate(dates);

        if(noOfRows>0){
            return ResponseEntity.ok("Successfully Inserted");
        }
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Insert Failed");

    }

    public ResponseEntity<String> registeruser(Map<String,Object> body){
        String fullname = (String) body.get("fullname");
        String email = (String) body.get("email");
        int age = Integer.parseInt((String) body.get("age"));
        String username = (String) body.get("username");
        String password = (String) body.get("password");

        int noOfRows=userrepository.registeruser(fullname,email,age,username,password);

        if(noOfRows>0){
            return ResponseEntity.ok("Successfully Registered");
        }
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Registeration Failed");

    }

    public ResponseEntity<String> loginuser(Map<String,Object> body){
        String username = (String) body.get("username");
        String password = (String) body.get("password");

        int noOfRows=userrepository.loginuser(username,password);

        if(noOfRows>0){
            return ResponseEntity.ok("Successfully Logged In");
        }
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("LogIn Failed");

    }


}
