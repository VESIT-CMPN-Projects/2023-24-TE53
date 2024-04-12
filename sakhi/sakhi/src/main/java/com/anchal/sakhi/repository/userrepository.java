package com.anchal.sakhi.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public class userrepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Map<String,Object>> fetchalldates(int userid){  

        return jdbcTemplate.queryForList("EXEC sp_fetch_previous_dates ?",userid);
    }

    public int insertdate(String dates){
        return jdbcTemplate.update("EXEC sp_add_dates ?",dates);
    }

    public int registeruser(String fullname,String email,int age,String username,String password){
        return jdbcTemplate.update("EXEC sp_register_user ?,?,?,?,?",fullname,email,age,username,password);
    }

    public int loginuser(String username,String password){
        return jdbcTemplate.update("EXEC sp_loginuser ?,?",username,password);
    }

    public Map<String,Object> validateToken(int user_id,String token){
        return jdbcTemplate.queryForMap("EXEC sp_validate_token ?,?",user_id,token);
    }

}
