
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
<div class="jumbotron big-banner" style="height: 500px; padding-top: 150px;">
    <div>  ${successOrder} </div>
    <iframe loading="lazy" title="John Coltrane - Blue Train (From The Rough Guide To John Coltrane) by World Music Network" width="640" height="200" scrolling="no" frameborder="no" src="https://w.soundcloud.com/player/?visual=false&#038;url=https%3A%2F%2Fapi.soundcloud.com%2Ftracks%2F70062910&#038;show_artwork=true&#038;maxheight=960&#038;maxwidth=640&#038;auto_play=false&#038;buying=true&#038;liking=true&#038;download=true&#038;sharing=true&#038;show_comments=true&#038;show_playcount=true&#038;show_user=true&#038;color"></iframe>
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