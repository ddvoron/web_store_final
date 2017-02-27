<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div id="content">
    <c:if test="${user==null}">
        <div class="informer">${message}</div>
    </c:if>
    <c:forEach var="good" items="${list}">
        <div class="item" id="order${good.getIdBasket()}">
            <div class="item1">
                <div class="item4">${good.getDataEntity().getBrand()} ${good.getDataEntity().getModel()}</div>

                <div class="item7">
                    <c:if test="${good.getDataEntity().getCatalogEntity().getIdCatalog()==1}">
                        <a class="a2" href="<c:url value="/catalog/fridges/${good.getDataEntity().getIdData()}"/>" target="_blank">Перейти к
                            описанию...</a>
                    </c:if>
                    <c:if test="${good.getDataEntity().getCatalogEntity().getIdCatalog()==2}">
                        <a class="a2" href="<c:url value="/catalog/televisions/${good.getDataEntity().getIdData()}"/>" target="_blank">Перейти к
                            описанию...</a>
                    </c:if>
                    <c:if test="${good.getDataEntity().getCatalogEntity().getIdCatalog()==3}">
                        <a class="a2" href="<c:url value="/catalog/washers/${good.getDataEntity().getIdData()}"/>" target="_blank">Перейти к
                            описанию...</a>
                    </c:if>
                    <c:if test="${good.getDataEntity().getCatalogEntity().getIdCatalog()==4}">
                        <a class="a2" href="<c:url value="/catalog/mobiles/${good.getDataEntity().getIdData()}"/>" target="_blank">Перейти к
                            описанию...</a>
                    </c:if>
                </div>
                <div class="item5">${good.getDataEntity().getPrice()} BYN</div>
            </div>
            <div class="item2">
                <div class="item3" onclick="deleteOrder(${good.getIdBasket()});">
                    Удалить
                </div>
            </div>
        </div>
    </c:forEach>
</div>
