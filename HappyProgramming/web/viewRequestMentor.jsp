<%-- 
    Document   : viewRequest
    Created on : Oct 5, 2021, 8:34:18 PM
    Author     : Duong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">

        <title>Request Details Page</title>
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
                            <%-- Check the current User --%>
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
                                    <c:otherwise>
                                        <li><a class="nav-link scrollto" href="listRequestByMe">Request</a>
                                        </li>
                                    </c:otherwise>
                                </c:choose>
                                <li class="dropdown getstarted scrollto ">
                                    <span style="color: white; padding: 0;">User</span>
                                    <ul>
                                        <li><a href="UserProfile?uId=${sessionScope.currUser.id}">Profile</a></li>
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
                </nav>

            </div>
        </header>
        <%-- End Header --%>
        <main id="main" class="section-bg">
            <section class="breadcrumbs">
                <div class="container">
                </div>
            </section>
            <%-- Page Title --%>
            <div class="row">
                <div class="col-md-2"></div>
                <div class="col-md-8 section-title title-1">
                    <h2>Request Detail</h2>
                </div>
                <div class="col-md-2"></div>
            </div>

            <div class="row">
                <div class="col-md-2"></div>
                <div class="col-md-8">
                    <section id="team" class="team displayy">
                        <%-- Request Detail --%>
                        <div class="row">
                            <div class="col-md-5">
                                <h3>Mentee: ${req.from.fullname} <a href="openChat?friendId=${req.from.id}" style="color:green;">Begin Chat </a></h3>
                                <br><br>
                                <p>Deadline Date: ${req.deadlineDate}</p>
                                <p>Hour: ${req.deadlineHour}</p>
                                <div>Status:
                                    <c:if test="${req.status==1}">
                                        <span class="status">Inviting</span>
                                    </c:if>
                                    <c:if test="${req.status==2}">
                                        <span class="status">Following</span>
                                    </c:if>
                                    <c:if test="${req.status==3}">
                                        <span class="status">Done</span>
                                    </c:if>
                                    <c:if test="${req.status==4}">
                                        <span class="status">Canceled</span>
                                    </c:if>
                                </div>
                                <br><br>
                                <div><h3>Skill:</h3>
                                    <c:forEach items="${sList}" var="s" varStatus="loop">
                                        <c:if test="${s.status==1}">
                                            <c:choose>
                                                <c:when test="${loop.last}">
                                                    <label class="form-check-label">${s.getName()}</label>
                                                </c:when>
                                                <c:otherwise>
                                                    <label class="form-check-label">${s.getName()},</label>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:if>
                                    </c:forEach>
                                </div>

                            </div>
                            <div class="col-md-1"></div>
                            <div class="col-md-6 vl">

                                <h3>Title: ${req.title}</h3><br>
                                <h3>Content:</h3>
                                <div class="content-req">
                                    <p>${req.content}</p>
                                </div>

                            </div>
                        </div>

                    </section>
                </div>
                <div class="col-md-2"> </div>
            </div>
            <div class="row last">
                <div class="col-md-2"></div>
                <div class="col-md-4">
                    <%-- Message --%>
                    <div class="mess">
                        <c:if test="${mess!=null}">
                            <c:out value="${mess}"></c:out>
                        </c:if>
                    </div>
                </div>
                    <c:choose> 
                        <c:when test="${req.status==1}">
                <div class="col-md-2"><a href="updateMentorRequestStatus?rid=${req.getId()}&status=2"><button class="create" style="min-width: 164px;background-color:#009900;">Accept request</button></a> </div> 
                <div class="col-md-2"><a href="updateMentorRequestStatus?rid=${req.getId()}&status=4"><button class="create" style="min-width: 164px;background-color:#ff0000;">Reject request</button></a> </div>
                        </c:when>
                    <c:otherwise>
                        <div class="col-md-2"></div>
                        <div class="col-md-2"></div>
                    </c:otherwise>
                    </c:choose>
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