<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="css/login.css">
    <title>Мои очереди</title>
</head>
<body>
<div class="login-page">
    <div class="form">
        <h2>Мои очереди</h2>

        <form class="login-form" action="DetailsQueueServlet" method="POST">
            <input type="submit" value="Редактировать очереди">
        </form>

        <c:forEach var="queue" varStatus="curr" items="${userqueues}">
            <h3>Очередь ${queue.getId()}          ${queue.getName()}</h3>
            <h3>${queue.printChangeable()}</h3>
            <br>

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
                        <th><pre>        </pre></th>
                    </tr>
                </c:forEach>
            </table>
        </details>
            <hr>
        </c:forEach>
        <br>
        <form class="login-form" action="NewQueue" method="POST">
            <h3>Имя новой очереди</h3>
            <br>
            <input type="text" placeholder="Введите имя" name="name" id="name">

            <input type="submit" value="Добавить очередь">
        </form>
        <hr/>
        <form class="login-form" action="AllQueuesServlet" method="POST">
            <input type="submit" value="Все очереди">
        </form>
        <hr/>
        <form class="login-form" action="LogOutServlet" method="GET">
            <input type="submit" value="Выйти">
        </form>
    </div>
</div>
</body>
</html>

