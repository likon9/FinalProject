<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        <input type="hidden" name="command" value="USER_MANAGEMENT"/>
        <input type="submit" value="select user"/>
    </form>
    <form  action="controller" method="get">
        <input type="hidden" name="command" value="GO_TO_ADD_TARIFF_PLAN"/>
        <input type="submit" value="add tariff"/>
    </form>
    <form  action="controller" method="get">
        <input type="hidden" name="command" value="TARIFF_PLAN_MANAGEMENT"/>
        <input type="submit" value="update tariff"/>
    </form>
</div>

<div id="content">
    ${res}
    <form action="controller" method="get">
        <input type="hidden" name="command" value="ADD_TARIFF_PLAN"/>
        <input type="text" name="nameTariffPlan" placeholder="Name tariff" required pattern="[0-9A-Za-z]{1-50}"/><br>
        <input type="text" name="price" placeholder="Price" required pattern="[0-9.]{1-10}"/><br>
        <input type="text" name="internetConnectionSpeed" placeholder="Internet speed" required pattern="[0-9]{1-5}"/><br>
        <input class="button" type="submit" value="Registration"/><br>
    </form>
</div>

</body>
</html>
