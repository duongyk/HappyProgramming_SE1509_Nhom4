<%-- 
    Document   : Sign-up
    Created on : Sep 24, 2021, 9:08:19 AM
    Author     : QMC
--%>

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
        <title>Sign up</title>
        <link rel="stylesheet" href="css/nicepage.css" media="screen">
        <link rel="stylesheet" href="css/Sign-up.css" media="screen">
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
        <meta property="og:title" content="Sign up">
        <meta property="og:description" content="">
        <meta property="og:type" content="website">
    </head>
    <%-- Copy from here --%>
        <header class="u-clearfix u-custom-color-1 u-header ">
            <a href="index.jsp" class="u-image u-logo u-image-1" data-image-width="313" data-image-height="95" t>
                <img src="images/Logo.png" class="u-logo-image u-logo-image-1">
            </a>
            <nav class="u-align-right u-menu x u-offcanvas u-menu-1" data-position="" data-responsive-from="MD">

                <div class="u-nav-container">
                    <ul class="u-custom-font u-nav u-spacing-30 u-text-font u-unstyled u-nav-1">
                        <li class="u-nav-item"><a
                                class="u-button-style u-nav-link u-text-active-palette-1-base u-text-grey-90 u-text-hover-grey-90"
                                href="UserControllerMap?service=listAllmentor" style="padding: 10px 36px;">All mentors</a>
                        </li>
                        <li class="u-nav-item"><a
                                class="u-button-style u-nav-link u-text-active-palette-1-base u-text-grey-90 u-text-hover-grey-90"
                                href="SkillControllerMap?service=allSkill" style="padding: 10px 36px;">All skills</a>
                        </li>
                        <li class="u-nav-item"><a class="u-button-style u-nav-link u-text-active-palette-1-base 
                                                  u-text-grey-90 u-text-hover-grey-90"  
                                                  href="SignIn.jsp" style="padding: 10px 36px;">Sign-in</a>
                        </li>
                    </ul>
                </div>

            </nav>
        </header>
        <section class="u-clearfix u-custom-color-2 u-section-1" id="sec-ebef">
            <div class="u-clearfix u-sheet u-sheet-1">
                <img class="u-image u-image-default u-image-1" src="images/signup.png" alt="" data-image-width="512" data-image-height="834">
                <div class="u-form u-form-1">
                    <form action="UserControllerMap" method="POST" class="u-clearfix u-form-custom-backend u-form-spacing-13 u-form-vertical u-inner-form" source="custom" name="form" style="padding: 5px;" redirect="true">
                        <div class="u-form-group u-form-group-1">
                            <label for="text-891d" class="u-form-control-hidden u-label"></label>
                            <input type="text" placeholder="User name" id="text-891d" name="username"pattern="^[^\s]+(\s+[^\s]+)*$" title="Must not contain only spaces, must not start or end by a space " class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white" required="required">
                        </div>
                        <div class="u-form-group u-form-group-2">
                            <label for="text-b9a0" class="u-form-control-hidden u-label"></label>
                            <input type="text" placeholder="Mail" id="text-b9a0" name="mail" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white" required="required">
                        </div>
                        <div class="u-form-group u-form-group-3">
                            <label for="text-1c7c" class="u-form-control-hidden u-label"></label>
                            <input type="text" placeholder="Password" id="text-1c7c" name="password"pattern="^[^\s]+(\s+[^\s]+)*$" title="Must not contain only spaces, must not start or end by a space " class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white" required="required">
                        </div>
                        <div class="u-form-group u-form-group-4">
                            <label for="text-b048" class="u-form-control-hidden u-label"></label>
                            <input type="text" placeholder="Confirm password" id="text-b048" name="confirm" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white" required="required">
                        </div>
                        <div class="u-form-group u-form-group-5">
                            <label for="text-3911" class="u-form-control-hidden u-label"></label>
                            <input type="text" placeholder="fullname" id="text-3911" name="fullname"pattern="^[^\s]+(\s+[^\s]+)*$" title="Must not contain only spaces, must not start or end by a space " class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white" required="required">
                        </div>
                        <div class="u-form-group u-form-phone u-form-group-6">
                            <label for="text-47b9" class="u-form-control-hidden u-label"></label>
                            <input type="tel" placeholder="phone" id="text-47b9" name="phone"pattern="^[^\s]+(\s+[^\s]+)*$" title="Must not contain only spaces, must not start or end by a space " class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white" pattern="\+?\d{0,2}[\s\(\-]?([0-9]{3})[\s\)\-]?([\s\-]?)([0-9]{3})[\s\-]?([0-9]{2})[\s\-]?([0-9]{2})" required="required">
                        </div>
                        <div class="u-form-group u-form-select u-form-group-8">
                            <label for="select-6004" class="u-label">Sex</label>
                            <div class="u-form-select-wrapper">
                                <select id="select-6004" name="sex" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white">
                                    <option value="Male">Male</option>
                                    <option value="Female">Female</option>
                                </select>
                                <svg xmlns="http://www.w3.org/2000/svg" width="14" height="12" version="1" class="u-caret"><path fill="currentColor" d="M4 8L0 4h8z"></path></svg>
                            </div>
                        </div>
                        <div class="u-form-date u-form-group u-form-group-9">
                            <label for="text-13e0" class="u-label">Date of birth</label>
                            <input type="date" id="text-13e0" name="dob" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white">
                        </div>
                        <div class="u-form-group u-form-select u-form-group-10">
                            <label for="select-8da9" class="u-label">Sign up to</label>
                            <div class="u-form-select-wrapper">
                                <select id="select-8da9" name="role" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white" required="required">
                                    <option value="1">Mentor</option>
                                    <option value="2">Mentee</option>
                                </select>
                                <svg xmlns="http://www.w3.org/2000/svg" width="14" height="12" version="1" class="u-caret"><path fill="currentColor" d="M4 8L0 4h8z"></path></svg>
                            </div>
                        </div>
                        <div class="u-align-center u-form-group u-form-submit">
                            <a href="#" class="u-border-none u-btn u-btn-submit u-button-style u-custom-color-3 u-text-body-alt-color u-btn-1">Submit</a>
                            <input type="submit" value="submit" class="u-form-control-hidden">
                        </div>
                        <input type="hidden" value="signUp" name="service">
                    </form>
                </div>
            </div>
        </section>



        <footer class="u-align-center u-clearfix u-footer u-white u-footer" id="sec-b0a2"><img class="u-image u-image-1" src="images/logowhite.png" data-image-width="571" data-image-height="388"><a href="https://nicepage.com/wordpress-themes" class="u-active-none u-btn u-btn-rectangle u-button-style u-hover-none u-none u-radius-0 u-text-body-color u-btn-1">0123456789</a><p class="u-text u-text-default u-text-1"> San Jose,Silicon Valley, California</p><p class="u-text u-text-2"> HappyProgramming@gmail.com</p><div class="u-grey-light-2 u-map u-map-1">
                <div class="embed-responsive">
                    <iframe class="embed-responsive-item" src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d287205.9795192053!2d-121.9745609966744!3d37.31390644748984!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x808fcae48af93ff5%3A0xb99d8c0aca9f717b!2sSan%20Jose%2C%20California%2C%20Hoa%20K%E1%BB%B3!5e0!3m2!1svi!2s!4v1632219783213!5m2!1svi!2s" data-map="JTdCJTIycG9zaXRpb25UeXBlJTIyJTNBJTIybWFwLWVtYmVkJTIyJTJDJTIyYWRkcmVzcyUyMiUzQSUyMk1hbmhhdHRhbiUyQyUyME5ldyUyMFlvcmslMjIlMkMlMjJ6b29tJTIyJTNBMTAlMkMlMjJ0eXBlSWQlMjIlM0ElMjJyb2FkJTIyJTJDJTIybGFuZyUyMiUzQW51bGwlMkMlMjJhcGlLZXklMjIlM0ElMjJkJTIyJTJDJTIybWFya2VycyUyMiUzQSU1QiU1RCUyQyUyMmVtYmVkJTIyJTNBJTIyaHR0cHMlM0ElMkYlMkZ3d3cuZ29vZ2xlLmNvbSUyRm1hcHMlMkZlbWJlZCUzRnBiJTNEITFtMTghMW0xMiExbTMhMWQyODcyMDUuOTc5NTE5MjA1MyEyZC0xMjEuOTc0NTYwOTk2Njc0NCEzZDM3LjMxMzkwNjQ0NzQ4OTg0ITJtMyExZjAhMmYwITNmMCEzbTIhMWkxMDI0ITJpNzY4ITRmMTMuMSEzbTMhMW0yITFzMHg4MDhmY2FlNDhhZjkzZmY1JTI1M0EweGI5OWQ4YzBhY2E5ZjcxN2IhMnNTYW4lMjUyMEpvc2UlMjUyQyUyNTIwQ2FsaWZvcm5pYSUyNTJDJTI1MjBIb2ElMjUyMEslMjVFMSUyNUJCJTI1QjMhNWUwITNtMiExc3ZpITJzITR2MTYzMjIxOTc4MzIxMyE1bTIhMXN2aSEycyUyMiU3RA=="></iframe>
                </div>
            </div><img class="u-image u-image-default u-image-2" src="images/contact.png" alt="" data-image-width="177" data-image-height="361"></footer>
        <section class="u-backlink u-clearfix u-grey-80">
            <a class="u-link" href="https://nicepage.com/website-templates" target="_blank">
                <span>Free Website Templates</span>
            </a>
            <p class="u-text">
                <span>created with</span>
            </p>
            <a class="u-link" href="https://nicepage.com/" target="_blank">
                <span>WYSIWYG Web Builder</span>
            </a>. 
        </section>
    </body>
</html>