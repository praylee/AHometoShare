<%-- 
File: renterProfileSearch.jsp
Description: Page for searching host listings within the renter profile.
Create: Nov 17,2018
Author: LiangLiang Du, Bin Yang
Clients: Michelle Bilek,Farheen Khan
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
                    <a href="faq.jsp">FAQ</a>
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
                    
                    //var priceMatch = priceFilter(selectedPrice, p);
                   // window.alert(c); //for debugging
                   
                   
                var val;
                var priceInt = parseInt(p);
                
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
                   
                 //  window.alert(val);
                   
                if (selectedCity === "-- Select City --") {
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
                            <li><h3>Hello <%out.print(session.getAttribute("firstname"));%>!</h3><li>
                        </ul >
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

                            <h2>Please find the properties you posted below</h2>

                            <hr width=600px;>    
                        <div class="flex flex-3">
                        <div>    
                            <input id="addProperty" type="button" value="Post Aother Property for Sharing" onclick="window.location.href='roomPosting.jsp'" />
                        </div>         
                        </div><br><br>
<!--table list format-->
<style> 
 td {
    border-bottom: 1px solid black;
    padding:5px;
    height: 50px;
    
}
</style>            
                            
                    <div class="flex flex-3">
                        <table class="hosttable" id="property" width=600px>
                            <%
                                List<Property> properties = (ArrayList<Property>)request.getAttribute("hostproperties");
                                if (properties.isEmpty()) { %>
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
                                    <h4> Property <%=i%> </h4>
                                    <input type="hidden" id="valOfI" name="valOfI" value="<%=i%>">
                                    <input type="hidden" id="propID" name="propID" value="<%=property.getpropertyID()%>">
                                    <input type="hidden" id="hostID" name="hostID" value="<%=property.getHostID()%>">
                                    Host Name: <input type="hidden" id="hostName" name="hostName" value="<%=host.getFirstName()%>"><%=host.getFirstName()%> <br>
                                    Host Email <input type="hidden" id="hostEmail" name="hostEmail" value="<%=host.getEmail()%>"><%=host.getEmail()%> <br>
                                    Address: <input type="hidden" id="address" name="address" value="<%=property.getAddress()%>"><%=property.getAddress()%> <br>
                                    City: <input type="hidden" id="city<%=i%>" name="city" value="<%=property.getCity()%>"><%=property.getCity()%> <br>
                                    Start Date: <input type="hidden" id="start" name="start" value="<%=property.getStartDate()%>"><%=property.getStartDate()%> <br>
                                    End Date: <input type="hidden" id="end" name="end" value="<%=property.getEndDate()%>"><%=property.getEndDate()%> <br>
                                    Price: <input type="hidden" id="price<%=i%>" name="price" value="<%=property.getPrice()%>"><%=property.getPrice()%> <br>
                                    <!--input type="button" value="View Details" onclick="window.location.href='RenterProfileSearchDetails'" /-->
                                    <!--input type="button" value="View Details" onclick="propertyDetails();" /-->
                                    <input id="delete" name="delete" type="submit" value="Delete" onclick="if (confirm('Are you sure you want to delete this property?')) form.action ='DeleteHostProperty'; else return false;">
                                    </td>
                                 <td>
                                    Picture:  <br>  
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
