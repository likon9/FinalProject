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
        <input class="input_text"type="text" name="login" placeholder="Login" minlength="6" required pattern="[0-9A-Za-z]{6,24}"/><br>
        <input class="input_text"type="password" name="password" placeholder="Password" minlength="6" required pattern="[0-9A-Za-z]{6,24}"/><br>
        <input class="input_text"type="text" name="name" placeholder="Name" minlength="3" required pattern="[A-Za-z]{3,24}"/><br>
        <input class="input_text"type="text" name="surname" placeholder="Surname" minlength="3" required pattern="[A-Za-z]{3,24}"/><br>
        <input class="input_text"type="text" name="phone" placeholder="Phone" length="9" required pattern="[0-9]{9}"/><br>
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
