<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div id="content">
    <div id="content_descriptionF">
        <div id="inside">
            <div id="brandModel">${data.getBrand()} ${data.getModel()}</div>
            <div id="forTable1">
                <table id="info1">
                    <c:forEach var="point" items="${list}">
                        <tr>
                            <td>${point.getTitle()}</td>
                            <td>${point.getValue()}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <div id="orderDuplicate">
                <table>
                    <tr>
                        <td id="anotherTwo">
                            Стоимость: ${data.getPrice()} BYN
                        </td>
                    </tr>
                    <tr>
                        <td id="anotherOne">
                            <c:if test="${productValue==1}">
                                <div id="order" class="buttonOrder"
                                     onclick="addOrder(${data.getIdData()},'fridges');">Добавить в корзину
                                </div>
                            </c:if>
                            <c:if test="${productValue==2}">
                                <div id="order" class="buttonOrder"
                                     onclick="addOrder(${data.getIdData()},'televisions');">Добавить в корзину
                                </div>
                            </c:if>
                            <c:if test="${productValue==3}">
                                <div id="order" class="buttonOrder"
                                     onclick="addOrder(${data.getIdData()},'washers');">Добавить в корзину
                                </div>
                            </c:if>
                            <c:if test="${productValue==4}">
                                <div id="order" class="buttonOrder"
                                     onclick="addOrder(${data.getIdData()},'mobiles');">Добавить в корзину
                                </div>
                            </c:if>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div class="mes" id="mes${data.getIdData()}">Требуется авторизация</div>
                        </td>
                    </tr>
                </table>
            </div>
            <div id="warranty">Информация о товаре предоставлена для ознакомления и не является публичной офертой.
                Информация о внешнем виде, характеристиках и комплектации товара обновляется с не-
                которой временной задержкой. Просим вас отнестись с пониманием к данному факту и
                заранее приносим извинения за возможные неточности в описании и фотографиях товара.
                С целью предоставления достоверной информации - уточняйте, пожалуйста, все важные
                для Вас параметры товары у консультанта при оформлении заказа.
            </div>
        </div>
        <div class="slider slider1">
            <div class="sliderContent">
                <div class="item">
                    <img class="imgD" src="../../resources/img/${productName}/${data.getPicture()}-1.jpg" alt=""/>
                </div>
                <div class="item">
                    <img class="imgD" src="../../resources/img/${productName}/${data.getPicture()}-2.jpg" alt=""/>
                </div>
                <div class="item">
                    <img class="imgD" src="../../resources/img/${productName}/${data.getPicture()}-3.jpg" alt=""/>
                </div>
                <div class="item">
                    <img class="imgD" src="../../resources/img/${productName}/${data.getPicture()}-4.jpg" alt=""/>
                </div>
            </div>
        </div>
    </div>
</div>


