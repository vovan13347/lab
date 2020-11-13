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
`docker-compose up --build`, а чтобы остановить  используете команду `docker-compose down' 

  
  
  
  ---
### *Примеры CURL запросов:*
Где,  XXX.XXX.XXX.XXX:8080 -  IP и порт виртуальной машины  docker на которой работает приложение.

1. Получить список топ 10 пользователей Kaggle:
`curl  http://XXX.XXX.XXX.XXX:8080/api/v1/kaggle`

В ответ будет получен JSON ответ с информацией о всех пользователях которые имеются в БД.

2. Получить информацию о пользователе по id:

`curl  http://XXX.XXX.XXX.XXX:8080/api/v1/kaggle/{id} `
В ответ будет получен JSON ответ с информацией о пользователе.

3. Добавить запись о пользователе:

Формат: `{rank: "string", department: "string ",room: integer, callnumber: integer}`
`curl -d "{"rank": 53, "tier": "Expert", "username": "icecuber", "points":52396}" http://XXX.XXX.XXX.XXX:8080/api/v1/kaggle -H "Content-Type:application/json"`
4. Удалить запись о пользователе:

Формат: `{rank: "string", department: "string ",room: integer, callnumber: integer}`
`curl -i -X DELETE http://XXX.XXX.XXX.XXX:8080/api/v1/kaggle/del/{id}`



В ответ будет получен статус 204 No Content.



5. Получит значение hostname:
`curl  http://XXX.XXX.XXX.XXX:8080/api/v1/status` 
В ответ будет получен JSON в виде {hostname: "hostname"}.
