<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${sessionScope.locale}" scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle scope="session" basename="language"/>
<html>
<head>
    <title><fmt:message key="top.up.balance.title"/></title>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    <style type="text/css">
        .c1{
            margin-top: 150px;
        }
        body { margin: 20px;
            background: whitesmoke}
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
    </style>
</head>
<body>
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
    <center>

        <form  class="c1" action="controller" method="get">
            <fmt:message key="top.up.balance.inscription"/>${balance}BYN<br><br><br>
            <input type="hidden" name="command" value="TOP_UP_BALANCE"/>
            <input class="input_text" type="text" name="balance" placeholder="<fmt:message key="top.up.balance"/>" maxlength="3" required pattern="[0-9]{1-3}" />
            <input class="btn btn-outline-success" type="submit" value="<fmt:message key="top.up.balance.but"/>"/>
        </form>
    </center>
</div>
</body>
</html>
