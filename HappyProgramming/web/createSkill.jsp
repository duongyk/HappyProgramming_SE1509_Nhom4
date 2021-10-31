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

        <title>Create Skill</title>
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

        <!-- Javascript File -->
        <script class="u-script" type="text/javascript" src="js/changeAvatar.js" defer=""></script>
        <script type="text/javascript" src="js/checkSpace.js" ></script>
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
                        <li><a class="nav-link scrollto" href="listAllmentor">All mentors</a></li>
                        <li><a class="nav-link scrollto" href="SkillControllerMap?service=allSkill">All skills</a></li>
                        <li><a class="nav-link scrollto" href="forum">Forum</a></li>
                            <c:choose>
                                <c:when test="${sessionScope.currUser!=null}">
                                <li><a class="nav-link scrollto" href="listRequestByMe">Request</a>
                                </li>
                                <li><a class="nav-link scrollto" href="openChat">Messenger</a></li>
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
                    <h2 class="title" style="color: black; font-weight: bold;">Create Skill  </h2>

                </div>
            </section><!-- End Breadcrumbs Section -->

            <section class="inner-page">
                <div class="container">
                    <div class="wrapper wrapper--w790">

                        <div class="card card-5">

                            <div class="card-body">
                                <form  action="createSkill" method="POST">
                                    <div class="form-row">
                                        <div class="name">Skill Name</div>
                                        <div class="value">
                                            <div class="input-group">
                                                <input class="input-white" id="content" placeholder="Skill Name" type="text" name="sName" pattern=".*\S+.*" title="Must not contain only spaces" onkeyup="checkSpace()" required="required" value="${sName}">
                                            </div>
                                            <%-- Message for checkSpace --%>
                                            <p id="text-space" style="display:none; color:red">Skill name contains only space</p>
                                            <p id="text-space-1" style="color:white;">Valid input</p>
                                        </div>
                                    </div>
                                    <div class="form-row">
                                        <div class="name">Detail</div>
                                        <div class="value">
                                            <div class="input-group">
                                                <textarea class="input-white" id="title" placeholder="Detail" name="sDetail" required="required" rows="3" cols="55" maxlength="200" onkeyup="checkSpace1()" >${sDetail}</textarea>
                                            <%-- Message for checkSpace --%>
                                            <p id="title-space" style="display:none; color:red">Detail contains only space</p>
                                            <p id="title-space-1" style="color:white;">Valid input</p>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="form-row">
                                        <div class="name">Image</div>
                                        <div class="value">
                                            <div class="input-group">
                                                <input class="input-white" id="avatarURL" onchange="changeImage()" class="input--style-5" type="file" name="sImage" required="required" src="img/css.jpg">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="form-row">
                                        <div class="name"></div>
                                        <div class="value">
                                            <div class="input-group">
                                                <img id="image" style="height: 162px; padding-left: 102px;" class="" src="img/79506d11e688f731ccd8668ea9a270a8f1c3bbe48deaaa39778eb19163c1b45a18be6e4c3e8f265299f9a3284a2e8cc04605fdfc7290b9d7c20251_1280.png" alt="" >
                                            </div>
                                        </div>
                                    </div>

                                    <!-- <input id="avatarURL" form="thisform" onchange="changeImage()" type="file" name="avatar" value="" style="width: 162px;" > -->
                                    <div style="margin-left: 230px;">
                                        <button id="button" class="btn btn--radius-2 btn--blue" type="submit">Create</button>
                                        <p class="text-danger" style="padding-left: 30px;">${mess}</p>  
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
        <script src="js/upload.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="vendor/glightbox/js/glightbox.min.js"></script>
        <script src="vendor/isotope-layout/isotope.pkgd.min.js"></script>
        <script src="vendor/php-email-form/validate.js"></script>
        <script src="vendor/purecounter/purecounter.js"></script>
        <script src="vendor/swiper/swiper-bundle.min.js"></script>

        <!-- Template Main JS File -->
        <script src="js/main.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="js/form.js"></script>
        <script>
                                                    function chooseFile(fileInput) {
                                                        if (fileInput.files && fileInput.files[0]) {
                                                            var reader = new FileReader();
                                                            reader.onload = function (e) {
                                                                $('#image').attr('src', e.target.result);
                                                            }
                                                            reader.readAsDataURL(fileInput.files[0]);
                                                            const url = event.target.results
                                                            document.querySelector("img").src = URL.createObjectURL(url);
                                                        }
                                                    }
        </script>

    </body>

</html>