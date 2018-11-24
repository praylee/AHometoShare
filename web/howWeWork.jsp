<%-- 
File: howWeWork.jsp
Description: How We Work page
Create: Nov,13,2018
Author: Zhan Shen
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
        <title>A Home To Share</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <link rel="stylesheet" href="assets/css/howWeWork_style.css" />
    </head>
	
    <body class="subpage">
        <!-- Header -->
            <header id="header">
                <div class="inner">
                    <a href="index.jsp" class="logo">A Home To Share</a>
                    <nav class="nav">
                        <a href="index.jsp">Home</a>
                        <a href="howWeWork.jsp">How We Work</a>
                        <a href="faq.jsp">FAQ</a>
                        <button id="loginBtn" onclick="window.location.href='LogInView'" class="unstyled-button" style="<%=session.getAttribute("isLoggedIn") != null ? "display: none;" : "display: inline;"%>">Log in</button>
                        <button id="signupBtn" onclick="window.location.href='SignUpView'" class="unstyled-button" style="<%=session.getAttribute("isLoggedIn") != null ? "display: none;" : "display: inline;"%>">Sign Up</button>
                        <a href="
                           <%=session.getAttribute("isLoggedIn") != null ? (session.getAttribute("userType").toString().equals("renter") ? "renterProfile.jsp" : "hostProfile.jsp") : "index.jsp"%>" 
                           style="
                           <%=session.getAttribute("isLoggedIn") != null ? "display: inline;" : "display: none;"%>">My Profile</a>
                        <button id="logoutBtn" class="unstyled-button" style="<%=session.getAttribute("isLoggedIn") != null ? "display: inline;" : "display: none;"%>" onclick="window.location.href='LogoutRedirect'">Log out</button>
                    </nav>
                </div>


         <!--Signup Popup Window when clicks button: Sign Up-->
            <div id="signupPopup" class="signupPopup">

             <!--Signup Popup content--> 
                <div class="signupPopup-content">
                    <span class="close1">&times;</span>

                    <section class="signupPopup_container">
                        <div class="signupPopup-left_half">
                            <h4>I want to sign up as a<span style="color:red; font-weight:bold">*</span></h4>
                            <div class="switch">
                                <input type="radio" class="switch-input" name="view" value="userHost" id="userHost" checked>
                                <label for="userHost" class="switch-label switch-label-off">Host</label>
                                <input type="radio" class="switch-input" name="view" value="userRenter" id="userRenter" >
                                <label for="userRenter" class="switch-label switch-label-on">Renter</label>
                                <span class="switch-selection"></span>
                            </div>
                        </div>
                    <hr>
                        <div class="signupPopup-right_half">
                            <div class="btn-group2">
                                <a id="emailBtn" class="signupBtn" >Sign up with email</a>
                                <a href="" class="signupBtn">Sign up with Facebook</a>
                                <a href="" class="signupBtn">Sign up with Linkedin</a>
                                <a href="" class="signupBtn">Sign up with Google</a>
                            </div>
                        </div>
                    </section>
                </div>
            </div>
            
             <!--Javascript functions for popup windows: Sign Up--> 
                <script>
                    // Get the popup
                    var signupPopup = document.getElementById("signupPopup");
                    // Get the button that opens the popup
                    var signupBtn = document.getElementById("signupBtn");
                    // Get the <span1> element that closes the popup
                    var span1 = document.getElementsByClassName("close1")[0];
                    // When the user clicks the button, open the popup 
                    signupBtn.onclick = function() {
                        signupPopup.style.display = "block";
                    };
                    // When the user clicks on <span1> (x), close the popup
                    span1.onclick = function() {
                        signupPopup.style.display = "none";
                    };
                    // When the user clicks anywhere outside of the popup, close it
                    window.onclick = function(event) {
                        if (event.target === signupPopup) {
                            signupPopup.style.display = "none";
                        }
                    };
                    
                    // Host & Renter toggle switch 
                    var signupEmailBtn = document.getElementById("emailBtn");
                    signupEmailBtn.onclick = function(){
                        var hostSelected = document.getElementById("userHost");
                        //When Host is selected, the page goes to Host Registratoin form                
                        if (hostSelected.checked) { 
                            window.location.href="hostRegister.html";                
                        }
                        //When Rrenter is selected, the page goes to Renter Registration form
                        else 
                            window.location.href="renterRegister.html";  
                    };
                    
                </script>
                
                
                
            <!--Login Popup Window when clicks button: Log in--> 
            <div id="loginPopup" class="loginPopup" >

             <!--Login Popup content--> 
                <div class="loginPopup-content">
                    <span class="close2">&times;</span>

                    <section class="loginPopup_container">
                        <div class="loginPopup-left_half">
                            <div class="btn-group3">
                                <a href="#" class="loginBtn">Login with Facebook</a>
                                <a href="#" class="loginBtn">Login with Linkedin</a>
                                <a href="#" class="loginBtn">Login with Google</a>
                            </div>
                        </div>
                    <hr>
                        <div class="loginPopup-right_half">
                            <form method="post" action="LogInView" onsubmit="" >
                                <div class="formRow">
                                    <h4 align="left">Login with email</h4>
                                    <!-- Modified by Chris -->
                                    <input type="email" name="loginEmail" id="loginEmail" value="<%=(request.getAttribute("email") == null ? "" : request.getAttribute("email"))%>" size="30" placeholder="Email Address" maxlength="42" required />                                    
                                </div>

                                <div class="formRow">
                                    <h4 align="left">Password</h4>
                                    <input type="password" name="loginPassword" size="30" required>
                                </div>
                                <br>
                                <div class="loginError">
                                    <%
                                        // added by Chris
                                        if(request.getAttribute("info") != null) {
                                            out.print(request.getAttribute("info"));
                                        }
                                    %>
                                </div>

                                <h5 align="left"><input type="checkbox" name="rememberPwd" value="rememberPwd">Remember me</h5>

                                <div class="btn-group4">
                                <!--    <a href="renterProfile.jsp" class="loginBtn" ></a> -->
                                
                                <button id="loginemailBtn" type="submit" class="unstyled-button2" >Login with email</button>
                                </div>
                            </form>
                        </div>
                    </section>
                </div>
            </div>
            
             <!--Javascript functions for popup windows: Login--> 
                <script>
                    // Get the popup
                    var loginPopup = document.getElementById("loginPopup");
                    // Get the button that opens the popup
                    var loginBtn = document.getElementById("loginBtn");
                    // Get the <span2> element that closes the popup
                    var span2 = document.getElementsByClassName("close2")[0];
                    // When the user clicks the button, open the popup 
                    loginBtn.onclick = function() {
                        loginPopup.style.display = "block";
                    };
                    // When the user clicks on <span2> (x), close the popup
                    span2.onclick = function() {
                        loginPopup.style.display = "none";
                    };
                    // When the user clicks anywhere outside of the popup, close it
                    window.onclick = function(event) {
                        if (event.target === loginPopup) {
                            loginPopup.style.display = "none";
                            
                        }
                    };
                    
                    if(<%=request.getAttribute("isLoginValid")%> === false) {
                        loginPopup.style.display = "block";
                    }
                    
                    
                </script>
                
                
                
        </header>

    <!-- Main -->
        <!-- Block 1 -->
        <section class="main_section">
                <div>
                    <img src="images/how_we_work01.jpg" alt="Renter registration image" style="width:500px;height:500px;"/>
                </div>
                
                <div>
                    <h1>How It Works</h1>
                    <p>A Home To Share helps make intergenerational home sharing safe and easy by providing screening, customizable home sharing agreements, and ongoing support. </p>
                </div>
        </section>    
            
    <!-- Block 2 -->
        <section class="main_section">
            <div class="card-body1">
                <h2 class="">HOW IT WORKS</h2>
                <h3 class="">As a Host</h3>
            </div>
            <div class="placeholder-v"></div>
            <div class="card-body2">
                <h2 class="">HOW IT WORKS</h2>
                <h3 class="">As a Guest</h3>
            </div>
        </section> 
    <div class="placeholder-h1"></div>

    <!-- Block 3 -->
        <section class="main_section">
            <div class="col-1-row-1">
                <img src="images/host-icon.png" alt="Host icon image" style="width:80px; height:80px; margin-left:360px;">
                <h4 class="timeline-title">Create your free profile and room listing</h4>
                <p>
                    Create a listing for your spare room using our simple signup
                    process. Include a brief description of your home and
                    neighborhood, photos, and your monthly price. Make your
                    listing even more appealing by adding information about
                    yourself so Guests can get to know you!
                </p>
            </div>
            <div class="placeholder-v"></div>
            <div class="col-1-row-1">
                <img src="images/guest-icon.png" alt="Guest icon image" style="width:80px;height:80px; margin-left:20px;">
                <h4 class="timeline-title">Create your free profile</h4>
                <p>
                    Help your future Hosts get to know you by telling 
                    them your hobbies, interests, and anything else 
                    you’d like to share about yourself. 
                </p>
            </div>
        </section>
    
        <div class="placeholder-h2"></div>
        
        <section class="main_section">
            <div class="col-1-row-1">
                <img src="images/host-icon.png" alt="Host icon image" style="width:80px;height:80px; margin-left:360px;">
                <h4 class="timeline-title">Review your booking requests</h4>
                <p>
                    We require all Hosts and Guests to complete our 
                    screening process, which includes a criminal record 
                    check and two reference checks. Only screened Guests 
                    will be able to request bookings, and we will need 
                    your verification before you can respond to them directly. 
                </p>
            </div>
            <div class="placeholder-v"></div>
            <div class="col-1-row-1">
                <img src="images/guest-icon.png" alt="Guest icon image" style="width:80px;height:80px; margin-left:20px;">
                <h4 class="timeline-title">Explore listings</h4>
                <p>
                    Search our list of verified Hosts by location, date, 
                    and price to find the right home share. Before you 
                    can message Hosts you must complete our screening process, 
                    which includes a criminal record check and two reference 
                    checks. 
                </p>
            </div>
        </section>
        
        <div class="placeholder-h2"></div>
        
        <section class="main_section">
            <div class="col-1-row-2">
                
            </div>
            <div class="placeholder-v"></div>
            <div class="col-1-row-1">
                <img src="images/guest-icon.png" alt="Guest icon image" style="width:80px;height:80px; margin-left:20px;">
                <h4 class="timeline-title">Send a booking request</h4>
                <p>
                    Contact us to reach out to Hosts. Send them a 
                    personalized note telling them about yourself 
                    and why you are interested in home sharing with them.  
                </p>
            </div>
        </section>
        
        <div class="placeholder-h2"></div>
        
        <section class="main_section">
            <div class="col-1-row-3">
                <img src="images/host-guest.png" alt="Host & Guest icon image" style="width:180px;height:90px; margin-left:20px;">
                <h4 class="timeline-title">Message</h4>
                <p>
                    Upfront communication is key to a successful home 
                    share. We will connect Host and Guest over the phone 
                    or meet in person to make sure you've found the right 
                    fit. Discuss the Host's home sharing agreement to 
                    clarify the rules and expectations on both sides. 
                </p>
            </div>
        </section>
        
        <div class="placeholder-h2"></div>
        
        <section class="main_section">
            <div class="col-1-row-3">
                <img src="images/host-guest.png" alt="Host & Guest icon image" style="width:180px;height:90px; margin-left:20px;">
                <h4 class="timeline-title">Confirm the booking</h4>
                <p>
                    When both Host and Guest are ready to move forward, 
                    A Home To Share makes it easy to confirm the terms 
                    of the home share and schedule automatic rent payments.
                    Our one-time Host match fee of $95-$195 is simply 
                    deducted from the first month's rent payment. 
                </p>
            </div>
        </section>
        
        <div class="placeholder-h2"></div>
        
        <section class="main_section">
            <div class="col-1-row-3">
                <img src="images/host-guest.png" alt="Host & Guest icon image" style="width:180px;height:90px; margin-left:20px;">
                <h4 class="timeline-title">Move in and enjoy your home share!</h4>
                <p>
                    A Home To Share makes sending and receiving rent 
                    payments a breeze with our secure payment system. 
                    Charges occur instantaneously, and generally take 
                    5-7 business days to be deposited into the Host’s 
                    account. A Home To Share charges just 10% of monthly 
                    rent for ongoing use of the A Home To Share platform, 
                    including automated rent payments and support throughout 
                    the duration of the home share.  
                </p>
            </div>
        </section>
        <div class="placeholder-h2"></div>
        <div class="placeholder-h2"></div>
        <div class="placeholder-h2"></div>
        

     
     <!-- Block 4 -->
     

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
