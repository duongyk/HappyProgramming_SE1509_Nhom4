<%-- 
    Document   : userProfile
    Created on : Oct 13, 2021, 11:24:41 AM
    Author     : Tung
--%>
<%@page import="entity.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta content="width=device-width, initial-scale=1.0" name="viewport">

        <title>Request Statistic</title>
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
        <!-- =======================================================
        * Template Name: Vesperr - v4.6.0
        * Template URL: https://bootstrapmade.com/vesperr-free-bootstrap-template/
        * Author: BootstrapMade.com
        * License: https://bootstrapmade.com/license/
        ======================================================== -->

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
                        <li><a class="nav-link scrollto" href="forum">Forum</a></li>  
                        <c:choose>
                                <c:when test="${sessionScope.currUser!=null}">
                                    <li><a class="nav-link scrollto" href="openChat">Messenger</a>
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


        <main id="main">

            <!-- ======= Breadcrumbs Section ======= -->
            <section class="breadcrumbs">
                <div class="card-heading">
                    <h2 class="title" style="color: black; font-weight: bold;">Request Statistic</h2>
                    <c:if test="${success!=null}">
                        <h3 style="color:#29cc49;font-weight: bold;text-align: center"><c:out value="${success}"></c:out></h3>
                    </c:if>
                    <c:if test="${error!=null}">
                        <h3 style="color:#ff0000;font-weight: bold;text-align: center"><c:out value="${error}"></c:out></h3>
                    </c:if>
                </div>

            </section><!-- End Breadcrumbs Section -->

            <div class="container">
                <div class="main-body">

                    <div class="row gutters-sm">
                        <div class="col-md-4 mb-3">
                            <div class="card" id="sidebar">
                                <div class="card-body">
                                    <c:choose>
                                        <c:when test="${user.getRole()==2}">
                                            <div class="d-flex flex-column align-items-center text-center">
                                                <img src="img/${user.getAvatar()}" alt="Admin" class="rounded-circle" width="150">
                                                <div class="mt-3">
                                                    <h4> <c:out value="${user.fullname}"></c:out> </h4>                                        
                                                    <p class="text-secondary mb-1"><c:out value="${cv.getProfession()}"></c:out></p>
                                                        <!--<p class="text-muted font-size-sm">Bay Area, San Francisco, CA</p>-->
                                                    </div>
                                                </div>
                                        </c:when>
                                        <c:otherwise>
                                            <div class="d-flex flex-column align-items-center text-center">
                                                <img src="img/${user.getAvatar()}" alt="User" class="rounded-circle" width="150">
                                                <div class="mt-3">
                                                    <h4> <c:out value="${user.fullname}"></c:out> </h4>                                                               
                                                    </div>
                                                </div>   
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-8">
                            <div class="card mb-3">
                                <div class="card-body">
                                    
                                    <div class="row" style="margin: 10px 15px 15px 15px;">
                                        <div id="chart">
                                        </div>
                                    </div>
                                    
                                    <hr>
                                    
                            </div>




                        </div>
                    </div>

                </div>
            </div>
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
            <script src="https://cdn.jsdelivr.net/npm/apexcharts"></script>
            <script>
                
                var options = {
                    series: [
                        {
                            name: 'Inviting Request',
                            data: [
                                <c:forEach items="${statisticMap.values()}" var="userStat" >
                                    <c:out value="${userStat.get(Integer.parseInt(1))}"></c:out>,
                                </c:forEach>
                                ]
                        },              
                        {
                            name: 'Following Request',
                            data: [
                                <c:forEach items="${statisticMap.values()}" var="userStat" >
                                       <c:out value="${userStat.get(Integer.parseInt(2))}"></c:out>,
                                </c:forEach>
                                ]
                        },
                        {
                            name: 'Completed Request',
                            data: [
                                <c:forEach items="${statisticMap.values()}" var="userStat" >
                                      <c:out value="${userStat.get(Integer.parseInt(3))}"></c:out>,
                                </c:forEach>
                                ]
                        },
                        {
                            name: 'Canceled Request',
                            data: [
                                <c:forEach items="${statisticMap.values()}" var="userStat" >
                                     <c:out value="${userStat.get(Integer.parseInt(4))}"></c:out>,
                                </c:forEach>
                                ]
                        },
                        ],
                    chart: {
                        type: 'bar',
                        height: 300,
                        stacked: true,
                    },
                    plotOptions: {
                        bar: {
                            horizontal: true,
                        },
                    },
                    stroke: {
                        width: 1,
                        colors: ['#fff']
                    },
                    title: {
                        text: 'Top 5 Mentor Request Statistic'
                    },
                    xaxis: {
                        categories: [
                            <c:forEach items="${statisticMap.keySet()}" var="fullname">
                                '${fullname}',
                            </c:forEach>
                                ],
                        labels: {
                            formatter: function (val) {
                                return val + ""
                            }
                        }
                    },
                    yaxis: {
                        title: {
                            text: undefined
                        },
                    },
                    tooltip: {
                        y: {
                            formatter: function (val) {
                                return val + "";
                            }
                        }
                    },
                    fill: {
                        opacity: 1
                    },
                    legend: {
                        position: 'top',
                        horizontalAlign: 'left',
                        offsetX: 40
                    }
                };

                var chart = new ApexCharts(document.querySelector("#chart"), options);
                chart.render();
            </script>
            <script>
                $(function () {
                    var offset = $("#sidebar").offset();
                    var topPadding = 100;
                    $(window).scroll(function () {
                        if ($(window).scrollTop() > offset.top) {
                            $("#sidebar").stop().animate({
                                marginTop: $(window).scrollTop() - offset.top + topPadding * 1.8
                            });
                        } else {
                            $("#sidebar").stop().animate({
                                marginTop: 0
                            });
                        }
                        ;
                    });
                });
            </script>
            <style>
                body{
                    margin-top:20px;
                    color: #1a202c;
                    text-align: left;
                    background-color: #e2e8f0;    
                }
                .main-body {
                    padding: 15px;
                }
                .card {
                    box-shadow: 0 1px 3px 0 rgba(0,0,0,.1), 0 1px 2px 0 rgba(0,0,0,.06);
                }

                .card {
                    position: relative;
                    display: flex;
                    flex-direction: column;
                    min-width: 0;
                    word-wrap: break-word;
                    background-color: #fff;
                    background-clip: border-box;
                    border: 0 solid rgba(0,0,0,.125);
                    border-radius: .25rem;
                }

                .card-body {
                    flex: 1 1 auto;
                    min-height: 1px;
                    padding: 1rem;
                }



                .gutters-sm>.col, .gutters-sm>[class*=col-] {
                    padding-right: 8px;
                    padding-left: 8px;
                }

                .bg-gray-300 {
                    background-color: #e2e8f0;
                }
                .h-100 {
                    height: 100%!important;
                }
                .shadow-none {
                    box-shadow: none!important;
                }
            </style>
    </body>

</html>
