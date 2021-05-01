<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="css/login.css">
    <title>Меню</title>
</head>
<body>
<div class="login-page">
    <div class="form">
        <h2>Меню</h2>
        <hr/>
        <form class="login-form" action="AllQueuesServlet" method="POST">
            <input type="submit" value="Все очереди">
        </form>
        <form class="login-form" action="UserQueuesServlet" method="POST">
            <input type="submit" value="Мои очереди">
        </form>
        <hr/>
        <form class="login-form" action="NewQueue" method="POST">
            <h3>Имя новой очереди</h3>
            <input type="text" placeholder="Введите имя" name="name" id="name">

            <input type="submit" value="Добавить очередь">
        </form>

        <br><br>
        <hr/>
        <br>
        <form class="login-form" action="LogOutServlet" method="GET">
            <input type="submit" value="Выйти">
        </form>
    </div>
</div>
</body>
</html>

