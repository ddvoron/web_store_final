<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div id="content">
    <s:form id="loginForm" action="logIn" modelAttribute="userForm" method="post">
        <table class="registrationTable">
            <tr>
                <td colspan="2">
                    <div class="tableName">Авторизация пользователя</div>
                </td>
            </tr>
            <tr>
                <td><label>Login</label></td>
                <td><s:input type="text" id="login" name="Login" path="Login" onfocus="hideLog();"/></td>
            </tr>
            <tr>
                <td>
                    <div class="mes3" id="login1">Заполните поле!</div>
                </td>
                <td>
                    <div class="helper">Введите логин</div>
                </td>
            </tr>
            <tr>
                <td><label>Password</label></td>
                <td><s:input name="Password" path="Password" id="password" type="password" onfocus="hideLog();"/></td>
            </tr>
            <tr>
                <td>
                    <div class="mes3" id="password1">Заполните поле!</div>
                </td>
                <td>
                    <div class="helper">Введите пароль</div>
                </td>
            </tr>
            <!--Отправка формы-->
            <tr>
                <td>
                    <div class="mail1"><a class="mail" href="<c:url value="/mail"/>">Забыли логин или пароль?</a></div>
                </td>
                <td>
                    <div class="butn"><input class="button_ok" type="button"
                                             onclick="event.preventDefault();sendFormLog();" value="Войти"/></div>
                </td>
            </tr>
        </table>
    </s:form>
</div>

