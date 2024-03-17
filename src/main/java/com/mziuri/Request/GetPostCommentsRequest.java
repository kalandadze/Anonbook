package com.mziuri.Request;

import com.mziuri.Classes.Post;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GetPostCommentsRequest {
    private String postId;

    public GetPostCommentsRequest(String postId) {
        this.postId = postId;
    }
}
