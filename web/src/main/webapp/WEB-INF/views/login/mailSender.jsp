<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div id="content">
    <form id="mailForm" action="<c:url value="/mail"/>" method="post">
        <table class="registrationTable">
            <tr>
                <td colspan="2"><div class="tableName" >Восстановление данных</div></td>
            </tr>
            <tr>
                <td><label>E-mail</label></td>
                <td><input type="text" id="email" name="Email"/></td>
            </tr>
            <tr>
                <td></td>
                <td><div class="helper">Введите Ваш электронный адрес</div></td>
            </tr>

            <!--Отправка формы-->
            <tr>
                <td></td>
                <td><div class="butn"><input class="button_ok" type="submit" value="Отправить"/></div></td>
            </tr>
        </table>
    </form>
</div>

