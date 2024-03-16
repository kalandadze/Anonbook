package com.mziuri.Request;

import com.mziuri.Classes.Post;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GetPostCommentsRequest {
    private Post post;

    public GetPostCommentsRequest(Post post) {
        this.post = post;
    }
}
