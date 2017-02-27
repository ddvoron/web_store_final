<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div id="content">
    <table id="modifyE">
        <tr>
            <td class="des3"></td>
            <td>ID</td>
            <td>Brand</td>
            <td>Model</td>
            <td>Price</td>
            <td>ReleaseDate</td>
            <td>Picture</td>
            <td>Department</td>
            <td>CreationDate</td>
            <td>Creator</td>
            <td>UpdateDate</td>
            <td>Updater</td>
        </tr>
        <c:forEach var="point" items="${products}">
            <tr id="element${point.getIdData()}">
                <td id="chosenField"><input type="radio" name="chosen" value="${point.getIdData()}"/></td>
                <td id="id${point.getIdData()}">${point.getIdData()}</td>
                <td id="brand${point.getIdData()}">${point.getBrand()}</td>
                <td id="model${point.getIdData()}">${point.getModel()}</td>
                <td id="price${point.getIdData()}">${point.getPrice()}</td>
                <td id="releaseDate${point.getIdData()}">${point.getReleaseDate()}</td>
                <td id="picture${point.getIdData()}">${point.getPicture()}</td>
                <td id="fk${point.getIdData()}">${point.getCatalogEntity().getIdCatalog()}</td>
                <td id="creationDate${point.getIdData()}">${point.getCreationDate()}</td>
                <td id="creator${point.getIdData()}">${point.getCreator()}</td>
                <td id="updateDate${point.getIdData()}">${point.getUpdateDate()}</td>
                <td id="updater${point.getIdData()}">${point.getUpdater()}</td>
            </tr>
        </c:forEach>
    </table>
    <div id="actions">
        <div class="modifyC" onclick="addGoodForm();">Добавить товар</div>
        <div class="modifyB" onclick="modifyGood();">Редактировать</div>
        <div class="modifyD" onclick="deleteGood();">Удалить</div>
    </div>
    <ul class="pagination">
        <li><a href="">&laquo;</a></li>
        <c:forEach var="pagination" items="${paginationSize}" varStatus="status">
            <c:if test="${currentPage==pagination}">
                <li><a class="active" href="products?page=${pagination}&size=10">${pagination}</a></li>
            </c:if>
            <c:if test="${currentPage!=pagination}">
                <li><a href="products?page=${pagination}&size=10">${pagination}</a></li>
            </c:if>
        </c:forEach>
        <li><a href="#">&raquo;</a></li>
    </ul>

</div>
<div class="megaDominator1">
    <form id="editGoods" action="<c:url value="/admin/products"/>" method="post">
        <table class="registrationTable">
            <tr><td colspan="2"><div class="tableName">Добавление товара</div></td></tr>
            <tr>
                <td><input type="hidden" id="id" name="ID"/></td>
            </tr>
            <tr>
                <td><label>Brand</label></td>
                <td><input type="text" id="brand" name="Brand"/></td>
            </tr>
            <tr>
                <td><label>Model</label></td>
                <td><input type="text" id="model" name="Model"/></td>
            </tr>
            <tr>
                <td><label>Price</label></td>
                <td><input type="text" id="price" name="Price"/></td>
            </tr>
            <tr>
                <td><label>ReleaseDate</label></td>
                <td><input type="text" id="releaseDate" name="ReleaseDate"/></td>
            </tr>
            <tr>
                <td><label>Picture</label></td>
                <td><input type="text" id="picture" name="Picture"/></td>
            </tr>
            <tr>
                <td><label>Department</label></td>
                <td><input type="text" id="fk" name="Department"/></td>
            </tr>
            <!--Отправка формы-->
            <tr>
                <td></td>
                <td>
                    <div class="butn"><input id="add" class="button_ok" type="submit" value="Добавить"/></div>
                </td>
            </tr>
        </table>
    </form>
</div>
