package com.mziuri.Servlet;

import com.mziuri.Request.AddCommentRequest;
import com.mziuri.Request.GetPostCommentsRequest;
import com.mziuri.Response.AddCommentResponse;
import com.mziuri.Response.AddPostResponse;
import com.mziuri.Response.GetPostCommentsResponse;
import com.mziuri.Response.GetPostsResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/comment")
public class CommentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String postId=req.getParameter("post_id");
        GetPostCommentsRequest request= new GetPostCommentsRequest(postId);
        GetPostCommentsResponse response=new GetPostCommentsResponse(request);
        resp.getWriter().write(response.getResultString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String text=req.getParameter("text");
        String postId=req.getParameter("post_id");
        System.out.println(text);
        System.out.println(postId);
        postId=postId.replace("N","");
        AddCommentRequest request=new AddCommentRequest(text,postId);
        AddCommentResponse response=new AddCommentResponse(request);
        if(response.commit()){
            resp.sendError(200);
        }else {
            resp.sendError(405);
        }
    }
}
