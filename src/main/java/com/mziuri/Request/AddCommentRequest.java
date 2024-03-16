package com.mziuri.Request;

import com.mziuri.Classes.Comment;
import com.mziuri.Classes.Post;
import com.mziuri.Service.DatabaseReader;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddCommentRequest {
    private String text;
    private Comment comment;
    private int postId;

    public AddCommentRequest(String text, String postId) {
        this.text = text;
        this.postId=Integer.parseInt(postId);

        this.comment=new Comment();
        this.comment.setComment(text);
    }
}
