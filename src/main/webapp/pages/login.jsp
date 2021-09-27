<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" href="styles/css/style.css">
</head>
<body>

<div class="form1">
    <h1>Authorization</h1>
    <form  action="controller" method="get">
        <input type="hidden" name="command" value="LOGIN"/>
        <input class="input_text" type="text" name="login" placeholder="Login" />
        <input class="input_text" type="password" name="password" placeholder="Password"/>
        <input class="button" type="submit" value="Sign in"/>
    </form>
    <h3>${fail}</h3>
    <form action="controller" method="get">
        <input type="hidden" name="command" value="GO_TO_REGISTRATION"/>
        <h2>First time here? Sign up for ap
            <input class="button1" type="submit" value="registration"/><br></h2>
    </form>
</div>

</body>
</html>
