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
                    <h1><a href="AdminControllerMap?service=dashboard">Vesperr</a></h1>
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
                                        <li><a href="AdminControllerMap?service=dashboard">Dashboard</a></li>
                                        <li><a href="UserControllerMap?service=logOut">Log out</a></li>
                                    </ul>
                                </li>
                            </c:when>
                            <c:otherwise>
                                <li class="dropdown getstarted scrollto "><a href="SignIn.jsp" style="color: white; padding: 0;">
                                        <span>Sign in</span></a>
                                    <ul>
                                        <li><a href="SignUp.jsp">Sign up</a>
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
                                    <a class="nav-link" href="AdminControllerMap?service=requestManage">
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
                            </ul>
                        </nav>
                        <!-- partial -->

                        <div class="main-panel">

                            <div class="content-wrapper">
                                <div class="row">
                                </div>
                                <div class="row">
                                    <div class="col-md-6 grid-margin stretch-card">
                                        <div class="card tale-bg">
                                            <div class="card-people mt-auto" style="padding: 0">
                                                <img style="min-width: 300px; min-height:250px " src="img/Message.png">

                                                <div class="weather-info">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-6 grid-margin transparent">
                                        <div class="row">
                                            <div class="col-md-6 mb-4 stretch-card transparent">
                                                <div class="card card-tale">
                                                    <div class="card-body">
                                                        <p class="mb-4">Total Messages </p>
                                                        <p class="fs-30 mb-2"><c:out value="${sList2.size()}"></c:out></p>
                                                            <p></p>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-6 mb-4 stretch-card transparent">
                                                    <div class="card card-dark-blue">
                                                        <div class="card-body">
                                                            <p class="mb-4">Unread Messages</p>
                                                            <p class="fs-30 mb-2"><c:out value="${menteeList.size()}"></c:out></p>
                                                            <p></p>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>



                                        <div class="row">
                                            <div class="col-lg-12 grid-margin stretch-card">
                                                <div class="card">
                                                    <div class="card-body">
                                                        <div class="table-responsive">
                                                            <table class="table table-striped">
                                                                <thead>
                                                                    <tr>
                                                                        <th>
                                                                            ID
                                                                        </th>
                                                                        <th>
                                                                            Title
                                                                        </th>
                                                                        <th>
                                                                            Email
                                                                        </th>

                                                                        <th>
                                                                            Is read
                                                                        </th>

                                                                    </tr>
                                                                </thead>
                                                                <tbody>
                                                                <c:forEach items="${listMess}" var="message">
                                                                    <tr>
                                                                        <td>
                                                                            ${message.mId}
                                                                        </td>
                                                                        <td>
                                                                            <a href="MessageControllerMap?service=viewMessage&mId=${message.mId}">   ${message.title}</a>
                                                                        </td>
                                                                        <td>
                                                                            <c:out value="${message.email}"></c:out>

                                                                            </td>
                                                                            <td>
                                                                            ${message.isRead}
                                                                        </td>

                                                                    </tr>
                                                                </c:forEach>

                                                            </tbody>
                                                        </table>

                                                    </div>
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
                        <style>.create {
                                height: 50px;
                                width: 180px;
                                background:rgb(84, 142, 228);
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