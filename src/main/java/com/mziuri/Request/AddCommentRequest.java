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
    private Post post;

    public AddCommentRequest(String text, String postId) {
        this.text = text;
        this.comment=new Comment();
        this.comment.setComment(text);
        DatabaseReader reader=DatabaseReader.getReader();
        this.post=reader.findPost(Integer.parseInt(postId));
    }
}
