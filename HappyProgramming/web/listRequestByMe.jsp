<%-- 
  Copyright (C) 2021, FPT University<br>
  SWP391 - SE1509 - Group 4<br>
  Happyprogramming<br>
 
  Record of change:<br>
  DATE          Version    Author           DESCRIPTION<br>
  20-09-2021    1.0        DuongVV          First Deploy<br>
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">

        <title>List Request by me Page</title>
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

        <link href="css/style.css" rel="stylesheet">
        <link href="css/popup.css" rel="stylesheet">
        <link href="css/requestByMe.css" rel="stylesheet">
    </head>

    <body>

        <%-- Header --%>
        <header id="header" class="fixed-top d-flex align-items-center" style="background-color:#e2f5fde0;">
            <div class="container d-flex align-items-center justify-content-between">

                <div class="logo">
                    <h1><a href="index.jsp">Vesperr</a></h1>
                </div>

                <nav id="navbar-main" class="navbar-main">
                    <ul>
                        <li><a class="nav-link scrollto" href="listAllmentor">All mentors</a></li>
                        <li><a class="nav-link scrollto" href="SkillControllerMap?service=allSkill">All skills</a></li>
                            <%-- Check current User --%>
                            <c:choose>
                                <c:when test="${sessionScope.currUser!=null}">
                                <li><a class="nav-link scrollto" href="listRequestByMe">Request</a>
                                </li>
                                <li class="dropdown getstarted scrollto ">
                                    <span style="color: white; padding: 0;">User</span>
                                    <ul>
                                        <li><a href="UserControllerMap?service=profile&uId=${sessionScope.currUser.id}">Profile</a></li>
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
                </nav>
            </div>
        </header>
        <%-- End header --%>
        <%-- Main --%>
        <main id="main">
            <section class="breadcrumbs">
                <div class="container">
                </div>
            </section>
            <section id="team" class="team section-bg">
                <div class="row">
                    <div class="col-md-2">
                        <div><a href="RequestControllerMap?service=loadRequest"><button class="create" style="min-width: 164px;">Create Request</button></a> </div> 
                        <input class="popup" name="modal" type="checkbox" id="modal">
                        <%-- Statistic reuquest button --%>
                        <label for="modal" class="label-show-modal">Statistic Request</label>
                        <div class="modal-show" style="z-index: 3;">
                            <div class="modal-show-inner">
                                <label for="modal">&#10006;</label>
                                <h2 class="text-center">Statistic Request</h2>
                                <p class="text-left">Total Request: ${statistic[0]}</p>
                                <p class="text-left">Total Mentor: ${statistic[1]}</p>
                                <p class="text-left">Total Hour: ${statistic[2]}</p>
                                <p class="text-left">Total Pending Request: ${statistic[3]}</p>
                                <p class="text-left">Total In-process Request: ${statistic[4]}</p>
                                <p class="text-left">Total Done Request: ${statistic[5]}</p>
                                <p class="text-left">Total Canceled Request: ${statistic[6]}</p>
                            </div>
                        </div>
                    </div>
                    <%-- Title  --%>
                    <div class="col-md-8 section-title padding-bottom">
                        <h2 class="">List Request by me</h2>
                    </div>
                    <div class="col-md-2 filter-box"  style="padding-bottom: 20px;">
                        <h2>Filter by Status</h2><hr>
                        <%-- Status filter  --%>
                        <div class="">
                            <label class="label">Status</label>
                            <c:choose>
                                <c:when test="${status==1}">
                                    <a class="status-filter1" href="listRequestByMe">All</a><br>
                                    <a class="status-filter underline" href="requestByStatus?status=1">Pending</a><br>
                                    <a class="status-filter" href="requestByStatus?status=2">Processing</a><br>
                                    <a class="status-filter" href="requestByStatus?status=3">Done</a><br>
                                    <a class="status-filter" href="requestByStatus?status=4">Canceled</a>
                                </c:when>

                                <c:when test="${status==2}">
                                    <a class="status-filter1" href="listRequestByMe">All</a><br>
                                    <a class="status-filter" href="requestByStatus?status=1">Pending</a><br>
                                    <a class="status-filter underline" href="requestByStatus?status=2">Processing</a><br>
                                    <a class="status-filter" href="requestByStatus?status=3">Done</a><br>
                                    <a class="status-filter" href="requestByStatus?status=4">Canceled</a>
                                </c:when>
                                <c:when test="${status==3}">
                                    <a class="status-filter1" href="listRequestByMe">All</a><br>
                                    <a class="status-filter" href="requestByStatus?status=1">Pending</a><br>
                                    <a class="status-filter" href="requestByStatus?status=2">Processing</a><br>
                                    <a class="status-filter underline" href="requestByStatus?status=3">Done</a><br>
                                    <a class="status-filter" href="requestByStatus?status=4">Canceled</a>
                                </c:when>
                                <c:when test="${status==4}">
                                    <a class="status-filter1" href="listRequestByMe">All</a><br>
                                    <a class="status-filter" href="requestByStatus?status=1">Pending</a><br>
                                    <a class="status-filter" href="requestByStatus?status=2">Processing</a><br>
                                    <a class="status-filter" href="requestByStatus?status=3">Done</a><br>
                                    <a class="status-filter underline" href="requestByStatus?status=4">Canceled</a>
                                </c:when>
                                <c:otherwise>
                                    <a class="status-filter1 underline" href="listRequestByMe">All</a><br>
                                    <a class="status-filter" href="requestByStatus?status=1">Pending</a><br>
                                    <a class="status-filter" href="requestByStatus?status=2">Processing</a><br>
                                    <a class="status-filter" href="requestByStatus?status=3">Done</a><br>
                                    <a class="status-filter" href="requestByStatus?status=4">Canceled</a>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div> 
                </div>

                </div>


                <div class="container">
                    <%-- List Request--%>
                    <div class="row">
                        <%-- Check if list Request empty or not --%>
                        <c:choose>
                            <%-- List Request empty --%>
                            <c:when test="${empty rList}">
                                <h1 class="no-req">  No Request yet! </h1>
                            </c:when>
                            <c:otherwise>
                                <%-- List Request not empty --%>
                                <c:forEach items="${rList}" var="request">
                                    <div class="col-lg-3 col-md-6">
                                        <div class="member box-display" data-aos="fade-up" data-aos-delay="100">
                                            <div class="member-img">
                                                <c:if test="${request.status==1}">
                                                    <div class="title1"> Status: Pending
                                                    </div>
                                                </c:if>
                                                <c:if test="${request.status==2}">
                                                    <div class="title1"> Status: In process
                                                    </div>
                                                </c:if>
                                                <c:if test="${request.status==3}">
                                                    <div class="title1"> Status: Done
                                                    </div>
                                                </c:if>
                                                <c:if test="${request.status==4}">
                                                    <div class="title1"> Status: Canceled
                                                    </div>
                                                </c:if>
                                            </div>
                                            <img class="img-display" src="img/default-image.jpg">
                                            <div class="member-info">
                                                <h4><c:out value="${request.title}"></c:out></h4>
                                                <a class="view-button" href="viewRequest?rId=${request.id}">View detail</a>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <%-- Paging --%>
                    <c:if test="${!empty rList}">
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
                </div>
            </section>
        </main>
        <%-- End main --%>
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