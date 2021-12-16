<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${sessionScope.locale}" scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle scope="session" basename="language"/>
<head>
    <meta charset="UTF-8">
    <title><fmt:message key="setting.title"/></title>
    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    <style type="text/css">
        h2{
            margin-top: 50px;
        }
        .table
        {width: 600px;
        margin-top: 50px;
       }
        .form-control
        {
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
    <h2><fmt:message key="setting.inscription"/></h2>
    <table class="table">
        <tr>
            <td>
                <fmt:message key="setting.email.now"/>: ${email}
            </td>
            <td>
                <form class="form-label" action="controller" method="post">
                    <input type="hidden" name="command" value="UPDATE_USER"/>
                    <input type="hidden" name="field" value="email"/>
                    <input type="email" class="form-control"  name="parameter" required />
                    <input type="submit" class="btn btn-primary" value="<fmt:message key="setting.email.update"/>"/>
                    <div class="form-text">
                    </div>
                </form>
            </td>
        </tr>
        <tr>
            <td>
                <fmt:message key="setting.name.now"/>: ${name}
            </td>
            <td>
                <form class="form-label" action="controller" method="post">
                    <input type="hidden" name="command" value="UPDATE_USER"/>
                    <input type="hidden" name="field" value="name"/>
                    <input type="text" class="form-control"  name="parameter" mminlength="3" required pattern="[a-zA-Z]*|[ЁёА-я]*{3,24}"/>
                    <input type="submit" class="btn btn-primary" value="<fmt:message key="setting.name.update"/>"/>
                    <div class="form-text">
                    </div>
                </form>
            </td>
        </tr>
        <tr>
            <td>
                <fmt:message key="setting.surname.now"/>: ${surname}
            </td>
            <td>
                <form class="form-label" action="controller" method="post">
                    <input type="hidden" name="command" value="UPDATE_USER"/>
                    <input type="hidden" name="field" value="surname"/>
                    <input type="text" class="form-control"  name="parameter" minlength="3" required pattern="[a-zA-Z]*|[ЁёА-я]*{3,24}"/>
                    <input type="submit" class="btn btn-primary" value="<fmt:message key="setting.surname.update"/>"/>
                    <div class="form-text">
                    </div>
                </form>
            </td>
        </tr>
        <tr>
            <td>
                <fmt:message key="setting.phone.now"/>: +375${phone}
            </td>
            <td>
                <form class="form-label" action="controller" method="post">
                    <input type="hidden" name="command" value="UPDATE_USER"/>
                    <input type="hidden" name="field" value="phone"/>
                    <input type="text" class="form-control"  name="parameter"
                           maxlength="9"  required pattern="[0-9]{9}"/>
                    <input type="submit" class="btn btn-primary" value="<fmt:message key="setting.phone.update"/>"/>
                    <div class="form-text">
                    </div>
                </form>
            </td>
        </tr>
    </table>
    </center>

    <form  action="controller" method="get">
        <input type="hidden" name="command" value="GO_TO_DELETE_USER"/>
        <input type="submit" class="btn btn-outline-danger" value="<fmt:message key="setting.delete"/>"/>
    </form>
</div>
<script src="<c:url value="/js/unReboot.js"/>"></script></body>
</html>


