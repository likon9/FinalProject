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
            margin-top: 50px;
            margin-bottom: 50px;
            margin-left: 500px;
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
    <center>
        <h2>Add tariff</h2>
    </center>
<div class="c1">
    <form action="controller" method="get">
        <input type="hidden" name="command" value="ADD_TARIFF_PLAN"/>
            <div class="mb-3">
                <label class="form-label">Name tariff</label>
                 <input type="text"  class="form-control" name="nameTariffPlan" required pattern="[0-9A-Za-z]{1-50}"/>
            </div>
            <div class="mb-3">
                <label class="form-label">Price</label>
                <input type="text"  class="form-control" name="price" minlength="1" maxlength="5" required pattern="[0-9]{1-5}"/>
            </div>
        <div class="mb-3">
            <label class="form-label">Internet speed</label>
            <input type="text" class="form-control" name="internetConnectionSpeed" minlength="1" required pattern="[0-9]{1-5}"/>
        </div>
        <input  class="btn btn-primary" class="button" type="submit" value="Add"/><br>
    </form>
</div>
   <center>
       ${res}
   </center>
</div>


</body>
</html>
