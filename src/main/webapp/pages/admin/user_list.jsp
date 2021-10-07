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
            height: 500px;
            top: 100px; /* Расстояние от верхнего края */
            left: 270px; /* Расстояние от левого края */
            right: 270px;
            border-radius: 5px;
            background-color: rgba(255, 255, 255, 0.8);
        }
        #sidebar{
            top: 470px; /* Расстояние от верхнего края */
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

    <div id="content">
<center>
    <h2>Block user</h2>
</center>
        <form class="c2" action="controller" method="get">
            <input type="hidden" name="command" value="USER_SELECT"/>
            <select name="select">
                <option value="allUsers">select all users</option>
                <option value="activeUsers">select active users</option>
                <option value="blockedUsers">select blocked users</option>
                <option value="deletedUsers">select deleted users</option>
                <br/>
            </select>
            <input class="btn btn-primary" type="submit" value="select"/>
        </form>

        <div class="c1">
            <form  style="display:inline;" action="controller" method="get">
                <input type="hidden" name="command" value="SELECT_BY_ID"/>
                <input type="text" name="userId" placeholder="user id" minlength="19" required pattern="[0-9]{19}"/>
                <input class="btn btn-primary" type="submit" value="Select by id"/>
            </form>
            <form  style="display:inline;"  action="controller" method="get">
                <input type="hidden" name="command" value="SELECT_BY_EMAIL"/>
                <input type="email" name="email" placeholder="email" minlength="6" required pattern="[0-9A-Za-z]{6-24}"/>
                <input class="btn btn-primary" type="submit" value="Select by email"/>
            </form>
                <form  style="display:inline;" action="controller" method="get">
                <input type="hidden" name="command" value="SELECT_BY_LOGIN"/>
                <input type="text" name="login" placeholder="login" minlength="6" required pattern="[0-9A-Za-z]{6-24}"/>
                <input class="btn btn-primary" type="submit" value="Select by login"/>
            </form>
        </div>
        <div class="c1">
            <form style="display:inline;" action="controller" method="get">
                <input type="hidden" name="command" value="SELECT_BY_NAME"/>
                <input type="text" name="name" placeholder="name" minlength="6" required pattern="[0-9A-Za-z]{6-24}" />
            <input class="btn btn-primary" type="submit" value="Select by name"/>
            </form>
            <form style="display:inline;" action="controller" method="get">
                <input type="hidden" name="command" value="SELECT_BY_SURNAME"/>
                <input type="text" name="surname" placeholder="surname" minlength="6" required pattern="[0-9A-Za-z]{6-24}" />
                <input class="btn btn-primary" type="submit" value="Select by surname"/>
            </form>
            <form style="display:inline;" action="controller" method="get">
                <input type="hidden" name="command" value="SELECT_BY_PHONE"/>
                <input type="text" name="phone" placeholder="phone" minlength="9" required pattern="[0-9]{9}" />
                <input class="btn btn-primary" type="submit" value="Select by phone"/>
            </form>
        </div><br>
        <center><h3>${answer}</h3></center><br>
    </div>
        <div id="sidebar">
            <table class="table">
                <tr>
                    <th>id user</th>
                    <th>login</th>
                    <th>email</th>
                    <th>name</th>
                    <th>surname</th>
                    <th>phone</th>
                    <th>balance</th>
                    <th>date of registration</th>
                    <th>status</th>
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
                    <td>
                        <form  action="controller" method="get">
                            <input type="hidden" name="command" value="BLOCK_USER"/>
                            <input type="hidden" name="user_id" placeholder="user id" minlength="19" value="${user.userId}" />
                            <input type="submit" value="Block user"/>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>

