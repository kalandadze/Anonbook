package com.mziuri.Classes;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "posts")
@Getter
@Setter
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Date date;
    private String image;
    private String text;
    @OneToMany(targetEntity = Comment.class)
    private List<Comment> comments;

    public void addComment(String text){
        Comment comment=new Comment();
        comment.setComment(text);
        comments.add(comment);
    }
}
