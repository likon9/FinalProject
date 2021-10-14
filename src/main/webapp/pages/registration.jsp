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
</head>
<body>
<div class="form1">
    <h4><fmt:message key="registration.registration"/></h4>

    <form action="controller" method="get">
        <center>
        <input type="hidden" name="command" value="REGISTRATION"/>
        <input class="input_text"type="email" name="email" placeholder="Email"/><br>
        <input class="input_text"type="text" name="login" placeholder="<fmt:message key="registration.login"/>" minlength="6" required pattern="[0-9A-Za-z]{6,24}"/><br>
        <input class="input_text"type="password" name="password" placeholder="<fmt:message key="registration.password"/>" minlength="6" required pattern="[0-9A-Za-z]{6,70}"/><br>
        <input class="input_text"type="text" name="name" placeholder="<fmt:message key="registration.name"/>" minlength="3" required pattern="[A-Za-z]{3,24}"/><br>
        <input class="input_text"type="text" name="surname" placeholder="<fmt:message key="registration.surname"/>" minlength="3" required pattern="[A-Za-z]{3,24}"/><br>
        <div class="c2">
        <select name="select">
            <option value="25">25</option>
            <option value="29">29</option>
            <option value="33">33</option>
            <option value="44">44</option>
        </select>
        <input class="input_text2"style="display:inline;" class="input_text"type="text" name="phone" placeholder="<fmt:message key="registration.phone"/>"
               required pattern="[0-9]{7}"/><br>
        </div>
            </center>
        <input class="button" type="submit" value="<fmt:message key="registration.registration"/>"/><br>
    </form>


    <h3>${res}</h3>

    <form action="controller" method="get">
        <input type="hidden" name="command" value="GO_TO_LOGIN"/>
        <h2><fmt:message key="registration.message"/>
            <input class="button1" type="submit" value="<fmt:message key="registration.back"/>"/><br></h2>
    </form>
</div>
</body>
</html>