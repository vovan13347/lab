[![Build Status](https://travis-ci.com/vovan13347/lab.svg?branch=main)](https://travis-ci.com/vovan13347/lab)

# *Технологии разработки программного обеспечения*
## *Лабораторная работа № 1: создание микросервиса на Spring Boot с базой данных*
### *Лебедев Владимир Владимирович ЗМАС2031*
## *Цель лабораторной работы:*
Знакомство с проектированием многослойной архитектуры Web-API (веб-приложений, микро-сервисов).
Сооздание микросервиса, реализующего CRUD  на примере интернет магазина
### *Как запустить*
_Версия java - openjdk-11-jdk_
---

1.Загрузите проект из Github. Для клонирования репозитория необходимо выполнить команду:
`git clone https://github.com/vovan13347/lab.git`

2.Необходимо встроить базу данных виртуальную среду . Установите [Docker Desktop](https://www.docker.com/products/docker-desktop) и запустите его

3.Для сборки приложения из командной строки с помощью maven, необходимо выполнить следующую команду из корневой директории проекта:
`mvn clean package spring-boot:repackage`

4.В терминале Docker строим контейнер с нашим приложением  и запускаем  следующей командой:
`docker-compose up --build`, а чтобы остановить  используете команду `docker-compose down`  
  
  ---
### *Примеры CURL запросов:*


1. Получить список всех  пользователей:
`curl localhost:8080/api/myshop/users`
2.список товаров:
`curl localhost:8080/api/myshop/goods`

В ответ будет получен JSON ответ с информацией о всех пользователях которые имеются в БД.

3. поиск по id пользователя:

` curl localhost:8080/api/myshop/users/{id} `
В ответ будет получен JSON ответ с информацией о пользователе.

4.поиск по номеру id товара 
`curl localhost:8080/api/myshop/goods/{id}`



5. Получит значение hostname:
` curl localhost:8080/api/myshop/hostname` 
В ответ будет получен JSON в виде {hostname: "hostname"}.



---
## *Лабораторная работа №3: CI/CD и деплой приложения в Heroku*
### *Цель лабораторной работы:*
Знакомство с CI/CD и его реализацией на примере Travis CI и Heroku.

---
### *Ссылка на развернутое приложение на платформе Heroku:*

<https://lebedev-shop.herokuapp.com>

### *Ссылка на Travis CI badge:*

<https://travis-ci.com/github/vovan13347/lab>
