<%@page import="entity.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html style="font-size: 16px;" lang="vi">
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta charset="utf-8">
        <meta name="keywords" content="">
        <meta name="description" content="">
        <meta name="page_type" content="np-template-header-footer-from-plugin">
        <title>List request by me</title>
        <link rel="stylesheet" href="css/nicepage.css" media="screen">
        <link rel="stylesheet" href="css/List-request-by-me.css" media="screen">
        <script class="u-script" type="text/javascript" src="js/jquery.js" defer=""></script>
        <script class="u-script" type="text/javascript" src="js/nicepage.js" defer=""></script>
        <meta name="generator" content="Nicepage 3.25.0, nicepage.com">
        <link id="u-theme-google-font" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i|Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i">



        <script type="application/ld+json">{
            "@context": "http://schema.org",
            "@type": "Organization",
            "name": "Happyprogramming",
            "logo": "images/Logo.png"
            }</script>
        <meta name="theme-color" content="#478ac9">
        <meta property="og:title" content="List request by me">
        <meta property="og:description" content="">
        <meta property="og:type" content="website">
    </head>
    <%-- Copy from here --%>
    <%
        User x = (User) request.getSession().getAttribute("currUser");
    %>
    <body class="u-body">
        <header class="u-clearfix u-custom-color-1 u-header ">
            <a href="index.jsp" class="u-image u-logo u-image-1" data-image-width="313" data-image-height="95" t>
                <img src="images/Logo.png" class="u-logo-image u-logo-image-1">
            </a>
            <nav class="u-align-right u-menu x u-offcanvas u-menu-1" data-position="" data-responsive-from="MD">

                <div class="u-nav-container">
                    <ul class="u-custom-font u-nav u-spacing-30 u-text-font u-unstyled u-nav-1">
                        <li class="u-nav-item"><a
                                class="u-button-style u-nav-link u-text-active-palette-1-base u-text-grey-90 u-text-hover-grey-90"
                                href="" style="padding: 10px 36px;">All mentors</a>
                        </li>
                        <li class="u-nav-item"><a
                                class="u-button-style u-nav-link u-text-active-palette-1-base u-text-grey-90 u-text-hover-grey-90"
                                href="SkillControllerMap?service=allSkill" style="padding: 10px 36px;">All skills</a>
                        </li>
                        <%if (x != null) {%>
                        <li class="u-nav-item"><a
                                class="u-button-style u-nav-link u-text-active-palette-1-base u-text-grey-90 u-text-hover-grey-90"
                                href="RequestControllerMap?service=loadRequest" style="padding: 10px 36px;">create request</a>
                        </li>
                        <li class="u-nav-item"><a
                                class="u-button-style u-nav-link u-text-active-palette-1-base u-text-grey-90 u-text-hover-grey-90"
                                href="RequestControllerMap?service=listRequestByMe" style="padding: 10px 36px;">Request</a>
                        </li> 
                        <li class="u-nav-item"><a
                                class="u-button-style u-nav-link u-text-active-palette-1-base u-text-grey-90 u-text-hover-grey-90"
                                href="UserControllerMap?service=profile" style="padding: 10px 36px;">Profile</a>
                        </li> 
                        <%} else {%>
                        <li class="u-nav-item"><a class="u-button-style u-nav-link u-text-active-palette-1-base u-text-grey-90 u-text-hover-grey-90" href="Sign-up.jsp" style="padding: 10px 16px;">Sign up</a> </li> 
                        <li class="u-nav-item"><a
                                class="u-button-style u-nav-link u-text-active-palette-1-base u-text-grey-90 u-text-hover-grey-90"  
                                href="Sign-in.jsp"style="padding: 10px 36px;">Sign-in</a>
                        </li>
                        <%}%>
                    </ul>
                </div>

            </nav>
        </header>
        <section class="u-clearfix u-grey-10 u-section-1" id="sec-7dfc">
            <div class="u-clearfix u-sheet u-sheet-1">
                <h2 class="u-custom-font u-text u-text-font u-text-1">List request by me</h2>
                <a href="#sec-1114" class="u-border-none u-btn u-button-style u-custom-color-3 u-dialog-link u-btn-1">Statistic</a>
                <a href="#" class="u-border-none u-btn u-button-style u-custom-color-4 u-btn-2">Create request</a>
                <div class="u-expanded-width u-list u-list-1">
                    <div class="u-repeater u-repeater-1">
                        
                        <c:forEach items="${listRequest}" var="request">
                        <div class="u-container-style u-list-item u-repeater-item u-video-cover u-white">
                            <div class="u-container-layout u-similar-container u-valign-top u-container-layout-1">
                                <h3 class="u-text u-text-default u-text-2">Status: ${request.status}</h3>
                                <div class="u-border-4 u-border-custom-color-3 u-expanded-width u-line u-line-horizontal u-line-1"></div>
                                <p class="u-align-left u-text u-text-3">${request.title}</p>
                                <a href="" class="u-border-none u-btn u-button-style u-custom-color-3 u-btn-3">View Request</a>
                            </div>
                        </div>
                        </c:forEach>
                        
                        
                    </div>
                </div>
            </div>
        </section>



        <footer class="u-align-center u-clearfix u-footer u-white u-footer" id="sec-b0a2"><img class="u-image u-image-1" src="images/logowhite.png" data-image-width="571" data-image-height="388"><a href="https://nicepage.com/wordpress-themes" class="u-active-none u-btn u-btn-rectangle u-button-style u-hover-none u-none u-radius-0 u-text-body-color u-btn-1">0123456789</a><p class="u-text u-text-default u-text-1"> San Jose,Silicon Valley, California</p><p class="u-text u-text-2"> HappyProgramming@gmail.com</p><div class="u-grey-light-2 u-map u-map-1">
                <div class="embed-responsive">
                    <iframe class="embed-responsive-item" src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d287205.9795192053!2d-121.9745609966744!3d37.31390644748984!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x808fcae48af93ff5%3A0xb99d8c0aca9f717b!2sSan%20Jose%2C%20California%2C%20Hoa%20K%E1%BB%B3!5e0!3m2!1svi!2s!4v1632219783213!5m2!1svi!2s" data-map="JTdCJTIycG9zaXRpb25UeXBlJTIyJTNBJTIybWFwLWVtYmVkJTIyJTJDJTIyYWRkcmVzcyUyMiUzQSUyMk1hbmhhdHRhbiUyQyUyME5ldyUyMFlvcmslMjIlMkMlMjJ6b29tJTIyJTNBMTAlMkMlMjJ0eXBlSWQlMjIlM0ElMjJyb2FkJTIyJTJDJTIybGFuZyUyMiUzQW51bGwlMkMlMjJhcGlLZXklMjIlM0ElMjJkJTIyJTJDJTIybWFya2VycyUyMiUzQSU1QiU1RCUyQyUyMmVtYmVkJTIyJTNBJTIyaHR0cHMlM0ElMkYlMkZ3d3cuZ29vZ2xlLmNvbSUyRm1hcHMlMkZlbWJlZCUzRnBiJTNEITFtMTghMW0xMiExbTMhMWQyODcyMDUuOTc5NTE5MjA1MyEyZC0xMjEuOTc0NTYwOTk2Njc0NCEzZDM3LjMxMzkwNjQ0NzQ4OTg0ITJtMyExZjAhMmYwITNmMCEzbTIhMWkxMDI0ITJpNzY4ITRmMTMuMSEzbTMhMW0yITFzMHg4MDhmY2FlNDhhZjkzZmY1JTI1M0EweGI5OWQ4YzBhY2E5ZjcxN2IhMnNTYW4lMjUyMEpvc2UlMjUyQyUyNTIwQ2FsaWZvcm5pYSUyNTJDJTI1MjBIb2ElMjUyMEslMjVFMSUyNUJCJTI1QjMhNWUwITNtMiExc3ZpITJzITR2MTYzMjIxOTc4MzIxMyE1bTIhMXN2aSEycyUyMiU3RA=="></iframe>
                </div>
            </div><img class="u-image u-image-default u-image-2" src="images/contact.png" alt="" data-image-width="177" data-image-height="361"></footer>
        <section class="u-backlink u-clearfix u-grey-80">
            <a class="u-link" href="https://nicepage.com/website-design" target="_blank">
                <span>Free Website Design</span>
            </a>
            <p class="u-text">
                <span>created with</span>
            </p>
            <a class="u-link" href="https://nicepage.com/" target="_blank">
                <span>WYSIWYG Web Builder</span>
            </a>. 
        </section>
        <section class="u-black u-clearfix u-container-style u-dialog-block u-opacity u-opacity-70 u-valign-middle u-section-4" id="sec-1114">
            <div class="u-align-center u-container-style u-dialog u-white u-dialog-1">
                <div class="u-container-layout u-container-layout-1">
                    <h6 class="u-text u-text-font u-text-1">Total of request:<br>Total hours:<br>Total mentors:&nbsp;
                    </h6>
                </div><button class="u-dialog-close-button u-icon u-text-grey-40 u-icon-1"><svg class="u-svg-link" preserveAspectRatio="xMidYMin slice" viewBox="0 0 16 16" style=""><use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#svg-c278"></use></svg><svg class="u-svg-content" viewBox="0 0 16 16" x="0px" y="0px" id="svg-c278"><rect x="7" y="0" transform="matrix(0.7071 -0.7071 0.7071 0.7071 -3.3138 8.0002)" width="2" height="16"></rect><rect x="0" y="7" transform="matrix(0.7071 -0.7071 0.7071 0.7071 -3.3138 8.0002)" width="16" height="2"></rect></svg></button>
            </div>
        </section><style>.u-section-4 {
                min-height: 876px;
            }

            .u-section-4 .u-dialog-1 {
                width: 214px;
                min-height: 167px;
                margin: 60px auto;
            }

            .u-section-4 .u-container-layout-1 {
                padding: 30px;
            }

            .u-section-4 .u-text-1 {
                margin: 0 20px 0 0;
            }

            .u-section-4 .u-icon-1 {
                width: 20px;
                height: 20px;
            }

            @media (max-width: 1199px) {
                .u-section-4 .u-dialog-1 {
                    height: auto;
                }
            }

            @media (max-width: 767px) {
                .u-section-4 .u-container-layout-1 {
                    padding-left: 10px;
                    padding-right: 10px;
                }
            }</style></body>
</html>