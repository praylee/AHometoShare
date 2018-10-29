<%-- 
File: renterProfileSearch.jsp
Description: Page for searching host listings within the renter profile.
Create: Oct 21,2018
Author: Melissa Rajala
Clients: Michelle Bilek,Farheen Khan
Course: Software Development Project
Professor: Dr. Anu Thomas
Project: A Home to Share
Copyright @ 2018
--%>

<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.ArrayList"%>
<%@page import="transferobjects.Host"%>
<%@page import="transferobjects.Property"%>
<%@page import="java.util.List"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Renter Host Property Search</title>
        <link rel="stylesheet" href="assets/css/subpage_style.css" />
    </head>
        
    <body class="subpage">
        <!-- Header -->
        <header id="header">
            <div class="inner">
                <a href="index.jsp" class="logo">A Home To Share</a>
                <nav id="nav">
                    <a href="index.jsp">Home</a>
                    <a href="index.jsp">How We Work</a>
                    <a href="index.jsp">FAQ</a>
                    <a href="
                       <%=session.getAttribute("isLoggedIn") != null ? (session.getAttribute("userType").toString().equals("renter") ? "renterProfile.jsp" : "hostProfile.jsp") : "index.jsp"%>" 
                       style="
                       <%=session.getAttribute("isLoggedIn") != null ? "display: inline;" : "display: none;"%>">My Profile</a>
                    <button id="logoutBtn" class="unstyled-button" onclick="window.location.href='LogoutRedirect'" style="<%=session.getAttribute("isLoggedIn") != null ? "display: inline;" : "display: none;"%>">Log out</button>
                </nav>
            </div>
        </header>
                
                
                
        <script>
            function myFilterFunction() {
                // Declare variables

                var select = document.getElementById("select");
                var selectedCity = select.options[select.selectedIndex].text;
            

                // Loop through all list items, and hide those who don't match the search query
                var li;
                table = document.getElementById("property");
                li = table.getElementsByTagName("li");
            
                var i;
                for (i = 1; i<li.length; i++){
                    var text = "";
                    text = li[i].value;
                    window.alert(text); //for debugging
                }
            }
            
            
            function propertyDetails() {
                var propertyID = document.getElementById("propID").value;
                window.alert(propertyID);
            }
            
        </script>        
                
        

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


                <!--Pane 3: "My Account" content container-->
                    <!--Pane 3: "My Account" - Renter host property search contents-->
                    <li class="aside aside-3">
                        <div class="property-search-content">

                            <h2>Search Host Properties</h2>

                            <hr width=600px;>    
                            
                            
                            <div class="flex flex-3">
                        <form method="get" action="RenterProfileSearch" >
                            <table class="filtertable">
                                <tr>
                                    <th>Filter by location</th>
                                    <th>Sort by price</th> 
                                    <th>Filter by requirements</th>
                                </tr>
                                <tr>
                                    <td>
                                        <select id="select">
                                            <option name="mississauga" value="mississauga">Mississauga</option>
                                            <option name="hamilton" value="hamilton">Hamilton</option>
                                            <option name="peel" value="peel">Peel Region</option>
                                        </select>
                                    </td>
                                    <td>
                                        <select>
                                            <option value="low">Low to High</option>
                                            <option value="high">High to Low</option>
                                        </select>
                                    </td>
                                    <td>
                                        <input type="checkbox" name="req" value="prvbath"> Private Bathroom <br>
                                        <input type="checkbox" name="req" value="parking"> Parking <br>
                                        <input type="checkbox" name="req" value="prvkitchen"> Private Kitchen 
                                    </td>
                                    <td>
                                        <input id="filter" type="button" value="Filter" onclick="myFilterFunction();" />
                                    </td>
                                </tr>
                            </table>
                        </form>         
                       
                    </div>
            
                            
                    <div class="flex flex-3">
                        <table class="hosttable" id="property">
                            <%
                                List<Entry<Host,Property>> pairList = (ArrayList<Entry<Host, Property>>) request.getAttribute("hostproperties");
                                if (pairList.isEmpty()) { %>
                                <h6>There are no available listings at this time.</h6>
                                <%
                                    } else {
                                    int i = 0;
                                    for (Entry entry: pairList){
                                    Host host = (Host) entry.getKey();
                                    Property property = (Property) entry.getValue();
                                    i++;
                            %>
                            <form method="post" action="RenterProfileSearchDetails">
                            <tr> 
                                
                                <td id="propertyData">
                                    <h4> Property <%=i%> </h4>
                                    <input type="hidden" id="valOfI" name="valOfI" value="<%=i%>">
                                    <input type="hidden" id="propID<%=i%>" name="propID" value="<%=property.getpropertyID()%>">
                                    <input type="hidden" id="hostID" name="hostID" value="<%=property.getHostID()%>">
                                    Host Name: <input type="hidden" id="hostName<%=i%>" name="hostName" value="<%=host.getFirstName()%>"><%=host.getFirstName()%> <br>
                                    Host Email <input type="hidden" id="hostEmail<%=i%>" name="hostEmail" value="<%=host.getEmail()%>"><%=host.getEmail()%> <br>
                                    Address: <input type="hidden" id="address<%=i%>" name="address" value="<%=property.getAddress()%>"><%=property.getAddress()%> <br>
                                    City: <input type="hidden" id="city<%=i%>" name="city" value="<%=property.getCity()%>"><%=property.getCity()%> <br>
                                    Start Date: <input type="hidden" id="start<%=i%>" name="start" value="<%=property.getStartDate()%>"><%=property.getStartDate()%> <br>
                                    End Date: <input type="hidden" id="end<%=i%>" name="end" value="<%=property.getEndDate()%>"><%=property.getEndDate()%> <br>
                                    Price: <input type="hidden" id="price<%=i%>" name="price" value="<%=property.getPrice()%>"><%=property.getPrice()%> <br>
                                    <!--input type="button" value="View Details" onclick="window.location.href='RenterProfileSearchDetails'" /-->
                                    <!--input type="button" value="View Details" onclick="propertyDetails();" /-->
                                    <input id="submit" name="submit" type="submit" value="View Details" onclick="RenterProfileSearchDetails">
                                </td>
                            </tr>
                            </form>
                            <%}

                             }
                            %>                         
                        </table>
                    </div>        

                        </div>
                    </li>
                    <!--Pane 4: a placeholder-->  
                    <li class="aside aside-4"></li>
                </div>            
       
        <!-- Footer -->
        <footer id="footer">
            <div class="inner">
                <div class="flex">
                    <div class="single-footer-widget">
                        <h6>Get in Touch</h6>
                        <div class='get-in-touch-section'>
                            <img alt="logo" class="" src="images/team_logo.png" />
                            <ul class="footer-nav-section-nav pL0">
                                <li><a href="mailto:hello@nesterly.io">info@ahometoshare.ca</a></li>
                                <li><a class="remove-cursor" href="#">(123) 456-7890</a></li>
                            </ul>
                        </div>
                    </div>

                    <div class="col-lg-3  col-md-3">
                        <div class="single-footer-widget">
                            <h6>Join Our Community</h6>
                            <ul class="footer-nav-section-nav pL0">
                                <li><a href="/how-it-works">How it Works</a></li>
                                <li><a href="/faq">Frequently Asked Questions</a></li>
                                <li><a href="/homesharing_resources">Homesharing Resources</a></li>
                                <li><a href="/community_compact">Community Compact</a></li>
                            </ul>
                        </div>
                    </div>

                    <div class="col-lg-3 col-md-3">
                        <div class="single-footer-widget">
                            <h6>Get Engaged</h6>
                                <ul class="footer-nav-section-nav pL0">
                                    <li>Live in Toronto and want to help us tackle the affordable housing crisis. <a href="" target="_blank"> <u>Apply</u></a> to be an Ambassador today.
                                    </li>
                                </ul>
                        </div>
                    </div>

                    <div class="col-lg-3  col-md-3">
                        <div class="single-footer-widget">
                            <h6>Follow us on Social</h6>
                                <a href="https://www.facebook.com/ahometoshare" class="btn btn-facebook waves-effect waves-light">
                                        <i class="fa fa-facebook" aria-hidden="true"></i>
                                </a>
                                &nbsp;&nbsp;
                                <a href="https://twitter.com/ahometoshare" class="btn btn-twitter waves-effect waves-light">
                                    <i class="fa fa-twitter" aria-hidden="true"></i>
                                </a>
                        </div>
                    </div>
                </div>
            </div>
        </footer> 
    </body>
</html>
