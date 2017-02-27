<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div id="content">
    <div id="department">
        <div id="insideDepartment">
            <c:forEach var="good" items="${products}" varStatus="status">
                <div class="element">
                    <div class="picture1">
                        <img class="picture" src="../resources/img/${productName}/${good.getPicture()}.jpg"/>
                    </div>
                    <div class="des1">
                        <div class="brand">${good.getBrand()} ${good.getModel()}</div>
                        <div class="des2">
                            Доставка:
                            Самовывоз, По городу - Бесплатно. А также Экспресс-доставка по Минску в течение 3 часов!
                            Подробнее на сайте., По области - Выберите свой населенный пункт и рассчитайте стоимость
                            доставки на сайте, По Беларуси - Выберите свой населенный пункт и рассчитайте стоимость
                            доставки на сайте
                            Оплата:
                            Наличный расчет, Банковская карта, Система «Расчет» (ЕРИП), Почтовый перевод
                        </div>
                        <div class="descriptionGood">
                            <a class="a1" href="/web/catalog/${productsValue}/${good.getIdData()}" target="_blank">Перейти
                                кописанию...</a></div>
                    </div>
                    <div class="order">
                        <div class="price">${good.getPrice()} BYN</div>
                        <div class="price1">
                            <c:if test="${productsName==1}">
                                <div id="order${good.getIdData()}" class="buttonOrder"
                                     onclick="addOrder(${good.getIdData()},'fridges');">Добавить в корзину
                                </div>
                            </c:if>
                            <c:if test="${productsName==2}">
                                <div id="order${good.getIdData()}" class="buttonOrder"
                                     onclick="addOrder(${good.getIdData()},'televisions');">Добавить в корзину
                                </div>
                            </c:if>
                            <c:if test="${productsName==3}">
                                <div id="order${good.getIdData()}" class="buttonOrder"
                                     onclick="addOrder(${good.getIdData()},'washers');">Добавить в корзину
                                </div>
                            </c:if>
                            <c:if test="${productsName==4}">
                                <div id="order${good.getIdData()}" class="buttonOrder"
                                     onclick="addOrder(${good.getIdData()},'mobiles');">Добавить в корзину
                                </div>
                            </c:if>
                        </div>
                        <div class="price0">
                            <div class="mes" id="mes${good.getIdData()}">Требуется авторизация</div>
                        </div>
                    </div>
                </div>
            </c:forEach>
            <ul class="pagination">
                <li><a href="">&laquo;</a></li>
                <c:forEach var="pagination" items="${paginationSize}" varStatus="status">
                    <c:if test="${currentPage==pagination}">
                        <li><a class="active" href="${productsValue}?page=${pagination}&size=3">${pagination}</a></li>
                    </c:if>
                    <c:if test="${currentPage!=pagination}">
                        <li><a href="${productsValue}?page=${pagination}&size=3">${pagination}</a></li>
                    </c:if>
                </c:forEach>
                <li><a href="#">&raquo;</a></li>
            </ul>
        </div>
    </div>
</div>

