<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Inner Page - Vesperr Bootstrap Template</title>
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
                                <c:choose>
                                    <c:when test="${sessionScope.currUser.getRole()==2}">
                                        <li><a class="nav-link scrollto" href="RequestControllerMap?service=viewMentorRequest&status=1">Inviting Request</a>
                                        </li>
                                        <li><a class="nav-link scrollto" href="RequestControllerMap?service=viewMentorRequest&status=2">Following Request</a>
                                        </li>
                                    </c:when>
                                    <c:otherwise>
                                        <li><a class="nav-link scrollto" href="RequestControllerMap?service=listRequestByMe">Request</a>
                                        </li>
                                    </c:otherwise>
                                </c:choose>
                                <li class="dropdown getstarted scrollto ">
                                    <span style="color: white; padding: 0;">User</span>
                                    <ul>
                                        <li><a href="UserControllerMap?service=profile&uId=${sessionScope.currUser.id}">Profile</a></li>
                                        <li><a href="UserControllerMap?service=formChangePass">Change pass</a></li>
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

  <main id="main">
    <!-- ======= Breadcrumbs Section ======= -->
    <section class="breadcrumbs">
      <div class="container">
      </div>
    </section><!-- End Breadcrumbs Section -->
   
    <section id="team" class="team section-bg">
        <!--
      <div class="wrapper" style="z-index: 3;">
        <input name="modal" type="checkbox" id="modal">
        <label for="modal" class="label-show-modal">Statistic Request</label>
        <div class="modal-show">
          <div class="modal-show-inner">
            <label for="modal">&#10006;</label>
            <h2>Show Modal Content</h2>
            <p>Nhét cái th?ng kê vào ?ây</p>
          </div>
        </div>
      </div>
        -->
      <div class="container">
        <div class="section-title" data-aos="fade-up">
            <h2>All <c:out value="${status}" ></c:out> request</h2>
        </div>
          
        <div class="row">

        <c:forEach items="${requestlist}" var="request">
          <div class="col-lg-4 col-md-6 d-flex align-items-stretch">
            <div class="member" data-aos="fade-up" data-aos-delay="100">
              <div class="member-img">
                <img src="img/team/team-1.jpg" class="img-fluid" alt="">
                <div class="">
                </div>
              </div>
              <div class="member-info">
                  <h4 >Request ID: <c:out value="${request.getId()}"></c:out></h4>
                  <h4 style="color:#3498db"><c:out value="${request.getTitle()}"></c:out></h4>
                  <!--<h4 style="color:#0066cc"><c:out value="${request.getContent()}"></c:out></h4> -->
                  <h4 style="">Mentee: <c:out value="${request.getFrom().getUsername()}"></c:out></h4>
                  <h4>DeadlineDate: <c:out value="${request.getDeadlineDate()}"></c:out></h4>                
                  <!--<h4>DeadlineHour: <c:out value="${request.getDeadlineHour()}"></c:out></h4>-->
                  <c:if test="${request.getStatus()==1}">
                      <h4><a class="btn btn-primary" style="background-color: #009900;" href="RequestControllerMap?service=mentorUpdateStatus&rid=<c:out value="${request.getId()}"></c:out>&status=2">Accept</a>
                      <a class="btn btn-primary" style="background-color: #ff0000;" href="RequestControllerMap?service=mentorUpdateStatus&rid=<c:out value="${request.getId()}"></c:out>&status=4">Reject</a></h4>
                  </c:if>
              </div>
            </div>
          </div>
        </c:forEach>
            
        </div>

      </div>
    </section><!-- End Team Section -->

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