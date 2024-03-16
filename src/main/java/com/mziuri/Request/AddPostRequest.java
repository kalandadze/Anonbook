package com.mziuri.Request;

import com.mziuri.Classes.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class AddPostRequest {
    private String text;
    private String image;
    private Post post;

    public AddPostRequest(String text, String image) {
        this.text = text;
        this.image = image;

        this.post = new Post();
        this.post.setText(text);
        this.post.setImage(image);
        this.post.setDate(new Date());
    }
}
