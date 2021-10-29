<%-- 
  Copyright (C) 2021, FPT University<br>
  SWP391 - SE1509 - Group 4<br>
  Happyprogramming<br>
 
  Record of change:<br>
  DATE          Version    Author           DESCRIPTION<br>

--%>
<%@page import="entity.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">

        <title>Vesperr</title>
        <meta content="" name="description">
        <meta content="" name="keywords">

        <link href="img/favicon.png" rel="icon">
        <link href="img/apple-touch-icon.png" rel="apple-touch-icon">


        <link
            href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
            rel="stylesheet">
        <link href="vendor/aos/aos.css" rel="stylesheet">
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
        <link href="vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
        <link href="vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
        <link href="vendor/remixicon/remixicon.css" rel="stylesheet">
        <link href="vendor/swiper/swiper-bundle.min.css" rel="stylesheet">

        <!-- Template Main CSS File -->
        <link href="css/style.css" rel="stylesheet">
        <link href="css/popup.css" rel="stylesheet">
        <link href="css/requestByMe.css" rel="stylesheet">

    </head>

    <body>

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
                            <c:choose>
                                <c:when test="${sessionScope.currUser!=null}">
                                    <c:choose>
                                        <c:when test="${sessionScope.currUser.getRole()==2}">
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
                                        <li><a href="UserProfileController?uId=${sessionScope.currUser.id}">Profile</a></li>
                                        <li><a href="UserControllerMap?service=formChangePass">Change pass</a></li>
                                        <li><a href="UserControllerMap?service=logOut">Log out</a></li>
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

        <main id="main">
            <!-- ======= Breadcrumbs Section ======= -->
            <section class="breadcrumbs">
                <div class="card-heading">
                    <h2 class="title" style="color: black; font-weight: bold; text-align: center">SKILL DETAIL </h2>
                </div>
            </section><!-- End Breadcrumbs Section -->
            <section id="portfolio-details" class="portfolio-details">
                <div class="container">

                    <div class="row gy-4">

                        <div class="col-lg-8">
                            <div class="portfolio-details-slider swiper">
                                <div class="swiper-wrapper align-items-center">
                                    <iframe width="856" height="567" src="${currSkill.link}" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
                                </div>
                            </div>
                        </div>

                        <div class="col-lg-4">
                            <div class="portfolio-info">
                                <h3>Skill information</h3>
                                <ul>
                                    <li><strong>Name</strong>: ${currSkill.name}</li>
                                    <li><strong>Skill Detail</strong>: ${currSkill.detail}
                                    </li>
                                </ul>
                                <!--<a href="CreateRequestController?mId=0"><button class="create" style="min-width: 164px;">Create Request</button></a>-->
                            </div>
                        </div>
                    </div>
                    <br>
                    <br>                
                    <div  class="row">
                        <h1 style="text-align: center"> Recommended Mentor </h1>
                        <c:forEach items="${listRecommend}" var="mentor">
                            <div class="col-lg-3 col-md-6">
                                <div class="member box-display" data-aos="fade-up" data-aos-delay="100">
                                    <img class="img-display" src="img/${mentor.getAvatar()}">
                                    <div style="background-color: lightgray" class="member-info">
                                        <h4 style="text-align: center"><c:out value="${mentor.getFullname()}"></c:out></h4>
                                            <div style="text-align: center">
                                                <a href="CVControllerMap?service=cvMentor&mId=${mentor.getId()}">View CV</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>

                </div>
            </section>

        </main><!-- End #main -->




        <!-- ======= Footer ======= -->
        <footer id="footer">
            <div class="container">
                <div class="row d-flex align-items-center">
                    <div class="col-lg-6 text-lg-left text-center">
                        <div class="copyright">
                            &copy; Copyright <strong>Vesperr</strong>. All Rights Reserved
                        </div>
                        <div class="credits">

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
        <script src="vendor/glightbox/js/glightbox.min.js"></script>
        <script src="vendor/swiper/swiper-bundle.min.js"></script>


        <script src="js/main.js"></script>

    </body>

</html>
