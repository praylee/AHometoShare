<%-- 
File: renterProfileSearch.jsp
Description: Page for searching host property listings within the renter profile.
Create: Oct. 21, 2018
Author: Melissa Rajala
Clients: Michelle Bilek, Farheen Khan
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
        <link rel="stylesheet" href="assets/css/renterProfileSearch_style.css" />
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
                
                
                
        <script>          
            function myFilterFunction() {

                var cityOptions = document.getElementById("cityFilter"); //get list of options
                var selectedCity = cityOptions.options[cityOptions.selectedIndex].text; //city filter
                
                var priceOptions = document.getElementsByName("priceFilter"); //get list of price options
                var selectedPrice; //price filter
                
                for (var i=0; i < priceOptions.length; i ++) {
                    if (priceOptions[i].checked) {
                        selectedPrice = priceOptions[i].value; //price filter value
                        break;
                    } else {
                        selectedPrice = "none";
                    }
                }

                //window.alert(selectedPrice); //for debugging
            
                //window.alert(selectedCity); //for debugging - show selected city to filter by
               
                table = document.getElementById("property");
                tr = table.getElementsByTagName("tr");
                //window.alert(tr.length); //for debugging
                for (i = 1; i < tr.length +1; i++) { //check each table row for it's city value
                    var c = document.getElementById("city" + i).value; //the city for property in row i
                    var p = document.getElementById("price" + i).value; //the price for property in row i

                    //window.alert(c); //for debugging
                    
                    var val;
                    var priceInt = parseInt(p); //get integer value of price
                
                    //check price filter
                    if (selectedPrice === "1") { // price under $500
                        if (priceInt < 500) {
                            val = "true";
                        } else {
                            val = "false";
                        }
                    } else if (selectedPrice === "2") { //price between $500-$800
                        if (priceInt >= 500 && priceInt <= 800) {
                            val = "true";
                        } else {
                            val = "false";
                        }
                    } else if (selectedPrice === "3") { //price above $800
                        if (priceInt > 800) {
                            val = "true";
                        } else {
                            val = "false";
                        }
                    } else { 
                        val = "none";
                    }

                    //set which table rows to display based on selected city and price filter
                    if (selectedCity === "-- Select City --" && (val === "true" || val === "none")) {
                        tr[i-1].style.display = ""; //keep all rows displayed
                    } else { //a filter option was used
                        if (c === selectedCity && (val === "true" || val === "none")) {
                            tr[i-1].style.display = ""; //keep row displayed
                        } else {
                            tr[i-1].style.display = "none"; //hide row
                            }  
                        }  
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


                <!--Pane 3: "Search Host Listings" content container-->
                    <li class="aside aside-3">
                        <div class="property-search-content">

                            <h2>Search host properties</h2>

                            <hr width=600px;>    

                            <div class="flex flex-3">
                                <form method="get" action="RenterProfileSearch" >
                                    <table class="filtertable">
                                        <tr>
                                            <th><em style='font-weight:bold'>Filter by location</em></th>
                                            <th><em style='font-weight:bold'>Sort by price</em></th> 
                                            <!--th>Filter by requirements</th-->
                                        </tr>
                                        <tr>
                                            <td>
                                                <select id="cityFilter">
                                                    <option value="none">-- Select City --</option>
                                                    <option value="mississauga">Mississauga</option>
                                                    <option value="hamilton">Hamilton</option>
                                                    <option value="peel">Peel Region</option>
                                                </select>
                                            </td>
                                            <td>
                                                <h5><input type="radio" name="priceFilter" value="1">Less than $500</h5><br>
                                                <h5><input type="radio" name="priceFilter" value="2"> $500 - $800</h5><br>
                                                <h5><input type="radio" name="priceFilter" value="3"> Above $800</h5>  
                                            </td>
                                            <!--td>
                                                TO DO: Add more filtering capabilities
                                                <input type="checkbox" name="req" value="prvbath"> Private Bathroom <br>
                                                <input type="checkbox" name="req" value="parking"> Parking <br>
                                                <input type="checkbox" name="req" value="prvkitchen"> Private Kitchen 
                                            </td-->
                                            <td>
                                                <input id="filter" type="button" value="Filter" onclick="myFilterFunction();" />
                                            </td>
                                        </tr>
                                    </table>
                                </form>
                            </div>
                            
                            <div class="flex flex-3">
                                <table class="hosttable" id="property" width=600px>
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

                                        <td>
                                            <input type="hidden" id="valOfI" name="valOfI" value="<%=i%>">
                                            <input type="hidden" id="propID" name="propID" value="<%=property.getpropertyID()%>">
                                            <input type="hidden" id="hostID" name="hostID" value="<%=property.getHostID()%>">
                                            <h4><em style='font-weight:bold'>Address:</em> <input type="hidden" id="address" name="address" value="<%=property.getAddress()%>"><%=property.getAddress()%> <br>
                                            <h4><em style='font-weight:bold'>City:</em> <input type="hidden" id="city<%=i%>" name="city" value="<%=property.getCity()%>"><%=property.getCity()%> <br>
                                            <h4><em style='font-weight:bold'>Start Date:</em> <input type="hidden" id="start<%=i%>" name="start" value="<%=property.getStartDate()%>"><%=property.getStartDate()%> <br>
                                            <h4><em style='font-weight:bold'>End Date:</em> <input type="hidden" id="end<%=i%>" name="end" value="<%=property.getEndDate()%>"><%=property.getEndDate()%> <br>
                                            <h4><em style='font-weight:bold'>Price:</em> $<input type="hidden" id="price<%=i%>" name="price" value="<%=property.getPrice()%>"><%=property.getPrice()%> <br>
                                            <!--input type="button" value="View Details" onclick="window.location.href='RenterProfileSearchDetails'" /-->
                                            <input id="submit" name="submit" type="submit" value="View Details" onclick="window.location.href='RenterProfileSearchDetails'">
                                        </td>
                                         <td>
                                            <h4><em style='font-weight:bold'>Picture:</em>  <br>  
                                            <img src="display_picture.jsp?property_no=<%=property.getpropertyID()%>" alt='Propery Image' height=180px width=180px/>                                                       
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
