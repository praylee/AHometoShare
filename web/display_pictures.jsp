<%-- 
File: display_pictures.jsp
Description: A page for logged-in hosts to view and edit profile details
Create: Nov.24,2018
Author: Liangliang Du
Clients: Michelle Bilek, Farheen Khan
Course: Software Development Project
Professor: Dr. Anu Thomas
Project: A Home to Share
Copyright @ 2018
--%>

<%@page import="business.PropertyPictureBusinessLayer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.io.*"%> 
<%@ page import="java.sql.*, javax.sql.*" %> 
<%@ page import="java.util.*"%> 
<%@ page import="java.math.*"%> 
<% 
    String picture_no = request.getParameter("pictureId"); 

    PropertyPictureBusinessLayer pPictureLayer = new PropertyPictureBusinessLayer();
    List<Blob> pictures = pPictureLayer.getAllPicturesById(Integer.valueOf(picture_no));
    byte[] imgData = null;
    for(Blob picture:pictures){
        long size = picture.length(); 
        imgData = picture.getBytes(1, (int)size); 
    }
              
    response.setContentType("image/*"); 
    OutputStream outs = response.getOutputStream(); 
    outs.write(imgData); 
    outs.flush(); 

    outs.close();  
    outs = null;  
    response.flushBuffer();
    out.clear();  
    out = pageContext.pushBody();
    
%> 