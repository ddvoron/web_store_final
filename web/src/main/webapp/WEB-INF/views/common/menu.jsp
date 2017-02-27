<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div id="top">
    <ul class="menu">
        <li><a href="<c:url value="/home"/>"><spring:message code="menu.locale.home"/></a></li>
        <li><a href=""><spring:message code="menu.locale.catalog"/></a>
            <ul>
                <li><a href="<c:url value="/catalog/televisions"/>"><spring:message code="menu.locale.televisions"/></a></li>
                <li><a href="<c:url value="/catalog/fridges"/>"><spring:message code="menu.locale.fridges"/></a></li>
                <li><a href="<c:url value="/catalog/washers"/>"><spring:message code="menu.locale.washers"/></a></li>
                <li><a href="<c:url value="/catalog/mobiles"/>"><spring:message code="menu.locale.mobiles"/></a></li>
            </ul>
        </li>
        <li><a href="<c:url value="/basket/orders"/>"><spring:message code="menu.locale.shoppingCart"/></a></li>
        <c:set var="locale" value="${pageContext.response.locale}"/>
        <c:if test="${locale eq 'en'}">
            <li id="menu1" class="locale"><a href="?locale=ru"><spring:message code="menu.locale.ru"/></a></li>
            <li id="menu1" class="locale activeLocale"><a href="?locale=en"><spring:message code="menu.locale.en"/></a></li>
        </c:if>
        <c:if test="${locale eq 'ru'}">
            <li id="menu1" class="locale activeLocale"><a href="?locale=ru"><spring:message code="menu.locale.ru"/></a></li>
            <li id="menu1" class="locale"><a href="?locale=en"><spring:message code="menu.locale.en"/></a></li>
        </c:if>
        <c:if test="${empty locale}">
            <li id="menu1" class="locale"><a href="?locale=ru"><spring:message code="menu.locale.ru"/></a></li>
            <li id="menu1" class="locale activeLocale"><a href="?locale=en"><spring:message code="menu.locale.en"/></a></li>
        </c:if>
        <c:if test="${user.getRoleEntity().getIdRole()==2}">
            <li id="menu1"><a href=""><spring:message code="menu.locale.admin"/></a>
                <ul>
                    <li><a href=''><spring:message code="menu.locale.users"/></a></li>
                    <li><a href=''><spring:message code="menu.locale.products"/></a></li>
                </ul>
            </li>
        </c:if>
        <c:if test="${user==null}">
            <li id="menu2"><a href="<c:url value="/login/log"/>"><spring:message code="menu.locale.log"/></a></li>
            <li id="menu4"><a href="<c:url value="/user/reg"/>"><spring:message code="menu.locale.reg"/></a></li>
        </c:if>
        <c:if test="${user!=null}">
            <li id="menu3"><a href="">${user.getName()}</a>
                <ul>
                    <li><a href=""><spring:message code="menu.locale.profileEditing"/></a></li>
                    <li><a href="<c:url value="/logout/logout"/>"><spring:message code="menu.locale.logout"/></a></li>
                </ul>
            </li>
        </c:if>
    </ul>
</div>
<div id="sidebar">
    <li class="menu">
        <ul>
            <li class="button cl"><a href="" class="box2"><spring:message code="menu.locale.catalog"/></a></li>
            <li class="dropdown">
                <ul>
                    <li><a href="<c:url value="/catalog/televisions"/>"><spring:message code="menu.locale.televisions"/></a></li>
                    <li><a href="<c:url value="/catalog/fridges"/>"><spring:message code="menu.locale.fridges"/></a></li>
                    <li><a href="<c:url value="/catalog/washers"/>"><spring:message code="menu.locale.washers"/></a></li>
                    <li><a href="<c:url value="/catalog/mobiles"/>"><spring:message code="menu.locale.mobiles"/></a></li>
                </ul>
            </li>
        </ul>
    </li>
    <li class="menu">
        <ul>
            <li class="button cl"><a href="#" class="box3"><spring:message code="menu.locale.contacts"/></a></li>
            <li class="dropdown">
                <ul>
                    <li>+375(33)397-33-33</li>
                    <li>+375(44)397-33-33</li>
                    <li>webstore@gmail.com</li>
                </ul>
            </li>
        </ul>
    </li>
</div>