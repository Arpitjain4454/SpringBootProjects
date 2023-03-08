package com.arpit.blogpost.utility;

import com.arpit.blogpost.model.Post;
import com.arpit.blogpost.model.User;
import org.json.JSONObject;

public class UserUtility {
    public static User setUser(String userData) {
        JSONObject jsonObject = new JSONObject(userData);
        User user = new User();

        user.setAge(jsonObject.getInt("age"));
        user.setEmail(jsonObject.getString("email"));
        user.setFirstName(jsonObject.getString("firstName"));
        user.setLastName(jsonObject.getString("lastName"));
        user.setPhoneNumber(jsonObject.getInt("phoneNumber"));
        return user;
    }

}
