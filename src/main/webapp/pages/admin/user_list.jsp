<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${sessionScope.locale}" scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle scope="session" basename="language"/>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title><fmt:message key="user.management.title"/></title>
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
        #sidebar, #content { position: absolute; }
        #sidebar, #content { overflow: auto; padding: 10px; }
        #content {
            height: 500px;
            top: 100px; /* Расстояние от верхнего края */
            left: 170px; /* Расстояние от левого края */
            right: 170px;
            border-radius: 5px;
            background-color: rgba(255, 255, 255, 0.8);
        }
        #sidebar{
            top: 480px; /* Расстояние от верхнего края */
            left: 170px; /* Расстояние от левого края */
            right: 170px;
            bottom: 50px;
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
    <h2><fmt:message key="user.management.inscription"/></h2>
</center>
        <form class="c2" action="controller" method="get">
            <input type="hidden" name="command" value="USER_SELECT"/>
            <select name="select">
                <option value="allUsers"><fmt:message key="user.management.select.all"/></option>
                <option value="activeUsers"><fmt:message key="user.management.select.active"/></option>
                <option value="blockedUsers"><fmt:message key="user.management.select.blocked"/></option>
                <option value="deletedUsers"><fmt:message key="user.management.select.deleted"/></option>
                <br/>
            </select>
            <input class="btn btn-primary" type="submit" value="<fmt:message key="user.management.select"/>"/>
        </form>
<center>
        <div class="c1">
            <form  style="display:inline;" action="controller" method="get">
                <input type="hidden" name="command" value="SELECT_BY_ID"/>
                <input type="text" name="userId" placeholder="<fmt:message key="user.management.id"/>"
                       required pattern="[0-9]{1,19}"/>
                <input class="btn btn-primary" type="submit" value="<fmt:message key="user.management.select.id"/>"/>
            </form>
            <form  style="display:inline;"  action="controller" method="get">
                <input type="hidden" name="command" value="SELECT_BY_EMAIL"/>
                <input type="email" name="email" placeholder="<fmt:message key="user.management.email"/>" required/>
                <input class="btn btn-primary" type="submit" value="<fmt:message key="user.management.select.email"/>"/>
            </form>
                <form  style="display:inline;" action="controller" method="get">
                <input type="hidden" name="command" value="SELECT_BY_LOGIN"/>
                <input type="text" name="login" placeholder="<fmt:message key="user.management.login"/>"
                       minlength="6" required pattern="[a-zA-Z0-9]{6,24}"/>
                <input class="btn btn-primary" type="submit" value="<fmt:message key="user.management.select.login"/>"/>
            </form>
        </div>
        <div class="c1">
            <form style="display:inline;" action="controller" method="get">
                <input type="hidden" name="command" value="SELECT_BY_NAME"/>
                <input type="text" name="name" placeholder="<fmt:message key="user.management.name"/>"
                       minlength="3" required pattern="[a-zA-Z]*|[ЁёА-я]*{3,24}"/>
            <input class="btn btn-primary" type="submit" value="<fmt:message key="user.management.select.name"/>"/>
            </form>
            <form style="display:inline;" action="controller" method="get">
                <input type="hidden" name="command" value="SELECT_BY_SURNAME"/>
                <input type="text" name="surname" placeholder="<fmt:message key="user.management.surname"/>"
                       minlength="3" required pattern="[a-zA-Z]*|[ЁёА-я]*{3,24}"/>
                <input class="btn btn-primary" type="submit" value="<fmt:message key="user.management.select.surname"/>"/>
            </form>
            <form style="display:inline;" action="controller" method="get">
                <input type="hidden" name="command" value="SELECT_BY_PHONE"/>
                <input type="text" name="phone" placeholder="<fmt:message key="user.management.phone"/>"
                       maxlength="9"  required pattern="[0-9]{9}"/>
                <input class="btn btn-primary" type="submit" value="<fmt:message key="user.management.select.phone"/>"/>
            </form>
        </div>
</center>
        <br>
        <center>
            <h3>
                <c:if test="${resBlockUser}">
                  user:  ${userId} <fmt:message key="message.admin.block.user"/>
                </c:if>
                <c:if test="${resNewDiscountTrue}">
                    user:  ${userId} <fmt:message key="message.admin.new.discount"/>
                </c:if>
                <c:if test="${resWriteTrue}">
                    user: ${userId} <fmt:message key="message.admin.write.of.account"/>
                </c:if>
            </h3>
        </center>
        <br>
    </div>
        <div id="sidebar">
            <table class="table table-striped">
                <tr>
                    <th><fmt:message key="user.management.table.id"/></th>
                    <th><fmt:message key="user.management.table.login"/></th>
                    <th><fmt:message key="user.management.table.email"/></th>
                    <th><fmt:message key="user.management.table.name"/></th>
                    <th><fmt:message key="user.management.table.surname"/></th>
                    <th><fmt:message key="user.management.table.phone"/></th>
                    <th><fmt:message key="user.management.table.balance"/></th>
                    <th><fmt:message key="user.management.table.date"/></th>
                    <th><fmt:message key="user.management.table.status"/></th>
                    <th><fmt:message key="user.management.table.discount"/></th>
                    <th></th>
                    <th></th>
                </tr>
            <c:forEach items="${list}" var="user" varStatus="count">
                <tr> <td>${user.userId}</td>
                    <td>${user.login}</td>
                    <td>${user.email}</td>
                    <td>${user.name}</td>
                    <td>${user.surname}</td>
                    <td>${user.phone}</td>
                    <td>${user.balance}</td>
                    <td>${user.registrationDate}</td>
                    <td>${user.userStatus}</td>
                    <td>${100*user.discount}%</td>
                    <td>
                        <form  action="controller" method="get">
                            <input type="hidden" name="command" value="NEW_USER_DISCOUNT"/>
                            <select name="select">
                                <option value="0.1">10%</option>
                                <option value="0.2">20%</option>
                                <option value="0.3">30%</option>
                                <br/>
                            </select>
                            <input type="hidden" name="userId" placeholder="user id" value="${user.userId}" />
                            <input class="btn btn-light" type="submit" value="<fmt:message key="user.management.table.discount.update"/>"/>
                        </form>
                    </td>
                    <td>
                        <form  action="controller" method="get">
                            <input type="hidden" name="command" value="WRITE_OF_ACCOUNT"/>
                            <input type="hidden" name="userId" placeholder="user id" value="${user.userId}" />
                            <input class="btn btn-light" type="submit" value="<fmt:message key="user.management.table.write.of"/>"/>
                        </form>
                    </td>
                    <td>
                        <form  action="controller" method="get">
                            <input type="hidden" name="command" value="BLOCK_USER"/>
                            <input type="hidden" name="userId" placeholder="user id" minlength="19" value="${user.userId}" />
                            <input class="btn btn-light" type="submit" value="<fmt:message key="user.management.block.user"/>"/>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
<script src="<c:url value="/js/unReboot.js"/>"></script>
</body>
</html>

