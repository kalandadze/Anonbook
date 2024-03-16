package com.mziuri.Response;

import com.mziuri.Classes.Comment;
import com.mziuri.Classes.Post;
import com.mziuri.Request.AddCommentRequest;
import com.mziuri.Service.DatabaseReader;
import org.hibernate.boot.model.relational.Database;

public class AddCommentResponse {
    private final DatabaseReader reader = DatabaseReader.getReader();
    private Comment comment;
    private int post_id;

    public AddCommentResponse(AddCommentRequest request) {
        this.comment = request.getComment();
        this.post_id = request.getPostId();
    }

    public boolean commit() {
        Post post=reader.findPost(post_id);
        if (post==null){
            return false;
        }else {
            comment.setPost(post);
            reader.addComment(comment);
        }
        return true;
    }
}
