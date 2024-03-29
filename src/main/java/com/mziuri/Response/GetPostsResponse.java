package com.mziuri.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mziuri.Classes.Post;
import com.mziuri.Service.DatabaseReader;

import java.util.List;

public class GetPostsResponse {
    private final DatabaseReader reader = DatabaseReader.getReader();
    public List<Post> getResultList(){
        return reader.findPosts();
    }
    public String getResultString() throws JsonProcessingException {
        ObjectMapper mapper=new ObjectMapper();
        return mapper.writeValueAsString(getResultList());
    }
}
