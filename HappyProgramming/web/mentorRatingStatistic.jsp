<%-- 
    Document   : userProfile
    Created on : Oct 13, 2021, 11:24:41 AM
    Author     : Tung
--%>

<%
    //ArrayList<Rating> ratingList = (ArrayList<Rating>) request.getAttribute("ratingList");
    
    //String five = request.getAttribute("five").toString();
    //String four = request.getAttribute("four").toString();
    //String three = request.getAttribute("three").toString();
    //String two = request.getAttribute("two").toString();
    //String one = request.getAttribute("one").toString();
    
    //String total = request.getAttribute("total").toString();
    
    //String average = request.getAttribute("average").toString();
    //int averageint = (Integer) request.getAttribute("averageint");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">

        <title>Request Statistic</title>
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
        <link href="vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
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
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    </head>

    <body style="">

        <!-- ======= Header ======= -->
        <header id="header" class="fixed-top d-flex align-items-center" style="background-color:#e2f5fde0;">
            <div class="container d-flex align-items-center justify-content-between">

                <div class="logo">
                    <h1><a href="index.jsp">Vesperr</a></h1>
                    <!-- Uncomment below if you prefer to use an image logo -->
                    <!-- <a href="index.html"><img src="img/logo.png" alt="" class="img-fluid"></a>-->
                </div>

                <nav id="navbar-main" class="navbar-main">
                    <ul>
                        <li><a class="nav-link scrollto" href="listAllMentor">All mentors</a></li>
                        <li><a class="nav-link scrollto" href="SkillControllerMap?service=allSkill">All skills</a></li>
                        <li><a class="nav-link scrollto" href="forum">Forum</a></li>
                        
                        <c:choose>
                                <c:when test="${sessionScope.currUser!=null}">
                                    <li><a class="nav-link scrollto" href="openChat">Messenger</a></li>
                                    <c:choose>
                                        <c:when test="${sessionScope.currUser.getRole()==2}">

                                        <li><a class="nav-link scrollto" href="viewMentorRequestStatistic">Statistic</a>
                                        </li>
                                        <li><a class="nav-link scrollto" href="viewMentorRatingStatistic">Rating</a>
                                        </li>
                                        <li><a class="nav-link scrollto" href="viewMentorRequest?status=1">Inviting Request</a>
                                        </li>
                                        <li><a class="nav-link scrollto" href="viewMentorRequest?status=2">Following Request</a>
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
                    <h2 class="title" style="color: black; font-weight: bold;">Request Statistic</h2>
                    <c:if test="${success!=null}">
                        <h3 style="color:#29cc49;font-weight: bold;text-align: center"><c:out value="${success}"></c:out></h3>
                    </c:if>
                    <c:if test="${error!=null}">
                        <h3 style="color:#009900;font-weight: bold;text-align: center"><c:out value="${error}"></c:out></h3>
                    </c:if>
                </div>

            </section><!-- End Breadcrumbs Section -->

            <div class="container">
                <div class="main-body">

                    <div class="row gutters-sm">
                        <div class="col-md-3 mb-3" style="position: relative">
                            <div id="sidebar" class="card">
                                <div class="card-body">
                                    <c:choose>
                                        <c:when test="${sessionScope.currUser.getRole()==2}">
                                            <div class="d-flex flex-column align-items-center text-center">
                                                <img src="img/${sessionScope.currUser.getAvatar()}" alt="Admin" class="rounded-circle" width="150">
                                                <div class="mt-3">
                                                    <h4> <c:out value="${sessionScope.currUser.getFullname()}"></c:out> </h4>                                        
                                                    <p class="text-secondary mb-1"><c:out value="${cv.getProfession()}"></c:out></p>
                                                        <!--<p class="text-muted font-size-sm">Bay Area, San Francisco, CA</p>-->
                                                    </div>
                                                </div>
                                        </c:when>
                                        <c:otherwise>
                                            <div class="d-flex flex-column align-items-center text-center">
                                                <img src="img/${sessionScope.currUser.getAvatar()}" alt="Admin" class="rounded-circle" width="150">
                                                <div class="mt-3">
                                                    <h4> <c:out value="${sessionScope.currUser.getUsername()}"></c:out> </h4>                                                               
                                                    </div>
                                                </div>   
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-9">
                            <div class="card mb-3">
                                <div class="card-body">
                                    <div class="row" style="margin: 10px 15px 15px 15px;">
                                        <div class="col-sm-6">
                                            <div class="rating-block">
                                                <h4>Average user rating</h4>
                                                <h2 class="bold padding-bottom-7">${average} <small>/ 5</small></h2>
                                                
                                                <c:forEach var="i" begin="1" end="${averageint}">
                                                <button type="button" class="btn btn-warning btn-sm" aria-label="Left Align">
                                                    <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
                                                </button>
                                                </c:forEach>
                                                <c:forEach var="i" begin="1" end="${5-averageint}">
                                                <button type="button" class="btn btn-default btn-grey btn-sm" aria-label="Left Align">
                                                    <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
                                                </button>
                                                </c:forEach>
                                            </div>
                                        </div>
                                        <div class="col-sm-6">
                                            <h4>Rating breakdown</h4>
                                            <div class="pull-left">
                                                <div class="pull-left" style="width:35px; line-height:1;">
                                                    <div style="height:9px; margin:5px 0;">5 <span class="glyphicon glyphicon-star"></span></div>
                                                </div>
                                                <div class="pull-left" style="width:180px;">
                                                    <div class="progress" style="height:9px; margin:8px 0;">
                                                        <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="5" aria-valuemin="0" aria-valuemax="5" style="width: ${five*100/total}%">
                                                            <span class="sr-only">80% Complete (danger)</span>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="pull-right" style="margin-left:10px;">${five}</div>
                                            </div>
                                            <div class="pull-left">
                                                <div class="pull-left" style="width:35px; line-height:1;">
                                                    <div style="height:9px; margin:5px 0;">4 <span class="glyphicon glyphicon-star"></span></div>
                                                </div>
                                                <div class="pull-left" style="width:180px;">
                                                    <div class="progress" style="height:9px; margin:8px 0;">
                                                        <div class="progress-bar progress-bar-primary" role="progressbar" aria-valuenow="4" aria-valuemin="0" aria-valuemax="5" style="width: ${four*100/total}%">
                                                            <span class="sr-only">80% Complete (danger)</span>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="pull-right" style="margin-left:10px;">${four}</div>
                                            </div>
                                            <div class="pull-left">
                                                <div class="pull-left" style="width:35px; line-height:1;">
                                                    <div style="height:9px; margin:5px 0;">3 <span class="glyphicon glyphicon-star"></span></div>
                                                </div>
                                                <div class="pull-left" style="width:180px;">
                                                    <div class="progress" style="height:9px; margin:8px 0;">
                                                        <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="3" aria-valuemin="0" aria-valuemax="5" style="width: ${three*100/total}%">
                                                            <span class="sr-only">80% Complete (danger)</span>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="pull-right" style="margin-left:10px;">${three}</div>
                                            </div>
                                            <div class="pull-left">
                                                <div class="pull-left" style="width:35px; line-height:1;">
                                                    <div style="height:9px; margin:5px 0;">2 <span class="glyphicon glyphicon-star"></span></div>
                                                </div>
                                                <div class="pull-left" style="width:180px;">
                                                    <div class="progress" style="height:9px; margin:8px 0;">
                                                        <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="2" aria-valuemin="0" aria-valuemax="5" style="width: ${two*100/total}%">
                                                            <span class="sr-only">80% Complete (danger)</span>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="pull-right" style="margin-left:10px;">${two}</div>
                                            </div>
                                            <div class="pull-left">
                                                <div class="pull-left" style="width:35px; line-height:1;">
                                                    <div style="height:9px; margin:5px 0;">1 <span class="glyphicon glyphicon-star"></span></div>
                                                </div>
                                                <div class="pull-left" style="width:180px;">
                                                    <div class="progress" style="height:9px; margin:8px 0;">
                                                        <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="1" aria-valuemin="0" aria-valuemax="5" style="width: ${one*100/total}%">
                                                            <span class="sr-only">80% Complete (danger)</span>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="pull-right" style="margin-left:10px;">${one}</div>
                                            </div>
                                        </div>			
                                    </div>			

                                    <div class="row">
                                        <div class="col-sm-7">
                                            <hr/>
                                            <div class="review-block">
                                                
                                                <c:forEach items="${ratingList}" var="rating">
                                                <div class="row">
                                                    <div class="col-sm-3">
                                                        <c:set var="user" value="${rating.getFrom()}"></c:set>
                                                        <img style="width:60px;height: 60px;" src="img/<c:out value="${user.getAvatar()}" ></c:out>" class="img-rounded">
                                                        <div class="review-block-name"></div>
                                                        <div class="review-block-date">${rating.getDate()}</div>
                                                    </div>
                                                    <div class="col-sm-9">
                                                        <div class="review-block-rate">
                                                            <c:forEach var="i" begin="1" end="${rating.getRateAmount()}">
                                                            <button type="button" class="btn btn-warning btn-sm" aria-label="Left Align">
                                                                <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
                                                            </button>
                                                            </c:forEach>
                                                            <c:forEach var="i" begin="1" end="${5-rating.getRateAmount()}">
                                                            <button type="button" class="btn btn-default btn-grey btn-sm" aria-label="Left Align">
                                                                <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
                                                            </button>
                                                            </c:forEach>
                                                        </div>
                                                        <div class="review-block-title">${user.getUsername()}</div>
                                                        <div class="review-block-description">${rating.getComment()}</div>
                                                    </div>
                                                </div>
                                                <hr/>
                                                </c:forEach>
     
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <hr>
                            </div>
                        </div>




                    </div>
                </div>

            </div>
        </div>
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
        <script src="js/upload.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="vendor/glightbox/js/glightbox.min.js"></script>
        <script src="vendor/isotope-layout/isotope.pkgd.min.js"></script>
        <script src="vendor/php-email-form/validate.js"></script>
        <script src="vendor/purecounter/purecounter.js"></script>
        <script src="vendor/swiper/swiper-bundle.min.js"></script>

        <!-- Template Main JS File -->
        <script src="js/main.js"></script>
        <script>
            $(function () {
                var offset = $("#sidebar").offset();
                var topPadding = 100;
                $(window).scroll(function () {
                    if ($(window).scrollTop() > offset.top) {
                        $("#sidebar").stop().animate({
                            marginTop: $(window).scrollTop() - offset.top + topPadding*1.8
                        });
                    } else {
                        $("#sidebar").stop().animate({
                            marginTop: 0
                        });
                    }
                    ;
                });
            });
        </script>

        <style>
            body{
                margin-top:20px;
                color: #1a202c;
                text-align: left;
                background-color: #e2e8f0;    
            }
            .main-body {
                padding: 15px;
            }
            .card {
                box-shadow: 0 1px 3px 0 rgba(0,0,0,.1), 0 1px 2px 0 rgba(0,0,0,.06);
            }

            .card {
                position: relative;
                display: flex;
                flex-direction: column;
                min-width: 0;
                word-wrap: break-word;
                background-color: #fff;
                background-clip: border-box;
                border: 0 solid rgba(0,0,0,.125);
                border-radius: .25rem;
            }

            .card-body {
                flex: 1 1 auto;
                min-height: 1px;
                padding: 1rem;
            }



            .gutters-sm>.col, .gutters-sm>[class*=col-] {
                padding-right: 8px;
                padding-left: 8px;
            }

            .bg-gray-300 {
                background-color: #e2e8f0;
            }
            .h-100 {
                height: 100%!important;
            }
            .shadow-none {
                box-shadow: none!important;
            }

            .btn-grey{
                background-color:#D8D8D8;
                color:#FFF;
            }
            .rating-block{
                background-color:#FAFAFA;
                border:1px solid #EFEFEF;
                padding:15px 15px 20px 15px;
                border-radius:3px;
            }
            .bold{
                font-weight:700;
            }
            .padding-bottom-7{
                padding-bottom:7px;
            }

            .review-block{
                background-color:#FAFAFA;
                border:1px solid #EFEFEF;
                padding:15px;
                border-radius:3px;
                margin-bottom:15px;
            }
            .review-block-name{
                font-size:12px;
                margin:10px 0;
            }
            .review-block-date{
                font-size:12px;
            }
            .review-block-rate{
                font-size:13px;
                margin-bottom:15px;
            }
            .review-block-title{
                font-size:15px;
                font-weight:700;
                margin-bottom:10px;
            }
            .review-block-description{
                font-size:13px;
            }
        </style>
</body>

</html>
