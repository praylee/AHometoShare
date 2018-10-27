<%-- 
    Document   : hostProfile
    Created on : 5-Oct-2018, 11:56:26 PM
    Author     : Xia Sheng
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Host Profile</title>
        <link rel="stylesheet" href="assets/css/style.css" />
    </head>
    <body>
        
        <!-- Header -->
        <header id="header">
            <div class="inner">
                <a href="index.html" class="logo">A Home To Share</a>
                <nav id="nav">
                        <a href="index.html">Home</a>
                        <a href="index.html">How We Work</a>
                        <a href="index.html">FAQ</a>
                <a href="
                       <%=session.getAttribute("isLoggedIn") != null ? (session.getAttribute("userType").toString().equals("host") ? "renterProfile.jsp" : "hostProfile.jsp") : "index.jsp"%>" 
                       style="
                       <%=session.getAttribute("isLoggedIn") != null ? "display: inline;" : "display: none;"%>">My Profile</a>
                    <button id="logoutBtn" class="unstyled-button" style="<%=session.getAttribute("isLoggedIn") != null ? "display: inline;" : "display: none;"%>">Log out</button>
                </nav>
            </div>
        </header>

			
        <!-- Banner: the text shows within the main image -->
        <section id="banner">
                <h1><%out.print(request.getAttribute("firstName"));%></h1>
        </section>
       
        <div class="sidenav">
            <button class="sidenavButton" onclick="openSection('myHostProfile')">My Profile</button>
            <button class="sidenavButton" onclick="openSection('accountSettings')">Account Settings</button>
            <button class="sidenavButton" id="manageProperty">Manage Properties</button>
        </div>
        
        <script type="text/javascript">
            document.getElementById("manageProperty").onclick = function () {
                window.location.href="roomPosting.jsp";
            };
        </script>
        
        <!-- Block 1: Host information info -->
       <section id="one" class="wrapper">
            <div id="myHostProfile" class="sectionContent">
                <h2>Profile Parameters</h2>
                <form method="get" action="ProfileHostView" onsubmit="return checkForm(this)" >
                <!--<div class="row uniform">-->
                    <!-- Break: First Name(db:first_name), Last Name(db:last_name) -->
                    <div class="formRow">
                        <h4>First Name<span style="color:red; font-weight:bold">*</span></h4>
                        <input type="text" name="firstname" id="firstname" value="<%=session.getAttribute("firstname")%>" size="30" maxlength="45" pattern="[A-Za-z]{1,45}" required />
                    </div>
                    
                    <div class="formRow">
                        <h4>Last Name<span style="color:red; font-weight:bold">*</span></h4>
                        <input type="text" name="lastname" id="lastname" value="<%=session.getAttribute("lastname")%>" size="30" maxlength="45" pattern="[A-Za-z]{1,45}" required />
                    </div>
                    <!-- Break: Phone Number(db:phone) -->
                    <div class="formRow">
                        <h4>Phone Number</h4>
                        <input type="tel" name="phoneNum" id="phoneNum" value="<%=session.getAttribute("phone")%>" size="30" pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}" />
                    </div>

                    <!--  Break: Gender(db:gender), Year Born(db:date_of_birth) -->
                    <div class="formRow">
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
                    </div>

                    <div class="formRow">
                        <h4>Birth Year<span style="color:red; font-weight:bold">*</span></h4>
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
                    </div>             

                    <!-- Break: Checkboxes for retire, pets, smoker -->
                    <div class="formRow">
                        <input type="checkbox" name="isRetired" id="isRetired" <%=Boolean.parseBoolean(session.getAttribute("isRetired").toString()) ? "checked" : ""%>>Retired?</input>
                    </div>    
                    <div class="formRow">
                        <input type="checkbox" name="isPets" id="isPet" <%=Boolean.parseBoolean(session.getAttribute("isPets").toString()) ? "checked" : ""%>>Pet?</input>
                    </div> 
                    <div class="formRow">
                        <input type="checkbox" name="isSmoker" id="isSmoker" <%=Boolean.parseBoolean(session.getAttribute("isSmoker").toString()) ? "checked" : ""%>>Smoker?</input>
                    </div> 
                    
                    <!-- Break: referral Source -->
                    <div class="formRow">
                        <h4>Referral Source</h4>
                        <input type="text" name="referralSource" id=referralSource" value="<%=session.getAttribute("referralSource")%>" size="30" maxlength="45" pattern="[A-Za-z]{1,45}" required />
                    </div>
                    
                    <!-- Buttons: submit, Save -->
                    <div>
                        <input type="submit" value="Save" />
                    </div>
                </form> 
            </div>
                    
            <div id="accountSettings" class="sectionContent">
                <span>These are your account settings</span>
            </div>
        </section>
                    
        <script>
            function openSection(sectionName) {
                var sectionContent = document.getElementsByClassName("sectionContent");
                if(sectionName.localeCompare("myHostProfile") === 0) {
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