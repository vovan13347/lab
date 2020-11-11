# *Технологии разработки программного обеспечения*
## *Лабораторная работа № 1: создание микросервиса на Spring Boot с базой данных*
### *Лебедев Владимир Владимирович ЗМАС2031*
## *Цель лабораторной работы:*
Знакомство с проектированием многослойной архитектуры Web-API (веб-приложений, микро-сервисов).
Сооздание микросервиса, реализующего CRUD  на примере ранжирования пользователей в Kaggle.
### *Инструкция по использованию*
simpleapi-это Spring приложение написаное на JAVA, с добавленной БД postgres в виде docker образа.
---

1.Загрузите проект из Github. Для клонирования репозитория необходимо выполнить команду:
`git clone https://github.com/lsemenov/mylab1.git`

2.Необходимо подготовить виртуальную среду для развёртывания БД . Установите [Docker Toolbox](https://github.com/docker/toolbox/releases), 

3.Установите postgresql  (локально или на удаленном сервере). Чтобы установить PostgreSQL образ, вы можете выполнить следующую команду в Docker Quickstart Terminal:
`docker pull postgres`

4.Подготовка базы данных для добавления к Spring-приложению. Чтобы запустить Postgres Docker-контейнер, необходимо выполнить следующие команды в Docker Quickstart Terminal:
` docker run -e POSTGRES_PASSWORD=root -p 5432:5432`

5.Добавляем базу данных (БД) в Spring приложение. Зайдите в репозиторий с проектом `...\src\main\resources`. Заполните следующие поля в файле `...\src\main\resources..application.properties`.

Настройки БД для Postgres:
`spring.datasource.username=postgres
spring.datasource.password=root
spring.datasource.url=jdbc:postgresql://XXX.XXX.XX.XX:5432/postgres`

