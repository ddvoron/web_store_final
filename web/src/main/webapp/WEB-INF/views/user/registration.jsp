<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div id="content">
    <s:form id="registrationForm" action="add" modelAttribute="userForm" method="post">
        <table class="registrationTable">
            <tr>
                <td colspan="2">
                    <div class="tableName">Регистрация нового пользователя</div>
                </td>
            </tr>
            <tr>
                <td><label>Name</label></td>
                <td><s:input type="text" id="name" name="Name" path="Name" onfocus="hide();"/></td>
            </tr>
            <tr>
                <td>
                    <div class="mes3" id="name1">Заполните поле!</div>
                    <div class="mes4" id="name2">Неверный формат!</div>
                </td>
                <td>
                    <div class="helper">Введите Ваше имя</div>
                </td>
            </tr>
            <tr>
                <td><label>Surname</label></td>
                <td><s:input type="text" id="surname" name="Surname" path="Surname" onfocus="hide();"/></td>
            </tr>
            <tr>
                <td>
                    <div class="mes3" id="surname1">Заполните поле!</div>
                    <div class="mes4" id="surname2">Неверный формат!</div>
                </td>
                <td>
                    <div class="helper">Введите Вашу фамилию</div>
                </td>
            </tr>
            <tr>
                <td><label>E-mail</label></td>
                <td><s:input type="text" id="email" name="Email" path="Email" onfocus="hide();"/></td>
            </tr>
            <tr>
                <td>
                    <div class="mes3" id="email1">Заполните поле!</div>
                    <div class="mes4" id="email2">Неверный формат!</div>
                </td>
                <td>
                    <div class="helper">Введите Ваш электронный адрес</div>
                </td>
            </tr>
            <tr>
                <td><label>Login</label></td>
                <td><s:input type="text" id="login" name="Login" path="Login" onfocus="hide();"/></td>
            </tr>
            <tr>
                <td>
                    <div class="mes3" id="login1">Заполните поле!</div>
                    <div class="mes4" id="login2">Неверный формат!</div>
                </td>
                <td>
                    <div class="helper">Введите логин</div>
                </td>
            </tr>
            <tr>
                <td><label>Password</label></td>
                <td><s:input type="password" id="password" name="Password" path="Password" onfocus="hide();"/></td>
            </tr>
            <tr>
                <td>
                    <div class="mes3" id="password1">Заполните поле!</div>
                    <div class="mes4" id="password2">Неверный формат!</div>
                </td>
                <td>
                    <div class="helper">Введите пароль</div>
                </td>
            </tr>
            <tr>
                <td><label>Confirm password</label></td>
                <td><input type="password" id="passwordRepeat" name="PasswordRepeat" onfocus="hide();"/></td>
            </tr>
            <tr>
                <td>
                    <div class="mes3" id="passwordRepeat1">Заполните поле!</div>
                    <div class="mes4" id="passwordRepeat2">Неверный формат!</div>
                    <div class="mes4" id="passwordRepeat3">Повторите верно!</div>
                </td>
                <td>
                    <div class="helper">Введите пароль снова</div>
                </td>
            </tr>
            <!--Отправка формы-->
            <tr>
                <td></td>
                <td>
                    <div class="butn"><input class="button_ok" type="button"
                                             onclick="event.preventDefault();sendFormReg();"
                                             value="Зарегистрироваться"/></div>
                </td>
            </tr>
        </table>
    </s:form>
</div>

