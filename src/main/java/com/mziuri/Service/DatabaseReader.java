package com.mziuri.Service;

import com.mziuri.Classes.Post;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DatabaseReader {
    private EntityManagerFactory factory;
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
}
