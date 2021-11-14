<%-- 
  Copyright (C) 2021, FPT University<br>
  SWP391 - SE1509 - Group 4<br>
  Happyprogramming<br>
 
  Record of change:<br>
  DATE          Version    Author           DESCRIPTION<br>

--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">

        <title>View message</title>
        <meta content="" name="description">
        <meta content="" name="keywords">

        <!-- Favicons -->
        <link href="img/favicon.png" rel="icon">
        <link href="img/apple-touch-icon.png" rel="apple-touch-icon">

        <!-- Google Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

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
        <link href="css/admin.css" rel="stylesheet">
        <link href="css/search.css" rel="stylesheet">

    </head>

    <body>

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
                        <c:choose>
                            <c:when test="${sessionScope.currUser!=null}">
                                <li> 
                                    <div>
                                        <form action="search" method="POST" style="margin-left: 10px">
                                            <label for="category">Category :</label>
                                            <select data-trigger="" name="category" class="search-btn" id="category">
                                                <c:choose>
                                                    <c:when test="${category==null}">
                                                        <option>Skill</option>
                                                        <option>Mentee</option>
                                                        <option>Mentor</option>
                                                        <option>Message</option>
                                                        <option>Request</option></c:when>
                                                    <c:when test="${category == 'Mentee'}">
                                                        <option>Skill</option>
                                                        <option selected="selected">Mentee</option>
                                                        <option>Mentor</option>
                                                        <option>Message</option>
                                                        <option>Request</option></c:when>
                                                    <c:when test="${category == 'Skill'}">
                                                        <option  selected="selected">Skill</option>
                                                        <option>Mentee</option>
                                                        <option>Mentor</option>
                                                        <option>Message</option>
                                                        <option>Request</option></c:when>
                                                    <c:when test="${category == 'Mentor'}">
                                                        <option>Skill</option>
                                                        <option>Mentee</option>
                                                        <option  selected="selected">Mentor</option>
                                                        <option>Message</option>
                                                        <option>Request</option></c:when>
                                                    <c:when test="${category == 'Request'}">
                                                        <option>Skill</option>
                                                        <option>Mentee</option>
                                                        <option>Mentor</option>
                                                        <option>Message</option>
                                                        <option selected="selected">Request</option></c:when>
                                                    <c:when test="${category == 'Message'}">
                                                        <option>Skill</option>
                                                        <option>Mentee</option>
                                                        <option>Mentor</option>
                                                        <option selected="selected">Message</option>
                                                        <option>Request</option></c:when>
                                                </c:choose>
                                            </select>
                                            <input type="text" class="searchTerm" placeholder="What are you looking for?" name="txtSearch" value="${txt}" >
                                            <button type="submit" class="searchButton"> <img src="img/search.svg"></button>
                                        </form>
                                    </div>
                                </li>
                                <li class="dropdown getstarted scrollto ">
                                    <span style="color: white; padding: 0;">Admin </span>
                                    <ul>
                                        <li><a href="logout">Log out</a></li>
                                    </ul>
                                </li>


                            </c:when>
                            <c:otherwise>
                                <li> 
                                    <div>
                                        <form action="search" method="POST" style="margin-left: 10px">
                                            <label for="category">Category :</label>
                                            <select data-trigger="" name="category" class="search-btn" id="category">
                                                <c:choose>
                                                    <c:when test="${category==null}">
                                                        <option>Skill</option>
                                                        <option>Mentee</option>
                                                        <option>Mentor</option>
                                                        <option>Message</option>
                                                        <option>Request</option></c:when>
                                                    <c:when test="${category == 'Mentee'}">
                                                        <option>Skill</option>
                                                        <option selected="selected">Mentee</option>
                                                        <option>Mentor</option>
                                                        <option>Message</option>
                                                        <option>Request</option></c:when>
                                                    <c:when test="${category == 'Skill'}">
                                                        <option  selected="selected">Skill</option>
                                                        <option>Mentee</option>
                                                        <option>Mentor</option>
                                                        <option>Message</option>
                                                        <option>Request</option></c:when>
                                                    <c:when test="${category == 'Mentor'}">
                                                        <option>Skill</option>
                                                        <option>Mentee</option>
                                                        <option  selected="selected">Mentor</option>
                                                        <option>Message</option>
                                                        <option>Request</option></c:when>
                                                    <c:when test="${category == 'Request'}">
                                                        <option>Skill</option>
                                                        <option>Mentee</option>
                                                        <option>Mentor</option>
                                                        <option>Message</option>
                                                        <option selected="selected">Request</option></c:when>
                                                    <c:when test="${category == 'Message'}">
                                                        <option>Skill</option>
                                                        <option>Mentee</option>
                                                        <option>Mentor</option>
                                                        <option selected="selected">Message</option>
                                                        <option>Request</option></c:when>
                                                </c:choose>
                                            </select>
                                            <input type="text" class="searchTerm" placeholder="What are you looking for?" name="txtSearch" value="${txt}" >
                                            <button type="submit" class="searchButton"> <img src="img/search.svg"></button>
                                        </form>
                                    </div>
                                </li>
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

            <section class="inner-page">
                <div class="container-scroller">
                    <div class="container-fluid page-body-wrapper" style="padding-top: 20px;">
                        <!-- partial -->
                        <!-- partial:../../partials/_sidebar.html -->
                        <nav class="sidebar sidebar-offcanvas" id="sidebar">
                            <ul class="nav">
                                <li class="nav-item">
                                    <a class="nav-link" href="adminDashboard.jsp">
                                        <i class="icon-grid menu-icon"></i>
                                        <span class="menu-title">Dashboard</span>
                                    </a>
                                </li>
                                <!--SKILL MANAGEMENT-->
                                <li class="nav-item">
                                    <a class="nav-link" href="MentorManagementController">
                                        <i class="icon-columns menu-icon"></i>
                                        <span class="menu-title">Mentor Management</span>
                                    </a>
                                </li>
                                <!--Mentor MANAGEMENT-->
                                <li class="nav-item">
                                    <a class="nav-link" href="mentorManagement">
                                        <i class="icon-columns menu-icon"></i>
                                        <span class="menu-title">Mentor Management</span>
                                    </a>
                                </li>
                                <!--Mentee MANAGEMENT-->
                                <li class="nav-item">
                                    <a class="nav-link" href="menteeManagement">
                                        <i class="icon-columns menu-icon"></i>
                                        <span class="menu-title">Mentee Management</span>
                                    </a>
                                </li>
                                <!--Request MANAGEMENT-->
                                <li class="nav-item">
                                    <a class="nav-link" href="requestManagement">
                                        <i class="icon-columns menu-icon"></i>
                                        <span class="menu-title">Request Management</span>
                                    </a>
                                </li>
                                <!--Message MANAGEMENT-->
                                <li class="nav-item">
                                    <a class="nav-link" href="MessageControllerMap?service=getMessage">
                                        <i class="icon-columns menu-icon"></i>
                                        <span class="menu-title">Message Management</span>
                                    </a>
                                </li>
                                <!--Forum MANAGEMENT-->
                                <li class="nav-item">
                                    <a class="nav-link" href="forumManagement">
                                        <i class="icon-columns menu-icon"></i>
                                        <span class="menu-title">Forum Management</span>
                                    </a>
                                </li>
                            </ul>
                        </nav>
                        <!-- partial -->

                        <div class="main-panel">

                            <div class="content-wrapper">
                                <div class="row">
                                </div>
                                <div class="row">

                                    <div class="col-md-6 grid-margin transparent">
                                        <div class="row">
                                            <p><a href="MessageControllerMap?service=getMessage">< Back</a></p>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6 mb-4 mb-lg-0 stretch-card transparent">
                                                <c:forEach items="${listMess}" var="message">
                                                    <button class="create"> <a href="MessageControllerMap?service=deleteMessage&mId=${message.mId}" style="color: white"> Delete </a></button>
                                                </div>

                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-lg-12 grid-margin stretch-card">
                                                <div class="card">
                                                    <div class="card-body">
                                                        <div class="row" style="margin: 10px 15px 15px 15px;">
                                                            <div class="col-sm-3">
                                                                <h6 class="mb-0">ID</h6>
                                                            </div>
                                                            <div class="col-sm-9 text-secondary" style="color: black">
                                                                ${message.mId}
                                                            </div>
                                                        </div>
                                                        <hr>
                                                        <div class="row" style="margin: 15px;" >
                                                            <div class="col-sm-3">
                                                                <h6 class="mb-0">Title</h6>
                                                            </div>
                                                            <div class="col-sm-9 text-secondary">
                                                                <c:out value="${message.title}"></c:out>
                                                                </div>
                                                            </div>
                                                            <hr>
                                                            <div class="row" style="margin: 15px;">
                                                                <div class="col-sm-3">
                                                                    <h6 class="mb-0">Email</h6>
                                                                </div>
                                                                <div class="col-sm-9 text-secondary">
                                                                <c:out value="${message.email}"></c:out>
                                                                </div>
                                                            </div>
                                                            <hr>
                                                            <div class="row" style="margin: 15px;">
                                                                <div class="col-sm-3">
                                                                    <h6 class="mb-0" >Content</h6>
                                                                </div>
                                                                <div class="col-sm-9 text-secondary">
                                                                <c:out value=" ${message.content}"></c:out>
                                                                </div>
                                                            </div>
                                                            <hr>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>

                                    </c:forEach>





                                </div>

                                <!-- content-wrapper ends -->
                                <!-- partial:../../partials/_footer.html -->

                                <!-- partial -->

                                <!-- main-panel ends -->
                            </div>
                            <!-- page-body-wrapper ends -->
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

                        <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i class="bi bi-arrow-up-short"></i></a>

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
                        <style>.create {
                                height: 50px;
                                width: 180px;
                                background:red;
                                border-radius: 0;
                                color: #fff;
                                cursor: pointer;
                                display: inline-block;
                                padding:  10px;
                                font-weight: bold;
                                margin-left: 0px;
                                border-radius: 25px;
                                border: none;

                            }

                            a.active {
                                background-color: #8dc2fe ;
                                color: #026adf;
                                font-weight: bold;
                            }

                        </style>
                        </body>

                        </html>