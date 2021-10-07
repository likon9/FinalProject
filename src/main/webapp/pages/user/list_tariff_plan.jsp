<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${sessionScope.locale}" scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle scope="session" basename="language"/>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    <style type="text/css">
        .table{
            margin-top: 50px;
            width: 900px;
        }
        tr
        {
            height: 10px;
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
                <input class="btn btn-outline-success" type="submit" value="exit"/>
            </form>
        </div>
    </div>
</nav>
<div id="content">
    <center>
    <table width="500px" class="table">
        <thead>
        <tr>
            <th scope="col">Name</th>
            <th scope="col">Prise</th>
            <th scope="col">Speed</th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="tariffPlan" varStatus="count">
            <tr>
                <td>${tariffPlan.nameTariffPlan}</td>
                <td>${tariffPlan.price}RUB</td>
                <td>${tariffPlan.internetConnectionSpeed}Mb/s</td>
                <td> <form  action="controller" method="get">
                    <input type="hidden" name="command" value="NEW_CONTRACT"/>
                    <input type="hidden" name="tariffPlanId" value="${tariffPlan.tariffPlanId}"/><br>
                    <input type="submit" value="enter"/>
                </form></td></tr>
        </c:forEach>
        </tbody>
    </table>
    </center>

</div>

<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
</body>
</html>
