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
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Renter Profile</title>
        <link rel="stylesheet" href="assets/css/profile_style.css" />
        <style>
            td { padding:0 15px 0 15px; }
            table.hosttable { 
                align-self:center;
                border-collapse: collapse;
                border: 1px solid black;
                border-spacing: 10px;
                width: 95%; 
                margin-left: auto;
                margin-right: auto;
            }
            td.hosttable { 
                border: 1px solid black;
                text-align: center;
            }
            
            
        </style>
    </head>
    <body>
        
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
                    <button id="logoutBtn" class="unstyled-button" style="<%=session.getAttribute("isLoggedIn") != null ? "display: inline;" : "display: none;"%>">Log out</button>
                </nav>
            </div>
        </header>

			
        <!-- Banner: the text shows within the main image -->
        <section id="banner">
                <h1>Welcome, <%out.print(session.getAttribute("firstName"));%>!</h1>
        </section>
        
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
        

        <!-- Block 1: Filter Options -->
        <section id="one" class="wrapper">
            <div class="inner">
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
            </div>
        </section>
        
        <section id="two" class="wrapper">
            <div class="inner">
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
            </div>
        </section>
        
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
                                                                <li>Live in Toronto and want to help us tackle the affordable housing crisis. <a href="https://docs.google.com/forms/d/e/1FAIpQLSc7Rtng9Dwi1uEH9A86Z9Jd1IFDRJoHeW-LMHBtUsYPOh571Q/viewform" target="_blank"> <u>Apply</u></a> to be an Ambassador today.
                                                                </li>
                                                        </ul>
                                        </div>
                                </div>

                                <div class="col-lg-3  col-md-3">
                                        <div class="single-footer-widget">
                                                <h6>Follow us on Social</h6>
                                                        <a href="https://www.facebook.com/nesterlyhome" class="btn btn-facebook waves-effect waves-light">
                                                                <i class="fa fa-facebook" aria-hidden="true"></i>
                                                        </a>
                                                        &nbsp;&nbsp;
                                                        <a href="https://twitter.com/nesterlyhome" class="btn btn-twitter waves-effect waves-light">
                                                                <i class="fa fa-twitter" aria-hidden="true"></i>
                                                        </a>

                                        </div>
                                </div>
                        </div>
                </div>
        </footer>
        
    </body>
</html>
