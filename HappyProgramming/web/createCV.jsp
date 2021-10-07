<%-- 
  Copyright (C) 2021, FPT University<br>
  SWP391 - SE1509 - Group 4<br>
  Happyprogramming<br>
 
  Record of change:<br>
  DATE          Version    Author           DESCRIPTION<br>

--%>

<%@page import="dao.impl.SkillDAOImpl"%>
<%@page import="dao.SkillDAO"%>
<%@page import="entity.Skill"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<!DOCTYPE html>
<html style="font-size: 16px;" lang="vi">
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta charset="utf-8">
        <meta name="keywords" content="">
        <meta name="description" content="">
        <meta name="page_type" content="np-template-header-footer-from-plugin">
        <title>Create CV</title>
        <link rel="stylesheet" href="css/nicepage.css" media="screen">
        <link rel="stylesheet" href="css/Create-CV.css" media="screen">
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
        <meta property="og:title" content="Create CV">
        <meta property="og:description" content="">
        <meta property="og:type" content="website">
    </head>
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
                        <li class="u-nav-item"><a
                                class="u-button-style u-nav-link u-text-active-palette-1-base u-text-grey-90 u-text-hover-grey-90"
                                href="UserControllerMap?service=profile" style="padding: 10px 36px;">Profile</a>
                        </li>
                    </ul>
                </div>

            </nav>
        </header>
        <section class="u-clearfix u-custom-color-2 u-section-1" id="sec-ebef">
            <div class="u-clearfix u-sheet u-sheet-1">
                <h4 class="u-text u-text-default u-text-1">CREATE CV</h4>
                <div class="u-form u-form-1">
                    <form action="CVControllerMap?service=submitCreateForm" id="thisform" method="POST" class="u-clearfix u-form-custom-backend u-form-spacing-13 u-form-vertical u-inner-form" source="custom" name="form" style="padding: 5px;" redirect="true">
                        <input type="hidden" name="uid" value="<c:out value="${uid}" ></c:out>" />
                        <div class="u-form-group u-form-group-1">
                            <label for="text-b048" class="u-form-control-hidden u-label"></label>
                            <input type="text" placeholder="Profession" id="text-b048" name="profession" pattern=".*\S+.*" title="No white space only" maxlength="20" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white" required="required">
                        </div>
                        <div class="u-form-group u-form-group-2">
                            <label for="text-3911" class="u-form-control-hidden u-label"></label>
                            <input type="text" id="text-3911" name="professionIntro" pattern=".*\S+.*" title="No white space only" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white" required="required" placeholder="Profession introduction">
                        </div>
                        <div class="u-form-group u-form-message u-form-group-3">
                            <label for="text-47b9" class="u-form-control-hidden u-label"></label>
                            <textarea placeholder="Service description" id="text-47b9" name="serviceDescription" pattern=".*\S+.*" title="No white space only" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white" pattern="\+?\d{0,2}[\s\(\-]?([0-9]{3})[\s\)\-]?([\s\-]?)([0-9]{3})[\s\-]?([0-9]{2})[\s\-]?([0-9]{2})" required="required"></textarea>
                        </div>
                        <div class="u-form-group u-form-message u-form-group-4">
                            <label for="text-0855" class="u-form-control-hidden u-label"></label>
                            <textarea placeholder="Achievement" id="text-0855" name="achievement" pattern=".*\S+.*" title="No white space only" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white" required="required"></textarea>
                        </div>
                        <div class="u-form-group u-form-select u-form-group-5">
                            <label for="select-6004" class="u-label">Select skill</label>
                            <div class="u-form-select-wrapper">
                                <!--
                                <select id="select-6004" name="Select skill" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white">
                                  <option value="Java">Java</option>
                                  <option value="Vân vân">Vân vân</option>
                                </select>
                                <svg xmlns="http://www.w3.org/2000/svg" width="14" height="12" version="1" class="u-caret"><path fill="currentColor" d="M4 8L0 4h8z"></path></svg>
                                -->
                                <%
                                    SkillDAO skilldao = new SkillDAOImpl();
                                    ArrayList<Skill> allSkill = skilldao.getAllSkill();
                                    request.setAttribute("allSkill", allSkill);
                                %>

                                <c:set var="count" value="6" scope="page" />

                                <c:forEach items="${allSkill}" var="skill">

                                    <div class="u-form-checkbox u-form-group u-form-partition-factor-2 u-form-group-<c:out value="${count}"></c:out>">

                                            <input type="checkbox" name="skills" value="<c:out value="${skill.getId()}"></c:out>">

                                            <label  class="u-label"><c:out value="${skill.getName()}"></c:out></label>
                                        </div>

                                    <c:set var="count" value="${count+1}" scope="page" />
                                </c:forEach>
                            </div>

                        </div>
                        <div class="u-align-center u-form-group u-form-submit">
                            <a href="#" class="u-border-none u-btn u-btn-submit u-button-style u-custom-color-3 u-text-body-alt-color u-btn-1">Create CV</a>
                            <input type="submit" value="submit" class="u-form-control-hidden">
                        </div>
                        <div class="u-form-send-message u-form-send-success"> Thank you! Your message has been sent. </div>
                        <div class="u-form-send-error u-form-send-message"> Unable to send your message. Please fix errors then try again. </div>
                        <input type="hidden" value="" name="recaptchaResponse">
                    </form>
                </div>
                <img id="image" class="u-image u-image-default u-preserve-proportions u-image-1" src="images/<c:out value="${currUser.getAvatar()}"></c:out>" alt="" data-image-width="1280" data-image-height="1280">     
        
                <input id="avatarURL" form="thisform" onchange="changeImage()" type="file" name="avatar" value="" style="width: 162px;" class="u-border-2 u-border-black u-btn u-button-style u-hover-custom-color-3 u-none u-text-black u-text-hover-white u-btn-2 />
                
                <p class="u-text u-text-default u-text-2"> </p>
                <p class="u-text u-text-default u-text-2"> </p>   
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