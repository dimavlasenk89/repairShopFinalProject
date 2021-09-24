
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
<div class="carousel slide carousel-fade" data-ride="carousel" id="slides">
    <ul class="carousel-indicators">
        <li data-target="#slides" data-slide-to="0" class="active"></li>
        <li data-target="#slides" data-slide-to="1" class="active"></li>
        <li data-target="#slides" data-slide-to="2" class="active"></li>
    </ul>
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img src="img/grasp.jpg">
            <div class="carousel-caption">
                <h1 class="display-4">«Тачка на прокачку»</h1>
                <h3>Ремонтне агентство</h3>
                <a href="signInPage.jsp"><button class="btn btn-outline-dark btn-lg" type="button">Увійти</button></a>
                <p></p>
                <a href="signOnPage.jsp"><button class="btn btn-outline-warning btn-lg" type="button">До сторінки реєстрації</button></a>
            </div>
        </div>

        <div class="carousel-item">
            <img src="img/car.jpg" class="img-fluid">
            <div class="carousel-caption">
                <a href="signInPageManager.jsp"><button class="btn btn-outline-dark btn-lg" type="button">Увійти як адміністратор</button></a>
            </div>
        </div>

        <div class="carousel-item">
            <img src="img/anotherCar.jpg" class="img-fluid">
            <div class="carousel-caption">
                <a href="signInPageMaster.jsp"><button class="btn btn-outline-dark btn-lg" type="button">Увійти як майстер</button></a>
            </div>
        </div>
    </div>
</div>
<div class="container-fluid">
    <div class="row-jumbotron">
        <div class="col-xs-12 col-sm-12 col-md-9 col-lg-9 col-xl-10">
            <hr>
            <h3 class="display-4">Автомобіль</h3>
            <p class="lead text-justify">Автомобілями називають самохідні сухопутні безрейкові транспортні засоби з двигуном внутрішнього згоряння, слово вживається з другої половини XIX століття.</p>

            <p class="lead text-justify">До справжніх автомобілів не відносять відомі з XVIII ст. безкінні транспортні засоби, що являли собою безрейкові паровози, такі як локомобілі, парові карети та інші(хоча їх часто називають паровими автомобілями.</p>
        </div>
        <div class="col-xs-12 col-sm-12 col-md-3 col-lg-3 col-xl-2">
            <a href="https://uk.wikipedia.org/wiki/%D0%90%D0%B2%D1%82%D0%BE%D0%BC%D0%BE%D0%B1%D1%96%D0%BB%D1%8C"><button class="btn btn-success btn-lg" type="button">Читати далі</button></a>
            <hr>
        </div>
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

<%--<!DOCTYPE html>--%>
<%--<html lang="ru">--%>
<%--<head>--%>
<%--    <meta charset="UTF-8">--%>
<%--    <title>Repair Shop</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<center>--%>
<%--    <h1>--%>
<%--        Select the type of Liquor--%>
<%--    </h1>--%>
<%--    <form method="post" action="SelectRole">--%>
<%--        <br>--%>
<%--        <select name="Type" size="1">--%>
<%--            <option>CUSTOMER</option>--%>
<%--            <option>MASTER</option>--%>
<%--            <option>MANAGER</option>--%>

<%--        </select>--%>
<%--        <br><br>--%>
<%--        <input type="submit" value="Подтвердить выбор">--%>
<%--    </form>--%>
<%--</center>--%>


<%--</body>--%>
<%--</html>--%>