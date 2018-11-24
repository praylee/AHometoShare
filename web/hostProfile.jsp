<%-- 
File: hostrPofile.jsp
Description: A page for logged-in hosts to view and edit profile details
Create: Oct.05,2018
Author: Xia Sheng
Modified by Zhan Shen: updated and reorganized the layout
Clients: Michelle Bilek, Farheen Khan
Course: Software Development Project
Professor: Dr. Anu Thomas
Project: A Home to Share
Copyright @ 2018
--%>

<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Host Profile</title>
        <link rel="stylesheet" href="assets/css/hostProfile_style.css" />
    </head>
        
    <body class="subpage">
        <!-- Header -->
        <header id="header">
            <div class="inner">
                <a href="index.jsp" class="logo">A Home To Share</a>
                <nav id="nav">
                    <a href="index.jsp">Home</a>
                    <a href="how_we_work.jsp">How We Work</a>
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
                        </ul >
                        <ul style="list-style:none;">
                            <li id="menu1"><input type="button" value="My Profile" class="" onclick="window.location.href='hostProfile.jsp'" /></li>
                            <li id="menu2"><input type="button" value="Account Settings" class="" onclick="window.location.href='hostAccountSettings.jsp'" /></li>
                            <li id="menu3"><input type="button" value="Manage Properties" class="" onclick="window.location.href='PropertyProfile'" /></li>
                        </ul>
                    </div>
                </li>    

        
                <!--Pane 3: "My Account" content container-->       
                <li class="aside aside-3">
                    <div class="my_profile_content">
                        <form method="get" action="ProfileHostView" onsubmit="return checkForm(this)" >

                        <!--<section id="one" class="wrapper">-->
            
                        <h2>Personal details</h2>

                        <hr width=600px;>
                        
                        <!-- Break: First/Last Name, Gender, Birth Year, Phone number, Retired, Pet, Smoker -->
                            <div class="profile_sections">
                                <li><h4>First name<span style="color:red; font-weight:bold">*</span></h4></li>
                                <li><input type="text" name="firstname" id="firstname" value="<%=session.getAttribute("firstname")%>" size="45" maxlength="45" pattern="[A-Za-z]{1,45}" required /></li>
                            </div>
                    
                            <div class="profile_sections">
                                <li><h4>Last name<span style="color:red; font-weight:bold">*</span></h4></li>
                                <li><input type="text" name="lastname" id="lastname" value="<%=session.getAttribute("lastname")%>" size="30" maxlength="45" pattern="[A-Za-z]{1,45}" required /></li>
                            </div>
                            
                            <div class="profile_sections">
                                <li><h4>Gender<span style="color:red; font-weight:bold">*</span></h4></li>
                                <li>
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
                                </li>
                            </div>
                                    
                            <div class="profile_sections">
                                <li><h4>Birth year<span style="color:red; font-weight:bold">*</span></h4></li>
                                <li>
                                    <select name="dateBirth" id="dateBirth" required >
                                        <%
                                            out.println("<option value=\"\">- Select the year you were born  -</option>");
                                            for(int i = 2000; i >= 1920; i--) {
                                                if(i == Integer.parseInt((session.getAttribute("dateBirth").toString()))) {
                                                    out.println("<option selected=\"selected\" value=\"" + i + "\">" + i + "</option>");
                                                }
                                                else {
                                                    out.println("<option value=\"" + i + "\">" + i + "</option>");
                                                }
                                            }
                                        %>     
                                    </select>
                                </li>
                            </div>
                                 
                            <div class="profile_sections">
                                <li><h4>Phone number</h4></li>
                                <li><input type="tel" name="phone" id="phone" value="<%=session.getAttribute("phone")%>" size="30" pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}" /></li>
                            </div>
                            
                            <div id="checkbox_items">
                                <li id="checkbox1"><input type="checkbox" name="isRetired" id="isRetired" 
                                    <%=Boolean.parseBoolean(session.getAttribute("isRetired").toString()) ? "checked" : ""%>>Retired?</input>
                                </li>

                                <li id="checkbox2"><input type="checkbox" name="isPets" id="isPets" 
                                    <%=Boolean.parseBoolean(session.getAttribute("isPets").toString()) ? "checked" : ""%>>Pet?</input>
                                </li>

                                <li id="checkbox3"><input type="checkbox" name="isSmoker" id="isSmoker" 
                                    <%=Boolean.parseBoolean(session.getAttribute("isSmoker").toString()) ? "checked" : ""%>>Smoker?</input>
                                </li>
                            </div>                          
                                
                            <div class="profile_sections">
                                <li><h4>Referral Source</h4></li>
                                <li><input type="text" name="referralSource" id=referralSource" value="<%=session.getAttribute("referralSource")%>" size="30" maxlength="45" pattern="[A-Za-z]{1,45}" required /></li>
                            </div>
                            
                        <!-- Break: Save button, Cancel button -->
                            <div id="save_cancel_btn">
                                <button id="save_btn" type="submit">Save changes</button>
                                <button id="cancel_btn" type="reset" onclick="hostProfile.jsp">Cancel</button>
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
                        <li><a href="how_we_work.jsp">How We Work</a></li>
                        <li><a href="faq.jsp">Frequently Asked Questions</a></li>
                        <li><a href="about_us.jsp">About Us</a></li>
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