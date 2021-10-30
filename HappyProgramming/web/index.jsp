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

        <title>Vesperr</title>
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
                        <li><a class="nav-link scrollto" href="listAllMentor">All mentors</a></li>
                        <li><a class="nav-link scrollto" href="ListAllSkillController">All skills</a></li>
                        <li><a class="nav-link scrollto" href="forum">Forum</a></li>
                            <c:choose>
                                <c:when test="${sessionScope.currUser!=null}">
                                    <li><a class="nav-link scrollto" href="openChat">Messenger</a></li>
                                    <c:choose>
                                        <c:when test="${sessionScope.currUser.getRole()==2}">
                                        <li><a class="nav-link scrollto" href="viewMentorRequestStatistic">Statistic</a>
                                        </li>
                                        <li><a class="nav-link scrollto" href="viewMentorRatingStatistic">Rating</a>
                                        </li>
                                        <li><a class="nav-link scrollto" href="viewMentorRequest?status=1">Inviting Request</a>
                                        </li>
                                        <li><a class="nav-link scrollto" href="viewMentorRequest?status=2">Following Request</a>
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
                                        <li><a href="ChangePassword">Change pass</a></li>
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

        <!-- ======= Hero Section ======= -->
        <section id="hero" class="d-flex align-items-center">

            <div class="container">
                <div class="row">
                    <div class="col-lg-6 pt-5 pt-lg-0 order-2 order-lg-1 d-flex flex-column justify-content-center">
                        <h1 data-aos="fade-up">Make it work <br>
                            Make it right<br>
                            Make it fast.</h1>
                        <h2 data-aos="fade-up" data-aos-delay="400" style="  margin-top: 40px;  font-size: 18px;">
                        </h2>
                    </div>
                    <div class="col-lg-6 order-1 order-lg-2 hero-img" data-aos="fade-left" data-aos-delay="200">
                        <img src="img/hero-img.png" class="img-fluid animated" alt="">
                    </div>
                </div>
            </div>

        </section><!-- End Hero -->

        <main id="main">

            <!-- ======= About Us Section ======= -->
            <section id="about" class="about" style="padding-top: 0;">
                <div class="container">

                    <div class="section-title" data-aos="fade-up">
                        <h2>About Us</h2>
                    </div>

                    <div class="row content">
                        <div class="col-lg-6" data-aos="fade-up" data-aos-delay="150">
                            <p>
                                Vesperr is a system which mainly allows mentors, mentees
                                and other actors to connect online and mentees to learn programming.

                            </p>
                            <ul>
                                <li><i class="ri-check-double-line"></i> All free</li>
                                <li><i class="ri-check-double-line"></i> Easy to use and manipulate</li>
                                <li><i class="ri-check-double-line"></i>Provide quality courses</li>
                            </ul>
                        </div>
                        <div class="col-lg-6 pt-4 pt-lg-0" data-aos="fade-up" data-aos-delay="300">
                            <p>
                                We was founded in 2020 with a vision of providing life-transforming learning experiences to learners around
                                the world. Today, Vespper is a global online learning platform that offers anyone, anywhere, access to
                                online courses and degrees from leading universities and companies. Vespper received B Corp certification
                                in February 2021, which means that we have a legal duty not only to our shareholders, but to also make a
                                positive impact on society more broadly, as we continue our efforts to reduce barriers to world-class
                                education for all.
                            </p>
                            <a href="#" class="btn-learn-more">Learn More</a>
                        </div>
                    </div>

                </div>
            </section><!-- End About Us Section -->
            <!-- ======= Services Section ======= -->
            <section id="services" class="services">
                <div class="container">

                    <div class="section-title" data-aos="fade-up">
                        <h2>Services</h2>

                    </div>

                    <div class="row">
                        <div class="col-md-6 col-lg-3 d-flex align-items-stretch mb-5 mb-lg-0">
                            <div class="icon-box" data-aos="fade-up" data-aos-delay="100">
                                <div class="icon"><i class="bx bxl-dribbble"></i></div>
                                <h4 class="title"><a href="">
                                        Study</a></h4>
                                <p class="description">Voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi</p>
                            </div>
                        </div>

                        <div class="col-md-6 col-lg-3 d-flex align-items-stretch mb-5 mb-lg-0">
                            <div class="icon-box" data-aos="fade-up" data-aos-delay="200">
                                <div class="icon"><i class="bx bx-file"></i></div>
                                <h4 class="title"><a href="">Study</a></h4>
                                <p class="description">Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore</p>
                            </div>
                        </div>

                        <div class="col-md-6 col-lg-3 d-flex align-items-stretch mb-5 mb-lg-0">
                            <div class="icon-box" data-aos="fade-up" data-aos-delay="300">
                                <div class="icon"><i class="bx bx-tachometer"></i></div>
                                <h4 class="title"><a href="">Study</a></h4>
                                <p class="description">Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia</p>
                            </div>
                        </div>

                        <div class="col-md-6 col-lg-3 d-flex align-items-stretch mb-5 mb-lg-0">
                            <div class="icon-box" data-aos="fade-up" data-aos-delay="400">
                                <div class="icon"><i class="bx bx-world"></i></div>
                                <h4 class="title"><a href="">Study</a></h4>
                                <p class="description">At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis</p>
                            </div>
                        </div>

                    </div>

                </div>
            </section><!-- End Services Section -->

            <!-- ======= F.A.Q Section ======= -->
            <section id="faq" class="faq">
                <div class="container">

                    <div class="section-title" data-aos="fade-up">
                        <h2>Frequently Asked Questions</h2>
                    </div>

                    <div class="row faq-item d-flex align-items-stretch" data-aos="fade-up" data-aos-delay="100">
                        <div class="col-lg-5">
                            <i class="ri-question-line"></i>
                            <h4>Why i cant login into my account?</h4>
                        </div>
                        <div class="col-lg-7">
                            <p>
                                Check your username and password
                            </p>
                        </div>
                    </div><!-- End F.A.Q Item-->

                    <div class="row faq-item d-flex align-items-stretch" data-aos="fade-up" data-aos-delay="200">
                        <div class="col-lg-5">
                            <i class="ri-question-line"></i>
                            <h4>How can I view all my request?</h4>
                        </div>
                        <div class="col-lg-7">
                            <p>
                                Click into "Request"
                            </p>
                        </div>
                    </div><!-- End F.A.Q Item-->


                </div>
            </section><!-- End F.A.Q Section -->

            <!-- ======= Contact Section ======= -->
            <section id="contact" class="contact">
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

                            <form action="MessageControllerMap?service=sendMessage" method="post" role="form" class="php-email-form">
                                <div class="form-group">
                                    <input type="email" class="form-control" name="email" id="email"   pattern=".*\S+.*" title="No white space only" maxlength="30" placeholder="Your Email*" required>
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control" name="title" id="subject"  pattern=".*\S+.*" title="No white space only" maxlength="30" placeholder="Title*" required>
                                </div>
                                <div class="form-group">
                                    <textarea class="form-control" name="content" rows="5" placeholder="Message* " maxlength="100" required></textarea>
                                </div>

                                <div class="text-center"><button type="submit">Send Message</button></div>
                            <p class="text-success">${mess}</p>  
                            </form>




                            <!--MAP-->
                        </div>
                       

                    </div>

                </div>
            </section><!-- End Contact Section -->

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
        <script src="vendor/glightbox/js/glightbox.min.js"></script>
        <script src="vendor/swiper/swiper-bundle.min.js"></script>


        <script src="js/main.js"></script>

    </body>

</html>