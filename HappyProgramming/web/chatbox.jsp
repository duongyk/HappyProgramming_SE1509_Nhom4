<%-- 
    Document   : chatbox
    Created on : Oct 26, 2021, 9:13:00 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">

        <title>Inner Page - Vesperr Bootstrap Template</title>
        <meta content="" name="description">
        <meta content="" name="keywords">

        <!-- Favicons -->
        <link href="img/favicon.png" rel="icon">
        <link href="img/apple-touch-icon.png" rel="apple-touch-icon">

        <!-- Google Fonts -->
        <link
            href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
            rel="stylesheet">

        <!-- Vendor CSS Files -->
        <link href="vendor/aos/aos.css" rel="stylesheet">
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
        <link href="vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
        <link href="vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
        <link href="vendor/remixicon/remixicon.css" rel="stylesheet">
        <link href="vendor/swiper/swiper-bundle.min.css" rel="stylesheet">

        <!-- Template Main CSS File -->
        <link href="css/style.css" rel="stylesheet">
        <link href="css/login.css" rel="stylesheet">

        <!-- =======================================================
        * Template Name: Vesperr - v4.6.0
        * Template URL: https://bootstrapmade.com/vesperr-free-bootstrap-template/
        * Author: BootstrapMade.com
        * License: https://bootstrapmade.com/license/
        ======================================================== -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script>
            function loadMessage() {
                var amount = document.getElementsByClassName("incoming_msg").length + document.getElementsByClassName("outgoing_msg").length;
                var idfriend = document.getElementById("friendId").innerHTML;
                $.ajax({
                    url: "/HappyProgramming/loadMessage",
                    type: "get",
                    data: {
                        offset: amount,
                        friendId: idfriend
                    },
                    success: function (data) {
                        var chatbox = document.getElementById("messagebox");
                        chatbox.innerHTML += data;
                    },
                    error: function (xhr) {

                    }
                });
            }

            function loadNewFriendMessage(friendId) {
                var messagebox = document.getElementById("messagebox");
                messagebox.innerHTML = null;

                var inputbox = document.getElementById("inputbox");
                inputbox.style.display = 'none';

                //document.getElementById("friendId").value= friendId;
                document.getElementById("friendId").innerHTML = friendId;
                
                loadMessage();
                inputbox.style.display='block';
            }

            function postMessage() {                
                
                var mess = document.querySelector('input').value;
                var messtatus = document.getElementById("status");
                
                if(messtatus !== null) {
                messtatus.remove();
                }
                document.getElementById("messagebox").innerHTML += "<div class=\"outgoing_msg\">\n"
                        + "                  <div class=\"sent_msg\">\n"
                        + "                    <p>" + mess + "</p>\n"
                        + "                    <span class=\"time_date\">" + "" + "</span>\n"
                        + "                    <span id=\"status\" class=\"\">" + "ĐANG GỬI" + "</span>\n"
                        + "                  </div>\n"
                        + "                </div>";

                var idfriend = document.getElementById("friendId").innerHTML;

                $.ajax({
                    url: "/HappyProgramming/loadMessage",
                    type: "post",
                    data: {
                        message: mess,
                        friendId: idfriend
                    },
                    success: function () {
                        document.getElementById("status").innerHTML = "ĐÃ GỬI";
                        document.getElementById("textbox").value = "";
                    },
                    error: function (xhr) {
                        document.getElementById("status").innerHTML = "KHÔNG GỬI ĐƯỢC";
                    }
                });
            }
            
            $( document ).ready(function() {
                var elem = document.getElementById("friendId");
                loadNewFriendMessage(elem.innerHTML);
            });
                        
        </script>
    </head>

    <body >

        <!-- ======= Header ======= -->
        <header id="header" class="fixed-top d-flex align-items-center" style="background-color:#e2f5fde0;">
            <div class="container d-flex align-items-center justify-content-between">

                <div class="logo">
                    <h1><a href="index.jsp">Vesperr</a></h1>

                </div>

                <nav id="navbar-main" class="navbar-main">
                    <ul>

                        <li><a class="nav-link scrollto" href="listAllMentor">All mentors</a></li>
                        <li><a class="nav-link scrollto" href="ListAllSkillController">All skills</a></li>
                        <li><a class="nav-link scrollto" href="forum">Forum</a></li>
                        <li><a class="nav-link scrollto" href="openChat">Messenger</a>
                            <c:choose>
                                <c:when test="${sessionScope.currUser!=null}">
                                    <c:choose>
                                        <c:when test="${sessionScope.currUser.getRole()==2}">
                                        </li>
                                        <li><a class="nav-link scrollto" href="viewMentorRequestStatistic">Statistic</a>
                                        </li>
                                        <li><a class="nav-link scrollto" href="viewMentorRatingStatistic">Rating</a>
                                        </li>
                                        <li><a class="nav-link scrollto" href="viewMentorRequest?status=1">Inviting Request</a>
                                        </li>
                                        <li><a class="nav-link scrollto" href="viewMentorRequest?status=2">Following Request</a>
                                        </li>
                                    </c:when>
                                    <c:when test="${sessionScope.currUser.getRole()==3}">
                                        <li><a class="nav-link scrollto" href="adminDashboard">Admin Dashboard</a>
                                        </li>

                                    </c:when>
                                    <c:otherwise>
                                        <li><a class="nav-link scrollto" href="listRequestByMe">Request</a>
                                        </li>
                                    </c:otherwise>
                                </c:choose>
                                <li class="dropdown getstarted scrollto ">
                                    <span style="color: white; padding: 0;">User</span>
                                    <ul>
                                        <li><a href="UserProfile?uId=${sessionScope.currUser.id}">Profile</a></li>
                                        <li><a href="ChangePassword">Change pass</a></li>
                                        <li><a href="logout">Log out</a></li>
                                    </ul>
                                </li>
                            </c:when>
                            <c:otherwise>
                                <li class="dropdown getstarted scrollto "><a href="signIn.jsp" style="color: white; padding: 0;">
                                        <span>Sign in</span></a>
                                    <ul>
                                        <li><a href="signUp.jsp">Sign up</a>
                                        </li>
                                    </ul>
                                </li>
                            </c:otherwise>
                        </c:choose>
                    </ul>
                    <i class="bi bi-list mobile-nav-toggle"></i>
                </nav><!-- .navbar-main -->

            </div>
        </header><!-- End Header -->

        <!-- ======= Hero Section ======= -->


        <main id="main">

            <!-- ======= Breadcrumbs Section ======= -->
            <section class="breadcrumbs">
                <div class="card-heading">
                    <h2 class="title" style="color: black; font-weight: bold;">Messaging </h2>
                </div>
            </section><!-- End Breadcrumbs Section -->

            <h2 id="friendId" style="display:none;">${friendId}</h2>

            <section class="inner-page" style="padding-bottom: 30px;">
                <div class="container">
                    <div class="messaging">
                        <div class="inbox_msg">
                            <div class="inbox_people">
                                <div class="headind_srch">
                                    <div class="recent_heading">
                                        <h4>Recent</h4>
                                    </div>
                                    <div class="srch_bar">
                                        <div class="stylish-input-group">

                                            <span class="input-group-addon">
                                                <button type="button"> <i class="fa fa-search" aria-hidden="true"></i> </button>
                                            </span>
                                        </div>
                                    </div>
                                </div>
                                <div class="inbox_chat">
                                    <c:set var="selectedId" value="${friendId}"></c:set>
                                    <c:forEach items="${friendList}" var="friend" >
                                    <c:choose>
                                        <c:when test="${friend.getId()==selectedId}">
                                    <div class="chat_list active_chat">
                                        <a href="#" onclick="loadNewFriendMessage(${friend.getId()}); return false;">
                                            <div class="chat_people">
                                                <div class="chat_img"> <img src="img/<c:out value="${friend.getAvatar()}" ></c:out>" alt="sunil">
                                                </div>
                                                <div class="chat_ib">
                                                    <h5><c:out value="${friend.getUsername()}"></c:out></h5>
                                                 
                                                </div>
                                            </div>
                                        </a>
                                    </div>
                                        </c:when>
                                        <c:otherwise>
                                    <div class="chat_list">
                                        <a href="#" onclick="loadNewFriendMessage(${friend.getId()}); return false;">
                                        <div class="chat_people">
                                            <div class="chat_img"> <img src="img/<c:out value="${friend.getAvatar()}" ></c:out>" alt="sunil">
                                            </div>
                                            <div class="chat_ib">
                                                <h5>${friend.getUsername()}</h5>
                                                
                                            </div>
                                        </div>
                                        </a>
                                    </div>
                                        </c:otherwise>
                                    </c:choose>
                                    </c:forEach>
                                </div>
                            </div>
                            <div class="mesgs">
                                <div class="headind_srch">
                                    <div class="recent_heading">
                                        <img src="https://ptetutorials.com/images/user-profile.png" alt="sunil" style="
                                             max-width: 30%;
                                             float: left;
                                             ">
                                        <h4 style="
                                            max-width: 30%;
                                            float: left;
                                            ">Recent</h4>
                                    </div>
                                    <div class="srch_bar">
                                        <div class="stylish-input-group">

                                            <span class="input-group-addon">
                                                <button type="button"> <i class="fa fa-search" aria-hidden="true"></i> </button>
                                            </span>
                                        </div>
                                    </div>
                                </div>
                                <div class="msg_history" id="messagebox">
                                    
                                </div>
                                <div class="type_msg" id="inputbox">
                                    <div class="input_msg_write">
                                        <form action="#" method="POST" onsubmit="postMessage();event.preventDefault();">
                                        <input id = "textbox" type="text" class="write_msg" placeholder="Type a message" required style="width: 91%"/>
                                        <button class="msg_send_btn" type="submit"><i class="fa fa-paper-plane-o"
                                                                                                       aria-hidden="true"></i></button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>

        </main><!-- End #main -->

        <!-- ======= Contact Section ======= -->
        <section id="contact" class="contact" style="background-color: white;">
            <div class="container">

                <div class="section-title" data-aos="fade-up">
                    <h2>Contact Us</h2>
                </div>

                <div class="row">

                    <div class="col-lg-4 col-md-6" data-aos="fade-up" data-aos-delay="100">
                        <div class="contact-about">
                            <h3>Vesperr</h3>
                            <p>Cras fermentum odio eu feugiat. Justo eget magna fermentum iaculis eu non diam phasellus. Scelerisque
                                felis imperdiet proin fermentum leo. Amet volutpat consequat mauris nunc congue.</p>
                            <div class="social-links">
                                <a href="#" class="twitter"><i class="bi bi-twitter"></i></a>
                                <a href="#" class="facebook"><i class="bi bi-facebook"></i></a>
                                <a href="#" class="instagram"><i class="bi bi-instagram"></i></a>
                                <a href="#" class="linkedin"><i class="bi bi-linkedin"></i></a>
                            </div>
                        </div>
                    </div>

                    <div class="col-lg-3 col-md-6 mt-4 mt-md-0" data-aos="fade-up" data-aos-delay="200">
                        <div class="info">
                            <div>
                                <i class="ri-map-pin-line"></i>
                                <p>A108 Adam Street<br>New York, NY 535022</p>
                            </div>

                            <div>
                                <i class="ri-mail-send-line"></i>
                                <p>info@example.com</p>
                            </div>

                            <div>
                                <i class="ri-phone-line"></i>
                                <p>+1 5589 55488 55s</p>
                            </div>

                        </div>
                    </div>

                    <div class="col-lg-5 col-md-12" data-aos="fade-up" data-aos-delay="300">






                        <!--MAP-->
                    </div>

                </div>

            </div>
        </section><!-- End Contact Section -->
        <!-- ======= Footer ======= -->
        <footer id="footer">
            <div class="container">
                <div class="row d-flex align-items-center">
                    <div class="col-lg-6 text-lg-left text-center">
                        <div class="copyright">
                            &copy; Copyright <strong>Vesperr</strong>. All Rights Reserved
                        </div>
                        <div class="credits">
                            <!-- All the links in the footer should remain intact. -->
                            <!-- You can delete the links only if you purchased the pro version. -->
                            <!-- Licensing information: https://bootstrapmade.com/license/ -->
                            <!-- Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/vesperr-free-bootstrap-template/ -->
                            Designed by <a href="https://bootstrapmade.com/">BootstrapMade</a>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <nav class="footer-links text-lg-right text-center pt-2 pt-lg-0">
                            <a href="#intro" class="scrollto">Home</a>
                            <a href="#about" class="scrollto">About</a>
                            <a href="#">Privacy Policy</a>
                            <a href="#">Terms of Use</a>
                        </nav>
                    </div>
                </div>
            </div>
        </footer><!-- End Footer -->

        <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i
                class="bi bi-arrow-up-short"></i></a>

        <!-- Vendor JS Files -->
        <script src="vendor/aos/aos.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="vendor/glightbox/js/glightbox.min.js"></script>
        <script src="vendor/isotope-layout/isotope.pkgd.min.js"></script>
        <script src="vendor/php-email-form/validate.js"></script>
        <script src="vendor/purecounter/purecounter.js"></script>
        <script src="vendor/swiper/swiper-bundle.min.js"></script>

        <!-- Template Main JS File -->
        <script src="js/main.js"></script>
        
        <style>
            .container {
                max-width: 1170px;
                margin: auto;
            }

            img {
                max-width: 100%;
            }

            .inbox_people {
                background: #f8f8f8 none repeat scroll 0 0;
                float: left;
                overflow: hidden;
                width: 33%;
                border-right: 1px solid #c4c4c4;
            }

            .inbox_msg {
                border: 1px solid #c4c4c4;
                clear: both;
                overflow: hidden;
            }

            .top_spac {
                margin: 20px 0 0;
            }


            .recent_heading {
                float: left;
                width: 40%;
            }

            .srch_bar {
                display: inline-block;
                text-align: right;
                width: 60%;
            }

            .headind_srch {
                padding: 10px 29px 10px 20px;
                overflow: hidden;
                border-bottom: 1px solid #c4c4c4;
            }

            .recent_heading h4 {
                color: #05728f;
                font-size: 21px;
                margin: auto;
            }

            .srch_bar input {
                border: 1px solid #cdcdcd;
                border-width: 0 0 1px 0;
                width: 80%;
                padding: 2px 0 4px 6px;
                background: none;
            }

            .srch_bar .input-group-addon button {
                background: rgba(0, 0, 0, 0) none repeat scroll 0 0;
                border: medium none;
                padding: 0;
                color: #707070;
                font-size: 18px;
            }

            .srch_bar .input-group-addon {
                margin: 0 0 0 -27px;
            }

            .chat_ib h5 {
                font-size: 15px;
                color: #464646;
                margin: 0 0 8px 0;
            }

            .chat_ib h5 span {
                font-size: 13px;
                float: right;
            }

            .chat_ib p {
                font-size: 14px;
                color: #989898;
                margin: auto
            }

            .chat_img {
                float: left;
                width: 11%;
            }

            .chat_ib {
                float: left;
                padding: 0 0 0 15px;
                width: 88%;
            }

            .chat_people {
                overflow: hidden;
                clear: both;
            }

            .chat_list {
                border-bottom: 1px solid #c4c4c4;
                margin: 0;
                padding: 18px 16px 10px;
            }

            .inbox_chat {
                height: 550px;
                overflow-y: scroll;
            }

            .active_chat {
                background: #ebebeb;
            }

            .incoming_msg_img {
                display: inline-block;
                width: 6%;
            }

            .received_msg {
                display: inline-block;
                padding: 0 0 0 10px;
                vertical-align: top;
                width: 92%;
            }

            .received_withd_msg p {
                background: #ebebeb none repeat scroll 0 0;
                border-radius: 3px;
                color: #646464;
                font-size: 14px;
                margin: 0;
                padding: 5px 10px 5px 12px;
                width: 100%;
            }

            .time_date {
                color: #747474;
                display: block;
                font-size: 12px;
                margin: 8px 0 0;
            }

            .received_withd_msg {
                width: 57%;
            }

            .mesgs {
                float: left;
                /*padding: 00px 15px 0 25px;*/
                width: 67%;
            }

            .sent_msg p {
                background: #05728f none repeat scroll 0 0;
                border-radius: 3px;
                font-size: 14px;
                margin: 0;
                color: #fff;
                padding: 5px 10px 5px 12px;
                width: 100%;
            }

            .outgoing_msg {
                overflow: hidden;
                margin: 26px 12px 26px;
            }

            .sent_msg {
                float: right;
                width: 46%;
            }

            .input_msg_write input {
                background: rgba(0, 0, 0, 0) none repeat scroll 0 0;
                border: medium none;
                color: #4c4c4c;
                font-size: 15px;
                min-height: 48px;
                width: 100%;
            }

            .type_msg {
                border-top: 1px solid #c4c4c4;
                position: relative;
                margin-left: 20px;
                margin-right: 20px;
            }

            .msg_send_btn {
                background:  none repeat scroll 0 0;
                border: medium none;
                color: #fff;
                cursor: pointer;
                font-size: 17px;
                position: absolute;
                right: 0;
                top: 10px;
                height: 15px;
                width: 15px;
                border-top: 15px solid transparent;
                border-left: 30px solid #05728f;
                border-bottom: 15px solid transparent;
            }

            .messaging {
                padding: 0 0 50px 0;
            }

            .msg_history {
                height: 516px;
                overflow-y: auto;
                flex-direction:column-reverse;
            }
        </style>

    </body>

</html>