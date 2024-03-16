package com.mziuri;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mziuri.Classes.Comment;
import com.mziuri.Classes.Post;
import com.mziuri.Service.DatabaseReader;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("unit");
        EntityManager manager=factory.createEntityManager();
        manager.getTransaction().begin();
//
//        Comment comment =new Comment();
//        comment.setComment("sagasdfhgahrharh11324131244444444444444444444444433");
//
//        Comment comment1 =new Comment();
//        comment1.setComment("111111111111111111111111111");
//
//        List<Comment> comments=new ArrayList<>();
//        comments.add(comment);
//        comments.add(comment1);
//
//        Post post=new Post();
//        post.setComments(comments);
//        post.setDate(new Date());
//        post.setText("sdfgdsjfghds kjgrh 34444444444444444444444444123333333333333333333333333333");
//
//        manager.persist(comment);
//        manager.persist(comment1);
//        manager.persist(post);

        DatabaseReader reader=DatabaseReader.getReader();
        Post post=reader.findPost(2);

        post.addComment("dfkjgasdfjkhasgdfkjhas");
//        manager
        manager.persist(post);

        ObjectMapper mapper=new ObjectMapper();
        System.out.println(mapper.writeValueAsString(post));

        manager.getTransaction().commit();
        manager.close();
        factory.close();

    }
}
