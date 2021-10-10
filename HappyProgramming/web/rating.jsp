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

        <title>Inner Page - Vesperr Bootstrap Template</title>
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
        <link href="css/style.css" rel="stylesheet">
        <link href="css/login.css" rel="stylesheet">
        <link href="css/rating.css" rel="stylesheet">
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
                        <li><a class="nav-link scrollto" href="UserControllerMap?service=listAllmentor">All mentors</a></li>
                        <li><a class="nav-link scrollto" href="SkillControllerMap?service=allSkill">All skills</a></li>
                            <c:choose>
                                <c:when test="${sessionScope.currUser!=null}">
                                <li><a class="nav-link scrollto" href="RequestControllerMap?service=listRequestByMe">Request</a>
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
                </nav><!-- .navbar-main -->

            </div>
        </header><!-- End Header -->

        <!-- ======= Hero Section ======= -->


        <main id="main">

            <!-- ======= Breadcrumbs Section ======= -->
            <section class="breadcrumbs">
                <div class="card-heading">

                </div>
            </section><!-- End Breadcrumbs Section -->
            <!-- Main Body -->
            <section>
                <div class="container">
                    <div class="row">
                        <div class="col-sm-5 col-md-6 col-12 pb-4">
                            <h1>Comments</h1>
                            <c:choose>
                                <c:when test="${empty listRating}">
                                    <h2>No comments yet!</h2>
                                </c:when>
                                <c:otherwise>
                                    <c:forEach items="${listRating}" var="rating"> 
                                        <div class="comment mt-4 text-justify float-left">
                                            <h4>${rating.from.fullname}</h4> <span>-${rating.toString()} | ${rating.rateAmount}/5</span> <br>
                                            <p style="padding-bottom: 13px;"><c:out value="${rating.comment}"></c:out>
                                            </p>
                                            <c:if test="${(mess!=null)&&(rating.from.id==sessionScope.currUser.id)}">
                                                <h5 class="mess">${mess}</h5>
                                            </c:if>
                                        </div>
                                    </c:forEach>
                                </c:otherwise>
                            </c:choose>

                        </div>
                        <div class="col-lg-4 col-md-5 col-sm-4 offset-md-1 offset-sm-1 col-12 mt-4 " style="margin-left: 210px;">
                            <h1 class="mentor-name">Mentor: ${mentor.fullname} </h1>
                            <div class="avatar">
                                <img class="avt" width="150px" height="270px"
                                     src="img/default-avatar.png">
                            </div>
                            <%-- Average rating --%>
                            <c:if test = "${!empty listRating}">
                                <h6 class="u-text u-text-font u-text-3">Rating: ${avg}/5</h6>
                            </c:if>
                            <c:if test="${sessionScope.currUser!=null}">

                                <div class="form-cmt">
                                    <form id="algin-form" action="RatingControllerMap" method="POST">
                                        <input type="hidden" name="mId" value="${mId}">
                                        <input type="hidden" name="service" value="rateMentor">
                                        <div class="rate">
                                            <input type="radio" id="star5" name="rate" value="1"/>
                                            <label for="star5" title="1 star"></label>
                                            <input type="radio" id="star4" name="rate" value="2"/>
                                            <label for="star4" title="2 star"></label>
                                            <input type="radio" id="star3" name="rate" value="3"/>
                                            <label for="star3" title="3 star"></label>
                                            <input type="radio" id="star2" name="rate" value="4"/>
                                            <label for="star2" title="4 star"></label>
                                            <input type="radio" id="star1" name="rate" value="5" required/>
                                            <label for="star1" title="5 star"></label>
                                        </div><br>
                                        <label for="select-d713" class="mess">${messBlank}</label><br>

                                        <div class="form-group">
                                            <h4>Leave a comment</h4> 
                                            <textarea name="comment" id="" msg cols="30" rows="5" class="form-control " maxlength="200" required></textarea>
                                        </div>
                                        <div class="form-group">
                                            <button class="btn btn--radius-2 btn--green" type="submit">Post</button>
                                        </div>
                                    </form>
                                </div>
                            </c:if>
                        </div>
                    </div>
                </div>
            </section>

            <!-- ======= Contact Section ======= -->
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
                        </div>

                        <div class="col-lg-5 col-md-12" data-aos="fade-up" data-aos-delay="300">






                            <!--MAP-->
                        </div>

                    </div>

                </div>
            </section><!-- End Contact Section -->

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