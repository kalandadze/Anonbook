package com.mziuri.Response;

import com.mziuri.Classes.Comment;
import com.mziuri.Classes.Post;
import com.mziuri.Request.GetPostCommentsRequest;
import com.mziuri.Service.DatabaseReader;

import java.util.List;

public class GetPostCommentsResponse {
    private final DatabaseReader reader = DatabaseReader.getReader();
    private Post post;

    public GetPostCommentsResponse(GetPostCommentsRequest request) {
        post=request.getPost();
    }
    public List<Comment> getResult(){
        return reader.findComments(post);
    }
}
