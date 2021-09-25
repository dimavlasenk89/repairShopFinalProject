
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="uk">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="Description" content="Діяльність: Ремонт автомобілів, Локація: Харків">
    <meta keywords="авто, ремонт, технічне обстеження, автомеханік, автоелектрик">
    <title>Ремонтне агентство «Тачка на прокачку»</title>
    <link rel="shortcut icon" type="image/png" href="img/favicon.png">
    <link rel="stylesheet" href="bootstrap.min.css">
    <link rel="stylesheet" href="stylem.css">
</head>
<body>
<nav class="navbar navbar-expand-md navbar-light bg-light sticky-top">
    <div class="container-fluid">
        <a href="index.jsp" class="navbar-brand"><img src="img/icon.png"></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a href="index.jsp" class="nav-link">Головна</a>
                </li>
                <li class="nav-item">
                    <a href="team.jsp" class="nav-link">Наша команда</a>
                </li>
                <li class="nav-item">
                    <a href="services.jsp" class="nav-link">Послуги</a>
                </li>
                <li class="nav-item">
                    <a href="kontakts.jsp" class="nav-link">Контакти</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div class="container">
    <hr>
    <div class="row">
        <div>  <span>Зробіть замовлення </span> <span name="congratulations">${congratulations}</span> </div>
            <form method="get" action="newOrderServlet" class="row g-3">
                <div class="col-1">
                    </div>
            <div class="col-5">
                <div class="form-check">
                    <input name="wheelsEngineElectricity" class="form-check-input" type="checkbox" value="option1" id="flexCheckWheels" checked>
                    <label class="form-check-label" for="flexCheckWheels">
                        Ремонт ходової
                    </label>
                </div>
                <div class="form-check">
                    <input name="wheelsEngineElectricity" class="form-check-input" type="checkbox" value="option2" id="flexCheckEngine">
                    <label class="form-check-label" for="flexCheckEngine">
                        Ремонт двигуна
                    </label>
                </div>
                <div class="form-check">
                    <input name="wheelsEngineElectricity" class="form-check-input" type="checkbox" value="option3" id="flexCheckElectricity">
                    <label class="form-check-label" for="flexCheckElectricity">
                        Ремонт електрообладнання
                    </label>
                </div>
                <div>  <i><b>${errorFillOrder}</b></i> </div>
            </div>
            <div class="col-4">
                <input name="carType" type="login" class="form-control" id="inputCarType" placeholder="Марка авто">
            </div>
            <div class="col-2">
                <input type="submit" class="btn btn-primary mb-3" value="Зробити замовлення">
            </div>
        </form>
        <div class="row">
                <div class="col-1">
                </div>
                <div class="col-11">
                    <table class="table">
                        <thead>
                        <form method="get" action="showCustomerOrdersServlet" class="row g-3">
                        <tr>
                            <th scope="col-4">Написати відгук</th>
                            <th scope="col">Залишити відгук</th>
                            <th scope="col">#</th>
                            <th scope="col">Дата</th>
                            <th scope="col">Машина</th>
                            <th scope="col">Майстер</th>
                            <th scope="col">Статус</th>
                            <th scope="col">Платіж</th>
                            <th scope="col">Вартість</th>
                            <th scope="col">Обсяг робіт</th>
                            <th scope="col"><input type="submit" class="btn btn-primary mb-3" value="Переглянути"></th>
                        </tr>
                        </form>
                        </thead>
                        <tbody>
                        <c:forEach var="orders" items="${ListOrdersByCustomer}">
                        <tr>
                            <form method="get" action="AddReferenceServlet" class="row g-3">
                            <td><textarea class="form-control" name="Textarea" id="FormControlTextarea" cols="15" rows="2"></textarea></td>
                            <c:if test="${orders.isDone() == true}">
                                <td>
                                    <input type="hidden" name="id" value="${orders.id}">
                                    <input type="submit" class="btn btn-outline-primary btn-lg" value="Відгук">
                                </td>
                            </c:if>
                            </form>
                            <c:if test="${orders.isDone() == false}">
                            <td><button type="button" class="btn btn-outline-secondary btn-lg">Відгук</button></td>
                            </c:if>
                            <th scope="row">${orders.id}</th>
                            <td><c:out value="${orders.createdAt}" /></td>
                            <td><c:out value="${orders.carType}" /></td>
                            <c:if test="${orders.masterLogin == null}">
                                <td>Не призначено</td>
                            </c:if>
                            <c:if test="${orders.masterLogin != null}">
                                <td><c:out value="${orders.masterLogin}" /></td>
                            </c:if>
                            <c:if test="${(orders.isInDevelopment() == false) && (orders.isDone() == false)}">
                                <td>В очікуванні</td>
                            </c:if>
                            <c:if test="${(orders.isInDevelopment() == true) && (orders.isDone() == false)}">
                                <td>В роботі</td>
                            </c:if>
                            <c:if test="${orders.isDone() == true}">
                                <td>Виконано</td>
                            </c:if>
                            <c:if test="${((orders.isPaid() == false) && (orders.isCanceled() == false))}">
                            <form method="get" action="PaymentServlet" class="row g-3">
                                <td>
                                    <input type="hidden" name="idInRow4" value="${orders.id}">
                                    <input type="hidden" name="customerLogin1" value="${orders.customerLogin}">
                                    <input type="hidden" name="ordersPrice1" value="${orders.ordersPrice}">
                                    <input type="submit" class="btn btn-outline-warning btn-lg" value="Сплатити">
                                </td>
                            </form>
                            </c:if>
                            <c:if test="${orders.isCanceled() == true}">
                                <td>Відмінено</td>
                            </c:if>
                            <c:if test="${((orders.isPaid() == true) && (orders.isCanceled() == false))}">
                                <td>Сплачено</td>
                            </c:if>
                            <td><c:out value="${orders.ordersPrice} $" /></td>
                            <c:if test="${orders.isCheckEngine() == true}">
                                <td>Двигун</td>
                            </c:if>
                            <c:if test="${orders.isCheckElectricity() == true}">
                                <td>Електрика</td>
                            </c:if>
                            <c:if test="${orders.isCheckWheels() == true}">
                                <td>Ходова</td>
                            </c:if>
                        </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
        </div>
        <hr>
        <div><span>${notEnoughMoney}</span></div>
    </div>
</div>
<div class="container-fluid">
    <div class="row text-center alert">
        <div class="col-12">
            <h1 class="display-4">Не гайте часу! Записуйтесь на консультацію просто зараз!</h1>
            <p class="lead">Запис по телефону +38(067) 90-90-777, +38 (093) 96-555-96. Або пишіть на <a id="link" href="https://mail.google.com">электронну пошту</a></p>
        </div>
        <hr>
    </div>
</div>
<div class="card">
    <div class="card-footer">
        <div class="row text-center alert">
            <div class="container-fluid">
                <p>
                    <br>Ремонтне агентство «Тачка на прокачку»
                    <br>Код ЄДРПОУ 42930071
                    <br>Адреса: 61024, Україна,м. Харків, вул. Чайковського, 24.
                    <br>Тел: +38(067) 90-90-777, +38 (093) 96-555-96
                    <br>Електронна пошта: tachkaNaProkachku@gmail.com
                </p>
            </div>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="bootstrap.min.js"></script>
<script src="main.js"></script>
</body>
</html>
