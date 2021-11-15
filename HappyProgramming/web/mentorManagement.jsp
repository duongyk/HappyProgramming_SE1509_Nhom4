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

        <title>Mentor Management</title>
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
        <link href="css/requestByMe.css" rel="stylesheet">
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
                                                    </c:when>
                                                    <c:when test="${category == 'Mentee'}">
                                                        <option>Skill</option>
                                                        <option selected="selected">Mentee</option>
                                                        <option>Mentor</option>
                                                        <option>Message</option>
                                                    </c:when>
                                                    <c:when test="${category == 'Skill'}">
                                                        <option  selected="selected">Skill</option>
                                                        <option>Mentee</option>
                                                        <option>Mentor</option>
                                                        <option>Message</option>
                                                    </c:when>
                                                    <c:when test="${category == 'Mentor'}">
                                                        <option>Skill</option>
                                                        <option>Mentee</option>
                                                        <option  selected="selected">Mentor</option>
                                                        <option>Message</option>
                                                    </c:when>

                                                    <c:when test="${category == 'Message'}">
                                                        <option>Skill</option>
                                                        <option>Mentee</option>
                                                        <option>Mentor</option>
                                                        <option selected="selected">Message</option>
                                                    </c:when>
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
                    <!-- partial:partials/_navbar.html -->
                    <div class="container-fluid page-body-wrapper">
                        <nav class="sidebar sidebar-offcanvas" id="sidebar">
                            <ul class="nav">
                                <li class="nav-item">
                                    <a class="nav-link" href="adminDashboard">
                                        <i class="icon-grid menu-icon"></i>
                                        <span class="menu-title">Dashboard</span>
                                    </a>
                                </li>
                                <!--SKILL MANAGEMENT-->
                                <li class="nav-item">
                                    <a class="nav-link" href="skillManagement">
                                        <i class="icon-columns menu-icon"></i>
                                        <span class="menu-title">Skill Management</span>
                                    </a>
                                </li>
                                <!--Mentor MANAGEMENT-->
                                <li class="nav-item">
                                    <a class="nav-link" href="MentorManagementController">
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
                                    <div class="col-md-6 grid-margin stretch-card">
                                        <div class="card tale-bg">
                                            <div class="card-people mt-auto" style="padding: 0">
                                                <img style="min-width: 300px; min-height:250px " src="img/2.png">

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
                                                        <p class="mb-4">Total Mentor </p>
                                                        <p class="fs-30 mb-2"><c:out value="${mentorList.size()}"></c:out></p>
                                                            <p></p>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="col-md-6 mb-4 stretch-card transparent">
                                                    <div class="card card-dark-blue">
                                                        <div class="card-body">
                                                            <p class="mb-4">Total Requested Hours To All Mentor</p>
                                                            <p class="fs-30 mb-2"><c:out value=" ${totalRequestedHour}"></c:out></p>
                                                            <p></p>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="row">
                                                <div class="col-md-6 mb-4 mb-lg-0 stretch-card transparent">
                                                    <div class="card card-light-blue">
                                                        <div class="card-body">
                                                            <p class="mb-4">Total Requests To All Mentor </p>
                                                            <p class="fs-30 mb-2"><c:out value=" ${numberOfRequest}"></c:out></p>
                                                            <p></p>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-12 grid-margin stretch-card">
                                            <div class="card">
                                                <div class="card-body">

                                                    <div class="table-responsive">
                                                        <table class="table table-striped table-borderless">
                                                            <thead>
                                                                <tr>
                                                                    <th>ID</th>
                                                                    <th>Fullname</th>
                                                                    <th>Username</th>
                                                                    <th>Email</th>
                                                                    <th style="padding-left: 50px;">Status</th>
                                                                </tr>
                                                            </thead>
                                                            <tbody>
                                                            <c:forEach items="${mentorList}" var="mentor">
                                                                <tr>
                                                                    <td>
                                                                        <c:out value="${mentor.id}"></c:out>
                                                                        </td>    
                                                                        <td>
                                                                            <a href="UserProfileController?uId=${mentor.id}"><c:out value="${mentor.fullname}"></c:out></a>
                                                                        </td>
                                                                        <td>
                                                                        <c:out value=" ${mentor.username}"></c:out>
                                                                        </td>
                                                                        <td>
                                                                        <c:out value="${mentor.mail}"></c:out>
                                                                        </td>

                                                                        <td>
                                                                        <c:if test="${mentor.status==1}">
                                                                            <a href="UpdateMentorStatusController?uId=${mentor.id}&&status=1" class="btn btn-success" > Activate </a>

                                                                        </c:if>
                                                                        <c:if test="${mentor.status==0}">
                                                                            <a href="UpdateMentorStatusController?uId=${mentor.id}&&status=0" class="btn btn-danger" > Deactivate </a>
                                                                        </c:if>
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
                                <%-- Paging --%>
                                <c:if test="${!empty mentorList}">
                                    <div class="row">  
                                        <div class="paging">
                                            <%-- Previous --%>
                                            <%-- Previous --%>
                                            <c:choose>
                                                <c:when test="${index>1}">
                                                    <a class="previous" href="${href}index=${index-1}"><</a>
                                                </c:when>
                                                <c:otherwise>
                                                    <a class="previous disabled" href="${href}index=${index-1}"><</a>
                                                </c:otherwise>
                                            </c:choose>
                                            <%-- Page index --%>
                                            <c:forEach begin="1" end="${endPage}" var="page">
                                                <c:choose>
                                                    <c:when test="${index==page}">
                                                        <a class="choose disabled" href="${href}index=${page}"> ${page}</a> 
                                                    </c:when>
                                                    <c:otherwise>
                                                        <a href="${href}index=${page}"> ${page}</a> 
                                                    </c:otherwise>
                                                </c:choose>
                                            </c:forEach>
                                            <%-- Next --%>
                                            <c:choose>
                                                <c:when test="${index!=endPage}">
                                                    <a class="next" href="${href}index=${index+1}">  ></a>
                                                </c:when>
                                                <c:otherwise>
                                                    <a class="next disabled" href="${href}index=${index+1}">></a>
                                                </c:otherwise>
                                            </c:choose>
                                        </div> 
                                    </div>
                                </c:if>
                                <%-- End Paging --%>                            
                            </div>
                        </div>
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