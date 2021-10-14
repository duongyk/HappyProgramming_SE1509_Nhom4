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

        <title>Vesperr Bootstrap Template - Index</title>
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

        <script type="text/javascript" src="js/myFunction.js" ></script>
        <script type="text/javascript" src="js/checkSpace.js" ></script>
        <!-- Template Main CSS File -->
        <link href="css/style.css" rel="stylesheet">
        <link href="css/login.css" rel="stylesheet">
        <link href="css/createRequest.css" rel="stylesheet">
    </head>

    <body>

        <%-- Header --%>
        <header id="header" class="fixed-top d-flex align-items-center" style="background-color:#e2f5fde0;">
            <div class="container d-flex align-items-center justify-content-between">

                <div class="logo">
                    <h1><a href="index.jsp">Vesperr</a></h1>
                    <!-- Uncomment below if you prefer to use an image logo -->
                    <!-- <a href="index.html"><img src="img/logo.png" alt="" class="img-fluid"></a>-->
                </div>

                <nav id="navbar-main" class="navbar-main">
                    <ul>
                        <li><a class="nav-link scrollto" href="UserControllerMap?service=listAllmentor">All mentors</a></li>
                        <li><a class="nav-link scrollto" href="SkillControllerMap?service=allSkill">All skills</a></li>
                            <%-- Check the current User --%>    
                            <c:choose>
                                <c:when test="${sessionScope.currUser!=null}">
                                <li><a class="nav-link scrollto" href="RequestControllerMap?service=listRequestByMe">Request</a>
                                </li>
                                <li class="dropdown getstarted scrollto ">
                                    <span style="color: white; padding: 0;">User</span>
                                    <ul>
                                        <li><a href="UserControllerMap?service=profile">Profile</a></li>
                                        <li><a href="UserControllerMap?service=logOut">Log out</a></li>
                                    </ul>
                                </li>
                            </c:when>
                        </c:choose>
                    </ul>
                    <i class="bi bi-list mobile-nav-toggle"></i>
                </nav>

            </div>
        </header>

        <%-- End Header --%>
        <%-- Main --%>

        <main id="main">

            <section class="breadcrumbs">
                <div class="card-heading">
                    <h2 class="title" style="color: black; font-weight: bold;">Update Request </h2>
                </div>

                <section class="inner-page">
                    <div class="container">
                        <div class="wrapper wrapper--w790">
                            <div class="card card-5">
                                <div class="card-body">
                                    <%-- Check the status of Request for display --%>
                                    <c:choose>
                                        <%-- Status = 1 --%>
                                        <c:when test="${req.getStatus()==1}">
                                            <form action="RequestControllerMap?service=updateRequest" method="POST">
                                                <input type="hidden" name="rId" value="${req.id}">
                                                <%-- Title --%>
                                                <div class="form-row m-b-55">
                                                    <div class="name">Title</div>
                                                    <div class="value">
                                                        <div class="row row-space">
                                                            <div class="col-12">
                                                                <div class="input-group-desc">
                                                                    <input class="input-white" type="text" name="title" placeholder="Your Request Title" pattern=".*\S+.*" title="No white space only" maxlength="100" value="${req.getTitle()}" required>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>

                                                <%-- Content --%>
                                                <div class="form-row">
                                                    <div class="name">Content</div>
                                                    <div class="value">
                                                        <div class="input-group">
                                                            <textarea class="input-white" id="content" type="text" name="content" maxlength="200" required  rows="3" cols="54" onkeyup="checkSpace()"><c:out value="${req.getContent()}"></c:out></textarea>
                                                            </div>
                                                        </div>
                                                            <div class="input-group">
                                                                <%-- Message for checkSpace --%>
                                                                <p id="text-space" style="display:none; color:red">Content contains only space</p>
                                                                <p id="text-space-1" style="color:white;">aaaaa</p>
                                                            </div>
                                                    </div>

                                                <%-- Deadline Date --%>
                                                <div class="form-row">
                                                    <div class="name">Deadline Date</div>
                                                    <div class="value">
                                                        <div class="input-group">
                                                            <input class="input-white" type="date" id="date" value="<c:out value="${req.deadlineDate}"></c:out>" name="deadlineDate" required>
                                                            </div>
                                                        </div>
                                                    </div>

                                                <%-- Deadline Hour --%>
                                                <div class="form-row">
                                                    <div class="name">Deadline Hour</div>
                                                    <div class="value">
                                                        <div class="input-group">
                                                            <input class="input-white" type="number" min="1" max="12" value="<c:out value="${req.deadlineHour}"></c:out>" placeholder="The time you want to request" name="deadlineHour" required>
                                                            </div>
                                                        </div>
                                                    </div>

                                                <%-- Mentor --%>
                                                <div class="form-row">
                                                    <div class="name">Choose Mentor</div>
                                                    <div class="value">
                                                        <div class="input-group">
                                                            <select id="select-6004" name="toId" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white">
                                                                <c:forEach items="${mList}" var="mentor">
                                                                    <c:choose>
                                                                        <c:when test="${mentor.getId()==req.getFrom().getId()}">
                                                                            <option value="${mentor.getId()}" selected> ${mentor.getFullname()} </option>
                                                                        </c:when>
                                                                        <c:otherwise>
                                                                            <option value="${mentor.getId()}"> ${mentor.getFullname()} </option>
                                                                        </c:otherwise>
                                                                    </c:choose>
                                                                </c:forEach>
                                                            </select>
                                                        </div>
                                                    </div>
                                                </div>
                                                <%-- Status --%>
                                                <div class="form-row">
                                                    <div class="name">Status</div>
                                                    <div class="value">
                                                        <select name="status" required="required">
                                                            <option value="1" selected>Pending</option>
                                                            <option value="4">Cancel</option>
                                                        </select>
                                                    </div>
                                                </div>
                                                <%-- Skill --%>
                                                <div class="form-row m-b-55">
                                                    <div class="name">Choose Skills</div>
                                                    <div class="value">
                                                        <div class="row row-refine">
                                                            <div class="row">
                                                                <div class="col-12">
                                                                    <ul>
                                                                        <c:set var="continueBox" scope="session" value="false"/>
                                                                        <c:forEach items="${sListAll}" var="skill">
                                                                            <c:forEach items="${sList}" var="s">
                                                                                <c:if test="${s.id==skill.id}">
                                                                                    <c:set var="continueBox" scope="session" value="true"/>
                                                                                </c:if>
                                                                            </c:forEach>
                                                                            <c:choose>
                                                                                <c:when test="${sessionScope.continueBox}">
                                                                                    <li>
                                                                                        <input class="form-check-input" type="checkbox" id="select" name="skill" value="${skill.getId()}" checked onchange="myFunction()">
                                                                                        <label class="form-check-label" style="word-wrap:break-word" for="${skill.getId()}">${skill.getName()}</label>
                                                                                    </li>
                                                                                </c:when>
                                                                                <c:otherwise>
                                                                                    <li>
                                                                                        <input class="form-check-input" type="checkbox" id="select" name="skill" value="${skill.getId()}" onchange="myFunction()">
                                                                                        <label class="form-check-label" style="word-wrap:break-word" for="${skill.getId()}">${skill.getName()}</label>
                                                                                    </li>
                                                                                </c:otherwise>
                                                                            </c:choose>
                                                                            <c:set var="continueBox" scope="session" value="false"/>
                                                                        </c:forEach>
                                                                    </ul>
                                                                </div>
                                                                <%-- Message for checkbox --%>
                                                                <p id="text" style="display:none; color:red">Please choose at least 1 skill and at max 3 skills</p>
                                                                <p id="text-1" style="color:white;">aaaaa</p>
                                                            </div>
                                                        </div>

                                                    </div>
                                                </div>

                                                <div class="row">
                                                    <div class="col-3"></div>
                                                    <div class="col-6">
                                                        <button id="button" class="btn btn--radius-2 btn--red" type="submit">Update Request</button>
                                                    </div>
                                                    <div class="col-3"></div>
                                                </div>
                                            </form>

                                        </c:when>
                                        <%-- Request's Status = 2 (Processing) -> Cancel only --%>
                                        <c:otherwise>

                                            <form action="RequestControllerMap?service=updateRequest" method="POST">
                                                <input type="hidden" name="rId" value="${req.id}">
                                                <div class="only"> You can only Cancel In-process Request!</div>
                                                <%-- Title --%>
                                                <div class="form-row m-b-55">

                                                    <div class="name">Title</div>
                                                    <div class="value">
                                                        <div class="row row-space">
                                                            <div class="col-12">
                                                                <div class="input-group-desc">
                                                                    <input class="input-readonly" type="text" name="title" placeholder="Your Request Title" pattern=".*\S+.*" title="No white space only" maxlength="100" value="${req.getTitle()}" readonly>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>

                                                <%-- Content --%>
                                                <div class="form-row">
                                                    <div class="name">Content</div>
                                                    <div class="value">
                                                        <div class="input-group">
                                                            <textarea class="input-readonly" type="text" name="content" placeholder="Your Request Content" pattern=".*\S+.*" title="No white space only" maxlength="200" readonly  rows="3" cols="54"><c:out value="${req.getContent()}"></c:out></textarea>
                                                            </div>
                                                        </div>
                                                    </div>

                                                <%-- Deadline Date --%>
                                                <div class="form-row">
                                                    <div class="name">Deadline Date</div>
                                                    <div class="value">
                                                        <div class="input-group">
                                                            <input class="input-readonly" type="date" id="date" value="<c:out value="${req.deadlineDate}"></c:out>" name="deadlineDate" readonly>
                                                            </div>
                                                        </div>
                                                    </div>

                                                <%-- Deadline Hour --%>
                                                <div class="form-row">
                                                    <div class="name">Deadline Hour</div>
                                                    <div class="value">
                                                        <div class="input-group">
                                                            <input class="input-readonly" type="number" min="1" max="12" value="<c:out value="${req.deadlineHour}"></c:out>" placeholder="The time you want to request" name="deadlineHour" readonly>
                                                            </div>
                                                        </div>
                                                    </div>

                                                <%-- Mentor --%>
                                                <div class="form-row">
                                                    <div class="name">Mentor</div>
                                                    <div class="value">
                                                        <div class="input-group">
                                                            <input class="input-readonly" value="<c:out value="${req.getTo().getFullname()}"></c:out>" readonly>
                                                            </div>
                                                        </div>
                                                    </div>
                                                <%-- Status --%>
                                                <div class="form-row">
                                                    <div class="name">Status</div>
                                                    <div class="value">
                                                        <select name="status" required="required">
                                                            <option value="1" selected>Processing</option>
                                                            <option value="4">Cancel</option>
                                                        </select>
                                                    </div>
                                                </div>
                                                <%-- Skill --%>
                                                <div class="form-row m-b-55">
                                                    <div class="name"> Skills</div>
                                                    <div class="value">
                                                        <c:forEach items="${sList}" var="s" begin="0" end="${sList.size()-2}">
                                                            <c:if test="${s.status==1}">
                                                                <label class="form-check-label">${s.getName()},</label>
                                                            </c:if>
                                                        </c:forEach>
                                                        <c:forEach items="${sList}" var="s" begin="${sList.size()-1}" end="${sList.size()-1}">
                                                            <c:if test="${s.status==1}">
                                                                <label class="form-check-label">${s.getName()}</label>
                                                            </c:if>
                                                        </c:forEach>  
                                                    </div>
                                                </div>

                                                <div class="row">
                                                    <div class="col-4"></div>
                                                    <div class="col-5">
                                                        <button class="btn btn--radius-2 btn--red submit-button" type="submit">Update Request</button>
                                                    </div>
                                                    <div class="col-3"></div>
                                                </div>
                                            </form>
                                        </div>
                                    </c:otherwise>
                                </c:choose>

                            </div>
                        </div>
                    </div>
                    </div>
                </section>

        </main>
        <%-- End Main --%>


        <section id="contact" class="contact" style="background-color: white;">
            <div class="container">

                <div class="section-title" data-aos="fade-up">
                    <h2>Contact Us</h2>
                </div>

                <div class="row">

                    <div class="col-lg-4 col-md-6" data-aos="fade-up" data-aos-delay="100">
                        <div class="contact-about">
                            <h3>Vesperr</h3>
                            <p>Cras fermentum odio eu feugiat. Justo eget magna fermentum iaculis eu non diam phasellus. Scelerisque
                                felis imperdiet proin fermentum leo. Amet volutpat consequat mauris nunc congue.</p>
                            <div class="social-links">
                                <a href="#" class="twitter"><i class="bi bi-twitter"></i></a>
                                <a href="#" class="facebook"><i class="bi bi-facebook"></i></a>
                                <a href="#" class="instagram"><i class="bi bi-instagram"></i></a>
                                <a href="#" class="linkedin"><i class="bi bi-linkedin"></i></a>
                            </div>
                        </div>
                    </div>

                    <div class="col-lg-3 col-md-6 mt-4 mt-md-0" data-aos="fade-up" data-aos-delay="200">
                        <div class="info">
                            <div>
                                <i class="ri-map-pin-line"></i>
                                <p>A108 Adam Street<br>New York, NY 535022</p>
                            </div>

                            <div>
                                <i class="ri-mail-send-line"></i>
                                <p>info@example.com</p>
                            </div>

                            <div>
                                <i class="ri-phone-line"></i>
                                <p>+1 5589 55488 55s</p>
                            </div>

                        </div>
                    </div

                    <div class="col-lg-5 col-md-12" data-aos="fade-up" data-aos-delay="300">



                        <!--MAP-->
                    </div>

                </div>


        </section>
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
    <!--Pick Deadline Date from today-->  
    <script>
                                                                                            var date = new Date();
                                                                                            var d = date.getDate();
                                                                                            var m = date.getMonth() + 1;
                                                                                            if (d < 10) {
                                                                                                d = '0' + d;
                                                                                            }
                                                                                            if (m < 10) {
                                                                                                m = '0' + m;
                                                                                            }
                                                                                            var y = date.getFullYear();
                                                                                            var min = y + "-" + m + "-" + d;
                                                                                            document.getElementById("date").setAttribute('min', min);
    </script>
</html>