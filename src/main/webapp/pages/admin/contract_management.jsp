<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${sessionScope.locale}" scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle scope="session" basename="language"/>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title><fmt:message key="contract.manager.title"/></title>
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

<div id="content"><center>
    <h2><fmt:message key="contract.manager.inscription"/></h2>
</center>
    <form class="c2" action="controller" method="get">
        <input type="hidden" name="command" value="CONTRACT_SELECT"/>
        <select name="select">
            <option value="allContracts"><fmt:message key="contract.manager.select.all"/></option>
            <option value="connectedContracts"><fmt:message key="contract.manager.select.connected"/></option>
            <option value="disconnectedContracts"><fmt:message key="contract.manager.select.disconnected"/></option>
            <br/>
        </select>
        <input class="btn btn-primary" type="submit" value="<fmt:message key="contract.manager.select.select"/>"/>
    </form>
    <center>
        <div class="c1">
            <form  style="display:inline;" action="controller" method="get">
              <input type="hidden" name="command" value="FIND_CONTRACTS_FROM_PARAMETER"/>
              <input type="hidden" name="field" value="contractId" />
             <input type="text" name="parameter" placeholder="<fmt:message key="contract.manager.select.contract.id"/>"
                       required pattern="[0-9]{1,19}"/>
             <input class="btn btn-primary" type="submit" value="<fmt:message key="contract.manager.select.select.contract.id"/>"/>
         </form>

            <form  style="display:inline;" action="controller" method="get">
                <input type="hidden" name="command" value="FIND_CONTRACTS_FROM_PARAMETER"/>
                <input type="hidden" name="field" value="tariffPlanId" />
                <input type="text" name="parameter" placeholder="<fmt:message key="contract.manager.select.tariff.id"/>"
                       required pattern="[0-9]{1,19}"/>
                <input class="btn btn-primary" type="submit" value="<fmt:message key="contract.manager.select.select.tariff.id"/>"/>
            </form>

            <form  style="display:inline;" action="controller" method="get">
                <input type="hidden" name="command" value="FIND_CONTRACTS_FROM_PARAMETER"/>
                <input type="hidden" name="field" value="userId" />
                <input type="text" name="parameter" placeholder="<fmt:message key="contract.manager.select.user.id"/>"
                       required pattern="[0-9]{1,19}"/>
                <input class="btn btn-primary" type="submit" value="<fmt:message key="contract.manager.select.select.user.id"/>"/>
            </form>
    </div>
    </center>
</div>
<div id="sidebar">

    <table class="table">
        <tr>
            <th><fmt:message key="contract.manager.table.id.contract"/></th>
            <th><fmt:message key="contract.manager.table.date"/></th>
            <th><fmt:message key="contract.manager.table.id.user"/></th>
            <th><fmt:message key="contract.manager.table.id.tariff"/></th>
            <th><fmt:message key="contract.manager.table.name"/></th>
            <th><fmt:message key="contract.manager.table.price"/></th>
            <th><fmt:message key="contract.manager.table.speed"/></th>
            <th><fmt:message key="contract.manager.table.status"/></th>
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