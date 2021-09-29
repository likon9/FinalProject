<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<link rel="stylesheet" href="styles/css/style.css">
<body>

<div class="form1">
    <h6>A code has been sent to your email, enter it.</h6>
    <h3>${fail}</h3>
    <form action="controller" method="get">
        <input type="hidden" name="command" value="CODE"/>
        <input class="input_text1" type="text" name="code" width="100px" placeholder=" Code" minlength="5" required pattern="[0-9A-Z]{5}"/>
        <input class="button2" type="submit" value="Enter"/><br>
    </form>

    <form action="controller" method="get">
        <input type="hidden" name="command" value="GO_TO_LOGIN"/>
        <h5>You can go
            <input class="button1" type="submit" value="back."/><br></h5>
    </form>


</div>
</body>
</html>
