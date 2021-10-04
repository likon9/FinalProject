<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${sessionScope.locale}" scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle scope="session" basename="language"/>
<html>
<head>
    <title><fmt:message key="code.title"/></title>
</head>
<link rel="stylesheet" href="styles/css/style.css">
<body>

<div class="form1">
    <h6><fmt:message key="code.message"/></h6>
    <h3>${fail}</h3>
    <form action="controller" method="get">
        <input type="hidden" name="command" value="CODE"/>
        <input class="input_text1" type="text" name="code" width="100px" placeholder="<fmt:message key="code.code"/>" minlength="5" required pattern="[0-9A-Z]{5}"/>
        <input class="button2" type="submit" value="<fmt:message key="code.button.enter"/>"/><br>
    </form>

    <form action="controller" method="get">
        <input type="hidden" name="command" value="GO_TO_LOGIN"/>
        <h5><input class="button1" type="submit" value="<fmt:message key="code.button.back"/>"/><br></h5>
    </form>


</div>
</body>
</html>
