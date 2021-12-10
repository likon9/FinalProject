<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${sessionScope.locale}" scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle scope="session" basename="language"/>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title><fmt:message key="new.tariff.title"/></title>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    <style type="text/css">
        .c1{
            margin-top: 50px;
            margin-bottom: 50px;
            margin-left: 500px;
        }
        .form-control{
            width: 300px;
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
                        <input type="hidden" name="command" value="USER_MANAGEMENT"/>
                        <input class="btn btn-light" type="submit" value="<fmt:message key="menu.admin.button.management.user"/>"/>
                    </form>
                </li>
                <li class="d-flex">
                    <form  action="controller" method="get">
                        <input type="hidden" name="command" value="GO_TO_ADD_TARIFF_PLAN"/>
                        <input class="btn btn-light" type="submit" value="<fmt:message key="menu.admin.button.add.tariff"/>"/>
                    </form>
                </li>
                <li class="d-flex">
                    <form  action="controller" method="get">
                        <input type="hidden" name="command" value="TARIFF_PLAN_MANAGEMENT"/>
                        <input class="btn btn-light" type="submit" value="<fmt:message key="menu.admin.button.management.tariff"/>"/>
                    </form>
                </li>
                <li class="d-flex">
                    <form  action="controller" method="get">
                        <input type="hidden" name="command" value="GO_TO_CONTRACT_MANAGEMENT"/>
                        <input class="btn btn-light" type="submit" value="<fmt:message key="menu.admin.button.management.contract"/>"/>
                    </form>
                </li>
            </ul>
            <form class="d-flex" action="controller" method="get">
                <input type="hidden" name="command" value="EXIT_USER"/>
                <input class="btn btn-outline-success" type="submit" value="<fmt:message key="menu.admin.button.exit"/>"/>
            </form>
        </div>
    </div>
</nav>

<div id="content">
    <center>
        <h2><fmt:message key="new.tariff.inscription"/></h2>
    </center>
<div class="c1">
    <form action="controller" method="get">
        <input type="hidden" name="command" value="ADD_TARIFF_PLAN"/>
            <div class="mb-3">
                <label class="form-label"><fmt:message key="new.tariff.name"/></label>
                 <input type="text"  class="form-control" name="nameTariffPlan"
                        minlength="3" required pattern="[a-zA-Z1-9А-Яа-я].{3,24}"/>
            </div>
            <div class="mb-3">
                <label class="form-label"><fmt:message key="new.tariff.price"/></label>
                <input type="text"  class="form-control" name="price"
                       required pattern="[0-9]{1,5}"/>
            </div>
            <div class="mb-3">
                <label class="form-label"><fmt:message key="new.tariff.speed"/></label>
                <input type="text" class="form-control" name="internetConnectionSpeed"
                       required pattern="[0-9]{1,4}"/>
            </div>
        <input  class="btn btn-primary" class="button" type="submit" value="<fmt:message key="new.tariff.add"/>"/><br>
    </form>
</div>
   <center>
       <c:if test="${resAddTariffTrue}">
           <fmt:message key="message.admin.add.tariff"/>
       </c:if>
       <c:if test="${resAddTariffFalse}">
           <fmt:message key="message.admin.add.tariff.fail"/>
       </c:if>
   </center>
</div>


</body>
</html>
