<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
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

        <!-- Template Main CSS File -->
        <link href="css/style.css" rel="stylesheet">
        <link href="css/login.css" rel="stylesheet">
        <link href="css/createRequest.css" rel="stylesheet">
        
        <script class="u-script" type="text/javascript" src="js/jquery.js" defer=""></script>
        <script class="u-script" type="text/javascript" src="js/changeAvatar.js" defer=""></script>
        <script class="u-script" type="text/javascript" src="js/checkpattern.js" defer=""></script>
        
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
                            <%-- Check the current User --%>
                            <c:choose>
                                <c:when test="${sessionScope.currUser!=null}">
                                <li><a class="nav-link scrollto" href="forum">Forum</a></li>
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
                </nav>

            </div>
        </header><!-- End Header -->

        <!-- ======= Hero Section ======= -->


        <main id="main">

            <!-- ======= Breadcrumbs Section ======= -->
            <section class="breadcrumbs">
                <div class="card-heading">
                    <h2 class="title" style="color: black; font-weight: bold;">Update CV </h2>
                    <c:if test="${success!=null}">
                        <h3 style="color:#29cc49;font-weight: bold;text-align: center"><c:out value="${success}"></c:out></h3>
                    </c:if>
                    <c:if test="${error!=null}">
                        <h3 style="color:#ff0000;font-weight: bold;text-align: center"><c:out value="${error}"></c:out></h3>
                    </c:if>
                </div>
            </section><!-- End Breadcrumbs Section -->

            <section class="inner-page">
                <div class="container">
                    <div class="wrapper wrapper--w790">
                        <div class="card card-5">

                            <div class="card-body">
                                <form action="updateCV" method="POST">
                                    <!--
                                    <div class="form-row m-b-55">
                                        <div class="name">Username</div>
                                        <div class="value">
                                            <div class="row row-space">
                                                <div class="col-12">
                                                    <div class="input-group-desc">
                                                        <input class="input-white" type="text" name="username" pattern=".*\S+.*" title="No white space only" maxlength="30" value="<c:out value="${mentorprofile.getUsername()}"></c:out>" required="required" readonly>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    -->
                                    
                                    <div class="form-row">
                                        <div class="name">Full Name(<span style="color:red">*</span>)</div>
                                        <div class="value">
                                            <div class="input-group">
                                                <input class="input-white" type="text" name="fullname" pattern=".*\S+.*" title="No white space only" maxlength="30" value="<c:out value="${mentorprofile.getFullname()}"></c:out>" required>
                                                <h4 id="htitle" style="color:red;"></h4>
                                            </div>
                                        </div>
                                    </div>
                                    
                                    <div class="form-row">
                                        <div class="name">Email(<span style="color:red">*</span>)</div>
                                        <div class="value">
                                            <div class="input-group">
                                                <input class="input-white" type="email" name="mail" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" title="Email pattern: abcxyz@abcxyz.domain" maxlength="35" value="<c:out value="${mentorprofile.getMail()}"></c:out>" required>
                                                <h4 id="htitle" style="color:red;"></h4>
                                            </div>
                                        </div>
                                    </div>
                                 
                                                                
                                    <div class="form-row m-b-55">
                                        <div class="name">Phone(<span style="color:red">*</span>)</div>
                                        <div class="value">
                                            <div class="row row-refine">

                                                <div class="col-12">
                                                    <div class="input-group-desc">
                                                        <input class="input-white" type="text" name="phone" pattern="[0-9]{9,11}" title="phone with 9 to 11 number" value="<c:out value="${mentorprofile.getPhone()}"></c:out>" required>
                                                        <h4 id="htitle" style="color:red;"></h4>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                                        
                                    <div class="form-row">
                                        <div class="name">Sex</div>
                                        <select id="select-6004" name="sex" class="input-white">
                                            <c:choose>
                                                <c:when test="${mentorprofile.getGender() eq \"Male\" }" >
                                                  <option value="Male" selected>Male</option>
                                                  <option value="Female" >Female</option>
                                                </c:when>                    
                                                <c:otherwise>
                                                  <option value="Male">Male</option>
                                                  <option value="Female" selected>Female</option>
                                                </c:otherwise>
                                            </c:choose>
                                        </select>
                                    </div>
                                    <div class="form-row">
                                        <div class="name">DOB(<span style="color:red">*</span>)</div>
                                        <div class="value">       
                                            <input  class="input-white" type="date" id="mentordob"  name="dob" value="<c:out value="${mentorprofile.getDob()}"></c:out>" >
                                        </div>    
                                    </div>
                                                        
                                    <div class="form-row m-b-55">
                                        <div class="name">Profession(<span style="color:red">*</span>)</div>
                                        <div class="value">
                                            <div class="row row-refine">

                                                <div class="col-12">
                                                    <div class="input-group-desc">
                                                        <input class="input-white" type="text" name="profession" pattern=".*\S+.*" title="No white space only"  maxlength="30" value="<c:out value="${mentorcv.getProfession()}"></c:out>" required>
                                                        <h4 id="htitle" style="color:red;"></h4>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    
                                    <div class="form-row m-b-55">
                                        <div class="name">Profession Intro(<span style="color:red">*</span>)</div>
                                        <div class="value">
                                            <div class="row row-refine">

                                                <div class="col-12">
                                                    <div class="input-group-desc">
                                                        <!--<input class="input-white" type="text" name="phone"> -->
                                                        <textarea class="input-white" style="width: 499px" pattern=".*\S+.*" title="No white space only" name="professionIntro" maxlength="200" required><c:out value="${mentorcv.getProfessionIntro()}"></c:out></textarea>
                                                        <h4 id="htitle" style="color:red;"></h4>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    
                                    <div class="form-row m-b-55">
                                        <div class="name">Service Description(<span style="color:red">*</span>)</div>
                                        <div class="value">
                                            <div class="row row-refine">

                                                <div class="col-12">
                                                    <div class="input-group-desc">
                                                        <!--<input class="input-white" type="text" name="phone"> -->
                                                        <textarea class="input-white" style="width: 499px" pattern=".*\S+.*" title="No white space only" name="serviceDescription" maxlength="200" required><c:out value="${mentorcv.getServiceDescript()}"></c:out></textarea>
                                                        <h4 id="htitle" style="color:red;"></h4>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    
                                    <div class="form-row m-b-55">
                                        <div class="name">Achievement(<span style="color:red">*</span>)</div>
                                        <div class="value">
                                            <div class="row row-refine">

                                                <div class="col-12">
                                                    <div class="input-group-desc">
                                                        <!--<input class="input-white" type="text" name="phone"> -->
                                                        <textarea class="input-white" style="width: 499px" pattern=".*\S+.*" title="No white space only" name="achievement" maxlength="200" required><c:out value="${mentorcv.getAchivement()}"></c:out></textarea>
                                                        <h4 id="htitle" style="color:red;"></h4>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                                                                       
                                    <div class="form-row m-b-55">
                                        <div class="name">Avatar</div>
                                        <div class="value">
                                            <div class="row row-refine">

                                                <div class="col-12">
                                                    <div class="input-group-desc">
                                                        <input id="avatarURL" class="input-white" type="file" onchange="changeImage()" type="file" name="avatar" value="">
                                                    </div>
                                                    <div class="input-group-desc">
                                                        <img id="image" style="width: 162px;" src="img/<c:out value="${mentorprofile.getAvatar()}"></c:out>" alt="" data-image-width="1280" data-image-height="1280">
                                                    </div>

                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    
                                    <div class="form-row m-b-55">
                                        <div class="name">Choose Skills(<span style="color:red">*</span>)</div>
                                        <div class="value">
                                            <div class="row row-refine">
                                                <div class="row">
                                                    <div class="col-12">
                                                        <ul >
                                                            <c:forEach items="${allskill}" var="s">
                                                                    <li style="display: inline-block; margin-right: 30px;margin-bottom: 10px">
                                                                    <c:choose>
                                                                        <c:when test="${mentorskill.contains(String.valueOf(s.getId()))}">
                                                                            <input class="form-check-input" type="checkbox" style="border-color: black;" id="${s.getId()}" name="skills" value="${s.getId()}" checked>

                                                                        </c:when>
                                                                        <c:otherwise>
                                                                            <input class="form-check-input" type="checkbox" style="border-color: black;" id="${s.getId()}" name="skills" value="${s.getId()}" >

                                                                        </c:otherwise>
                                                                    </c:choose>
                                                                         <label class="form-check-label" style="word-wrap:break-word" for="${s.getId()}">${s.getName()}</label>
                                                                    </li>

                                                            </c:forEach>
                                                        </ul>
                                                    </div>
                                                </div>
                                            </div>
                                            <h4 id="checkboxtitle" style="color:red;"></h4>
                                        </div>
                                    </div> 
                                                    
                                    <div style="padding-left: 200px;">
                                        <button class="btn btn--radius-2 btn--blue" type="submit">Update CV</button>
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
        
        <script>
                var date = new Date();
                var d = date.getDate();
                var m = date.getMonth()+1;
                if (d < 10) {
                    d = '0' + d;
                }
                if (m < 10) {
                    m = '0' + m;
                }
                var y = date.getFullYear()-18;
                var max = y + "-" + m + "-" + d;
                document.getElementById("mentordob").setAttribute('max', max);
    </script>
        
    </body>
    
</html>