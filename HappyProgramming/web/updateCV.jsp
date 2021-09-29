<%-- 
    Document   : Update-CV
    Created on : Sep 24, 2021, 8:04:14 AM
    Author     : PC
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@page import="entity.Skill"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entity.CV"%>
<%@page import="entity.User"%>

<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<!DOCTYPE html>
<html style="font-size: 16px;" lang="vi">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta charset="utf-8">
        <meta name="keywords" content="">
        <meta name="description" content="">
        <meta name="page_type" content="np-template-header-footer-from-plugin">
        <title>Update CV</title>
        <link rel="stylesheet" href="css/nicepage.css" media="screen">
        <link rel="stylesheet" href="Update-CV.css" media="screen">
        <script class="u-script" type="text/javascript" src="js/jquery.js" defer=""></script>
        <script class="u-script" type="text/javascript" src="js/nicepage.js" defer=""></script>
        <meta name="generator" content="Nicepage 3.25.0, nicepage.com">
        <link id="u-theme-google-font" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i|Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i">


        <meta name="theme-color" content="#478ac9">
        <meta property="og:title" content="Update CV">
        <meta property="og:description" content="">
        <meta property="og:type" content="website">
    </head>
    <%
        //String title = request.getAttribute("title").toString();
        
        //User mentorProfile = (User)request.getAttribute("mentorprofile");
        //CV mentorCV = (CV) request.getAttribute("mentorcv");     
        
        //ArrayList<Skill> allSkill = (ArrayList<Skill>) request.getAttribute("allskill");
        
        //ArrayList<String> mentor_skill_Id = (ArrayList<String>) request.getAttribute("mentorskill");
    %>    
    <%
        User x = (User) request.getSession().getAttribute("mentorprofile");
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
                                href="UserControllerMap?service=listRequest" style="padding: 10px 36px;">Request</a>
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
        <section class="u-clearfix u-custom-color-2 u-section-1" id="sec-ebef">
            <div class="u-clearfix u-sheet u-sheet-1">
                <h4 class="u-text u-text-default u-text-1"><c:out value="${title}"></c:out></h4>
                <div class="u-form u-form-1">
                    <form id="my_form"  action="CVControllerMap?service=submitFormUpdate" method="POST" class="u-clearfix u-form-spacing-9 u-form-vertical u-inner-form" source="custom" name="form" style="padding: 0px;">
                        <input type="hidden" name="uid" value="<c:out value="${mentorprofile.getuId()}"></c:out>" readonly="readonly" />
                        <div class="u-form-group u-form-group-1">
                            <label for="text-891d" class="u-form-control-hidden u-label"></label>
                            <input type="text" placeholder="User name" id="text-891d" name="username" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white" required="required" value="<c:out value="${mentorprofile.getUsername()}"></c:out>" readonly="readonly">
                        </div>
                        <div class="u-form-group u-form-group-2">
                            <label for="text-3911" class="u-form-control-hidden u-label"></label>
                            <input type="text" placeholder="Fullname" id="text-3911" name="fullname" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white" required="required" value="<c:out value="${mentorprofile.getFullname()}"></c:out>">
                        </div>
                        <div class="u-form-date u-form-group u-form-partition-factor-2 u-form-group-3">
                            <label for="text-13e0" class="u-label">Date of birth</label>
                            <input type="date" id="text-13e0" name="dob" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white" value="<c:out value="${mentorprofile.getDob()}"></c:out>">
                        </div>
                        <div class="u-form-group u-form-partition-factor-2 u-form-select u-form-group-4">
                            <label for="select-6004" class="u-label">Sex</label>
                            <div class="u-form-select-wrapper">
                                <select id="select-6004" name="sex" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white">
                                    <option value="Male">Male</option>
                                    <option value="Female">Female</option>
                                </select>
                                <svg xmlns="http://www.w3.org/2000/svg" width="14" height="12" version="1" class="u-caret"><path fill="currentColor" d="M4 8L0 4h8z"></path></svg>
                            </div>
                        </div>
                        <div class="u-form-group u-form-group-5">
                            <label for="text-b9a0" class="u-form-control-hidden u-label"></label>
                            <input type="text" placeholder="Mail" id="text-b9a0" name="mail" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white" required="required" value="<c:out value="${mentorprofile.getuMail()}"></c:out>">
                        </div>
                        <div class="u-form-group u-form-group-6">
                            <label for="text-0855" class="u-form-control-hidden u-label"></label>
                            <input type="text" placeholder="Phone" id="text-0855" name="phone" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white" required="required" value="<c:out value="${mentorprofile.getuPhone()}"></c:out>">
                        </div>
                        <div class="u-form-group u-form-group-7">
                            <label for="text-1c7c" class="u-form-control-hidden u-label"></label>
                            <input type="text" placeholder="Profession" id="text-1c7c" name="profession" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white" required="required" value="<c:out value="${mentorcv.getProfession()}"></c:out>">
                        </div>
                        <div class="u-form-group u-form-message u-form-group-8">
                            <label for="text-b048" class="u-form-control-hidden u-label"></label>
                            <textarea placeholder="Profession introduction" id="text-b048" name="professionIntro" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white" required="required" ><c:out value="${mentorcv.getProfessionIntro()}"></c:out></textarea>
                        </div>
                        <div class="u-form-group u-form-message u-form-group-9">
                            <label for="text-47b9" class="u-form-control-hidden u-label"></label>
                            <textarea placeholder="Service description" id="text-47b9" name="serviceDescription" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white" pattern="\+?\d{0,2}[\s\(\-]?([0-9]{3})[\s\)\-]?([\s\-]?)([0-9]{3})[\s\-]?([0-9]{2})[\s\-]?([0-9]{2})" required="required"><c:out value="${mentorcv.getServiceDescript()}"></c:out></textarea>
                        </div>
                        <div class="u-form-group u-form-textarea u-form-group-10">
                            <label for="textarea-3873" class="u-form-control-hidden u-label"></label>
                            <textarea rows="4" cols="50" id="textarea-3873" name="achievement" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white" required="" placeholder="Achievement"><c:out value="${mentorcv.getAchivement()}"></c:out></textarea>
                        </div>
                        <div class="u-form-group u-form-textarea u-form-group-11">
                            <p class="u-text u-text-default u-text-2">Skills:&nbsp;</p>
                        </div>
                        
                        <%
                            //int count = 12;
                            //for(Skill skill: allSkill) {
                        %>
                        <c:set var="count" value="12" scope="page" />
                        <c:forEach items="${allskill}" var="skill">
                        <div class="u-form-checkbox u-form-group u-form-partition-factor-2 u-form-group-<c:out value="${count}"></c:out>">
                            <%
                                //String.valueOf();
                                //if (mentor_skill_Id.contains(""+skill.getsId())) {
                            %>
                            <c:choose>
                                <c:when test="${mentorskill.contains(String.valueOf(skill.getsId()))}">
                            <input type="checkbox" name="skills" value="<c:out value="${skill.getsId()}"></c:out>" checked>
                            <%
                                //} else {
                            %>
                                </c:when>
                                <c:otherwise>
                            <input type="checkbox" name="skills" value="<c:out value="${skill.getsId()}"></c:out>">
                            <%
                                //}
                            %>
                                </c:otherwise>
                            </c:choose>
                            <label  class="u-label"><c:out value="${skill.getsName()}"></c:out></label>
                        </div>
                        <%
                            //count++;
                            //}
                        %>
                        <c:set var="count" value="${count+1}" scope="page" />
                        </c:forEach>
                        <div class="u-align-center u-form-group u-form-submit">
                            <a href="javascript:{}" onclick="document.getElementById('my_form').submit();" class="u-border-none u-btn u-btn-submit u-button-style u-custom-color-3 u-text-body-alt-color u-btn-1">Update CV</a>
                        </div>
                        
                    </form>
                </div>
                
                <img class="u-image u-image-default u-preserve-proportions u-image-1" src="images/79506d11e688f731ccd8668ea9a270a8f1c3bbe48deaaa39778eb19163c1b45a18be6e4c3e8f265299f9a3284a2e8cc04605fdfc7290b9d7c20251_1280.png" alt="" data-image-width="1280" data-image-height="1280">
                <a href="https://nicepage.com/joomla-templates" class="u-border-2 u-border-black u-btn u-button-style u-hover-custom-color-3 u-none u-text-black u-text-hover-white u-btn-2">Change avatar</a>
                
            </div>
        </section>


        <footer class="u-align-center u-clearfix u-footer u-white u-footer" id="sec-b0a2"><img class="u-image u-image-1" src="images/logowhite.png" data-image-width="571" data-image-height="388"><a href="https://nicepage.com/wordpress-themes" class="u-active-none u-btn u-btn-rectangle u-button-style u-hover-none u-none u-radius-0 u-text-body-color u-btn-1">0123456789</a><p class="u-text u-text-default u-text-1"> San Jose,Silicon Valley, California</p><p class="u-text u-text-2"> HappyProgramming@gmail.com</p><div class="u-grey-light-2 u-map u-map-1">
                <div class="embed-responsive">
                    <iframe class="embed-responsive-item" src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d287205.9795192053!2d-121.9745609966744!3d37.31390644748984!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x808fcae48af93ff5%3A0xb99d8c0aca9f717b!2sSan%20Jose%2C%20California%2C%20Hoa%20K%E1%BB%B3!5e0!3m2!1svi!2s!4v1632219783213!5m2!1svi!2s" data-map="JTdCJTIycG9zaXRpb25UeXBlJTIyJTNBJTIybWFwLWVtYmVkJTIyJTJDJTIyYWRkcmVzcyUyMiUzQSUyMk1hbmhhdHRhbiUyQyUyME5ldyUyMFlvcmslMjIlMkMlMjJ6b29tJTIyJTNBMTAlMkMlMjJ0eXBlSWQlMjIlM0ElMjJyb2FkJTIyJTJDJTIybGFuZyUyMiUzQW51bGwlMkMlMjJhcGlLZXklMjIlM0ElMjJkJTIyJTJDJTIybWFya2VycyUyMiUzQSU1QiU1RCUyQyUyMmVtYmVkJTIyJTNBJTIyaHR0cHMlM0ElMkYlMkZ3d3cuZ29vZ2xlLmNvbSUyRm1hcHMlMkZlbWJlZCUzRnBiJTNEITFtMTghMW0xMiExbTMhMWQyODcyMDUuOTc5NTE5MjA1MyEyZC0xMjEuOTc0NTYwOTk2Njc0NCEzZDM3LjMxMzkwNjQ0NzQ4OTg0ITJtMyExZjAhMmYwITNmMCEzbTIhMWkxMDI0ITJpNzY4ITRmMTMuMSEzbTMhMW0yITFzMHg4MDhmY2FlNDhhZjkzZmY1JTI1M0EweGI5OWQ4YzBhY2E5ZjcxN2IhMnNTYW4lMjUyMEpvc2UlMjUyQyUyNTIwQ2FsaWZvcm5pYSUyNTJDJTI1MjBIb2ElMjUyMEslMjVFMSUyNUJCJTI1QjMhNWUwITNtMiExc3ZpITJzITR2MTYzMjIxOTc4MzIxMyE1bTIhMXN2aSEycyUyMiU3RA=="></iframe>
                </div>
            </div><img class="u-image u-image-default u-image-2" src="images/contact.png" alt="" data-image-width="177" data-image-height="361"></footer>
        <section class="u-backlink u-clearfix u-grey-80">

            <p class="u-text">
                <span>Copyright © 2021 Happy Programming. All rights reserved.</span>
            </p>

        </section>
    </body>
</html>