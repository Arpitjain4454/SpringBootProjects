package com.arpit.blogpost.service;

import com.arpit.blogpost.model.Post;
import com.arpit.blogpost.model.User;
import com.arpit.blogpost.repository.PostRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;
    public int savePost(Post post) {
        Post savedPost = postRepository.save(post);
        return savedPost.getPostId();
    }

    public JSONArray getPost(Integer userid, String postId) {

        // Todo Add filter for userId

        JSONArray postArr = new JSONArray();

        if(null != postId && postRepository.findById(Integer.valueOf(postId)).isPresent()){
            Post post = postRepository.findById(Integer.valueOf(postId)).get();
            JSONObject postObj = setPostData(post);
            postArr.put(postObj);
        }
        else{
            List<Post> postList = postRepository.findAll();
            for(Post post:postList){
                JSONObject postObj = setPostData(post);
                postArr.put(postObj);
            }
        }
        return postArr;
    }

    private JSONObject setPostData(Post post) {
        JSONObject masterjson = new JSONObject();

        masterjson.put("postId", post.getPostId());
        masterjson.put("postData", post.getPostData());

        User user = post.getUser();

        JSONObject userjson = new JSONObject();
        userjson.put("userId", user.getUserId());
        userjson.put("firstName", user.getFirstName());
        userjson.put("age", user.getAge());
        masterjson.put("user", userjson);

        return masterjson;
    }

    public void updatePost(String postId, Post post) {
        Post db = postRepository.findById(Integer.valueOf(postId)).get();
        post.setPostId(db.getPostId());
        Timestamp updateData = new Timestamp(System.currentTimeMillis());
        post.setUpdateDate(updateData);
        post.setUser(db.getUser());
        post.setCreateDate(db.getCreateDate());
        postRepository.save(post);
    }


}
