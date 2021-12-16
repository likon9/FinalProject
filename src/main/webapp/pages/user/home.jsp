<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${sessionScope.locale}" scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle scope="session" basename="language"/>
<head>
    <meta charset="UTF-8">
    <title><fmt:message key="home.title"/></title>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    <style type="text/css">
        .column {
            margin-left: 500px;
            width: 400px;
            -webkit-column-count: 2;
            -moz-column-count: 2;
            column-count: 2;
            -webkit-column-gap: 30px;
            -moz-column-gap: 30px;
            column-gap: 30px;
            -webkit-column-rule: 1px solid #ccc;
            -moz-column-rule: 1px solid #ccc;
            column-rule: 1px solid #ccc;
        }

        #sidebar, #content { position: absolute; }
        #sidebar, #content { overflow: auto; padding: 10px; }
        #content {
            top: 100px; /* Расстояние от верхнего края */
            left: 270px; /* Расстояние от левого края */
            right: 270px;
            bottom: 100px;
            border-radius: 5px;
            background-color: rgba(255, 255, 255, 0.8);
        }
        body{
            margin: 20px;
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

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-xl">
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="d-flex">
                    <form  action="controller" method="get">
                        <input type="hidden" name="command" value="TARIFF"/>
                        <input class="btn btn-light" type="submit" value="<fmt:message key="menu.user.button.tariff.tariffs"/>"/>
                    </form>
                </li>
                <li class="d-flex">
                    <form  action="controller" method="get">
                        <input type="hidden" name="command" value="USER_CONTRACT"/>
                        <input class="btn btn-light" type="submit" value="<fmt:message key="menu.user.button.contract.myContracts"/>"/>
                    </form>
                </li>
                <li class="d-flex">
                    <form  action="controller" method="get">
                        <input type="hidden" name="command" value="HOME"/>
                        <input class="btn btn-light" type="submit" value="<fmt:message key="menu.user.button.home"/>"/>
                    </form>
                </li>
            </ul>
            <form class="d-flex" action="controller" method="get">
                <input type="hidden" name="command" value="EXIT_USER"/>
                <input class="btn btn-outline-success" type="submit" value="<fmt:message key="menu.user.button.exit"/>"/>
            </form>
        </div>
    </div>
</nav>
<div id="content">
    <form action="controller" method="get" >
        <input type="hidden" name="command" value="SETTING_USER"/>
        <input class="rounded float-end" type="image" width="30px" src="img/pngwing.png" name="submit">
    </form>
    <text class="fs-4" >
    <p class="fst-italic" > <fmt:message key="home.inscription"/></p>
    </text>
    <div class="column">
        <text class="fs-6">
        <p >
            <fmt:message key="home.login"/><br>
            <fmt:message key="home.email"/><br>
            <fmt:message key="home.name"/><br>
            <fmt:message key="home.surname"/><br>
            <fmt:message key="home.phone"/><br>
            <fmt:message key="home.balance"/><br>
            <fmt:message key="home.discount"/><br>
        </p>
        <p >${login}<br> ${email}<br>${name}<br>${surname}<br>+375 ${phone}<br>${balance}BYN<br>${100*discount}%
            <form  action="controller" method="get">
                <input type="hidden" name="command" value="GO_TO_TOP_UP_BALANCE"/>
                <input class="btn btn-outline-success" type="submit" value="<fmt:message key="home.balance.up"/>"/>
            </form>
            </p>
        </text>
</div>
    <br>
    <br>
    <br>
    <center class="fs-5">
        <c:if test="${resUpdateUserTrue}">
            <fmt:message key="message.user.update"/>
        </c:if>
        <c:if test="${resUpdateUserFalse}">
            <fmt:message key="message.user.update.fail"/>
        </c:if>
        <c:if test="${resConnectTariff}">
            <fmt:message key="message.user.connect.tariff"/>
        </c:if>
        <c:if test="${resDisconnectTariff}">
            <fmt:message key="message.user.disconnect.tariff"/>
        </c:if>
        <c:if test="${resTopUpBalance}">
            <fmt:message key="message.user.balance.top.up"/>
        </c:if>
    </center>
</div>
<script src="<c:url value="/js/unReboot.js"/>"></script>
</body>
</html>