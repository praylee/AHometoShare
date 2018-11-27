<%-- 
File: renterProfileSearchDetails.jsp
Description: Page for host property details within the renter profile.
Create: Oct. 21, 2018
Author: Melissa Rajala
Modified by: Zhan Shen
Last modification: Nov. 25, 2018
Clients: Michelle Bilek, Farheen Khan
Course: Software Development Project
Professor: Dr. Anu Thomas
Project: A Home to Share
Copyright @ 2018
--%>

<%@page import="transferobjects.PropertyPicture"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.ArrayList"%>
<%@page import="transferobjects.Host"%>
<%@page import="transferobjects.Property"%>
<%@page import="java.util.List"%>
<%@page import="business.PropertyPictureBusinessLayer"%>
<%@ page import="java.sql.*, javax.sql.*" %> 
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Property Details</title>

        <link rel="stylesheet" href="assets/css/renterProfileSearchDetails_style.css" />
        
        <style>
            .img_container > img:hover {
                width: 100%;
                height: 100%;
            }
        </style>
    </head>
        
    <body class="subpage">
        <!-- Header -->
        <header id="header">
            <div class="inner">
                <a href="index.jsp" class="logo">A Home To Share</a>
                <nav id="nav">
                    <a href="index.jsp">Home</a>
                    <a href="howWeWork.jsp">How We Work</a>
                    <a href="faq.jsp">FAQ</a>
                    <!-- Buttons modified with java by Christopher Labelle-->
                    <a href="
                       <%=session.getAttribute("isLoggedIn") != null ? (session.getAttribute("userType").toString().equals("renter") ? "renterProfile.jsp" : "hostProfile.jsp") : "index.jsp"%>" 
                       style="
                       <%=session.getAttribute("isLoggedIn") != null ? "display: inline;" : "display: none;"%>">My Account</a>
                    <button id="logoutBtn" class="unstyled-button" onclick="window.location.href='LogoutRedirect'" style="<%=session.getAttribute("isLoggedIn") != null ? "display: inline;" : "display: none;"%>">Log out</button>
                </nav>
            </div>
        </header>
              

	<!--Main Frame-->
            <div class="wrapper">
            
                <!--Pane 1: a placeholder-->    
                <li class="aside aside-1"></li>

                <!--Pane 2: "My Account" - menu buttons-->
                <li class="aside aside-2">
                    <div class="btn-group-vertical">
                        <ul id="horizontal-list">
                            <li><hr class="welcome_block" align="left"></li>
                            <li><h3>Hello <%out.print(session.getAttribute("firstName"));%>!</h3><li>
                        </ul >
                        <ul style="list-style:none;">
                            <li id="menu1"><input type="button" value="My Profile" class="" onclick="window.location.href='renterProfile.jsp'" /></li>
                            <li id="menu2"><input type="button" value="Account Settings" class="" onclick="window.location.href='renterAccountSettings.jsp'" /></li>
                            <li id="menu3"><input type="button" value="Search Host Listings" onclick="window.location.href='RenterProfileSearch'" /></li>
                        </ul>
                    </div>
                </li>    


                    <!--Pane 3: Selected Host Property Details contents-->
                    <li class="aside aside-3">
                        <div class="property-search-details-content">
                                                    
                            <%
                                Property property = (Property) request.getAttribute("property");
                                Host host = (Host) request.getAttribute("host");
                            %>
                            
                            <form action="RenterProfileSearchDetails" method="get">

                                <h2>Property details</h2>

                                <hr width=600px;>
                            
                                <input type="hidden" id="bookingHost" name="bookingHost" value="<%=host.getHostID()%>">

                                <h5>Host name: <%=host.getFirstName()%> <%=host.getLastName()%></h5>

                                <h5>Start date: <%=property.getStartDate()%></h5>

                                <h5>End date: <%=property.getEndDate()%></h5>

                                <h5>Price: $<%=property.getPrice()%></h5>

                                <h4>About the property</h4>

                                <h5>Address: <%=property.getAddress()%>, <%=property.getCity()%>, <%=property.getProvince()%>, <%=property.getCountry()%></h5>
                                <h5>Postal code: <%=property.getPostalCode()%></h5>


                                <h4>Property details</h4>

                                <table border="1" class="detailsTable">
                                    <tr>
                                        <td><em style='font-weight:bold'>Family Members:</em>   <%=property.getFamMembers()%></td>
                                        <td><em style='font-weight:bold'>Chores:</em>   <%=property.getChores()%></td>
                                    </tr>
                                    <tr>
                                        <td><em style='font-weight:bold'>Smoker friendly:</em>   <%=property.getIsSmokerFriendly()==false?"No":"Yes"%></td>
                                        <td><em style='font-weight:bold'>Pet friendly:</em>   <%=property.getIsPetFriendly()==false?"No":"Yes"%></td>
                                    </tr>
                                    <tr>
                                        <td><em style='font-weight:bold'>Hydro included:</em>   <%=property.getHydroIncl()==false?"No":"Yes"%></td>
                                        <td><em style='font-weight:bold'>Water included:</em>   <%=property.getWaterIncl()==false?"No":"Yes"%></td>
                                    </tr>
                                    <tr>
                                        <td><em style='font-weight:bold'>Gas included:</em>   <%=property.getGasIncl()==false?"No":"Yes"%></td>
                                        <td><em style='font-weight:bold'>Cable included:</em>   <%=property.getCableIncl()==false?"No":"Yes"%></td>
                                    </tr>
                                    <tr>
                                        <td><em style='font-weight:bold'>Internet included:</em>   <%=property.getInternet()==false?"No":"Yes"%></td>
                                        <td><em style='font-weight:bold'>Parking available:</em>   <%=property.getParking()==false?"No":"Yes"%></td>
                                    </tr>
                                    <tr>
                                        <td><em style='font-weight:bold'>Laundry on-Site:</em>   <%=property.getLaundry()==false?"No":"Yes"%></td>
                                        <td><em style='font-weight:bold'>Private bedroom:</em>   <%=property.getPriBedroom()==false?"No":"Yes"%></td>
                                    </tr>
                                    <tr>
                                        <td><em style='font-weight:bold'>Private kitchen:</em>   <%=property.getPriKitchen()==false?"No":"Yes"%></td>
                                        <td><em style='font-weight:bold'>Private washroom:</em>   <%=property.getPriWashroom()==false?"No":"Yes"%></td>
                                    </tr>                                    
                                </table>

                                <h4>Property images</h4><br>

                                <% 
                                    PropertyPictureBusinessLayer pPictureLayer = new PropertyPictureBusinessLayer();
                                    List<PropertyPicture> pictures = pPictureLayer.getAllPicturesByProperty(property.getpropertyID());
                                    for(PropertyPicture picture : pictures){
                                %>
                                <div class="img_container">
                                    <img src="display_pictures.jsp?pictureId=<%=picture.getPictureID()%>" alt='Propery Image' height=130px width=130px/>
                                </div>
                                <%   
                                    }
                                %>
                            
                            <br><br>
                            <div id="submit_reset_btn">
                                <button id="submit_btn" type="submit">Request to book this property</button>
                                <button id="reset_btn" type="button" onclick="window.location.href='RenterProfileSearch'">Back to search</button>
                            </div>
                        </form>

                        </div>
                    </li>
                    <!--Pane 4: a placeholder-->  
                    <li class="aside aside-4"></li>
                </div>            
       
        <!-- Footer -->
        <footer id="footer">
            <div class="row">
                <div class="footer_column inner1">
                    <!--a placeholder-->
                </div>

                <div class="footer_column inner2">
                    <h6>Get in Touch</h6>
                    <div class="footer_nav">
                        <img alt="logo" class="" src="images/team_logo.png" />
                        <ul class="">
                            <li><a href="mailto:info@ahometoshare.ca">info@ahometoshare.ca</a></li>
                            <li><a class="remove-cursor" href="#">(123) 456-7890</a></li>
                        </ul>
                    </div>
                </div> 

                <div class="footer_column inner3">
                    <h6>Join Our Community</h6>
                    <ul class="footer_nav">
                        <li><a href="howWeWork.jsp">How We Work</a></li>
                        <li><a href="faq.jsp">Frequently Asked Questions</a></li>
                        <li><a href="aboutUs.jsp">About Us</a></li>
                        <li><a href="index.jsp">Placeholder</a></li>
                    </ul>
                </div>

                <div class="footer_column inner4">
                    <h6>Get Engaged</h6>
                    <ul class="footer_nav">
                        <li>Live in Toronto and want to help us tackle the affordable housing crisis. 
                            <a href="index.jsp" target="_blank"><u>Apply</u></a> to be an Ambassador today.
                        </li>
                    </ul>       
                </div>

                <div class="footer_column inner5">
                    <h6>Follow us on Social</h6>
                    <a href="https://www.facebook.com/ahometoshare" class="">
                            <i class="fa fa-facebook" aria-hidden="true"></i>
                            <img alt="facebook" class="" src="images/facebook36.png" width=28.5 height=36 />
                    </a>
                    &nbsp;&nbsp;
                    <a href="https://twitter.com/ahometoshare" class="">
                        <i class="fa fa-twitter" aria-hidden="true"></i>
                        <img alt="twitter" class="" src="images/twitter36.png" width=28.5 height=36 />
                    </a>
                </div>

                <div class="footer_column inner6"> 
                    <!--a placeholder-->
                </div>

                <p>© 2018 A Home To Share | All right reserved
                    <a href="index.jsp">&nbsp;&nbsp;&nbsp;Privacy Policy</a>
                    <a href="index.jsp">&nbsp;&nbsp;&nbsp;Terms of Use</a>
                </p>
            </div>            
        </footer> 
    </body>
</html>
