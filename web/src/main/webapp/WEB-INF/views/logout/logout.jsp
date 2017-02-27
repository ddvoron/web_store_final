<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<div id="content">
    <form id="loginForm" action="<c:url value="/logout/finish"/>" method="post">
        <table class="registrationTable">
            <tr>
                <td colspan="2">
                    <div class="tableName">Завершить сеанс?</div>
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <div class="butn"><input class="button_ok" type="submit" value="Подтвердить"/></div>
                </td>
            </tr>
        </table>
    </form>
</div>


