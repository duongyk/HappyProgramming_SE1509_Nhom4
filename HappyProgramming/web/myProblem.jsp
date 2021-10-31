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
<html>
    <head>
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">

        <title>Forum Page</title>
        <meta content="" name="description">
        <meta content="" name="keywords">

        <link href="img/favicon.png" rel="icon">
        <link href="img/apple-touch-icon.png" rel="apple-touch-icon">

        <link href="vendor/aos/aos.css" rel="stylesheet">
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
        <link href="vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
        <link href="vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
        <link href="vendor/remixicon/remixicon.css" rel="stylesheet">
        <link href="vendor/swiper/swiper-bundle.min.css" rel="stylesheet">

        <!-- Template Main CSS File -->
        <link href="css/style.css" rel="stylesheet">

        <link href="css/login.css" rel="stylesheet">
        <link href="css/forum.css" rel="stylesheet">
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
                                </li><li><a class="nav-link scrollto" href="openChat">Messenger</a></li>
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
                    <div class="col-md-2"></div>
                    <%-- Title  --%>
                    <div class="col-md-8 section-title">
                        <h2 class="">My Problem</h2>
                        <c:if test="${messSucc!=null}">
                            <h1 style="color:#29cc49;font-weight: bold;text-align: center"><c:out value="${messSucc}"></c:out></h1>
                        </c:if>
                    </div>
                    <div class="col-md-2"></div>
                </div>
                <div class="row">
                    <%-- Button  --%>
                    <div class="col-md-2">
                        <c:if test="${sessionScope.currUser!=null}">
                            <div><a href="myProblem"><button class="myProblem" style="min-width: 164px;">My Problem</button></a> </div> 
                            <div><a href="postProblem"><button class="myProblem" style="min-width: 164px;">Post Problem</button></a> </div> 
                        </c:if> 
                    </div>
                    <div class="col-md-7">
                        <%-- Problem list  --%>
                        <c:choose>
                            <%-- Problem list not empty --%>
                            <c:when test="${!empty pList}">
                                <c:set var="i" scope="session" value="0"/>
                                <c:forEach items="${pList}" var="p" >
                                    <c:if test="${p.status==0}">
                                        <div class="problem pro-close" onclick="location.href = 'viewProblem?pId=${p.getId()}';" id="smallbox">
                                        </c:if>
                                        <c:if test="${p.status==1}">
                                            <div class="problem pro-open" onclick="location.href = 'viewProblem?pId=${p.getId()}';" id="smallbox">
                                            </c:if>
                                            <h2>${p.getFrom().getFullname()}</h2>
                                            <h2 class="text-bold">${p.getTitle()}</h2>
                                            <h3>${p.getContent()}</h3>
                                            <div class="row" style="padding-top:10px;">
                                                <div class="col-md-6">
                                                    <p class="">${p.toString()}</p>
                                                </div>
                                                <c:if test="${answerNumber[i]==0}">
                                                    <div class="col-md-6">
                                                        <p class="time-right">No answer yet!</p>
                                                    </div>
                                                </c:if>
                                                <c:if test="${answerNumber[i]==1}">
                                                    <div class="col-md-6">
                                                        <p class="time-right">1 answer</p>
                                                    </div>
                                                </c:if>
                                                <c:if test="${answerNumber[i]>1}">
                                                    <div class="col-md-6">
                                                        <p class="time-right">${answerNumber[i]} answers</p>
                                                    </div>
                                                </c:if>
                                            </div>
                                        </div>
                                        <c:set var="i" scope="session" value="${i+1}"/>
                                    </c:forEach>
                                </c:when>
                                <%-- Problem list empty  --%>
                                <c:otherwise>
                                    <h2>Looks like you have not had any problem! Try to post one!</h2>
                                </c:otherwise>
                            </c:choose>
                        </div>
                        <div class="col-md-2 imagee">
                            <img src="img/forum3.png">
                        </div>
                        <div class="col-md-1"></div>
                    </div>
                </div>          

                <%-- Paging --%>
                <c:if test="${!empty pList}">
                    <div class="row">  
                        <div class="paging">
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


</html>
