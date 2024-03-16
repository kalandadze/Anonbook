package com.mziuri.Classes;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "comments")
@Getter
@Setter
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String comment;
    @ManyToOne
    private Post post;
    public Comment(String comment, Post post) {
        this.comment = comment;
        this.post = post;
    }
}
