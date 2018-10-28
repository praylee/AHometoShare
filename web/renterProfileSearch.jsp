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
                <a href="index.html" class="logo">A Home To Share</a>
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
                                    for (Entry entry: pairList){
                                    Host host = (Host) entry.getKey();
                                    Property property = (Property) entry.getValue();
                                    String city = property.getCity();
                            %>
                            <tr>
                                <td>
                                    Property ID: <%=property.getpropertyID()%> <br>
                                    Host ID: <%=property.getHostID()%> <br>
                                    Host Name: <%=host.getFirstName()%> <br>
                                    Address: <%=property.getAddress()%> <br>
                                    City: <li value="hi"><%=city%></li> <br>
                                    Start Date: <%=property.getStartDate()%> <br>
                                    End Date: <%=property.getEndDate()%> <br>
                                    Price: <%=property.getPrice()%> <br>
                                    <button onclick="window.location.href='RenterProfileSearch'">View Details</button>
                                </td>
                            </tr>
                            <%}

                             }
                            %>                         
                        </table>
                    </div>        
                            
                            
                            
                            

                            <!-- Break: Old password, New password, Confirm new password >
                            <ul style="list-style:none;">
                            <div class="password">
                                <li class="old_pwd"><h4>Old password</h4></li>
                                <li><input type="password" name="old_pwd" size="45" maxlength="45" required></li>
                            </div>

                            <div class="password">
                                <li class="new_pwd"><h4>New password</h4></li>
                                <li><input type="password" name="new_pwd" size="45" maxlength="45" required></li>
                            </div>

                            <div class="password">
                                <li class="confirm_new_pwd"><h4>Confirm new password</h4></li>
                                <li><input type="password" name="confirm_new_pwd" size="45" maxlength="45" required></li>
                            </div>

                            
                                <div class="password" id="password">
                                    <ul id="update_pwd_btn">                                                                             
                                        <li><input type="button" value="Update password" /></li>
                                    </ul>
                                </div>
                                    <br>
                                <div id="forgot_pwd_link">
                                    <a href="index.jsp">I forgot my password</a></li>
                                </div>

                            
                            <h2 class="delete_account">Delete account</h2>

                            <hr width=600px;>

                            <h5>Once you delete your account, there is no going back. Please be certain.</h5>

                            <ul class="delete_account_btn">                                                                             
                                <li class="delete_my_account"><input type="button" value="Delete my account" /></li>
                            </ul-->
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
