<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${sessionScope.locale}" scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle scope="session" basename="language"/>
<html>
<head>
    <title><fmt:message key="code.title"/></title>
</head>
<link rel="stylesheet" href="styles/css/style.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
<style type="text/css">
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

<div class="form1">
    <br><br><br><br><br>
    <h4><fmt:message key="code.message"/></h4>
    <h>${fail}</h>
    <center>
        <div class="flex">
            <form style="display:inline;" action="controller" method="post">
                <input type="hidden" name="command" value="CODE"/>
                <input class="input_text1" type="text" name="code" width="100px" placeholder="<fmt:message key="code.code"/>" required pattern="[0-9A-Z]{5}"/><br>
                <input class="button2" type="submit" value="<fmt:message key="code.button.enter"/>"/>
            </form>
            <form style="display:inline;" aclass="button1"ction="controller" method="get">
                <input type="hidden" name="command" value="GO_TO_LOGIN"/>
                <input class="button2" type="submit" value="<fmt:message key="code.button.back"/>"/><br>
            </form>
        </div>
    </center>
</div>
</body>
</html>
