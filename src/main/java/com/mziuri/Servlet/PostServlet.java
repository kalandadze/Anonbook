package com.mziuri.Servlet;

import com.mziuri.Request.AddPostRequest;
import com.mziuri.Response.AddPostResponse;
import com.mziuri.Response.GetPostsResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;

@WebServlet("/post")
@MultipartConfig(fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5)
public class PostServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GetPostsResponse response = new GetPostsResponse();
        resp.getWriter().write(response.getResultString());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String text = req.getParameter("text");
        Part imagePart = req.getPart("filename");
        String fileName = getFileName(imagePart);
        String uploadPath = getServletContext().getRealPath("") + File.separator + "images";
        String url = uploadPath + File.separator + fileName;
        AddPostRequest request;
        if (fileName.isEmpty()) {
            request = new AddPostRequest(text);
        } else {
            imagePart.write(url);
            url = "images/" + fileName;
            request = new AddPostRequest(text, url);
        }
        AddPostResponse response = new AddPostResponse(request);
        response.commit();
    }

    private String getFileName(Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename"))
                return content.substring(content.indexOf("=") + 2, content.length() - 1);
        }
        return "";
    }
}
