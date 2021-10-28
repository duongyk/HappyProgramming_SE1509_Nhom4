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

        <title>List Suggested Mentor Page</title>
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
        <link href="css/allMentor.css" rel="stylesheet">
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
                        <li><a class="nav-link scrollto" href="listAllMentor">All mentors</a></li>
                        <li><a class="nav-link scrollto" href="SkillControllerMap?service=allSkill">All skills</a></li>
                        <li><a class="nav-link scrollto" href="forum">Forum</a></li>
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

                    </div>
                    <%-- Title  --%>
                    <div class="col-md-8 section-title">
                        <h2 class="">List Suggested Mentor</h2>
                    </div>
                    <div class="col-md-2 filter-box"  style="padding-bottom: 20px;">
                        <h2>Filter by:</h2><hr>
                        <%-- Status filter  --%>
                        <div class="">
                            <c:choose>
                                <c:when test="${filter==1}">
                                    <a class="status-filter1 red-text" href="listSuggestedMentor?filter=1">Your Requested Skills</a><br>
                                    <a class="status-filter1" href="listSuggestedMentor?filter=2">Top Rating</a><br>
                                    <a class="status-filter1" href="listSuggestedMentor?filter=3">Top Popular</a><br>
                                    <a class="status-filter1" href="listSuggestedMentor?filter=4">Top Multi-Skill</a><br>
                                </c:when>

                                <c:when test="${filter==2}">
                                    <a class="status-filter1" href="listSuggestedMentor?filter=1">Your Requested Skills</a><br>
                                    <a class="status-filter1 red-text" href="listSuggestedMentor?filter=2">Top Rating</a><br>
                                    <a class="status-filter1" href="listSuggestedMentor?filter=3">Top Popular</a><br>
                                    <a class="status-filter1" href="listSuggestedMentor?filter=4">Top Multi-Skill</a><br>
                                </c:when>
                                <c:when test="${filter==3}">
                                    <a class="status-filter1" href="listSuggestedMentor?filter=1">Your Requested Skills</a><br>
                                    <a class="status-filter1" href="listSuggestedMentor?filter=2">Top Rating</a><br>
                                    <a class="status-filter1 red-text" href="listSuggestedMentor?filter=3">Top Popular</a><br>
                                    <a class="status-filter1" href="listSuggestedMentor?filter=4">Top Multi-Skill</a><br>
                                </c:when>
                                <c:when test="${filter==4}">
                                    <a class="status-filter1" href="listSuggestedMentor?filter=1">Your Requested Skills</a><br>
                                    <a class="status-filter1" href="listSuggestedMentor?filter=2">Top Rating</a><br>
                                    <a class="status-filter1" href="listSuggestedMentor?filter=3">Top Popular</a><br>
                                    <a class="status-filter1 red-text" href="listSuggestedMentor?filter=4">Top Multi-Skill</a><br>
                                </c:when>
                            </c:choose>
                        </div>
                    </div>


                </div>

                <div class="row">
                    <div class="col-md-2"></div>
                    <div class="col-md-6"></div>
                    <div class="col-md-2"></div>
                    <div class="col-md-2"></div>
                </div>          
                <div class="container">

                    <div class="row">
                        <%-- Check if list Mentor empty or not --%>
                        <c:choose>
                            <%-- List Mentor empty --%>
                            <c:when test="${empty mList}">
                                <h1 class="no-req">  No Mentor suitable for you yet! </h1>
                            </c:when>
                            <c:otherwise>
                                <%-- List Mentor not empty --%>
                                
                                <c:choose>
                                    <%-- Filter by Rating, Show Rating --%>
                                    <c:when test="${filter==2}">
                                        <c:set var="i" scope="session" value="0"/>
                                        <c:forEach items="${mList}" var="mentor">
                                            <div class="col-lg-3 col-md-6">
                                                <div class="member member-1 box-display" data-aos="fade-up" data-aos-delay="100">
                                                    <div class="member-img">
                                                        <div class="title1">Rating: <c:out value="${ratingList[i]}"></c:out>
                                                            </div>
                                                        </div>
                                                        <img class="img-display" src="img/default-image.jpg">
                                                        <div class="member-info">
                                                            <h4><c:out value="${mentor.getFullname()}"></c:out></h4>
                                                        <a class="view-button" href="CVControllerMap?service=cvMentor&mId=${mentor.getId()}">View CV</a>
                                                    </div>
                                                </div>
                                            </div>
                                                    <c:set var="i" scope="session" value="${i+1}"/>
                                        </c:forEach>
                                    </c:when>
                                    <%-- Filter by Number of Request, Show number of Request --%>
                                    <c:when test="${filter==3}">
                                        <c:set var="i" scope="session" value="0"/>
                                        <c:forEach items="${mList}" var="mentor">
                                            <div class="col-lg-3 col-md-6">
                                                <div class="member member-1 box-display" data-aos="fade-up" data-aos-delay="100">
                                                    <div class="member-img">
                                                        <div class="title1">Number of Request: <c:out value="${requestNumberList[i]}"></c:out>
                                                            </div>
                                                        </div>
                                                        <img class="img-display" src="img/default-image.jpg">
                                                        <div class="member-info">
                                                            <h4><c:out value="${mentor.getFullname()}"></c:out></h4>
                                                        <a class="view-button" href="CVControllerMap?service=cvMentor&mId=${mentor.getId()}">View CV</a>
                                                    </div>
                                                </div>
                                            </div>
                                                    <c:set var="i" scope="session" value="${i+1}"/>
                                        </c:forEach>
                                    </c:when>
                                    <%-- Filter by number of Skill, Show number of Skill --%>
                                    <c:when test="${filter==4}">
                                        <c:set var="i" scope="session" value="0"/>
                                        <c:forEach items="${mList}" var="mentor">
                                            <div class="col-lg-3 col-md-6">
                                                <div class="member member-1 box-display" data-aos="fade-up" data-aos-delay="100">
                                                    <div class="member-img">
                                                        <div class="title1">Number of Skill: <c:out value="${skillNumberList[i]}"></c:out>
                                                            </div>
                                                        </div>
                                                        <img class="img-display" src="img/default-image.jpg">
                                                        <div class="member-info">
                                                            <h4><c:out value="${mentor.getFullname()}"></c:out></h4>
                                                        <a class="view-button" href="CVControllerMap?service=cvMentor&mId=${mentor.getId()}">View CV</a>
                                                    </div>
                                                </div>
                                            </div>
                                        <c:set var="i" scope="session" value="${i+1}"/>
                                        </c:forEach>
                                    </c:when>
                                    <c:otherwise>
                                        <%-- Filter by Skill in Request --%>
                                        <c:forEach items="${mList}" var="mentor">
                                            <div class="col-lg-3 col-md-6">
                                                <div class="member member-2 box-display" data-aos="fade-up" data-aos-delay="100">
                                                    <div class="member-img">
                                                        <img class="img-display" src="img/default-image.jpg">
                                                        <div class="member-info">
                                                            <h4><c:out value="${mentor.getFullname()}"></c:out></h4>
                                                            <a class="view-button-2" href="CVControllerMap?service=cvMentor&mId=${mentor.getId()}">View CV</a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </c:forEach>
                                    </c:otherwise>
                                </c:choose>
                            </div>

                        </c:otherwise>
                    </c:choose>
                </div>
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
