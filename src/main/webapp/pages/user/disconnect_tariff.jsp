<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${sessionScope.locale}" scope="session"/>
<fmt:setLocale value="${language}"/>
<fmt:setBundle scope="session" basename="language"/>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title></title>
    <style type="text/css">
        body { margin: 20px;
            background: #222222}
        #sidebar, #content { position: absolute; }
        #sidebar, #content { overflow: auto; padding: 10px; }

        #sidebar {
            width: 100px;
            top: 100px; /* Расстояние от верхнего края */
            bottom: 100px; /* Расстояние снизу  */
            left: 100px;
            border-radius: 5px;
            background-color: rgba(255, 255, 255, 0.8);
        }
        #content {
            top: 100px; /* Расстояние от верхнего края */
            left: 270px; /* Расстояние от левого края */
            bottom: 100px; right: 100px;
            border-radius: 5px;
            background-color: rgba(255, 255, 255, 0.8);
        }

    </style>
</head>
<body>
<div id="sidebar">
    <form  action="controller" method="get">
        <input type="hidden" name="command" value="TARIFF"/>
        <input type="submit" value="<fmt:message key="menu.user.button.tariff.tariffs"/>"/>
    </form>
    <form  action="controller" method="get">
        <input type="hidden" name="command" value="USER_CONTRACT"/>
        <input type="submit" value="<fmt:message key="menu.user.button.contract.myContracts"/>"/>
    </form>
    <form  action="controller" method="get">
        <input type="hidden" name="command" value="HOME"/>
        <input type="submit" value="<fmt:message key="menu.user.button.home"/>"/>
    </form>


</div>
<div id="content">

    <p>name:${nameTariffPlan}</p>
    <p>price:${price}</p>
    <p>speed:${internetConnectionSpeed}</p>
    <p>date:${connectionDate}</p>
    <form  action="controller" method="get">
        <input type="hidden" name="command" value="DISCONNECT_TARIFF_TRUE"/>
        <input type="hidden" name="idTariffPlan" value="${idContract}"/><br>
        <input type="submit" value="connect"/>
    </form>


</div>
</body>
</html>
