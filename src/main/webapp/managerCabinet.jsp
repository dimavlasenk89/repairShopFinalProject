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
        <div>  <span>Відфільтруйте замовлення </span> <span name="congratulations">${congratulations}</span> </div>
        <form method="get" action="ManageWatchOrdersServlet" class="row g-3">
            <div class="col-1">
            </div>
            <div class="col-5">
                <div class="form-check">
                    <input name="orderStatus" class="form-check-input" type="radio" value="option1" id="waitingForPayment">
                    <label class="form-check-label" for="waitingForPayment">
                        Чекає на оплату
                    </label>
                </div>
                <div class="form-check">
                    <input name="orderStatus" class="form-check-input" type="radio" value="option2" id="paid" checked>
                    <label class="form-check-label" for="paid">
                        Сплачено
                    </label>
                </div>
                <div class="form-check">
                    <input name="orderStatus" class="form-check-input" type="radio" value="option3" id="cancelled">
                    <label class="form-check-label" for="cancelled">
                        Відмінено
                    </label>
                </div>
                <div><i><b>${counterCurrent}</b></i></div>
                <div><i><b>${counterTotal}</b></i></div>
                <div>  <i><b>${errorFillOrder}</b></i> </div>
            </div>
            <div class="col-4">
                <input name="master" type="login" class="form-control" id="inputMaster" placeholder="Майстер">
            </div>
            <div class="col-2">
                <input type="submit" class="btn btn-primary mb-3" value="Фільтрувати замовлення">
            </div>
        </form>
                    <div class="container">
                        <hr>
                        <div class="row">
                            <div class="col-3">
                            </div>
                            <div>  <span>Усі замовники </span> </div>
                            <form method="get" action="customersListServlet" class="row g-3">
                                <div class="col-9">
                                    <table class="table">
                                        <thead>
                                        <tr>
                                            <th scope="col">#</th>
                                            <th scope="col">Замовник</th>
                                            <th scope="col">Рахунок</th>
                                            <th scope="col">Поповнити</th>
                                            <form method="get" action="customersListServlet" class="row g-3">
                                                <th scope="col"><input type="submit" class="btn btn-primary mb-3" value="Переглянути"></th>
                                            </form>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="Customer" items="${ListCustomers}">
                                            <tr>
                                                <th scope="row" >${Customer.id}</th>
                                                <th scope="row">${Customer.login}</th>
                                                <td><c:out value="${Customer.bill}" /></td>
                                                    <form method="get" action="updateBillServlet" class="row g-3">
                                                        <td>
                                                            <input type="hidden" name="idInRow3" value="${Customer.id}">
                                                            <input name="money" type="login" class="form-control form-control-sm" id="moneyCustomer" placeholder="Сума">
                                                            <br>
                                                            <input type="submit" class="btn btn-outline-warning btn-sm" value="Надіслати">
                                                        </td>
                                                    </form>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </form>
                            <div class="row">
                                <div class="col-1">
                                </div>
                            </div>
                        </div>
                    </div>
        <div class="row">
            <div class="col-1">
            </div>
            <div>  <span>Усі замовлення </span> </div>
            <div class="col-11">
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Замовник</th>
                        <th scope="col">
                            <form method="get" action="allOrdersSelectByDataASCServlet" class="row g-3">
                                <input type="submit" class="btn btn-primary mb-3 btn-sm" value="Дата <">
                            </form>
                            <form method="get" action="allOrdersSelectByDataDESCServlet" class="row g-3">
                                <input type="submit" class="btn btn-primary mb-3 btn-sm" value="Дата >">
                            </form>
                        </th>
                        <th scope="col">Машина</th>
                        <th scope="col">Майстер</th>
                        <th scope="col">
                            <form method="get" action="allOrdersSelectByDoneDESCServlet" class="row g-3">
                                <input type="submit" class="btn btn-primary mb-3 btn-sm" value="Статус +">
                            </form>
                            <form method="get" action="allOrdersSelectByDevDESCServlet" class="row g-3">
                                <input type="submit" class="btn btn-primary mb-3 btn-sm" value="Статус -">
                            </form>
                        </th>
                        <th scope="col">Платіж</th>
                        <th scope="col">
                            <form method="get" action="allOrdersSelectByPriceASCServlet" class="row g-3">
                            <input type="submit" class="btn btn-primary mb-3 btn-sm" value="Вартість <">
                            </form>
                            <form method="get" action="allOrdersSelectByPriceDESCServlet" class="row g-3">
                            <input type="submit" class="btn btn-primary mb-3 btn-sm" value="Вартість >">
                            </form>
                        </th>
                        <th scope="col">Обсяг робіт</th>
                        <form method="get" action="allOrdersManagerServlet" class="row g-3">
                            <th scope="col"><input type="submit" class="btn btn-primary mb-3 btn-lg" value="Переглянути"></th>
                        </form>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="orders" items="${ListOrders}">
                        <tr>
                            <th scope="row" >${orders.id}</th>
                            <th scope="row">${orders.customerLogin}</th>
                            <td><c:out value="${orders.createdAt}" /></td>
                            <td><c:out value="${orders.carType}" /></td>
                            <c:if test="${orders.masterLogin == null}">
                                <form method="get" action="ChooseMasterServlet" class="row g-3">
                                    <td>
                                        <input type="hidden" name="idInRow2" value="${orders.id}">
                                        <input name="masterLogin" type="login" class="form-control form-control-sm" id="masterLogin" placeholder="Майстер">
                                        <br>
                                        <input type="submit" class="btn btn-outline-warning btn-sm" value="Призначити">
                                    </td>
                                </form>
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
                                <form method="get" action="paymentStatusServlet" class="row g-3">
                                    <td>
                                        <input type="hidden" name="idInRow3" value="${orders.id}">
                                        <select class="custom-select" name="paymentSelect" size="1">
                                            <option selected disabled value="option0">Призначити статус...</option>
                                            <option value="option1">Чекає на оплату</option>
                                            <option value="option2">Сплачено</option>
                                            <option value="option3">Відмінено</option>
                                        </select>
                                        <br>
                                        <br>
                                        <input type="submit" class="btn btn-outline-warning btn-sm" value="Призначити">
                                    </td>
                                </form>
                            </c:if>
                            <c:if test="${((orders.isPaid() == true) && (orders.isCanceled() == false))}">
                                <td>Сплачено</td>
                            </c:if>
                            <c:if test="${orders.isCanceled() == true}">
                                <td>Відмінено</td>
                            </c:if>

                            <c:if test="${orders.ordersPrice > 0}">
                                <td><c:out value="${orders.ordersPrice} $" /></td>
                            </c:if>
                            <c:if test="${orders.ordersPrice == 0}">
                                <form method="get" action="ManageAllOrdersServlet" class="row g-3">
                                    <td>
                                        <input type="hidden" name="idInRow" value="${orders.id}">
                                        <input name="price" type="login" class="form-control form-control-sm" id="inputPrice" placeholder="Ціна">
                                        <br>
                                        <input type="submit" class="btn btn-outline-warning btn-sm" value="Призначити">
                                    </td>
                                </form>
                            </c:if>

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
