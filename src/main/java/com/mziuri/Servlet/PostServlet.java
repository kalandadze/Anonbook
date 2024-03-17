package com.mziuri.Servlet;

import com.mziuri.Request.AddPostRequest;
import com.mziuri.Response.AddPostResponse;
import com.mziuri.Response.GetPostsResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/post")
public class PostServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GetPostsResponse response=new GetPostsResponse();
        resp.getWriter().write(response.getResultString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String text=req.getParameter("text");
        String image=req.getParameter("image");
        AddPostRequest request;
        if (image.isEmpty()){
            request=new AddPostRequest(text);
        }else {
            request=new AddPostRequest(text,image);
        }
        AddPostResponse response=new AddPostResponse(request);
        response.commit();
    }
}
