<%-- 
  Copyright (C) 2021, FPT University<br>
  SWP391 - SE1509 - Group 4<br>
  Happyprogramming<br>
 
  Record of change:<br>
  DATE          Version    Author           DESCRIPTION<br>
  20-10-2021    1.0        DuongVV          First Deploy<br>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">

        <title>Statistic Request Page</title>
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
                        <li><a class="nav-link scrollto" href="forum">Forum</a></li>
                        <li><a class="nav-link scrollto" href="listAllMentor">All mentors</a></li>
                        <li><a class="nav-link scrollto" href="ListAllSkillController">All skills</a></li>
                        
                            <c:choose>
                                <c:when test="${sessionScope.currUser!=null}">
                                    
                                    <li><a class="nav-link scrollto" href="openChat">Messenger</a></li>
                                    <c:choose>
                                        <c:when test="${sessionScope.currUser.getRole()==2}">                       
                                        <li class="dropdown getstarted scrollto " style="background:#0dcaf0">
                                            <span style="color: white; padding: 0;">View Request</span>
                                            <ul>
                                                <li><a class="nav-link scrollto" href="viewMentorRequest?status=1">Inviting Request</a>
                                                </li>
                                                <li><a class="nav-link scrollto" href="viewMentorRequest?status=2">Following Request</a>
                                                </li>
                                            </ul>
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
                                        <li><a href="changePassword.jsp">Change pass</a></li>
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
        <main id="main" class="section-bg">
            <section class="breadcrumbs">
                <div class="container">
                </div>
            </section>
            <%-- Page Title --%>
            <div class="row">
                <div class="col-md-2"></div>
                <div class="col-md-8 section-title title-1">
                    <h2>Statistic Request</h2>
                </div>
                <div class="col-md-2"></div>
            </div>

            <div class="row">
                <div class="col-md-2"></div>
                <div class="col-md-6">
                    <section id="team" class="team displayy">
                        <%-- Request Detail --%>
                        <div class="row">

                            <c:choose>
                                <c:when test="${statistic[0]>0}">
                                    <div class="col-md-8">
                                        <h1>Hello <c:out value="${user.getFullname()}"></c:out> 
                                            </h1>
                                            <br><br>
                                        <h2>Here are your Statistic Request: </h2>
                                        <h5>(Click the number for detail)</h5><br>
                                        <h4>Total Request:<a class="" href="listRequestByMe"> ${statistic[0]}</a></h4>
                                        <h4>Total Mentor: ${statistic[1]}</h4>
                                        <h4>Total Hour: ${statistic[2]}</h4>
                                        <h4>Total Pending Request:<a class="" href="requestByStatus?status=1"> ${statistic[3]}</a></h4>
                                        <h4>Total In-process Request:<a class="" href="requestByStatus?status=2"> ${statistic[4]}</a></h4>
                                        <h4>Total Done Request:<a class="" href="requestByStatus?status=3"> ${statistic[5]}</a></h4>
                                        <h4>Total Canceled Request:<a class="" href="requestByStatus?status=4"> ${statistic[6]}</a></h4>

                                    </div>
                                    <div class="col-md-4">
                                    </div> 
                                </c:when>
                                <c:otherwise>
                                    <div class="col-md-8">
                                        <h1>Hello <c:out value="${user.getFullname()}"></c:out> </h1>
                                            <br><br>
                                            <h2>Looks like you have not had any Request yet! </h2>
                                        </div>
                                        <div class="col-md-4"></div> 
                                </c:otherwise>
                            </c:choose>



                        </div>
                    </section>
                </div>
                <div class="col-md-3">
                    <div class="statistic">
                        <img  src="img/statistic.png">
                    </div>
                </div>
                <div class="col-md-1"></div>
            </div>
            <div class="row last">
                <div class="col-md-2"></div>
                <div class="col-md-6"></div>
                <div class="col-md-2"></div> 
                <div class="col-md-2"></div>
            </div>

        </main>
        <%-- Footer --%>
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
        </footer>
        <%-- End Footer --%>

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

    </body>

</html>