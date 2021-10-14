<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${sessionScope.locale}" scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle scope="session" basename="language"/>
<html>
<head>
    <title><fmt:message key="user.recovery.title"/></title>
    <link rel="stylesheet" href="styles/css/style.css">
    <style type="text/css">
        .but1{
            margin-top: 20px;
            background: #203da2;
            border: none;
            color: white;
            padding: 5px 32px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            border-radius: 10px;
        }
    </style>
</head>
<body>

<div class="form1">
    <h6><fmt:message key="user.recovery.massage1"/> ${login} <fmt:message key="user.recovery.massage2"/></h6>
    <center>
        <div сlass="flex">
            <form style="display:inline;"  action="controller" method="get">
                <input type="hidden"  name="command" value="USER_RECOVERY"/>
                <input type="hidden" name="login" value="${login}"/>
                <input type="submit" class="but1" value="<fmt:message key="user.recovery.but1"/>"/>
            </form>
            <form style="display:inline;" action="controller" method="get">
                <input type="hidden" name="command" value="GO_TO_LOGIN"/>
               <input type="submit" class="but1" value="<fmt:message key="user.recovery.but2"/>"/>
            </form>
        </div>
    </center>
    </div>
</div>
</body>
</html>

