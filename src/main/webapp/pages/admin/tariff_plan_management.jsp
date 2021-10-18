<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${sessionScope.locale}" scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle scope="session" basename="language"/>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title><fmt:message key="tariff.manager.title"/></title>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    <style type="text/css">
        .btn-primary{
            height: 40px;
        }
        .c1{
            margin-top: 50px;
        }
        .c2{
            margin-left: 200px;
            margin-top: 50px;
        }

        body { margin: 20px;
            background: whitesmoke}
        #sidebar, #content { position: absolute; }
        #sidebar, #content { overflow: auto; padding: 10px; }
        #content {
            height: 400px;
            top: 100px; /* Расстояние от верхнего края */
            left: 270px; /* Расстояние от левого края */
            right: 270px;
            border-radius: 5px;
            background-color: rgba(255, 255, 255, 0.8);
        }
        #sidebar{
            top: 400px; /* Расстояние от верхнего края */
            left: 270px; /* Расстояние от левого края */
            right: 270px;
            bottom: 50px;
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
    <center><h2><fmt:message key="tariff.manager.inscription"/></h2></center>
    <br>
    <center>
        <div class="c1">
            <form  style="display:inline;" action="controller" method="get">
                <input type="hidden" name="command" value="SELECT_BY_NAME_TARIFF_PLAN"/>
                <input  type="text"  name="nameTariffPlan" required pattern="[0-9]{1-10}"/>
                <input  class="btn btn-primary" type="submit" value="<fmt:message key="tariff.manager.select.name"/>"/>
            </form>
            <form  style="display:inline;" action="controller" method="get">
                <input type="hidden" name="command" value="SELECT_BY_PRICE"/>
                <input type="text" name="price" required pattern="[0-9]{1,5}"/>
                <input  class="btn btn-primary" type="submit" value="<fmt:message key="tariff.manager.select.price"/>"/>
            </form>
            <form  style="display:inline;" action="controller" method="get">
                <input type="hidden" name="command" value="SELECT_BY_INTERNET_CONNECTION_SPEED"/>
                <input type="text" name="internetConnectionSpeed" required pattern="[0-9]{1,4}"/>
                <input  class="btn btn-primary" type="submit" value="<fmt:message key="tariff.manager.select.speed"/>"/>
            </form>
        </div>
        <div class="c2">
            <form class="row g-1" action="controller" method="get">
                <div class="col-auto">
                    <input type="hidden" name="command" value="UPDATE_TARIFF_PLAN"/>
                    <input type="text" name="tariffPlanId"   required pattern="[0-9]{1,19}" placeholder="<fmt:message key="tariff.manager.select.id"/>" />
                    <select name="select">
                        <option value="nameTariffPlan"><fmt:message key="tariff.manager.update.name"/></option>
                        <option value="price"><fmt:message key="tariff.manager.update.price"/></option>
                        <option value="internetConnectionSpeed"><fmt:message key="tariff.manager.update.speed"/></option>
                    </select>
                    <input type="text" name="attribute"  minlength="2" required pattern="[0-9A-Za-z]{3-24}"/>
                    <input type="submit" class="btn btn-success"  value="<fmt:message key="tariff.manager.update"/>"/>
                </div>
            </form>
        </div>
        <c:if test="${resTariffUpdateTrue}">
            <fmt:message key="message.admin.tariff.update"/>
        </c:if>
        <c:if test="${resTariffUpdateFalse}">
            <fmt:message key="message.admin.tariff.update.false"/>
        </c:if>
    </center>
</div>

<div id="sidebar">
    <center>
        <table class="table">
            <tr> <th><fmt:message key="tariff.manager.table.id"/></th>
                <th><fmt:message key="tariff.manager.table.name"/></th>
                <th><fmt:message key="tariff.manager.table.price"/>BYN</th>
                <th><fmt:message key="tariff.manager.table.speed"/>Mb/s</th>
                <c:forEach items="${list}" var="tariffPlan" varStatus="count">
            <tr> <td>${tariffPlan.tariffPlanId}</td>
                <td>${tariffPlan.nameTariffPlan}</td>
                <td>${tariffPlan.price}</td>
                <td>${tariffPlan.internetConnectionSpeed}</td>
            </tr>
            </c:forEach>
        </table>
        <br>
    </center>
</div>
</body>
</html>