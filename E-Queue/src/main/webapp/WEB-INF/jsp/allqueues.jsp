<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" type="text/css" href="css/login.css">
  <title>Все очереди</title>
</head>
<body>
<div class="login-page">
  <div class="form">
    <h2>Все очереди</h2>
    <c:forEach var="queue" items="${allqueues}">
      <h3>Очередь номер ${queue.getId()}  ${queue.getName()}</h3>
      <details>
        <summary>Просмотреть больше информации</summary>
        <br>
        <table>
          <tr>
            <th>Номер</th>
            <th>Логин</th>
          </tr>
          <c:forEach var="user" items="${queue.getQueue()}">
            <tr>
              <th>${queue.numberInQueue(user)}</th>
              <th>${user.getLogin()}</th>
            </tr>
          </c:forEach>
          <form class="login-form" action="AddToQueue" method="POST">
            <input type="hidden" value="${queue.getId()}" name="idAdd" id="idAdd">
            <input type="submit" value="Встать в очередь">
          </form>

        </table>
      </details>
      <hr>
    </c:forEach>
    <br/>

    <form class="login-form" action="NewQueue" method="POST">
      <h3>Имя новой очереди</h3>
      <input type="text" placeholder="Введите имя" name="name" id="name">

      <input type="submit" value="Добавить очередь">
    </form>

    <hr/>
    <br>
    <form class="login-form" action="UserQueuesServlet" method="POST">
      <input type="submit" value="Мои очереди">
    </form>
    <hr/>
    <br>
    <form class="login-form" action="LogOutServlet" method="GET">
      <input type="submit" value="Выйти">
    </form>
  </div>
</div>
</body>
</html>
