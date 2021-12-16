<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${sessionScope.locale}" scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle scope="session" basename="language"/>
<head>
    <meta charset="UTF-8">
    <title><fmt:message key="my.contract.title"/></title>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    <style type="text/css">
        .table{
            margin-top: 50px;
            width: 900px;
        }
        tr {
            height: 10px;
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
    <table class="table table-striped">
        <thead>
        <tr>
            <th> id</th>
            <th scope="col"><fmt:message key="my.contract.name"/></th>
            <th scope="col"><fmt:message key="my.contract.price"/></th>
            <th scope="col"><fmt:message key="my.contract.speed"/></th>
            <th scope="col"><fmt:message key="my.contract.connection.date"/></th>
            <th scope="col"><fmt:message key="my.contract.status"/></th>
            <th scope="col"></th></tr>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="contract" varStatus="count">
            <tr>
                <td>${contract.contractId}</td>
                <td>${contract.tariffPlanName}</td>
                <td>${contract.tariffPlanPrice}</td>
                <td>${contract.tariffPlanSpeed}</td>
                <td>${contract.connectionDate}</td>
                <td>${contract.contractStatus}</td>
                <td> <form  action="controller" method="get">
                    <input type="hidden" name="command" value="DISCONNECT_TARIFF"/>
                    <input type="hidden" name="contractId" value="${contract.contractId}"/><br>
                    <input type="submit" class="btn btn-outline-secondary" value="<fmt:message key="my.contract.disconnect"/>"/>
                </form></td></tr>
        </c:forEach>
        </tbody>
    </table>
    </center>
</div>
<script src="<c:url value="/js/unReboot.js"/>"></script>
</body>
</html>

