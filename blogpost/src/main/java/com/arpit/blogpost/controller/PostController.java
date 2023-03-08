package com.arpit.blogpost.controller;

import com.arpit.blogpost.model.Post;
import com.arpit.blogpost.model.User;
import com.arpit.blogpost.repository.UserRepository;
import com.arpit.blogpost.service.PostService;
import com.arpit.blogpost.service.UserService;
import com.arpit.blogpost.utility.UserUtility;
import jakarta.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

@RestController
public class PostController {

    @Autowired
    PostService postService;
    @Autowired
    UserRepository userRepository;

    @PostMapping(name = "/post")
    public ResponseEntity<String> savePost(@RequestBody String postRequest){
        Post post = setPost(postRequest);
        int postId = postService.savePost(post);
        return new ResponseEntity<String>("post saved with post_id-" + postId, HttpStatus.CREATED);
    }

    public ResponseEntity<String> getPost(@RequestParam Integer userId,@Nullable @RequestParam String postId){
        JSONArray postArray = postService.getPost(userId, postId);
        return new ResponseEntity<String>("post saved with post_id-" + postId, HttpStatus.CREATED);
    }

    public Post setPost(String postRequest) {
        JSONObject jsonObject = new JSONObject(postRequest);

//      //Validation for user id
        User user = null;
        int userId = jsonObject.getInt("userId");

        if(userRepository.findById(userId).isPresent()){
            user = userRepository.findById(userId).get();
        }
        else{
            return null;
        }

        Post post = new Post();
        post.setUser(user);

        post.setPostData(jsonObject.getString("postData"));
        Timestamp createdTime = new Timestamp(System.currentTimeMillis());
        post.setCreateDate(createdTime);
        Timestamp uptedTime = new Timestamp(System.currentTimeMillis());
        post.setUpdateDate(uptedTime);

        return post;
    }

    @PutMapping(value = "/post/{postId}")
    public ResponseEntity<String> updatePost(@PathVariable("postId") String postId, @RequestBody String postData){
        Post post = setPost(postData);
        postService.updatePost(postId, post);
        return new ResponseEntity<String>("user data get updated", HttpStatus.OK);
    }
}
