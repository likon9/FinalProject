<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${sessionScope.locale}" scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle scope="session" basename="language"/>
<head>
    <meta charset="UTF-8">
    <title><fmt:message key="connect.tariff.title"/></title>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    <style type="text/css">
        .btn{
            margin-left: 50px;
        }
        h2{
            margin-top: 50px;
        }
        .table{
            margin-top:100px;
            width: 600px;
            margin-left: 370px;
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
    <center>
        <h2><fmt:message key="connect.tariff.inscription"/>
        </h2>
    </center>
    <table class="table">
        <tr>
            <td>
                <fmt:message key="connect.tariff.login"/>:
            </td>
            <td>
                ${login}
            </td>
        </tr>
        <tr>
            <td>
                <fmt:message key="connect.tariff.email"/>:
            </td>
            <td>
                ${email}
            </td>
        </tr>
        <tr>
            <td>
                <fmt:message key="connect.tariff.name"/>:
            </td>
            <td>
                ${name}
            </td>
        </tr>
        <tr>
            <td>
                <fmt:message key="connect.tariff.surname"/>:
            </td>
            <td>
                ${surname}
            </td>
        </tr>
        <tr>
            <td>
                <fmt:message key="connect.tariff.phone"/>:
            </td>
            <td>
                +375${phone}
            </td>
        </tr>
        <tr>
            <td>
                <fmt:message key="connect.tariff.plan"/>:
            </td>
            <td>
                ${nameTariffPlan}
            </td>
        </tr>
        <tr>
            <td>
                <fmt:message key="connect.tariff.price"/>:
            </td>
            <td>
                ${price}
            </td>
        </tr>
        <tr>
            <td>
                <fmt:message key="connect.tariff.speed"/>:
            </td>
            <td>
                ${internetConnectionSpeed}
            </td>
        </tr>
    </table>
    <br> <br> <br>
    <form action="controller" method="get">
        <input type="hidden" name="command" value="CONNECT_TARIFF"/>
        <input type="hidden" name="tariffPlanId" value="${tariffPlanId}"/><br>
        <input class="btn btn-primary" type="submit" value=" <fmt:message key="connect.tariff.connect"/>"/>
    </form>
</div>
<script src="<c:url value="/js/unReboot.js"/>"></script></body>
</html>

