<%-- 
File: renterLoginSettings.jsp
Description: A page for logged-in renters to change password
Create: Oct.26,2018
Author: Zhan Shen
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
        <title>Account Settings</title>
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


                <!--Pane 3: "My Account" content container-->
                    <!--Pane 3: "My Account" - Account Settings contents-->
                    <li class="aside aside-3">
                        <div class="login-settings-content">

                            <h2>Change password</h2>

                            <hr width=600px;>    
                            <form method="post" action="ProfileRenterEditView" onsubmit="" >
                                <!-- Break: Old password, New password, Confirm new password -->
                                <ul style="list-style:none;">
                                    <div class="password">
                                        <li class="account_email"><h4>Email address</h4></li>
                                        <li id="account_email"><input type="text" name="email" value="<%=session.getAttribute("email") %>" size="40" maxlength="45" readonly>
                                    </div>
                                    
                                    <div class="password">
                                        <li class="old_pwd"><h4>Old password</h4></li>
                                        <li><input type="password" name="old_pwd" size="45" maxlength="45" ></li>
                                        <li class="pwd_error">
                                            <h5>
                                                <%
                                                    if(request.getAttribute("old_pwd_info") !=null) {
                                                        out.print(request.getAttribute("old_pwd_info"));
                                                    }
                                                %>
                                            </h5>
                                        </li>
                                    </div>

                                    <div class="password">
                                        <li class="new_pwd"><h4>New password</h4></li>
                                        <li><input type="password" name="new_pwd" size="45" maxlength="45" ></li>
                                        <li class="pwd_error">
                                            <h5>
                                                <%
                                                    if(request.getAttribute("new_pwd_info") !=null) {
                                                        out.print(request.getAttribute("new_pwd_info"));
                                                    }
                                                %>
                                            </h5>
                                        </li>
                                    </div>

                                    <div class="password">
                                        <li class="confirm_new_pwd"><h4>Confirm new password</h4></li>
                                        <li><input type="password" name="confirm_new_pwd" size="45" maxlength="45" ></li>
                                        <li class="pwd_error">
                                            <h5>
                                                <%
                                                    if(request.getAttribute("confirm_pwd_info") !=null) {
                                                        out.print(request.getAttribute("confirm_pwd_info"));
                                                    }
                                                %>
                                            </h5>
                                        </li>
                                    </div>
                                    
                                    <!-- Break: Update password, Forgot password link -->
                                    <div class="password" id="password">
                                        <ul id="update_pwd_btn">                                                                             
                                            <li class="update_pwd"><input type="submit" name="update" value="Update password" /></li>
                                             <li class="update_success">
                                                <h5>
                                                    <%                                   
                                                        if(request.getAttribute("update_info") != null) {
                                                            out.print(request.getAttribute("update_info"));
                                                        }
                                                    %> 
                                                </h5>
                                            </li>
                                        </ul>
                                    </div>
<!--                                        <br>
                                    <div id="forgot_pwd_link">
                                        <a href="index.jsp">I forgot my password</a></li>
                                    </div>-->
                                </ul>
                                <!-- Break: Delete account, Delete my account button -->
                                <h2 class="delete_account">Delete account</h2>

                                <hr width=600px;>

                                <h5>Once you delete your account, there is no going back. Please be certain.</h5>

                                <ul class="delete_account_btn">                                                                             
                                    <li class="delete_my_account"><input type="submit" name="delete" value="Delete my account" /></li>

                                </ul>
                            </form>
                            
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