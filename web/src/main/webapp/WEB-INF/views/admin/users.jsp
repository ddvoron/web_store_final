<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div id="content">
    <table id="modifyE">
        <tr>
            <td>ID</td>
            <td>Name</td>
            <td>Surname</td>
            <td>E-mail</td>
            <td>Login</td>
            <td>BlackList</td>
            <td>RegistrationDate</td>
            <td class="asdf"></td>
        </tr>
        <c:forEach var="point" items="${users}">
            <tr>
                <td id="id${point.getIdUser()}">${point.getIdUser()}</td>
                <td id="name${point.getIdUser()}">${point.getName()}</td>
                <td id="surname${point.getIdUser()}">${point.getSurname()}</td>
                <td id="email${point.getIdUser()}">${point.getEmail()}</td>
                <td id="login${point.getIdUser()}">${point.getLogin()}</td>
                <td id="blackList${point.getIdUser()}">${point.getBlackList()}</td>
                <td id="registrationDate${point.getIdUser()}">${point.getRegistrationDate()}</td>
                <td>
                    <div class="modifyB" onclick="modifyUser(${point.getIdUser()});">Редактировать</div>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<div class="megaDominator">
    <s:form id="editUsers" modelAttribute="user" action="/web/admin/users" method="post">
        <table class="registrationTable">
            <tr>
                <td colspan="2"><div class="tableName" >Редактирование пользователя</div></td>
            </tr>
            <tr>
                <td><s:input type="hidden" id="id" path="idUser" name="ID"/></td>
            </tr>
            <tr>
                <td><label>Name</label></td>
                <td><s:input type="text" id="name" path="name" name="Name"/></td>
            </tr>
            <tr>
                <td><label>Surname</label></td>
                <td><s:input type="text" id="surname" path="surname" name="Surname"/></td>
            </tr>
            <tr>
                <td><label>E-mail</label></td>
                <td><s:input type="text" id="email" path="email" name="Email"/></td>
            </tr>
            <tr>
                <td><label>Login</label></td>
                <td><s:input type="text" id="login" path="login" name="Login"/></td>
            </tr>
            <tr>
                <td><label>BlackList</label></td>
                <td><s:input type="text" id="blackList" path="blackList" name="BlackList"/></td>
            </tr>
            <!--Отправка формы-->
            <tr>
                <td></td>
                <td><div class="butn"><input class="button_ok" type="submit" value="Применить"/></div></td>
            </tr>
        </table>
    </s:form>
</div>
