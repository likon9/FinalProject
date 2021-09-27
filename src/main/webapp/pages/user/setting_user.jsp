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
<div class="form1">
    <div id="sidebar">
        <form  action="controller" method="get">
            <input type="hidden" name="command" value="TARIFF"/>
            <input type="submit" value="Tariffs"/></form>
        <form  action="controller" method="get">
            <input type="hidden" name="command" value="CONNECT_TARIFF"/>
            <input type="submit" value="connect tariff"/>
        </form>
        <form  action="controller" method="get">
            <input type="hidden" name="command" value="USER_CONTRACT"/>
            <input type="submit" value="check my tariff plans"/>
        </form>
        <form  action="controller" method="get">
            <input type="hidden" name="command" value="HOME"/>
            <input type="submit" value="home page"/>
        </form>
    </div>
    <div id="content">
        <table>
        <tr>
            <td>${email}</td>
            <td>${name}</td>
            <td>${surname}</td>
            <td>+375${phone}</td>
        </tr>
            <tr>
                <td>
                <form  action="controller" method="get">
                    <input type="hidden" name="command" value="UPDATE_EMAIL"/>
                    <input type="email" name="email"/><br>
                    <input type="submit" value="update email"/>
                </form>
                </td>
                <td>
                <form  action="controller" method="get">
                    <input type="hidden" name="command" value="UPDATE_NAME"/>
                  <input type="text" name="name"/><br>
                    <input type="submit" value="update name"/>
                </form>
                </td>
                <td>
                <form  action="controller" method="get">
                    <input type="hidden" name="command" value="UPDATE_SURNAME"/>
                   <input type="text" name="surname"/><br>
                    <input type="submit" value="update surname"/>
                </form>
                </td>
                <td>
                <form  action="controller" method="get">
                    <input type="hidden" name="command" value="UPDATE_PHONE"/>
                    <input type="textl" name="phone"/><br>
                    <input type="submit" value="update phone"/>
                </form>
                </td>
            </tr>
        </table>
        <form  action="controller" method="get">
            <input type="hidden" name="command" value="HOME"/>
            <input type="submit" value="back"/>
        </form>
</div>
</body>
</html>