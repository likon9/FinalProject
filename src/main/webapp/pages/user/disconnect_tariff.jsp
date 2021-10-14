<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${sessionScope.locale}" scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle scope="session" basename="language"/>
<head>
    <meta charset="UTF-8">
    <title><fmt:message key="disconnect.tariff.title"/></title>
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
        }
        body {
            margin: 20px;
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
        <h2><fmt:message key="disconnect.tariff.inscription"/>
        </h2>
    <table class="table">
        <tr>
        <tr>
            <td>
                <fmt:message key="disconnect.tariff.plan"/>:
            </td>
            <td>
                ${nameTariffPlan}
            </td>
        </tr>
        <tr>
            <td>
                <fmt:message key="disconnect.tariff.price"/>:
            </td>
            <td>
                ${price}BYN
            </td>
        </tr>
        <tr>
            <td>
                <fmt:message key="disconnect.tariff.speed"/>:
            </td>
            <td>
                ${internetConnectionSpeed}Mb/s
            </td>
        </tr>
        <tr>
            <td>
                <fmt:message key="disconnect.tariff.connect.date"/>:
            </td>
            <td>
                ${connectionDate}
            </td>
        </tr>
    </table>
    </center>
    <br> <br> <br>
    <form action="controller" method="get">
        <input type="hidden" name="command" value="NULLIFICATION_CONTRACT"/>
        <input type="hidden" name="contractId" value="${contractId}"/><br>
        <input class="btn btn-primary" type="submit" value=" <fmt:message key="disconnect.tariff.disconnect"/>"/>
    </form>

</div>
</body>

