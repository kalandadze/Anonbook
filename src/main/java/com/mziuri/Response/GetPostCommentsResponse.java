package com.mziuri.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mziuri.Classes.Comment;
import com.mziuri.Classes.Post;
import com.mziuri.Request.GetPostCommentsRequest;
import com.mziuri.Service.DatabaseReader;

import java.util.List;

public class GetPostCommentsResponse {
    private final DatabaseReader reader = DatabaseReader.getReader();
    private Post post;

    public GetPostCommentsResponse(GetPostCommentsRequest request) {
        this.post=reader.findPost(Integer.parseInt(request.getPostId()));
    }
    public List<Comment> getResultList(){
        return reader.findComments(post);
    }
    public String getResultString() throws JsonProcessingException {
        ObjectMapper mapper=new ObjectMapper();
        return mapper.writeValueAsString(getResultList());
    }
}
