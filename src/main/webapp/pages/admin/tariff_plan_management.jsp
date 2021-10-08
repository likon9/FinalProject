<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title></title>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    <style type="text/css">
        .c1{
            margin-left: 100px;
            margin-top: 50px;
        }
        .c2{
            margin-top: 50px;
            margin-left: 300px;
        }
        .table{
        margin-top: 20px;
        width: 600px;
    }
        .form-control{
        width: 300px;
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
                        <input type="hidden" name="command" value="USER_MANAGEMENT"/>
                        <input class="btn btn-light" type="submit" value="Select user"/>
                    </form>
                </li>
                <li class="d-flex">
                    <form  action="controller" method="get">
                        <input type="hidden" name="command" value="GO_TO_ADD_TARIFF_PLAN"/>
                        <input class="btn btn-light" type="submit" value="Add tariff"/>
                    </form>
                </li>
                <li class="d-flex">
                    <form  action="controller" method="get">
                        <input type="hidden" name="command" value="TARIFF_PLAN_MANAGEMENT"/>
                        <input class="btn btn-light" type="submit" value="Update tariff"/>
                    </form>
                </li>
                <li class="d-flex">
                    <form  action="controller" method="get">
                        <input type="hidden" name="command" value="GO_TO_CONTRACT_MANAGEMENT"/>
                        <input class="btn btn-light" type="submit" value="Contract management"/>
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
<center><h2>Update tariff plan</h2></center>
<br>
    <div class="c1">
        <form  style="display:inline;" action="controller" method="get">
            <input type="hidden" name="command" value="SELECT_BY_NAME_TARIFF_PLAN"/>
            <input  type="text"  name="nameTariffPlan" required pattern="[0-9]{1-10}"/>
            <input  class="btn btn-primary" type="submit" value="Select by name"/>
        </form>
        <form  style="display:inline;" action="controller" method="get">
            <input type="hidden" name="command" value="SELECT_BY_PRICE"/>
            <input type="text" name="price" required pattern="[0-9]{1-10}"/>
            <input  class="btn btn-primary" type="submit" value="Select by price"/>
        </form>
        <form  style="display:inline;" action="controller" method="get">
            <input type="hidden" name="command" value="SELECT_BY_INTERNET_CONNECTION_SPEED"/>
            <input type="text" name="internetConnectionSpeed" required pattern="[0-9]{1-10}"/>
            <input  class="btn btn-primary" type="submit" value="Select by speed"/>
        </form>
    </div>



    <div class="c2">
        <form class="row g-1" action="controller" method="get">
                <div class="col-auto">
                <input type="hidden" name="command" value="UPDATE_TARIFF_PLAN"/>
                <input type="text" name="tariffPlanId"  required pattern="[0-9]{19}" placeholder="id" />
                <select name="select">
                    <option value="nameTariffPlan">Name tariff</option>
                    <option value="price">price</option>
                    <option value="internetConnectionSpeed">Internet Speed</option>
                </select>
                <input type="text" name="attribute"  minlength="2" required pattern="[0-9A-Za-z]{2-50}"/>
                <input type="submit" class="btn btn-success"  value="Update this tariff plan"/>
            </div>
        </form>
    </div>
    <center>${res}
    <table class="table">
        <tr> <td>id tariff plan</td>
            <td>name tariff plan</td>
            <td>price</td>
            <td>internet speed</td>
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