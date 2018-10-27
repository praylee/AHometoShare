<%-- 
File: index.html
Description: Home page for A Home to Share website
Create: Sept.30,2018
Author: Chris Labelle
Clients: Michelle Bilek,Farheen Khan
Course: Software Development Project
Professor: Dr. Anu Thomas
Project: A Home to Share
Copyright @ 2018
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Renter Profile</title>
        <link rel="stylesheet" href="assets/css/profile_style.css" />
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
        
        <section class="sidenav">
            <button class="sidenavButton" onclick="openSection('myProfile')">My Profile</button>
            <button class="sidenavButton" onclick="openSection('accountSettings')">Account Settings</button>
            <button class="sidenavButton" onclick="window.location.href='ProfileRenterView'">Search Host Listings</button>
        </section>   
        <section id="myProfile" class="sectionContent">
                <h1>My Profile Details</h1>
                <form method="get" action="ProfileRenterEditView" onsubmit="return checkForm(this)" >
                <!--<div class="row uniform">-->
                    <!-- Break: First Name(db:first_name), Last Name(db:last_name) -->
                    <h2>Personal Details</h2>
                    <table>
                        
                        <tr class="formRow">
                            <td>
                                <h4>First Name<span style="color:red; font-weight:bold">*</span></h4>
                                <input type="text" name="firstname" id="firstname" value="<%=session.getAttribute("firstName")%>" size="30" maxlength="45" pattern="[A-Za-z]{1,45}" required /> 
                            </td>
                            <td>
                                <h4>Last Name<span style="color:red; font-weight:bold">*</span></h4>
                                <input type="text" name="lastname" id="lastname" value="<%=session.getAttribute("lastName")%>" size="30" maxlength="45" pattern="[A-Za-z]{1,45}" required />
                            </td> 
                        </tr>
                        <tr class="formRow">
                            <td>
                                <h4>Gender<span style="color:red; font-weight:bold">*</span></h4>
                                <select name="gender" id="gender" required >
                                <%
                                    out.println("<option value=\"\">- Select your gender -</option>");
                                    switch(Integer.parseInt(session.getAttribute("gender").toString())) {
                                        case 0: 
                                            out.println("<option selected=\"selected\" value=\"0\">Male</option>");
                                            out.println("<option value=\"1\">Female</option>");
                                            break;
                                        case 1: 
                                            out.println("<option value=\"0\">Male</option>");
                                            out.println("<option selected=\"selected\" value=\"1\">Female</option>");
                                            break;
                                    }
                                %>     
                                </select>
                            </td>
                            <td>
                                <h4>Birth Year<span style="color:red; font-weight:bold">*</span></h4>
                                <select name="yearBorn" id="yearBorn" required >
                                <%
                                    out.println("<option value=\"\">- Select the year you were born  -</option>");
                                    for(int i = 2000; i > 1982; i--) {
                                        if(i == Integer.parseInt((session.getAttribute("dateBirth").toString()))) {
                                            out.println("<option selected=\"selected\" value=\"" + i + "\">" + i + "</option>");
                                        }
                                        else {
                                            out.println("<option value=\"" + i + "\">" + i + "</option>");
                                        }
                                    }
                                %>
                                </select>	
                            </td> 
                        </tr>
                        <tr>
                            <td>
                                <h4>Phone Number</h4>
                                <input type="tel" name="phoneNum" id="phoneNum" value="<%=session.getAttribute("phone")%>" size="30" pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}" />
                            </td>
                            <td>
                                <h4> </h4>
                                <input type="checkbox" name="isStudent" id="isStudent" <%=Boolean.parseBoolean(session.getAttribute("isStudent").toString()) ? "checked" : ""%>>Student?</input><br>
                                <input type="checkbox" name="isEmployed" id="isEmployed" <%=Boolean.parseBoolean(session.getAttribute("isEmployed").toString()) ? "checked" : ""%>>Employed?</input><br>
                                <input type="checkbox" name="isSmoker" id="isSmoker" <%=Boolean.parseBoolean(session.getAttribute("isSmoker").toString()) ? "checked" : ""%>>Smoker?</input>
                            </td>
                        </tr> 
                    </table>
                    
                    <h2>Renting Details</h2>
                    <table>
                        <tr>
                            <td>
                                <h4>Start Date</h4>
                                <input type="text" name="startDate" id="startDate" value="<%=session.getAttribute("startDate")%>" size="30" maxlength="10" pattern="[0-9-]{8,10}" required />
                            </td>
                            <td>
                                <h4>End Date</h4>
                                <input type="text" name="endDate" id="endDate" value="<%=session.getAttribute("endDate")%>" size="30" maxlength="10" pattern="[0-9-]{8,10}" required />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <h4>Low Price</h4>
                        <input type="text" name="lowPrice" id="lowPrice" value="<%=session.getAttribute("lowPrice")%>" size="30" maxlength="10" pattern="[0-9\.]+" required />
                            </td>
                            <td>
                                <h4>High Price</h4>
                        <input type="text" name="highPrice" id="highPrice" value="<%=session.getAttribute("highPrice")%>" size="30" maxlength="10" pattern="[0-9\.]+" required />
                            </td>
                        </tr>
                    </table>
                </form> 
        </section> 
        
        <section id="accountSettings" class="sectionContent">
            <span>These are your account settings</span>
        </section>
                    
        <script>
            function openSection(sectionName) {
                var sectionContent = document.getElementsByClassName("sectionContent");
                if(sectionName.localeCompare("myProfile") === 0) {
                    sectionContent[0].style.display = "block";
                    sectionContent[1].style.display = "none";
                }
                else {
                    sectionContent[0].style.display = "none";
                    sectionContent[1].style.display = "block";  
                }
            }
        </script>
        
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