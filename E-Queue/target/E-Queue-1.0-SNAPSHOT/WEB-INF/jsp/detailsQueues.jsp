<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="css/login.css">
    <title>Редактировать</title>
</head>
<body>
<div class="login-page">
    <div class="form">
        <h2>Редактировать мои очереди</h2>
        <c:forEach var="queue" varStatus="curr" items="${userqueues}">
            <h3>Очередь ${queue.getId()}          ${queue.getName()}</h3>
            <h3>${queue.printChangeable()}</h3>
            <br>
            <form class="login-form" action="MuteQueue" method="POST">
                <input type="hidden" value="${queue.getId()}" name="idMute" id="idMute">
                <input type="submit" value="Изменить статус очереди">
            </form>

            <form class="login-form" action="NextQueue" method="POST">
                <input type="hidden" value="${queue.getId()}" name="idNext" id="idNext">
                <input type="submit" value="Сдвинуть очередь">
            </form>

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

                            <th><form class="login-form" action="DeleteFromQueue" method="POST">
                                <input type="hidden" value="${queue.getId()}" name="idDel" id="idDel">
                                <input type="hidden" value="${user.getLogin()}" name="del" id="del">
                                <input type="submit" value="Удалить из очереди">
                            </form></th>

                        </tr>
                    </c:forEach>
                </table>
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
