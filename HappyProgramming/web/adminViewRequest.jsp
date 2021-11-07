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

        <title>Skill management</title>
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

                                <li class="dropdown getstarted scrollto ">
                                    <span style="color: white; padding: 0;">Admin </span>
                                    <ul>
                                        <li><a href="adminDashboard">Dashboard</a></li>
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
                                    <a class="nav-link" href="AdminControllerMap?service=skillManage">
                                        <i class="icon-columns menu-icon"></i>
                                        <span class="menu-title">Skill Management</span>
                                    </a>
                                </li>
                                <!--Mentor MANAGEMENT-->
                                <li class="nav-item">
                                    <a class="nav-link" href="AdminControllerMap?service=mentorManage">
                                        <i class="icon-columns menu-icon"></i>
                                        <span class="menu-title">Mentor Management</span>
                                    </a>
                                </li>
                                <!--Mentee MANAGEMENT-->
                                <li class="nav-item">
                                    <a class="nav-link" href="AdminControllerMap?service=menteeManage">
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
                                    <div class="row">
                                        <div class="col-lg-12 grid-margin stretch-card">
                                            <div class="card">
                                                <div class="card-body">
                                                    <div class="row" style="margin: 15px;">
                                                        <div class="col-sm-3">
                                                            <h6 class="mb-0">Title</h6>
                                                        </div>
                                                        <div class="col-sm-9 text-secondary">
                                                            <c:out value="${req.title}"></c:out>
                                                            </div>
                                                        </div>
                                                        <hr>
                                                        <div class="row" style="margin: 10px 15px 15px 15px;">
                                                            <div class="col-sm-3">
                                                                <h6 class="mb-0">To Mentor</h6>
                                                            </div>
                                                            <div class="col-sm-9 text-secondary" style="color: black">
                                                                <a href="UserProfileController?uId=${req.to.id}">${req.to.fullname}</a>
                                                        </div>
                                                    </div>
                                                    <hr>
                                                    <div class="row" style="margin: 15px;" >
                                                        <div class="col-sm-3">
                                                            <h6 class="mb-0">Deadline Date:</h6>
                                                        </div>
                                                        <div class="col-sm-9 text-secondary">
                                                            <c:out value="${req.deadlineDate}"></c:out>
                                                            </div>
                                                        </div>
                                                        <hr>
                                                        <div class="row" style="margin: 15px;">
                                                            <div class="col-sm-3">
                                                                <h6 class="mb-0">Hour:</h6>
                                                            </div>
                                                            <div class="col-sm-9 text-secondary">
                                                            <c:out value="${req.deadlineHour}"></c:out>
                                                            </div>
                                                        </div>
                                                        <hr>
                                                        <div class="row" style="margin: 15px;">
                                                            <div class="col-sm-3">
                                                                <h6 class="mb-0" >Status</h6>
                                                            </div>
                                                            <div class="col-sm-9 text-secondary">
                                                            <c:if test="${req.status==1}">
                                                                <span class="status">Pending</span>
                                                            </c:if>
                                                            <c:if test="${req.status==2}">
                                                                <span class="status">In-Process</span>
                                                            </c:if>
                                                            <c:if test="${req.status==3}">
                                                                <span class="status">Done</span>
                                                            </c:if>
                                                            <c:if test="${req.status==4}">
                                                                <span class="status">Canceled</span>
                                                            </c:if>
                                                        </div>
                                                    </div>
                                                    <hr>
                                                    <div class="row" style="margin: 15px;">
                                                        <div class="col-sm-3">
                                                            <h6 class="mb-0">Skill:</h6>
                                                        </div>
                                                        <div class="col-sm-9 text-secondary">
                                                            <c:forEach items="${sList}" var="s" varStatus="loop">
                                                                <c:if test="${s.status==1}">
                                                                    <c:choose>
                                                                        <c:when test="${loop.last}">
                                                                            <label class="skill">${s.getName()}</label>
                                                                        </c:when>
                                                                        <c:otherwise>
                                                                            <label class="skill">${s.getName()},</label>
                                                                        </c:otherwise>
                                                                    </c:choose>
                                                                </c:if>
                                                            </c:forEach>
                                                        </div>
                                                    </div>
                                                    <hr>
                                                    <div class="row" style="margin: 15px;">
                                                        <div class="col-sm-3">
                                                            <h6 class="mb-0">Title</h6>
                                                        </div>
                                                        <div class="col-sm-9 text-secondary">
                                                            <c:out value="${req.title}"></c:out>
                                                            </div>
                                                        </div>
                                                        <hr>
                                                        <div class="row" style="margin: 15px;">
                                                            <div class="col-sm-3">
                                                                <h6 class="mb-0">Content:</h6>
                                                            </div>
                                                            <div class="col-sm-9 text-secondary">
                                                            <c:out value="${req.content}"></c:out>
                                                        </div>
                                                    </div>
                                                    <hr>
                                                </div>
                                            </div>
                                        </div>
                                    </div>







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

                        </body>

                        </html>