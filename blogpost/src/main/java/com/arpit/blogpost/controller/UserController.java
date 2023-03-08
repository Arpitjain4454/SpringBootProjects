package com.arpit.blogpost.controller;

import com.arpit.blogpost.model.User;
import com.arpit.blogpost.service.UserService;
import com.arpit.blogpost.utility.UserUtility;
import jakarta.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/user")
    public ResponseEntity saveUser(@RequestBody String userData){
        User user = UserUtility.setUser(userData);
        int userId = userService.saveUser(user);
        return new ResponseEntity("user saved with id-" + userId, HttpStatus.CREATED);
    }

    @PutMapping(value = "/user/{userId}")
    public ResponseEntity<String> updateUser(@PathVariable("userId") String userId, @RequestBody String userData){
        User user = UserUtility.setUser(userData);
        userService.updateUser(userId, user);
        return new ResponseEntity("user data get updated", HttpStatus.CREATED);
    }

    @GetMapping(value = "/user")
    public ResponseEntity<String> getUser(@Nullable @RequestParam String userId){
        JSONArray userdetails = userService.getUser(userId);
        return new ResponseEntity(userdetails.toString(), HttpStatus.OK);
    }


}
