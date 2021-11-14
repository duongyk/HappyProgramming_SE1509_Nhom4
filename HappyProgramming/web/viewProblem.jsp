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
        <link href='https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css' rel='stylesheet'>
        <link href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css' rel='stylesheet'>
        <script type='text/javascript' src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>
        <title>View Problem Page</title>
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

        <script type="text/javascript" src="js/checkSpace.js" ></script>
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
        <main id="main" style="background-color: #f7fbfe;">
            <section class="breadcrumbs" style="background-color:#f8f8f8 ">
                <div class="container">
                    
                </div>
            </section>
            <div class="container mt-5 mb-5">
                <div class="row">
                    <div class="col-md-2"></div>
                    <%-- Title  --%>
                    <div class="col-md-8 section-title">
                        <h2 class="">View Problem</h2>
                    </div>
                    <div class="col-md-2"></div>
                </div>
                <div class="d-flex justify-content-center row" >
                    <div class="d-flex flex-column col-md-8" >
                        <div class="d-flex flex-row align-items-center text-left comment-top p-2 bg-white border-bottom px-4">
                            <div class="d-flex flex-column ml-3">
                                <div class="post-title">
                                    <span class="titlee">${problem.getTitle()}</span>
                                    <%-- Check Problem belong to User --%>
                                    <c:choose>
                                        <%-- Problem belong to User --%>
                                        <c:when test="${sessionScope.currUser.getId()==problem.getFrom().getId()}">
                                            <c:if test="${problem.getStatus()==0}">
                                                <span class="closed">(Closed)</span>   
                                                <a href="activeProblem?pId=${problem.getId()}">Re-open</a>
                                            </c:if>
                                            <c:if test="${problem.getStatus()==1}">
                                                <span class="opening">(Opening)</span>   
                                                <a href="activeProblem?pId=${problem.getId()}">Close</a>
                                            </c:if>
                                        </c:when>
                                        <%-- Check Problem not belong to User --%>
                                        <c:otherwise>
                                            <c:if test="${problem.getStatus()==0}">
                                                <span class="closed">(Closed)</span>   
                                            </c:if>
                                            <c:if test="${problem.getStatus()==1}">
                                                <span class="opening">(Opening)</span>   
                                            </c:if>
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                                    <%-- Problem display --%>
                                <div class="d-flex flex-row align-items-center align-content-center post-title">
                                    <span class="mr-2 comments">${problem.getFrom().getFullname()}&nbsp;</span>
                                    <span class="mr-2 dot"></span>
                                    <span>${answerNumber} comment(s) &nbsp; </span>
                                    <span class="mr-2 dot"></span>
                                    <span>${problem.toString()}</span></div>
                                <div class="content-pro">${problem.getContent()}</div> 
                            </div>
                        </div>

                        <div class="coment-bottom bg-white p-2 px-4" style="height: 700px">
                            <%-- Check User and Problem's Status --%>
                            <c:if test="${sessionScope.currUser!=null && problem.getStatus()==1}">
                                <form action="postAnswer" method="POST">
                                    <input type="hidden" name="pId" value="${problem.getId()}">
                                    <div class="d-flex flex-row add-comment-section mt-4 mb-4">
                                        <%-- Comment box --%>        
                                        <textarea class="form-control mr-3" id="content" type="text" name="content" placeholder="Your Answer" onkeyup="checkSpace()" maxlength="200" required  rows="4" cols="55"></textarea>
                                        <button class="btn btn-primary" id="button" type="submit">Comment</button>
                                    </div>
                                </form>
                                <%-- Message for checkSpace --%>
                                <p id="text-space" style="display:none; color:red;font-weight: bold;">Input contains only space</p>
                                <p id="text-space-1" style="color:white;">Valid input</p>
                            </c:if>
                            <c:choose>
                                <%-- Problem's Answer list --%>
                                <c:when test="${!empty paList}">
                                    <div class="">
                                        <h3>Answer(s):</h3>
                                    </div>
                                    <c:forEach items="${paList}" var="a" >  

                                        <div class="commented-section mt-2 cmtt">
                                            <div class="d-flex flex-row align-items-center commented-user">
                                                <h5 class="mr-2">${a.getFrom().getFullname()}</h5><span class="dot mb-1"></span><span class="mb-1 ml-2">${a.toString()}</span>
                                            </div>
                                            <div class="comment-text-sm"><span>${a.getContent()}</span></div>
                                        </div>
                                    </c:forEach> 
                                </c:when>
                                <%-- Problem have no Answers--%>
                                <c:otherwise>
                                    <div class="no-answer">
                                        <h3>Look likes no one having the Answer! Maybe later !</h3>
                                    </div>
                                </c:otherwise>
                            </c:choose>
                            <%-- Paging --%>
                            <c:if test="${!empty paList}">
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
                        </div>
                    </div>
                </div>
            </div>
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
        <script type='text/javascript' src='https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js'></script>
        <style>body {
                background-color: #eee
            }
            .titlee{
                font-size: 30px;
                color: black;
                text-transform: none;
                font-weight: bold
            }

            .closed{
                font-size: 30px;
                color: red;
                text-transform: none;
                font-weight: bold
            }

            .opening{
                font-size: 30px;
                color: green;
                text-transform: none;
                font-weight: bold
            }

            .bdge {
                height: 21px;
                background-color: orange;
                color: #fff;
                font-size: 11px;
                padding: 8px;
                border-radius: 4px;
                line-height: 3px
            }

            .comments {
                text-decoration: underline;
                text-underline-position: under;
                cursor: pointer
            }

            .dot {
                height: 7px;
                width: 7px;
                margin-top: 3px;
                background-color: #bbb;
                border-radius: 50%;
                display: inline-block
            }

            .hit-voting:hover {
                color: blue
            }

            .hit-voting {
                cursor: pointer

            }
            .mr-2 {
                font-weight: bold;
            }

            .cmtt {
                border-radius: 5px;
                background-color: #ddd;
            }
        </style>
</html>
