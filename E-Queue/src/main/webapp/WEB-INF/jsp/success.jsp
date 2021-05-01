<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" type="text/css" href="css/login.css">
  <title>Готово</title>
</head>
<body>
<div class="login-page">
  <div class="form">
    <h2>Операция успешно выполнена!</h2>
    <hr/>
    <form action="AllQueuesServlet" method="POST">
      <input type="submit" value="Все очереди">
    </form>
    <form action="UserQueuesServlet" method="POST">
      <input type="submit" value="Мои очереди">
    </form>

    <form action="LogOutServlet" method="GET">
      <input type="submit" value="Выйти">
    </form>
  </div>
</div>
</body>
</html>
