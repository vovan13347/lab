# *Технологии разработки программного обеспечения*
## *Лабораторная работа № 1: создание микросервиса на Spring Boot с базой данных*
### *Лебедев Владимир Владимирович ЗМАС2031*
## *Цель лабораторной работы:*
Знакомство с проектированием многослойной архитектуры Web-API (веб-приложений, микро-сервисов).
Сооздание микросервиса, реализующего CRUD  на примере интернет магазина
### *Как запустить*

---

1.Загрузите проект из Github. Для клонирования репозитория необходимо выполнить команду:
`git clone https://github.com/vovan13347/lab.git`

2.Необходимо встроить базу данных виртуальную среду . Установите [Docker Desktop](https://www.docker.com/products/docker-desktop) и запустите его

3.Установите postgresql используя приложение  [IntelliJ IDEA 2020.2.3 (Ultimate Edition)](https://www.jetbrains.com/idea/download/#section=windows)

4.Запустить Postgres Docker-контейнер,команду:`docker-compose up`

5.Добавляем базу данных (БД) в Spring приложение. Зайдите в репозиторий с проектом `...\src\main\resources`. Заполните следующие поля в файле `...\src\main\resources..application.properties`.

Настройки БД для Postgres:
`spring.datasource.username=root
spring.datasource.password=root
spring.datasource.url=jdbc:postgresql://localhost:5432/myshopdb`

где, localhost:5432myshopdb -IP адрес,базы данных.


Для запуска прилодения используете файл `MyshopApplication`

После настройки БД, необходимо пересобрать приложение, используя для этого [maven](https://maven.apache.org/download.cgi). 

6.Для сборки приложения из командной строки с помощью maven, необходимо выполнить следующую команду из корневой директории проекта:
`mvn clean package spring-boot:repackage`


7.В терминале Docker строим контейнер с нашим приложением  и запускаем  следующей командой:
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
`curl localhost:8080/api/myshop/hostname` 
В ответ будет получен JSON в виде {hostname: "hostname"}.
