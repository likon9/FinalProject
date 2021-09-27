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
    </div>

    <div id="content">
        <form action="controller" method="get">
            <input type="hidden" name="command" value="USER_SELECT"/>
                <select name="select">
                    <option value="allUsers">select all users</option>
                    <option value="activeUsers">select active users</option>
                    <option value="blockedUsers">select blocked users</option>
                    <option value="deletedUsers">select deleted users</option>
                    <br/>
                </select>
            <input type="submit" value="select"/>
        </form>
        <form  action="controller" method="get">
            <input type="hidden" name="command" value="SELECT_BY_ID"/>
            <input type="text" name="user_id" placeholder="user id"/>
            <input type="submit" value="Select by id"/>
        </form>
        <form  action="controller" method="get">
            <input type="hidden" name="command" value="SELECT_BY_LOGIN"/>
            <input type="text" name="login" placeholder="login"/>
            <input type="submit" value="Select by login"/>
        </form>
        <form  action="controller" method="get">
            <input type="hidden" name="command" value="SELECT_BY_NAME"/>
            <input type="text" name="name" placeholder="name"/>
            <input type="submit" value="Select by name"/>
        </form>
        <form  action="controller" method="get">
            <input type="hidden" name="command" value="SELECT_BY_SURNAME"/>
            <input type="text" name="surname" placeholder="surname"/>
            <input type="submit" value="Select by surname"/>
        </form>
        <form  action="controller" method="get">
            <input type="hidden" name="command" value="SELECT_BY_PHONE"/>
            <input type="text" name="phone" placeholder="phone"/>
            <input type="submit" value="Select by phone"/>
        </form>
        <table class="tab1">
            <tr> <td>id user</td>
                <td>login</td>
                <td>email</td>
                <td>name</td>
                <td>surname</td>
                <td>phone</td>
                <td>balance</td>
                <td>date of registration</td>
                <td>status</td></tr>
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
                   </tr>
            </c:forEach>
        </table>
        ${answer}
        <form  action="controller" method="get">
            <input type="hidden" name="command" value="BLOCK_USER"/>
            <input type="text" name="user_id" placeholder="user id"/>
            <input type="submit" value="Block user"/></form>
    </div>



</body>
</html>