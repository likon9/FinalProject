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
        .btn-primary{
            width: 150px;
            height: 40px;
        }
        .c1{
            margin-left: 100px;
            margin-top: 50px;
        }
        .c2{
            margin-left: 100px;
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
<div id="content"><center>
    <h2>Contracts</h2>
</center>
    <form class="c2" action="controller" method="get">
        <input type="hidden" name="command" value="CONTRACT_SELECT"/>
        <select name="select">
            <option value="allContracts">Select all contracts</option>
            <option value="connectedContracts">Select connect contracts</option>
            <option value="disconnectedContracts">select disconnect contracts</option>
            <br/>
        </select>
        <input class="btn btn-primary" type="submit" value="select"/>
    </form>
    <div class="c1">
        <form  style="display:inline;" action="controller" method="get">
            <input type="hidden" name="command" value="FIND_CONTRACTS_FROM_PARAMETER"/>
            <input type="hidden" name="field" value="contractId" />
            <input type="text" name="parameter" placeholder="contract id" minlength="19" required pattern="[0-9]{19}"/>
            <input class="btn btn-primary" type="submit" value="Select by contract id"/>
        </form>

            <form  style="display:inline;" action="controller" method="get">
                <input type="hidden" name="command" value="FIND_CONTRACTS_FROM_PARAMETER"/>
                <input type="hidden" name="field" value="tariffPlanId" />
                <input type="text" name="parameter" placeholder="tariff plan id" minlength="19" required pattern="[0-9]{19}"/>
                <input class="btn btn-primary" type="submit" value="Select by tariff plan id"/>
            </form>

            <form  style="display:inline;" action="controller" method="get">
                <input type="hidden" name="command" value="FIND_CONTRACTS_FROM_PARAMETER"/>
                <input type="hidden" name="field" value="userId" />
                <input type="text" name="parameter" placeholder="user id" minlength="19" required pattern="[0-9]{19}"/>
                <input class="btn btn-primary" type="submit" value="Select by user id"/>
            </form>


    </div>
</div>
<div id="sidebar">

    <table class="table">
        <tr>
            <th>id contract</th>
            <th>connection date</th>
            <th>id user</th>
            <th>id tariff plan</th>
            <th>tariff plan name</th>
            <th>tariff plan price</th>
            <th>tariff plan speed</th>
            <th>status</th>
        </tr>
        <c:forEach items="${list}" var="contract" varStatus="count">
            <tr>
                <td>${contract.contractId}</td>
                <td>${contract.connectionDate}</td>
                <td>${contract.userId}</td>
                <td>${contract.tariffPlanId}</td>
                <td>${contract.tariffPlanName}</td>
                <td>${contract.tariffPlanPrice}</td>
                <td>${contract.tariffPlanSpeed}</td>
                <td>${contract.contractStatus}</td>


            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>