<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="styles/css/style.css">
</head>
<body>
<div class="form1">
    <h4>Registration</h4>
    <form action="controller" method="get">
        <input class="input_text" type="hidden" name="command" value="REGISTRATION"/>
        <input class="input_text"type="email" name="email" placeholder="Email"/><br>
        <input class="input_text"type="text" name="login" placeholder="Login"/><br>
        <input class="input_text"type="password" name="password" placeholder="Password"/><br>
        <input class="input_text"type="text" name="name" placeholder="Name"/><br>
        <input class="input_text"type="text" name="surname" placeholder="Surname"/><br>
        <input class="input_text"type="text" name="phone" placeholder="Phone"/><br>
        <input class="button" type="submit" value="Registration"/><br>
    </form>
    <h3>${res}</h3>

    <form action="controller" method="get">
        <input type="hidden" name="command" value="GO_TO_LOGIN"/>
        <h2>If you already have an account, then
            <input class="button1" type="submit" value="use it."/><br></h2>
    </form>
</div>
</body>
</html>
