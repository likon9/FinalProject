<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${sessionScope.locale}" scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle scope="session" basename="language"/>
<html>
<head>
    <title><fmt:message key="registration.title"/></title>
    <link rel="stylesheet" href="styles/css/style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    <style>
        body{
            background-repeat: no-repeat;
            background-position: center center;
            background-attachment: fixed;
            -webkit-background-size: cover;
            -moz-background-size: cover;
            -o-background-size: cover;
            background-size: cover;
            opacity: 0.8;
        }
    </style>
</head>
<body background="img/background1.jpg" background-size=cover >
<div class="form1"><br><br><br><br>
    <h1><fmt:message key="registration.registration"/></h1>

    <form action="controller" method="post">
        <center>
        <input type="hidden" name="command" value="REGISTRATION"/>
            <input class="input_text"type="email" name="email" placeholder="Email" required/><br>
        <input class="input_text"type="text" name="login" placeholder="<fmt:message key="registration.login"/>"
               minlength="6" required pattern="[a-zA-Z0-9]{6,24}"/><br>
        <input class="input_text"type="password" name="password" placeholder="<fmt:message key="registration.password"/>"
               minlength="6" required pattern="[a-zA-Z0-9]{6,24}"/><br>
        <input class="input_text"type="text" name="name" placeholder="<fmt:message key="registration.name"/>"
               minlength="3" required pattern="[a-zA-Z]*|[ЁёА-я]*{3,24}"/><br>
        <input class="input_text"type="text" name="surname" placeholder="<fmt:message key="registration.surname"/>"
               minlength="3" required pattern="[a-zA-Z]*|[ЁёА-я]*{3,24}"/><br>
        <div class="c2">
        <select name="select">
            <option value="25">25</option>
            <option value="29">29</option>
            <option value="33">33</option>
            <option value="44">44</option>
        </select>
            <input class="input_text2"style="display:inline;" class="input_text"type="text" name="phone" placeholder="<fmt:message key="registration.phone"/>"
                   maxlength="7" required pattern="[0-9]{7}"/><br>
        </div>
        </center>
<input class="button" type="submit" value="<fmt:message key="registration.registration"/>"/><br>


    </form>
    <h3>
        <c:if test="${res}">
            <fmt:message key="message.reg.incorrect.data"/>
        </c:if>
        <c:if test="${fail}">
            <fmt:message key="message.reg.error.reg"/>
        </c:if>
    </h3>

    <form action="controller" method="get">
        <input type="hidden" name="command" value="GO_TO_LOGIN"/>
        <h4><fmt:message key="registration.message"/>
            <input class="button1" type="submit" value="<fmt:message key="registration.back"/>"/><br></h4>
    </form>
</div>
</body>
</html>