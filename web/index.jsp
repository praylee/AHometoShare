<%-- 
File: index.html
Description: Home page for A Home to Share website
Create: Sept.30,2018
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
        <link rel="stylesheet" href="assets/css/mainpage_style.css" />
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
                    <button id="loginBtn" onclick="window.location.href='LogInView'" class="unstyled-button" style="<%=session.getAttribute("isLoggedIn") != null ? "display: none;" : "display: inline;"%>">Log in</button>
                    <button id="signupBtn" onclick="window.location.href='SignUpView'" class="unstyled-button" style="<%=session.getAttribute("isLoggedIn") != null ? "display: none;" : "display: inline;"%>">Sign Up</button>
                    <a href="
                       <%=session.getAttribute("isLoggedIn") != null ? (session.getAttribute("userType").toString().equals("renter") ? "renterProfile.jsp" : "hostProfile.jsp") : "index.jsp"%>" 
                       style="
                       <%=session.getAttribute("isLoggedIn") != null ? "display: inline;" : "display: none;"%>">My Profile</a>
                    <button id="logoutBtn" class="unstyled-button" style="<%=session.getAttribute("isLoggedIn") != null ? "display: inline;" : "display: none;"%>">Log out</button>
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
                            <form method="get" action="LogInView" onsubmit="" >
                                <div class="formRow">
                                    <h4 align="left">Login with email</h4>
                                    <!-- Modified by Chris -->
                                    <input type="email" name="loginEmail" id="loginEmail" value="<%=(request.getAttribute("email") == null ? "" : request.getAttribute("email"))%>" size="30" placeholder="Email Address" maxlength="42" required />                                    
                                </div>

                                <div class="formRow">
                                    <h4 align="left">Password</h4>
                                    <input type="password" name="loginPassword" size="30" required>
                                </div>
                                
                                <span class="loginError">
                                    <%
                                        // added by Chris
                                        if(request.getAttribute("info") != null) {
                                            out.print(request.getAttribute("info"));
                                        }
                                    %>
                                </span>

                                <h5 align="left"><br><input type="checkbox" name="rememberPwd" value="rememberPwd">Remember me</h5>

                                <div class="btn-group4">
                                <!--    <a href="renterProfile.jsp" class="loginBtn" ></a> -->
                                <a href="LogInView" class="loginBtn"><button id="loginemailBtn" type="submit" class="unstyled-button2" >Login with email</button></a>

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


    <!-- Banner: the text shows within the main image -->
            <section id="banner">
                <h1>Welcome to A Home To Share</h1>
                <p>Benefit from the extra space in your home</p>
            </section>

    <!-- Block 1: Core benefits info -->
        <section id="one" class="wrapper">
            <div class="inner">
                <div class="flex flex-3">
                    <header>
                        <h2>A Home to Share is a trusted service for integenerational home sharing</h2>
                        <p>Placeholder: detailed description</p>
                    </header>
                    <footer>
                        <div class="flex flex-3">
                            <article>
                                <div>
                                    <img src="images/home_block1_01.png" alt="block1_01 image"/>	
                                </div>
                                <h3>Placeholder 1: Make Money</h3>
                            </article>

                            <article>
                                <div>
                                    <img src="images/home_block1_02.png" alt="block1_02 image"/>	
                                </div>
                                <h3>Placeholder 2: Get help around the home</h3>
                            </article>

                            <article>
                                <div>
                                    <img src="images/home_block1_03.png" alt="block1_03 image"/>	
                                </div>
                                <h3>Placeholder 3: Build new friendships</h3>
                            </article>	
                        </div>
                    </footer>
                </div>
            </div>
        </section>

    <!-- Block 2: User Comments -->
        <section id="two" class="wrapper style1 special">
            <div class="inner">
                <header>
                    <h2>We don't want to brag, but...</h2>
                </header>
                <div class="flex flex-4">
                    <div class="box person">
                        <div class="image round">
                            <img src="images/home_block2_01.png" alt="User 1">
                        </div>
                        <h3>A great service</h3>
                        <p>I have really appreciated support's help...</p>
                    </div>
                    <div class="box person">
                        <div class="image round">
                            <img src="images/home_block2_02.png" alt="User 2">
                        </div>
                        <h3>Save my money</h3>
                        <p>Comments........</p>
                    </div>
                    <div class="box person">
                        <div class="image round">
                            <img src="images/home_block2_03.png" alt="User 3">
                        </div>
                        <h3>It's easy to use</h3>
                        <p>Comments........</p>
                    </div>
                    <div class="box person">
                        <div class="image round">
                            <img src="images/home_block2_04.png" alt="User 4">
                        </div>
                        <h3>We built a good friendship</h3>
                        <p>Comments........</p>
                    </div>
                </div>
            </div>
        </section>

    <!-- Block 3: How A Home To Share works -->
        <section id="three" class="wrapper special">
            <div class="inner">
                <header class="align-center">
                    <h2>How A Home To Share works</h2>
                </header>
                <div class="flex flex-2">
                    <article>
                        <div class="image fit">
                            <img src="images/home_block3_01.jpg" alt="Pic 01" />
                        </div>
                        <header>
                                <h3>1 Create your free profile</h3>
                        </header>
                        <h4>We verify ID and check references</h4>
                    </article>
                    <article>
                        <div class="image fit">
                            <img src="images/home_block3_02.jpg" alt="Pic 02" />
                        </div>
                        <header>
                            <h3>2 Connect to housemates</h3>
                        </header>
                        <h4>Connect and chat through out platform, then meet in person</h4>
                    </article>
                    <article>
                        <div class="image fit">
                            <img src="images/home_block3_03.jpg" alt="Pic 03" />
                        </div>
                        <header>
                            <h3> We support your through our</h3>
                        </header>
                        <h4>-Customizable homeshare agreement</h4>
                        <h4>-Automated payment system</h4>
                        <h4>-Ongoing service</h4>
                    </article>
                </div>
            </div>
        </section>

    <!-- Footer -->
        <footer id="footer">
            <div class="flex">

                <div>
                    <h6>Get in Touch</h6>
                    <div>
                        <img alt="logo" src="images/team_logo.png" />
                        <ul>
                            <li><a href="mailto:info@ahometoshare.ca">info@ahometoshare.ca</a></li>
                            <li><a href="#">(123) 456-7890</a></li>
                        </ul>
                    </div>
                </div>

                <div>
                    <h6>Join Our Community</h6>
                    <ul>
                        <li><a href=index.html>How it Works</a></li>
                        <li><a href=index.html>Frequently Asked Questions</a></li>
                        <li><a href=index.html>Homesharing Resources</a></li>
                        <li><a href=index.html>Community Compact</a></li>
                    </ul>
                </div>

                <div>
                    <h6>Get Engaged</h6>
                        <ul>
                            <li>Live in Toronto and want to help us tackle the affordable housing crisis.</li>
                            <li><a href="" target="_blank"> <u>Apply</u></a> to be an Ambassador today.</li>
                        </ul>
                </div>

                <div>
                    <h6>Follow us on Social</h6>
                        <a href="https://www.facebook.com/ahometoshare" class=""></a>
                        &nbsp;&nbsp;
                        <a href="https://twitter.com/ahometoshare" class=""></a>
                </div>
            </div>
        </footer>
    </body>
</html>
