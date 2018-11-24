<%-- 
File: display_picture.jsp
Description: A page for logged-in hosts to view and edit profile details
Create: Nov.01,2018
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
    String property_no = request.getParameter("property_no"); 

    PropertyPictureBusinessLayer pPictureLayer = new PropertyPictureBusinessLayer();
    Blob picture = pPictureLayer.getFirstPictureByProperty(Integer.valueOf(property_no));
    if(picture != null){
        long size = picture.length(); 
        //out.print(size); 
        byte[] bs = picture.getBytes(1, (int)size); 
        response.setContentType("image/*"); 
        OutputStream outs = response.getOutputStream(); 
        outs.write(bs); 
        outs.flush(); 
         
        outs.close();  
        outs = null;  
        response.flushBuffer();
        out.clear();  
        out = pageContext.pushBody();
    
    }

else { 
//response.sendRedirect("./images/error.gif"); 

} 
%> 