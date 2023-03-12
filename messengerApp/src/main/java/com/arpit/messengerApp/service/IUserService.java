package com.arpit.messengerApp.service;

import com.arpit.messengerApp.model.Users;
import org.json.JSONArray;
import org.json.JSONObject;

public interface IUserService {
    public long saveUser(Users user);

    JSONArray getUsers(String userId);

    JSONObject login(String username, String password);

    JSONObject updateUser(String userId, Users user);
}
