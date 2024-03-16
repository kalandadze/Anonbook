package com.mziuri;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mziuri.Classes.Comment;
import com.mziuri.Classes.Post;
import com.mziuri.Response.GetPostsResponse;
import com.mziuri.Service.DatabaseReader;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper=new ObjectMapper();
//        EntityManagerFactory factory = Persistence.createEntityManagerFactory("unit");
//        EntityManager manager=factory.createEntityManager();
//        manager.getTransaction().begin();



//
//        Comment comment1 =new Comment();
//        comment1.setComment("comment text 4 for 2");
//        comment1.setPost(post);
//
//
//        manager.persist(comment);
//        manager.persist(post);
//        manager.persist(comment1);




//
//        DatabaseReader reader=DatabaseReader.getReader();
//
//        Post post=reader.findPost(102);
//        System.out.println(mapper.writeValueAsString(post));
//        System.out.println(mapper.writeValueAsString(reader.findComments(post)));

//
//
//
//        manager.getTransaction().commit();
//        manager.close();
//        factory.close();

        DatabaseReader reader=DatabaseReader.getReader();

//        Post post=new Post();
//        post.setDate(new Date());
//        post.setText("text post 3");
//
//        Comment comment =new Comment();
//        comment.setComment("comment text 5 for 3");
//        comment.setPost(post);

//        reader.addPost(post);
//        reader.addComment(comment);

        GetPostsResponse response=new GetPostsResponse();
        System.out.println(response.getList());
        System.out.println(response.getString());
    }
}
