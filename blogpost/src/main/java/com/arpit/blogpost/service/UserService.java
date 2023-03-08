package com.arpit.blogpost.service;

import com.arpit.blogpost.model.User;
import com.arpit.blogpost.repository.UserRepository;
import com.arpit.blogpost.utility.UserUtility;
import jakarta.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    public int saveUser(User user) {
        User userobj = userRepository.save(user);
        return userobj.getUserId();
    }

    public JSONArray getUser(String userId){

        JSONArray userArray = new JSONArray();

        if(null != userId && userRepository.findById(Integer.valueOf(userId)).isPresent()){
           User user = userRepository.findById(Integer.valueOf(userId)).get();
           JSONObject userObj = setUserObject(user);
           userArray.put(userObj);
        }
        else {
            List<User> userList = userRepository.findAll();
            for(User user : userList){
                JSONObject userObj = setUserObject(user);
                userArray.put(userObj);
            }
        }
        return userArray;
    }

    private JSONObject setUserObject(User user){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userId", user.getUserId());
        jsonObject.put("firstName", user.getFirstName());
        jsonObject.put("lastName", user.getLastName());
        jsonObject.put("email", user.getEmail());
        jsonObject.put("phoneNumber", user.getPhoneNumber());
        jsonObject.put("age", user.getAge());
        return jsonObject;
    }

    public User updateUser(String userId, User user) {
        User db = userRepository.findById(Integer.valueOf(userId)).get();

        if(Objects.nonNull(user.getFirstName()) &&
        !"".equalsIgnoreCase(user.getFirstName())){
        db.setFirstName(user.getFirstName());
        }

        if(Objects.nonNull(user.getLastName()) &&
                !"".equalsIgnoreCase(user.getLastName())){
            db.setLastName(user.getLastName());
        }

        if(Objects.nonNull(user.getEmail()) &&
                !"".equalsIgnoreCase(user.getEmail())){
            db.setEmail(user.getEmail());
        }

        if(Objects.nonNull(user.getAge()) &&
                !"".equalsIgnoreCase(String.valueOf(user.getAge()))){
            db.setAge(user.getAge());
        }
        if(Objects.nonNull(user.getPhoneNumber()) &&
                !"".equalsIgnoreCase(String.valueOf(user.getPhoneNumber()))){
            db.setPhoneNumber(user.getPhoneNumber());
        }

        return userRepository.save(db);
    }
}
