package com.mziuri.Service;

import com.mziuri.Classes.Comment;
import com.mziuri.Classes.Post;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.Date;
import java.util.List;

public class DatabaseReader {
    private final EntityManagerFactory factory;
    private static  DatabaseReader reader=null;
    private DatabaseReader(){
        this.factory= Persistence.createEntityManagerFactory("unit");
    }
    public static DatabaseReader getReader(){
        if(reader==null){
            reader=new DatabaseReader();
        }
        return reader;
    }
    public Post findPost(int id){
        EntityManager manager=factory.createEntityManager();
        manager.getTransaction().begin();
        Post post=manager.find(Post.class,id);
        manager.close();
        return post;
    }
    public List<Comment> findComments(Post post){
        EntityManager manager=factory.createEntityManager();
        manager.getTransaction().begin();
        Query query=manager.createQuery("from Comment where post=?1");
        query.setParameter(1,post);
        List<Comment> comments= query.getResultList();
        manager.getTransaction().commit();
        manager.close();
        return comments;
    }
    public List<Post> findPosts(){
        EntityManager manager=factory.createEntityManager();
        manager.getTransaction().begin();
        Query query=manager.createQuery("from Post");
        List<Post> posts= query.getResultList();
        manager.getTransaction().commit();
        manager.close();
        return posts;
    }

    public void addPost(Post post){
        EntityManager manager=factory.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(post);
        manager.getTransaction().commit();
        manager.close();
    }
    public void addComment(Comment comment){
        EntityManager manager=factory.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(comment);
        manager.getTransaction().commit();
        manager.close();
    }

}
