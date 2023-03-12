package com.arpit.messengerApp.controller;

import com.arpit.messengerApp.model.Status;
import com.arpit.messengerApp.model.Users;
import com.arpit.messengerApp.repository.StatusRepository;
import com.arpit.messengerApp.repository.UserRepository;
import com.arpit.messengerApp.service.UserService;
import com.arpit.messengerApp.util.CommonUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    StatusRepository statusRepository;

    @Autowired
    UserRepository userRepository;

    @PostMapping(value = "/create-user")
    public ResponseEntity<String> createUser(@RequestBody String userData) {
        JSONObject isValid = validateRequest(userData);

        Users user = null;
        if(isValid.isEmpty()){
            user = setUser(userData);
        }
        else{
            return new ResponseEntity<>(isValid.toString(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("User Saved", HttpStatus.CREATED);
    }

    @GetMapping(value = "/get-users")
    public ResponseEntity<String> getUsers(@RequestParam String userId){
        JSONArray userArray = userService.getUsers(userId);
        return new ResponseEntity<>(
                "saved", HttpStatus.OK
        );
    }

    @PostMapping(value = "/login")
    public ResponseEntity<String> login(@RequestBody String requestData){

        JSONObject requestJson = new JSONObject(requestData);

        JSONObject isValidLogin = validateLogin(requestJson);

        if(isValidLogin.isEmpty()){
            String username = requestJson.getString("username");
            String password = requestJson.getString("password");
            JSONObject responseObj = userService.login(username, password);
            if(responseObj.has("errorMessage")){
                return new ResponseEntity<String>(responseObj.toString(), HttpStatus.BAD_REQUEST);
            }
            else{
                return new ResponseEntity<String>(responseObj.toString(), HttpStatus.OK);
            }
        }
        else{
            return new ResponseEntity<>(isValidLogin.toString(), HttpStatus.BAD_REQUEST);
        }
    }

//    @DeleteMapping(value ="/delete-user/{userId}")
//    public ResponseEntity<String> deleteUser(@PathVariable String userId){
//        userService.deleteUserById(userId);
//    }

    @PutMapping(value = "/update-user/{userId}")
    public ResponseEntity<String> updateUser(@PathVariable String userId, @RequestBody String requestData){
        JSONObject isRequestValid = validateRequest(requestData);
        Users user = null;

        if(isRequestValid.isEmpty()){
            user = setUser(requestData);
            JSONObject responseObj = userService.updateUser(userId, user);
            if(responseObj.has("errorMessage")){
                return new ResponseEntity<String>(responseObj.toString(), HttpStatus.BAD_REQUEST);
            }
        }
        else{
            return new ResponseEntity<>(isRequestValid.toString(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("User updated", HttpStatus.CREATED);
    }


    private JSONObject validateLogin(JSONObject requestJson) {
        JSONObject errorList = new JSONObject();

        if(!requestJson.has("username")){
            errorList.put("username", "missing username");
        }
        if(!requestJson.has("password")){
            errorList.put("password", "missing password");
        }
        return errorList;
    }

    private JSONObject validateRequest(String userData) {
        JSONObject userJson = new JSONObject(userData);
        JSONObject errorList = new JSONObject();

        if(userJson.has("username")){
           String username = userJson.getString("username");

           if(!userJson.has("isUpdate")){
               List<Users> userList = userRepository.findByUsername(username);

               if(userList.size() > 0) {
                   errorList.put("username", "This username already exists");

                   return errorList;
               }
           }

        }
        else{
            errorList.put("username", "Missing username");
        }

        if(!userJson.has("isUpdate")){
            if(userJson.has("password")){
                String password = userJson.getString("password");
                if(!CommonUtils.isValidPassword(password)){
                    errorList.put("password", "Please enter valid Password");
                }
            }
            else{
                errorList.put("password", "Missing Password");
            }
        }

        if(userJson.has("firstName")){
            String firstName = userJson.getString("firstName");

        }
        else{
            errorList.put("firstName", "Missing firstName");

        }

        if(userJson.has("email")){
            String email = userJson.getString("email");
            if(!CommonUtils.isValidEmail(email)){
                errorList.put("email", "Please enter valid Email-id");
            }

        }
        else{
            errorList.put("email", "Missing email");

        }

        if(userJson.has("phoneNumber")){
            String phoneNumber = userJson.getString("phoneNumber");
            if(!CommonUtils.isValidPhoneNumber(phoneNumber)){
                errorList.put("phoneNumber", "Please enter valid PhoneNumber");
            }
        }
        else{
            errorList.put("phoneNumber", "Missing PhoneNumber");

        }

        if(userJson.has("age")){
            String age = userJson.getString("age");

        }
        if(userJson.has("lastName")){
            String lastName = userJson.getString("lastName");
        }

        return errorList;
    }

    private Users setUser(String userData) {
        Users user = new Users();
        JSONObject json = new JSONObject(userData);

        user.setEmail(json.getString("email"));
        user.setPassword(json.getString("password"));
        user.setUserName(json.getString("userName"));
        user.setFirstName(json.getString("firstName"));
        user.setLastName(json.getString("phoneNumber"));

        if(json.has("age")){
            user.setAge(json.getInt("age"));
        }
        if(json.has("lastName")){
            user.setLastName(json.getString("lastName"));
        }
        if(json.has("gender")){
            user.setAge(json.getInt("gender"));
        }

        Timestamp createTime = new Timestamp(System.currentTimeMillis());
        user.setCreateDate(createTime);

        Status status = statusRepository.findById(1L).get();
        user.setStatusId(status);

        return user;
    }
}