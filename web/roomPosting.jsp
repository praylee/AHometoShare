<%-- 
File: roomPosting.jsp
Description: Host's room posting page for A Home to Share website
Create: Oct 23,2018
Author: Bin Yang
Modified by Liangliang Du for adding pictures
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
        <title>Room Posting</title>
        <link rel="stylesheet" href="assets/css/roomposting_style.css" />
        <script class="jsbin" src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
        <script class="jsbin" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.0/jquery-ui.min.js"></script>
    </head>
    <body>
        
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
                       <%=session.getAttribute("isLoggedIn") != null ? "display: inline;" : "display: none;"%>">My Account</a>
                    <button id="logoutBtn" class="unstyled-button" onclick="window.location.href='LogoutRedirect'" style="<%=session.getAttribute("isLoggedIn") != null ? "display: inline;" : "display: none;"%>">Log out</button>
                </nav>
            </div>
        </header>
        

	<!-- Main -->
       
        <section id="main_section" class="wrapper">
            <div>
                <h2></h2>
            </div>
            <div class="btn-group-vertical">
                        <ul id="horizontal-list">
                            <li><hr class="welcome_block" align="left"></li>
                            <li><h3>Hello <%out.print(session.getAttribute("firstname"));%>!</h3><li>
                        </ul >
                        <ul style="list-style:none;">
                            <li id="menu1"><input type="button" value="My Profile" class="" onclick="window.location.href='hostProfile.jsp'" /></li>
                            <li id="menu2"><input type="button" value="Account Settings" class="" onclick="window.location.href='hostAccountSettings.jsp'" /></li>
                            <li id="menu3"><input type="button" value="Manage Properties" onclick="window.location.href='roomPosting.jsp'" /></li>
                        </ul>
            </div>
            <div>
                    <form id="roomForm" method="post" action="RoomPostingView" onsubmit="" enctype="multipart/form-data">
                        <!--<div class="row uniform">-->

                        <h2>Property information</h2>

                        <!-- Break: First Name(db:first_name), Last Name(db:last_name) -->
                            <div class="formRow">
                                <h4>Address<span style="color:red; font-weight:bold">*</span></h4>
                                <input type="text" name="address" id="address" value="" size="30" placeholder="Address" maxlength="100" required />
                            </div>

                            <div class="formRow">
                                <h4>City<span style="color:red; font-weight:bold">*</span></h4>
                                <input type="text" name="city" id="city" value="" size="30" placeholder="City" maxlength="30" required />
                            </div>
                        
                            <div class="formRow">
                                <h4>Province<span style="color:red; font-weight:bold">*</span></h4>
                                <input type="text" name="province" id="province" value="" size="30" placeholder="Province" maxlength="30" required />
                            </div>
                        
                            <div class='formRow'>
                                <h4>Country<span style="color:red; font-weight:bold">*</span></h4>
                                <input type="text" name="country" id="country" value="Canada" size="30" placeholder="Canada" maxlength="30" required />
                            </div>
                        
                            <div class='formRow'>
                                <h4>Postal Code<span style="color:red; font-weight:bold">*</span></h4>
                                <input type="text" name="postalcode" id="postalcode" value="" size="30" placeholder="PostalCode" maxlength="30" required />
                            </div>

                        <!-- Break: Email Address(db:email), Phone Number(db:phone) -->
                            <div class="formRow">
                                <h4>Start Sharing<span style="color:red; font-weight:bold">*</span></h4>
                                <input type="date" name="startdate" id="startdate" value="" size="30" placeholder="yyyy-mm-dd" maxlength="15" required />
                            </div>
                        
                            <div class="formRow">
                                <h4>End Sharing<span style="color:red; font-weight:bold">*</span></h4>
                                <input type="date" name="enddate" id="enddate" value="" size="30" placeholder="yyyy-mm-dd" maxlength="15" />
                            </div>

                            <div class="formRow2">
                                <h4>How many people living in the house<span style="color:red; font-weight:bold">*</span></h4>
                                <select name="fammembers" id="fammembers" required >
                                        <option value="">- Select a number -</option>
                                        <option value="0">0</option>
                                        <option value="1">1</option>
                                        <option value="2">2</option>
                                        <option value="3">3</option>
                                        <option value="4">4</option>
                                        <option value="5">5</option>
                                        <option value="6">6</option>
                                </select>
                            </div>

                            <div class="formRow2">
                                <h4 >How long this room will be available<span style="color:red; font-weight:bold">*</span></h4>
                                <select name="availability" id="availability" required >
                                        <option value="">- Select the term -</option>
                                        <option value="5">Long Term</option>
                                        <option value="6">Short Term</option>
                                        <option value="7">Temporary</option>
                                </select>
                            </div>
                        
                             <!--upload picture-->
                            <div >
                                <h4>Upload Picture:</h4>
                                <table>
                                    <tr>
                                        <td>
                                            <input id="inputfile" type='file' name="inputfile" hidden="hidden" />
                                            <button type="button" id="custom-button"><img id="img"  src="http://placehold.it/180" alt="your image" height=180px width=180px/> </button>
                                        </td>
                                        <td>
                                            <input id="inputfile2" type='file' name="inputfile2" hidden="hidden" />
                                            <button type="button" id="custom-button2"><img id="img2"  src="http://placehold.it/180" alt="your image" height=180px width=180px/> </button>
                                        </td>
                                        <td>
                                            <input id="inputfile3" type='file' name="inputfile3" hidden="hidden" />
                                            <button type="button" id="custom-button3"><img id="img3"  src="http://placehold.it/180" alt="your image" height=180px width=180px/> </button>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <input id="inputfile4" type='file' name="inputfile4" hidden="hidden" />
                                            <button type="button" id="custom-button4"><img id="img4"  src="http://placehold.it/180" alt="your image" height=180px width=180px /> </button>
                                        </td>
                                        <td>
                                            <input id="inputfile5" type='file' name="inputfile5" hidden="hidden" />
                                            <button type="button" id="custom-button5"><img id="img5"  src="http://placehold.it/180" alt="your image" height=180px width=180px/> </button>
                                        </td>
                                        <td>
                                            <input id="inputfile6" type='file' name="inputfile6" hidden="hidden"  />
                                            <button type="button" id="custom-button6"><img id="img6"  src="http://placehold.it/180" alt="your image" height=180px width=180px/> </button>
                                        </td>
                                    </tr>
                                </table>                               
                            </div>
                        
                            <script>
                                var fileIds = ["inputfile","inputfile2" ,"inputfile3","inputfile4","inputfile5","inputfile6"];                            
                                var Imgs = ['#img','#img2','#img3','#img4','#img5','#img6'];
                                var Files = ['#inputfile','#inputfile2','#inputfile3','#inputfile4','#inputfile5','#inputfile6'];
 
                                var customBtn = document.getElementById("custom-button");                            
                                customBtn.addEventListener("click",function() {
                                    readURL(fileIds[0],Imgs[0],Files[0]);
                                });                                                                     

                                var customBtn2 = document.getElementById("custom-button2");
                                customBtn2.addEventListener("click",function(){
                                    readURL(fileIds[1],Imgs[1],Files[1]);
                                });
 
                                var customBtn3 = document.getElementById("custom-button3");
                                customBtn3.addEventListener("click",function(){
                                    readURL(fileIds[2],Imgs[2],Files[2]);
                                });
                                
                                var customBtn4 = document.getElementById("custom-button4");
                                customBtn4.addEventListener("click",function(){
                                    readURL(fileIds[3],Imgs[3],Files[3]);
                                });

                                var customBtn5 = document.getElementById("custom-button5");
                                customBtn5.addEventListener("click",function(){
                                    readURL(fileIds[4],Imgs[4],Files[4]);
                                });
                                
                                var customBtn6 = document.getElementById("custom-button6");
                                customBtn6.addEventListener("click",function(){
                                    readURL(fileIds[5],Imgs[5],Files[5]);
                                });
                                                                                               
                                function readURL(fileId,img,file) {    
                                    realFileBtn = document.getElementById(fileId);
                                    realFileBtn.click();
                                    realFileBtn.addEventListener("change",function(){
                                        if (this.files && this.files[0]) {
                                            var reader = new FileReader();
                                             reader.onload = function (e) {
                                                $(img)
                                                    .attr('src', e.target.result);

                                            };
                                             reader.readAsDataURL(this.files[0]);
                                        }

                                        var image_name = $(file).val();
                                        if(image_name != ''){
                                            var extension = $(file).val().split('.').pop().toLowerCase();
                                            if($.inArray(extension,['gif','png','jpg','jpeg']) == -1){
                                                alert('Invalid Image File');
                                                $(file).val('');
                                                return false;
                                            }
                                        }
                                    });
                                }
                                
                            </script>
                        
                        
                            <div>
                                <h4>Please check the following items which are applicable<span style="color:red; font-weight:bold">*</span></h4>
                                <table>
                                    <tr>
                                        <td width="200"><input type="checkbox" name="isSmokerFriendly" value="true">Smoke allowed</td>
                                        <td><input type="checkbox" name="isPetFriendly" value="true">Pet allowed</td>
                                    </tr>
                                    <tr>
                                        <td><input type="checkbox" name="hydro" value="true">Hydro Included</td>
                                        <td><input type="checkbox" name="water" value="true">Water Included</td>
                                    </tr>
                                    <tr>
                                        <td><input type="checkbox" name="gas" value="true">Gas Included</td>
                                        <td><input type="checkbox" name="cable" value="true">Cable Included</td>
                                    </tr>
                                    <tr>
                                        <td><input type="checkbox" name="internet" value="true">Internet Included</td>
                                        <td><input type="checkbox" name="parking" value="true">Parking Available</td>
                                    <tr>
                                        <td><input type="checkbox" name="laundry" value="true">OnSite Laundry</td>
                                        <td><input type="checkbox" name="familyroom" value="true">Family Room Accessible</td>
                                    </tr>
                                    <tr>
                                        <td><input type="checkbox" name="privatebedroom" value="true">Private Bedroom</td>
                                        <td><input type="checkbox" name="sharedbedroom" value="true">Shared Bedroom</td>
                                    </tr>
                                    <tr>
                                        <td><input type="checkbox" name="privatekitchen" value="true">Private Kitchen</td>
                                        <td><input type="checkbox" name="sharedkitchen" value="true">Shared Kitchen</td>
                                    </tr>
                                    <tr>
                                        <td><input type="checkbox" name="privatewashroom" value="true">Private Washroom</td>
                                        <td><input type="checkbox" name="sharedwashroom" value="true">Shared Washroom</td>
                                    </tr>
                                </table><br>
                            </div>

                            <div class='formRow'>
                                <h4>Shared Chores<span style="color:red; font-weight:bold">*</span></h4>
                                <input type="text" name="chores" id="chores" value="" size="30" placeholder="chores" maxlength="30" required />
                            </div>
                        
                            <div class="formRow">
                                <h4>Asking Price<span style="color:red; font-weight:bold">*</span></h4>
                                <input type="number" name="price" id="price" size="30" value="" placeholder="$(per month)" maxlength="45" required/>
                            </div>

                        <!-- Host email address to verify the information -->

                            <div class="formRow">
                                <h4>Your Email<span style="color:red; font-weight:bold">*</span></h4>
                                <input type="text" name="email" id="email" size="30" value="" placeholder="Your registration email" maxlength="45" required>
                            </div><br><br>
                        
                        <!-- Buttons: submit, Reset -->
                            <div>
                                <ul class="actions fit">                                                                             
                                    <li><input type="reset" value="Reset" class="alt" /></li>
                                    <li><input type="submit" value="Submit" /></li>

                                </ul>
                            </div>

                    </form>
                </div>
                <div>
                    <h2></h2>
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

