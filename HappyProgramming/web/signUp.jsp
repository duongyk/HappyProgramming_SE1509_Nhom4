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

        <title>Sign up page</title>
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
        <link href="css/login.css" rel="stylesheet">
        <link href="css/createRequest.css" rel="stylesheet">

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
                        <li><a class="nav-link scrollto" href="listAllMentor">All mentors</a></li>
                        <li><a class="nav-link scrollto" href="SkillControllerMap?service=allSkill">All skills</a></li>
                            <c:choose>
                                <c:when test="${sessionScope.currUser!=null}">
                                <li><a class="nav-link scrollto" href="listRequestByMe">Request</a>
                                </li>
                                <li class="dropdown getstarted scrollto ">
                                    <span style="color: white; padding: 0;">User</span>
                                    <ul>
                                        <li><a href="UserControllerMap?service=profile">Profile</a></li>
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
                    <h2 class="title" style="color: black; font-weight: bold;">Sign up </h2>
                </div>
            </section><!-- End Breadcrumbs Section -->

            <section class="inner-page">
                <div class="container">
                    <div class="wrapper wrapper--w790">
                        <div class="card card-5">

                            <div class="card-body">
                                <form action="Signup" method="POST">
                                   
                                    <div class="form-row m-b-55">
                                        <div class="name">Name</div>
                                        <div class="value">
                                            <div class="row row-space">
                                                <div class="col-12">
                                                    <div class="input-group-desc">
                                                        <input class="input-white" type="text" name="username" required="required">
                                                        <!--                          <label class="label--desc">User Name</label>-->
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="form-row">
                                        <div class="name">Email</div>
                                        <div class="value">
                                            <div class="input-group">
                                                <input class="input-white" type="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" title="Email pattern: abcxyz@abcxyz.domain" name="mail">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-row">
                                        <div class="name">password</div>
                                        <div class="value">
                                            <div class="input-group">
                                                <input class="input-white" type="password" pattern="^(?=.*[a-z])(?=.*\d)[a-zA-Z\d]{8,}$"title="Minimum of eight characters, at least one uppercase letter, one lowercase letter, and one number" name="password">
                                            </div>
                                        </div>
                                    </div>
                                  
                                    <div class="form-row">
                                        <div class="name">repeat password</div>
                                        <div class="value">
                                            <div class="input-group">
                                                <input class="input-white" type="password" pattern="^(?=.*[a-z])(?=.*\d)[a-zA-Z\d]{8,}$"title="Minimum of eight characters, at least one uppercase letter, one lowercase letter, and one number" name="confirm">
                                            </div>
                                        </div>
                                    </div>
                                      <div class="form-row">
                                        <div class="name">Full Name</div>
                                        <div class="value">
                                            <div class="input-group">
                                                <input class="input-white" type="text" pattern=".*\S+.*" title="No white space only" maxlength="30" name="fullname">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-row m-b-55">
                                        <div class="name">Phone</div>
                                        <div class="value">
                                            <div class="row row-refine">

                                                <div class="col-12">
                                                    <div class="input-group-desc">
                                                        <input class="input-white" type="text" pattern="[0-9]{9,11}" title="phone with 9 to 11 number" name="phone">
                                                        <label class="label--desc">Phone Number</label>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-row">
                                        <div class="name">Sex</div>
                                        <select id="select-6004" name="sex" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white">
                                            <option value="Male">Male</option>
                                            <option value="Female">Female</option>
                                        </select>
                                    </div>
                                    <div class="form-row">
                                        <label for="text-13e0" class="name">Date of birth</label>
                                        <input  class="input-white" type="date"  name="dob" >
                                    </div>
                                    <div class="form-row">
                                        <div class="name">Sign up to </div>
                                        <div class="value">
                                            <div class="input-group">
                                                <div class="rs-select2 js-select-simple select--no-search">
                                                    <select name="role">
                                                        <option disabled="disabled" selected="selected">Choose a role</option>
                                                        <option value="2">Mentor</option>
                                                        <option value="1">Mentee</option>
                                                    </select>
                                                    <div class="select-dropdown"></div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div>
                                        <button class="btn btn--radius-2 btn--red" type="submit">Register</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </section>

        </main><!-- End #main -->

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
                    </div

                    <div class="col-lg-5 col-md-12" data-aos="fade-up" data-aos-delay="300">






                        <!--MAP-->
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