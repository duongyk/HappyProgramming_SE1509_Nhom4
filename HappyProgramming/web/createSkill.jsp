<%-- 
  Copyright (C) 2021, FPT University<br>
  SWP391 - SE1509 - Group 4<br>
  Happyprogramming<br>
 
  Record of change:<br>
  DATE          Version    Author           DESCRIPTION<br>

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
        <title>Create skill</title>
        <link rel="stylesheet" href="css/nicepage.css" media="screen">
        <link rel="stylesheet" href="css/Create-skill.css" media="screen">
        <script class="u-script" type="text/javascript" src="js/jquery.js" defer=""></script>
        <script class="u-script" type="text/javascript" src="js/nicepage.js" defer=""></script>
        <meta name="generator" content="Nicepage 3.25.0, nicepage.com">
        <link id="u-theme-google-font" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i|Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i">
        <meta name="theme-color" content="#478ac9">
        <meta property="og:title" content="Create skill">
        <meta property="og:description" content="">
        <meta property="og:type" content="website">
    </head>
    <header class="u-clearfix u-custom-color-1 u-header ">
        <a href="index.jsp" class="u-image u-logo u-image-1" data-image-width="313" data-image-height="95" t>
            <img src="img/Logo.png" class="u-logo-image u-logo-image-1">
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
                    <li class="u-nav-item"><a
                            class="u-button-style u-nav-link u-text-active-palette-1-base u-text-grey-90 u-text-hover-grey-90"
                            href="UserControllerMap?service=profile" style="padding: 10px 36px;">Profile</a>
                    </li>
                </ul>
            </div>

        </nav>
    </header>
    <section class="u-clearfix u-grey-10 u-section-1" id="sec-84c8">
        <div class="u-clearfix u-sheet u-sheet-1">
            <h4 class="u-text u-text-default u-text-font u-text-1">Create Skill</h4>
            <div class="u-form u-form-1">
                <form action="SkillControllerMap" method="POST" class="u-clearfix u-form-custom-backend u-form-spacing-26 u-form-vertical u-inner-form" source="custom" name="form" style="padding: 50px;" redirect="true">
                    <input type="hidden" name ="service" value="createSkill">
                    <div class="u-form-group u-form-group-1">
                        <input type="text" placeholder="Skill name" id="text-b048" name="sName" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white" pattern="^[^\s]+(\s+[^\s]+)*$" title="Must not contain only spaces, must not start or end by a space " required="required">
                    </div>
                    <div class="u-form-group u-form-message u-form-group-2">
                        <input id="text-3911" name="sDetail" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white" placeholder="Detail" required="required" pattern="^[^\s]+(\s+[^\s]+)*$" title="Must not contain only spaces, must not start or end by a space " >
                    </div>
                    <div class="u-form-group u-form-message u-form-group-2">
                        <input name="sImage" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white" placeholder="Image"  required="required" pattern="^(https?|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]" title="
                               Please enter a valid photo URL">
                    </div>
                    ${mess}
                    <div class="u-align-center u-form-group u-form-submit">
                        <button class="u-border-none u-btn u-btn-round u-btn-submit u-button-style u-custom-color-4 u-radius-13 u-btn-1" type="submit">Create</button>
                    </div>
                </form>

            </div>
        </div>
    </section>


    <footer class="u-align-center u-clearfix u-footer u-white u-footer" id="sec-b0a2"><img class="u-image u-image-1" src="img/logowhite.png" data-image-width="571" data-image-height="388"><a href="https://nicepage.com/wordpress-themes" class="u-active-none u-btn u-btn-rectangle u-button-style u-hover-none u-none u-radius-0 u-text-body-color u-btn-1">0123456789</a><p class="u-text u-text-default u-text-1"> San Jose,Silicon Valley, California</p><p class="u-text u-text-2"> HappyProgramming@gmail.com</p><div class="u-grey-light-2 u-map u-map-1">
            <div class="embed-responsive">
                <iframe class="embed-responsive-item" src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d287205.9795192053!2d-121.9745609966744!3d37.31390644748984!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x808fcae48af93ff5%3A0xb99d8c0aca9f717b!2sSan%20Jose%2C%20California%2C%20Hoa%20K%E1%BB%B3!5e0!3m2!1svi!2s!4v1632219783213!5m2!1svi!2s" data-map="JTdCJTIycG9zaXRpb25UeXBlJTIyJTNBJTIybWFwLWVtYmVkJTIyJTJDJTIyYWRkcmVzcyUyMiUzQSUyMk1hbmhhdHRhbiUyQyUyME5ldyUyMFlvcmslMjIlMkMlMjJ6b29tJTIyJTNBMTAlMkMlMjJ0eXBlSWQlMjIlM0ElMjJyb2FkJTIyJTJDJTIybGFuZyUyMiUzQW51bGwlMkMlMjJhcGlLZXklMjIlM0ElMjJkJTIyJTJDJTIybWFya2VycyUyMiUzQSU1QiU1RCUyQyUyMmVtYmVkJTIyJTNBJTIyaHR0cHMlM0ElMkYlMkZ3d3cuZ29vZ2xlLmNvbSUyRm1hcHMlMkZlbWJlZCUzRnBiJTNEITFtMTghMW0xMiExbTMhMWQyODcyMDUuOTc5NTE5MjA1MyEyZC0xMjEuOTc0NTYwOTk2Njc0NCEzZDM3LjMxMzkwNjQ0NzQ4OTg0ITJtMyExZjAhMmYwITNmMCEzbTIhMWkxMDI0ITJpNzY4ITRmMTMuMSEzbTMhMW0yITFzMHg4MDhmY2FlNDhhZjkzZmY1JTI1M0EweGI5OWQ4YzBhY2E5ZjcxN2IhMnNTYW4lMjUyMEpvc2UlMjUyQyUyNTIwQ2FsaWZvcm5pYSUyNTJDJTI1MjBIb2ElMjUyMEslMjVFMSUyNUJCJTI1QjMhNWUwITNtMiExc3ZpITJzITR2MTYzMjIxOTc4MzIxMyE1bTIhMXN2aSEycyUyMiU3RA=="></iframe>
            </div>
        </div><img class="u-image u-image-default u-image-2" src="img/contact.png" alt="" data-image-width="177" data-image-height="361"></footer>
    <section class="u-backlink u-clearfix u-grey-80">
        <p>Copyright © 2021 HappyProgramming. All rights reserved.</p>
    </section>
</body>
</html>