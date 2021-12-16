<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${sessionScope.locale}" scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle scope="session" basename="language"/>

<html>
<head>
    <title><fmt:message key="login.title"/></title>
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

<div class="form1">
    <c:set var="localeRu">ru</c:set>
    <c:set var="localeEn">en</c:set>
    <form method="post" action="controller">
        <input type="hidden" name="command" value="CHANGE_LANGUAGE_COMMAND"/>
        <button class="btn btn-primary btn-sm" type="submit">
            <c:if test="${language == localeRu}">
                <fmt:message key="header.language.ru"/>
            </c:if>
            <c:if test="${language == localeEn}">
                <fmt:message key="header.language.en"/>
            </c:if>
        </button>
    </form>
    <br><br><br><br>
    <h1><fmt:message key="login.log"/></h1>

    <form class="form2" action="controller" method="post">
        <input type="hidden" name="command" value="LOGIN"/>
        <center>
            <input class="input_text" type="text" name="login"
                   placeholder="<fmt:message key="login.login"/>" minlength="6" maxlength="64" required pattern="[a-zA-Z0-9]{6,24}" /><br>
            <input class="input_text" type="password" name="password"
                   placeholder="<fmt:message key="login.password"/>" minlength="6" maxlength="64" required pattern="[0-9A-Za-z0-9]{6,24}"/><br>
        </center>
            <input class="button" type="submit" value="<fmt:message key="login.singIn"/>"/>
    </form>

    <h2>
        <c:if test="${res}">
            <fmt:message key="message.login.reg"/>
        </c:if>
        <c:if test="${resUserDelete}">
            <fmt:message key="message.user.delete"/>
        </c:if>
        <c:if test="${resRecoveryUser}">
            <fmt:message key="message.user.recovery"/>
        </c:if>
    </h2>
    <h3>
        <c:if test="${resUserBlock}">
            <fmt:message key="message.login.block.user"/>
        </c:if>
        <c:if test="${resUserNotFound}">
            <fmt:message key="message.login.fail"/>
        </c:if>
    </h3>
    <form action="controller" method="get">
        <input type="hidden" name="command" value="GO_TO_REGISTRATION"/>
        <h4><fmt:message key="login.firstTime"/>
            <input class="button1" type="submit" value="<fmt:message key="login.registration"/>"/><br></h4>
    </form>

</div>
<script language="JavaScript">
    $('p').append(Math.random());

    $(window).bind({
        beforeunload: function(ev) {
            ev.preventDefault();
        },
        unload: function(ev) {
            ev.preventDefault();
        }
    });
</script>
<script src="<c:url value="/js/unReboot.js"/>"></script>
</body>
</html>

