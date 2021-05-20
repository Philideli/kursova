<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Войти</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="css/login.css">
</head>
<body>
    <div class="login-page">
        <div class="form">
        <h2>Log In</h2>
        <br>
        <form class="login-form" action="LogInServlet" method="POST">
            <!--<label for="login">Логин</label>-->
            <input type="text" placeholder="Введите логин" name="login" id="login">
            <br>
            <!--<label for="password">Пароль</label>-->
            <input type="password" placeholder="Введите пароль" name="password" id="password">
            <br>
            <input type="submit" value="Войти">
        </form>
        <br>
            <p class="message">
            <h3><a href="registration.jsp">Зарегистрироваться</a></h3>
            </p>
        </div>
    </div>
</body>
</html>