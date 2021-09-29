<%-- 
    Document   : loginJsp
    Created on : Sep 21, 2021, 8:27:13 PM
    Author     : QMC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="font-size: 16px;" lang="vi">
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta charset="utf-8">
        <meta name="keywords" content="">
        <meta name="description" content="">
        <meta name="page_type" content="np-template-header-footer-from-plugin">
        <title>Sign in</title>
        <link rel="stylesheet" href="css/nicepage.css" media="screen">
        <link rel="stylesheet" href="css/Sign-in.css" media="screen">
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
        <meta property="og:title" content="Sign in">
        <meta property="og:description" content="">
        <meta property="og:type" content="website">
    </head>
    <body class="u-body"><header class="u-clearfix u-custom-color-1 u-header u-sticky u-sticky-c79c u-header" id="sec-6b6d"><a href="Home.html" data-page-id="745383" class="u-image u-logo u-image-1" data-image-width="313" data-image-height="95" title="D">
                <img src="images/Logo.png" class="u-logo-image u-logo-image-1">
            </a><nav class="u-menu u-menu-dropdown u-offcanvas u-menu-1" data-responsive-from="XS">
                <div class="menu-collapse" style="font-size: 0.875rem; letter-spacing: 0px; font-weight: 700; text-transform: uppercase;">
                    <a class="u-button-style u-custom-active-border-color u-custom-active-color u-custom-border u-custom-border-color u-custom-borders u-custom-hover-border-color u-custom-hover-color u-custom-left-right-menu-spacing u-custom-text-active-color u-custom-text-color u-custom-text-hover-color u-custom-top-bottom-menu-spacing u-nav-link" href="#">
                        <svg><use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#menu-hamburger"></use></svg>
                        <svg version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"><defs><symbol id="menu-hamburger" viewBox="0 0 16 16" style="width: 16px; height: 16px;"><rect y="1" width="16" height="2"></rect><rect y="7" width="16" height="2"></rect><rect y="13" width="16" height="2"></rect>
                        </symbol>
                        </defs></svg>
                    </a>
                </div>
                <div class="u-custom-menu u-nav-container">
                    <ul class="u-nav u-spacing-30 u-unstyled u-nav-1"><li class="u-nav-item"><a class="u-button-style u-nav-link u-text-active-palette-1-base u-text-grey-90 u-text-hover-grey-90" href="All-skills.html" style="padding: 10px 16px;">All skills</a>
                        </li><li class="u-nav-item"><a class="u-button-style u-nav-link u-text-active-palette-1-base u-text-grey-90 u-text-hover-grey-90" href="#" style="padding: 10px 16px;">All mentors</a>
                        </li><li class="u-nav-item"><a class="u-button-style u-nav-link u-text-active-palette-1-base u-text-grey-90 u-text-hover-grey-90" href="Sign-up.html" style="padding: 10px 16px;">Sign up</a>
                        </li><li class="u-nav-item"><a class="u-button-style u-nav-link u-text-active-palette-1-base u-text-grey-90 u-text-hover-grey-90" href="Sign-in.html" style="padding: 10px 16px;">Sign in</a>
                        </li></ul>
                </div>
                <div class="u-custom-menu u-nav-container-collapse">
                    <div class="u-black u-container-style u-inner-container-layout u-opacity u-opacity-95 u-sidenav">
                        <div class="u-sidenav-overflow">
                            <div class="u-menu-close"></div>
                            <ul class="u-align-center u-nav u-popupmenu-items u-unstyled u-nav-2"><li class="u-nav-item"><a class="u-button-style u-nav-link" href="All-skills.html" style="padding: 10px 16px;">All skills</a>
                                </li><li class="u-nav-item"><a class="u-button-style u-nav-link" href="#" style="padding: 10px 16px;">All mentors</a>
                                </li><li class="u-nav-item"><a class="u-button-style u-nav-link" href="Sign-up.html" style="padding: 10px 16px;">Sign up</a>
                                </li><li class="u-nav-item"><a class="u-button-style u-nav-link" href="Sign-in.html" style="padding: 10px 16px;">Sign in</a>
                                </li></ul>
                        </div>
                    </div>
                    <div class="u-black u-menu-overlay u-opacity u-opacity-70"></div>
                </div>
            </nav><form action="#" method="get" class="u-border-1 u-border-grey-30 u-search u-search-left u-white u-search-1">
                <button class="u-search-button" type="submit">
                    <span class="u-search-icon u-spacing-10">
                        <svg class="u-svg-link" preserveAspectRatio="xMidYMin slice" viewBox="0 0 56.966 56.966"><use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#svg-6677"></use></svg>
                        <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" version="1.1" id="svg-6677" x="0px" y="0px" viewBox="0 0 56.966 56.966" style="enable-background:new 0 0 56.966 56.966;" xml:space="preserve" class="u-svg-content"><path d="M55.146,51.887L41.588,37.786c3.486-4.144,5.396-9.358,5.396-14.786c0-12.682-10.318-23-23-23s-23,10.318-23,23  s10.318,23,23,23c4.761,0,9.298-1.436,13.177-4.162l13.661,14.208c0.571,0.593,1.339,0.92,2.162,0.92  c0.779,0,1.518-0.297,2.079-0.837C56.255,54.982,56.293,53.08,55.146,51.887z M23.984,6c9.374,0,17,7.626,17,17s-7.626,17-17,17  s-17-7.626-17-17S14.61,6,23.984,6z"></path></svg>
                    </span>
                </button>
                <input class="u-search-input" type="search" name="search" value="" placeholder="Search">
            </form></header>
        <section class="u-align-center u-clearfix u-custom-color-2 u-section-1" id="sec-eec3">
            <div class="u-clearfix u-sheet u-sheet-1">
                <div class="u-align-center u-container-style u-group u-radius-50 u-shape-round u-white u-group-1">
                    <div class="u-container-layout u-container-layout-1">
                        <h3 class="u-text u-text-1">Sign In</h3>
                        <div class="u-form u-login-control u-form-1">
                            <form action="UserControllerMap" method="POST" class="u-clearfix u-form-custom-backend u-form-spacing-35 u-form-vertical u-inner-form" source="custom" name="form-2" style="padding: 10px;">
                                <div class="u-form-group u-form-name">
                                    <label for="username-708d" class="u-form-control-hidden u-label"></label>
                                    <input type="text" placeholder="Enter your Username" id="username-708d" name="username" class="u-grey-5 u-input u-input-rectangle" required="">
                                </div>
                                <div class="u-form-group u-form-password">
                                    <label for="password-708d" class="u-form-control-hidden u-label"></label>
                                    <input type="password" placeholder="Enter your Password" id="password-708d" name="password" class="u-grey-5 u-input u-input-rectangle" required="">
                                </div>
                                <div class="u-form-checkbox u-form-group">
                                    <input type="checkbox" id="checkbox-708d" name="remember" value="On">
                                    <label for="checkbox-708d" class="u-label">Remember me</label>
                                </div>
                                <div class="u-align-center u-form-group u-form-submit">
                                    <a href="#" class="u-btn u-btn-round u-btn-submit u-button-style u-radius-17 u-text-body-alt-color u-btn-1">Login</a>
                                    <input type="submit" value="submit" class="u-form-control-hidden">
                                </div>
                                <input type="hidden" value="" name="recaptchaResponse">
                            </form>
                        </div>
                        <a href="" class="u-border-1 u-border-active-palette-2-base u-border-hover-palette-1-base u-btn u-button-style u-login-control u-login-forgot-password u-none u-text-palette-1-base u-btn-2">Forgot password?</a>
                    </div>
                </div>
                <img class="u-image u-image-default u-image-1" src="images/login.png" alt="" data-image-width="764" data-image-height="805">
            </div>
        </section>



        <footer class="u-align-center u-clearfix u-footer u-white u-footer" id="sec-b0a2"><img class="u-image u-image-1" src="images/logowhite.png" data-image-width="571" data-image-height="388"><a href="https://nicepage.com/wordpress-themes" class="u-active-none u-btn u-btn-rectangle u-button-style u-hover-none u-none u-radius-0 u-text-body-color u-btn-1">0123456789</a><p class="u-text u-text-default u-text-1"> San Jose,Silicon Valley, California</p><p class="u-text u-text-2"> HappyProgramming@gmail.com</p><div class="u-grey-light-2 u-map u-map-1">
                <div class="embed-responsive">
                    <iframe class="embed-responsive-item" src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d287205.9795192053!2d-121.9745609966744!3d37.31390644748984!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x808fcae48af93ff5%3A0xb99d8c0aca9f717b!2sSan%20Jose%2C%20California%2C%20Hoa%20K%E1%BB%B3!5e0!3m2!1svi!2s!4v1632219783213!5m2!1svi!2s" data-map="JTdCJTIycG9zaXRpb25UeXBlJTIyJTNBJTIybWFwLWVtYmVkJTIyJTJDJTIyYWRkcmVzcyUyMiUzQSUyMk1hbmhhdHRhbiUyQyUyME5ldyUyMFlvcmslMjIlMkMlMjJ6b29tJTIyJTNBMTAlMkMlMjJ0eXBlSWQlMjIlM0ElMjJyb2FkJTIyJTJDJTIybGFuZyUyMiUzQW51bGwlMkMlMjJhcGlLZXklMjIlM0ElMjJkJTIyJTJDJTIybWFya2VycyUyMiUzQSU1QiU1RCUyQyUyMmVtYmVkJTIyJTNBJTIyaHR0cHMlM0ElMkYlMkZ3d3cuZ29vZ2xlLmNvbSUyRm1hcHMlMkZlbWJlZCUzRnBiJTNEITFtMTghMW0xMiExbTMhMWQyODcyMDUuOTc5NTE5MjA1MyEyZC0xMjEuOTc0NTYwOTk2Njc0NCEzZDM3LjMxMzkwNjQ0NzQ4OTg0ITJtMyExZjAhMmYwITNmMCEzbTIhMWkxMDI0ITJpNzY4ITRmMTMuMSEzbTMhMW0yITFzMHg4MDhmY2FlNDhhZjkzZmY1JTI1M0EweGI5OWQ4YzBhY2E5ZjcxN2IhMnNTYW4lMjUyMEpvc2UlMjUyQyUyNTIwQ2FsaWZvcm5pYSUyNTJDJTI1MjBIb2ElMjUyMEslMjVFMSUyNUJCJTI1QjMhNWUwITNtMiExc3ZpITJzITR2MTYzMjIxOTc4MzIxMyE1bTIhMXN2aSEycyUyMiU3RA=="></iframe>
                </div>
            </div><img class="u-image u-image-default u-image-2" src="images/contact.png" alt="" data-image-width="177" data-image-height="361"></footer>
        <section class="u-backlink u-clearfix u-grey-80">
            <a class="u-link" href="https://nicepage.com/website-design" target="_blank">
                <span>Website Design</span>
            </a>
            <p class="u-text">
                <span>created with</span>
            </p>
            <a class="u-link" href="https://nicepage.com/static-site-generator" target="_blank">
                <span>Static Site Generator</span>
            </a>. 
        </section>
    </body>
</html>