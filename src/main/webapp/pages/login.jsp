<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${sessionScope.locale}" scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle scope="session" basename="language"/>


<html>
<head>
    <title><fmt:message key="login.title"/></title>
    <link rel="stylesheet" href="styles/css/style.css">
</head>
<body>

<div class="form1">
    <c:set var="localeRu">ru</c:set>
    <c:set var="localeEn">en</c:set>
    <form method="post" action="controller">
        <input type="hidden" name="command" value="CHANGE_LANGUAGE_COMMAND"/>
        <button class="language-button" type="submit">
            <c:if test="${language == localeRu}">
                <fmt:message key="header.language.ru"/>
            </c:if>
            <c:if test="${language == localeEn}">
                <fmt:message key="header.language.en"/>
            </c:if>
        </button>
    </form>

    <h1><fmt:message key="login.log"/></h1>
    <form  action="controller" method="get">
        <input type="hidden" name="command" value="LOGIN"/>
        <input class="input_text" type="text" name="login" placeholder="<fmt:message key="login.login"/>" minlength="6" required pattern="[0-9A-Za-z]{6,24}" />
        <input class="input_text" type="password" name="password" placeholder="<fmt:message key="login.password"/>" minlength="6" required pattern="[0-9A-Za-z]{6,24}"/>
        <input class="button" type="submit" value="<fmt:message key="login.singIn"/>"/>
    </form>
    <h3>${fail}</h3>
    <form action="controller" method="get">
        <input type="hidden" name="command" value="GO_TO_REGISTRATION"/>
        <h2><fmt:message key="login.firstTime"/>
            <input class="button1" type="submit" value="<fmt:message key="login.registration"/>"/><br></h2>
    </form>
</div>

</body>
</html>
