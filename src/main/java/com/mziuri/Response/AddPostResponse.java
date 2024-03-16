package com.mziuri.Response;

import com.mziuri.Classes.Post;
import com.mziuri.Request.AddPostRequest;
import com.mziuri.Service.DatabaseReader;

public class AddPostResponse {
    private final DatabaseReader reader = DatabaseReader.getReader();
    private Post post;
    public AddPostResponse(AddPostRequest request) {
        this.post=request.getPost();
    }
    public void commit(){
        reader.addPost(post);
    }
}
