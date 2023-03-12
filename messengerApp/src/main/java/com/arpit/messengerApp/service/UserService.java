package com.arpit.messengerApp.service;

import com.arpit.messengerApp.model.Users;
import com.arpit.messengerApp.repository.UserRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class UserService implements IUserService {

   private UserRepository userRepository;
    public long saveUser(Users user) {
        Users userObj = userRepository.save(user);
        return userObj.getUserId();
    }

    @Override
    public JSONArray getUsers(String userId) {

        JSONArray response = new JSONArray();
        if(null != userId){
            List<Users> userList = userRepository.getUserByUserId(Long.parseLong(userId));
            for(Users user:userList){
                JSONObject userObj = createResponse(user);
                response.put(userObj);
            }
        }else {
            List<Users> userList = userRepository.getAllUsers();
            for(Users user:userList){
                JSONObject userObj = createResponse(user);
                response.put(userObj);
            }
        }
        return null;
    }

    @Override
    public JSONObject login(String username, String password) {

        JSONObject response = new JSONObject();
        List<Users> user = userRepository.findByUsername(username);

        if(user.isEmpty()){
            response.put("error Message", "Username doesn't exists");
            return response;
        }
        else{
            Users userObj = user.get(0);
            if(password.equals(userObj.getPassword())){
                response = createResponse(userObj);
            }
            else{
                response.put("error message", "password is not valid");
            }
        }
        return response;
    }

    @Override
    public JSONObject updateUser(String userId, Users newUser) {
        List<Users> userList = userRepository.getUserByUserId(Integer.valueOf(userId));
        JSONObject obj = new JSONObject();
        if(!userList.isEmpty()){
            Users oldUser = userList.get(0);
            newUser.setUserId(oldUser.getUserId());
            newUser.setCreateDate(oldUser.getCreateDate());
            newUser.setPassword(oldUser.getPassword());
            Timestamp updatedTime = new Timestamp(System.currentTimeMillis());
            newUser.setUpdatedDate(updatedTime);
            userRepository.save(newUser);
        }
        else{
            obj.put("errorMessage", "User doesn't exist");
        }
        return obj;
    }

    private JSONObject createResponse(Users user) {
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("userId", user.getUserId());
        jsonObject.put("fistName", user.getFirstName());
        jsonObject.put("lastName", user.getLastName());
        jsonObject.put("age", user.getAge());
        jsonObject.put("email", user.getEmail());
        jsonObject.put("phoneNumber" ,user.getPhoneNumber());
        jsonObject.put("gender", user.getGender());
        jsonObject.put("createdDate", user.getCreateDate());

        return jsonObject;
    }

//    public void deleteUserById(String userId){
//        userRepository.deleteUserById(Integer.parseInt(userId));
//    }
}
