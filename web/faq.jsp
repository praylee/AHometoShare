<%-- 
File: faq.jsp
Description: A page for displaying frequently asked questions about the business
Create: Oct. 30, 2018
Author: Zhan Shen
Modified on: Nov. 13, 2018
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
        <title>My Profile</title>
        <link rel="stylesheet" href="assets/css/faq_style.css" />
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
                    <a href="
                       <%=session.getAttribute("isLoggedIn") != null ? (session.getAttribute("userType").toString().equals("renter") ? "renterProfile.jsp" : "hostProfile.jsp") : "index.jsp"%>" 
                       style="
                       <%=session.getAttribute("isLoggedIn") != null ? "display: inline;" : "display: none;"%>">My Account</a>
                    <button id="logoutBtn" class="unstyled-button" onclick="window.location.href='LogoutRedirect'" style="<%=session.getAttribute("isLoggedIn") != null ? "display: inline;" : "display: none;"%>">Log out</button>
                </nav>
            </div>
        </header>
        
        <h1 id="faq_title">Frequently asked questions</h1>

        <!--Main Frame-->
        <div class="wrapper">
            
            <!--Pane 1: a placeholder-->    
                <div class="colunm aside-1"></div>
                
            <!--Pane 2: FAQ - left side-->
                <div class="colunm aside-2">
                    <h3 id="top_question1">How does A Home To Share work?</h3>
                    <article class="article">
                        <p>The A Home To Share connects households, Hosts, who 
                            have spare space with people who are seeking a place 
                            to stay for longer than one month, Guests. In a twist 
                            that’s unique to A Home To Share, Guests can also 
                            exchange help around the house for lower rent. A Home 
                            To Share helps to make intergenerational home sharing 
                            safe and easy by providing screening, a customizable 
                            home sharing agreement, and on-going personal service. 
                        </p>
                    </article>
                    
                    <h3>How do I find the right home sharing arrangement?</h3>
                    <article class="article">
                        <p>Once Guests create a profile and complete our screening 
                            process, they can search our list of verified Hosts 
                            by location, date, and price to find the right home 
                            share. They then use our secure system to reach out 
                            to their selected Host(s). If both Host and Guest 
                            decide to move forward, we can design and confirm 
                            the booking terms, complete a Home sharing Agreement, 
                            and set up payments, all through A Home To Share. 
                        </p>
                    </article>
                    
                    <h3>Is A Home To Share a safe place to find a housemate?</h3>
                    <article class="article">
                        <p>Trust and safety are paramount to us at A Home To Share. 
                            This is why all community members go through our 
                            multi-step screening process. After verifying their 
                            identity we contact references. We ask all Hosts and 
                            Guests to complete a criminal record check, and in 
                            addition to requiring a complete A Home To Share 
                            application we also conduct two reference checks for 
                            every user (at minimum).  
                        </p>
                    </article>
                    
                    <h3>What information do you need from me to sign up and 
                        become an active member of the A Home To Share community?
                    </h3>
                    <article class="article">
                        <p>We require your: name, date of birth, contact info, 
                            recent photo, names and contact information of at 
                            least two references, bank account info (to send or 
                            receive payments), and photos of your home (Hosts only).  
                        </p>
                    </article>
                    
                    <h3>Where is A Home To Share operating?</h3>
                    <article class="article">
                        <p>A Home To Share is currently operating in the Region 
                            of Peel, in the Greater Toronto Area. We are working 
                            around the clock to scale A Home To Share to additional 
                            cities and hope to be in your neighborhood soon. If 
                            you think your city needs A Home To Share, let us know 
                            at the bottom of our homepage!  
                        </p>
                    </article>
                    
                    <h3>How do I know if I am eligible?</h3>
                    <article class="article">
                        <p>While we designed A Home To Share to meet the demand 
                            for intergenerational home sharing, anyone over the 
                            age of 18 is eligible to apply. Please read our 
                            <a href="index.jsp">Terms of Use</a> to better understand what it 
                            means to join our community.  
                        </p>
                    </article>
                    
                    <h3>What does it cost to use A Home To Share?</h3>
                    <article class="article">
                        <p>It’s free to create a profile and search our secure 
                            community. A Home To Share’s one-time matching fee 
                            ranges from $95-195 depending on the length of stay 
                            and is charged at the time a home share is confirmed. 
                            A Home To Share charges only 10% of monthly rent for 
                            ongoing use of A Home To Share’s platform and ongoing 
                            support, including our secure payment system and ongoing 
                            service team.  
                        </p>
                    </article>
                    
                    <h3>What if things aren’t working out with my housemate?</h3>
                    <article class="article">
                        <p>A Home To Share encourages all Hosts and Guests to connect 
                            over the phone or in person before confirming a home 
                            share. A Home To Share facilitates the creation of a 
                            detailed Home sharing Agreement to help ensure upfront 
                            communication and expectation setting. If housemates 
                            need to alter or shorten the original Home sharing 
                            Agreement, A Home To Share can help facilitate. A Home 
                            To Share is available to help housemates work through 
                            issues or concerns throughout the duration of the home 
                            share.  
                        </p>
                    </article>

                </div>
            
            <!--Pane 3: FAQ - right side-->
                <div class="colunm aside-3">
                    <div style="border-left:1px solid #bbb; height:1750px"></div>

                </div>
            
            <!--Pane 4: a placeholder-->  
                <div class="colunm aside-4">
                    <h3 id="top_question2">Is there a minimum length of stay?</h3>
                    <article class="article">
                        <p>A Home To Share is not a platform for short-term accommodations. 
                            All bookings must be for a minimum of 30 consecutive days. 
                            A Home To Share is designed to be flexible to meet the 
                            needs of each individual home sharing arrangement and 
                            can range from one month to up to a year or more.  
                        </p>
                    </article>
                    
                    <h3>Is home sharing legal?</h3>
                    <article class="article">
                        <p>Yes, home sharing with one Guest for a period of more 
                            than 30 days is legal in most circumstances. In many 
                            cities and towns, you can even Host up to 3 Guests at 
                            a time with no issue. 
                        </p>
                    </article>
                    
                    <h3>Can I rent out my entire house?</h3>
                    <article class="article">
                        <p>No. Hosts on the A Home To Share Platform can only rent 
                            out a room or spare space in or on the property of 
                            their primary residence. A Home To Share is a platform 
                            for home sharing, not home renting! 
                        </p>
                    </article>
                    
                    <h3>Can I list more than one room?</h3>
                    <article class="article">
                        <p>Yes. Once you create your first room listing you will
                            have the option to add additional rooms via a link on 
                            your Hosting Dashboard. Some municipalities require 
                            permits and collect occupancy taxes once a resident 
                            is renting out more than three rooms though, so be 
                            sure to check your local policies and regulations. 
                        </p>
                    </article>
                    
                    <h3How do I price the room?</h3>
                    <article class="article">
                        <p>Hosts choose how to price their rooms. That said, one 
                            of A Home To Share’s key goals is to expand the supply 
                            of affordable housing so we strongly encourage Hosts 
                            to price their rooms as affordably as possible. 
                            Currently, most Hosts on the platform are charging 
                            $700 or less per month in the Region of Peel, utilities 
                            included. 
                        </p>
                    </article>
                    
                    <h3>How do I price the task exchange?</h3>
                    <article class="article">
                        <p>As part of the A Home To Share’s signup process, both 
                            Hosts and Guests are asked to indicate whether they 
                            would like to incorporate task exchange into their home 
                            share. Incorporating tasks is an optional feature that 
                            can be tailored to meet the needs of each home share. 
                            We typically see a $150 reduction in rent per month 
                            for approximately 2-3 hours of help per week (8-10 
                            hours per month). 
                        </p>
                    </article>
                    
                    <h3>How do automated payments work?</h3>
                    <article class="article">
                        <p>A Home To Share processes monthly rent payments quickly 
                            and easily through our automated payment system. Charges 
                            occur instantaneously, and generally take 5-7 business 
                            days to be deposited into the Host’s account. For new 
                            accounts it may take up to 10 business days. All payments 
                            are processed through the safest and most secure 
                            environment possible. 
                        </p>
                    </article>
                    
                    <h3>Is my personal information safe?</h3>
                    <article class="article">
                        <p>Our customers’ safety and security are our top priorities. 
                            We use industry-standard certificates to ensure that your 
                            connection to our site is always secure and your 
                            information is protected. Additionally, we do not accept 
                            or store any sensitive information (e.g. payment info) 
                            on our servers, and only use trusted providers that take
                            security as seriously as we do. Review our 
                            <a href="index.jsp">Terms of Use</a> and 
                            <a href="index.jsp">Privacy Policy</a> for more information.
                        </p>
                    </article>
                    
                    <h3>Do you have any job openings at A Home To Share?</h3>
                    <article class="article">
                        <p>We’re always looking for passionate, talented people to 
                            join our team. If you think you’re a good fit or if 
                            you’d just like to learn more, send your resume to 
                            <a href="mailto:info@ahometoshare.ca ">A Home To Share</a>
                            and tell us how you’d like to contribute. 
                            
                        </p>
                    </article>
                    

                </div>
                
            
            <!--Pane 5: a placeholder-->
                <div class="colunm aside-5"></div>
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