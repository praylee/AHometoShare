<%-- 
File: propertyProfile.jsp
Description: Page for searching host listings within the renter profile.
Create: Nov. 17, 2018
Author: LiangLiang Du, Bin Yang, Zhan Shen
Clients: Michelle Bilek, Farheen Khan
Course: Software Development Project
Professor: Dr. Anu Thomas
Project: A Home to Share
Copyright @ 2018
--%>

<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.ArrayList"%>
<%@page import="business.HostBusinessLayer"%>
<%@page import="transferobjects.Host"%>
<%@page import="transferobjects.Property"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>A Home To Share</title>
        <link rel="stylesheet" href="assets/css/manageProperty_style.css" />
    </head>
        
    <body class="subpage">
        <!-- Header -->
        <header id="header">
            <div class="inner">
                <a href="index.jsp" class="logo">A Home To Share</a>
                <nav id="nav">
                    <a href="index.jsp">Home</a>
                    <a href="index.jsp">How We Work</a>
                    <a href="faq.jsp">FAQ</a>
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
                        <li><h3>Hello <%out.print(session.getAttribute("firstname"));%>!</h3><li>
                    </ul>
                    <ul style="list-style:none;">
                        <li id="menu1"><input type="button" value="My Profile" class="" onclick="window.location.href='hostProfile.jsp'" /></li>
                        <li id="menu2"><input type="button" value="Account Settings" class="" onclick="window.location.href='hostAccountSettings.jsp'" /></li>
                        <li id="menu3"><input type="button" value="Manage Properties" class="" onclick="window.location.href='PropertyProfile'" /></li>
                    </ul>
                </div>
            </li>    


            <!--Pane 3: "My Account" content container-->
                <!--Pane 3: "My Account" - Renter host property search contents-->
                <li class="aside aside-3">
                    <div class="property-search-content">

                        <h2>My properties</h2>

                        <hr width=600px;>       

                        <div class="flex flex-3">
                            <table class="hosttable" id="property" width=600px>
                                <%
                                    List<Property> properties = (ArrayList<Property>)request.getAttribute("hostproperties");
                                    if (properties.isEmpty()) { 
                                %>
                                    <h6>There are no available listings at this time.</h6>
                                    <%
                                        } else  {
                                        int i = 0;
                                        HostBusinessLayer hostBusiness = new HostBusinessLayer();
                                        Host host = hostBusiness.getHostByEmail(session.getAttribute("email").toString());
                                        for (Property property:properties){
                                        i++;
                                    %>
                                <form method="post" action="DeleteHostProperty">
                                    <tr> 
                                        <td>
                                            <h4><em style='font-weight:bold'>Property</em> <%=i%></h4>
                                            <input type="hidden" id="valOfI" name="valOfI" value="<%=i%>">
                                            <input type="hidden" id="propID" name="propID" value="<%=property.getpropertyID()%>">
                                            <input type="hidden" id="hostID" name="hostID" value="<%=property.getHostID()%>">
                                            <h4><em style='font-weight:bold'>Host Name:</em> <input type="hidden" id="hostName" name="hostName" value="<%=host.getFirstName()%>"><%=host.getFirstName()%></h4>
                                            <h4><em style='font-weight:bold'>Host Email:</em> <input type="hidden" id="hostEmail" name="hostEmail" value="<%=host.getEmail()%>"><%=host.getEmail()%></h4>
                                            <h4><em style='font-weight:bold'>Address:</em> <input type="hidden" id="address" name="address" value="<%=property.getAddress()%>"><%=property.getAddress()%></h4>
                                            <h4><em style='font-weight:bold'>City:</em> <input type="hidden" id="city<%=i%>" name="city" value="<%=property.getCity()%>"><%=property.getCity()%></h4>
                                            <h4><em style='font-weight:bold'>Start Date:</em> <input type="hidden" id="start" name="start" value="<%=property.getStartDate()%>"><%=property.getStartDate()%></h4>
                                            <h4><em style='font-weight:bold'>End Date:</em> <input type="hidden" id="end" name="end" value="<%=property.getEndDate()%>"><%=property.getEndDate()%></h4>
                                            <h4><em style='font-weight:bold'>Price:</em> <input type="hidden" id="price<%=i%>" name="price" value="<%=property.getPrice()%>"><%=property.getPrice()%></h4>
                                            <!--input type="button" value="View Details" onclick="window.location.href='RenterProfileSearchDetails'" /-->
                                            <!--input type="button" value="View Details" onclick="propertyDetails();" /-->
                                            <input id="delete" name="delete" type="submit" value="Delete" onclick="if (confirm('Are you sure you want to delete this property?')) form.action ='DeleteHostProperty'; else return false;">
                                        </td>
                                        <td>
                                            <h4><em style='font-weight:bold'>Picture:</em> <br>  
                                            <img src="display_picture.jsp?property_no=<%=property.getpropertyID()%>" alt='Propery image' height=180px width=180px/></h4>                                                        
                                        </td>
                                        
                                    </tr>
                                    
                                </form>      
                                <%}



                                 }
                                %>                         
                            </table>
                            

                            <div class="addPropertyBtn">    
                                <input id="addProperty" type="button" value="Post a Property" onclick="window.location.href='roomPosting.jsp'" />
                            </div>         

                        </div>        
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
