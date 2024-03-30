# Инструкция по запуску приложения

## Запуск когда базу данных не надо поднимать
1. Postgresql
   1. В файле application.yml в профиле dev-postgresql поменять url, username и password для подключение к бд
   2. запустить приложение с помощью команды `gradle bootRun --spring.profiles.active=dev-postgresql`
2. H2
   1. В файле application.yml в профиле dev-h2 поменять url, username и password для подключение к бд и откомментировать блок
   2. запустить приложение с помощью команды `gradle bootRun --spring.profiles.active=dev-h2`

## Запускаем приложение в docker (Postgresql)

- Заходим в файл docker-compose.yml
- Смотрим на параметры 
`SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/Goods `
 `SPRING_DATASOURCE_USERNAME=user`
  `SPRING_DATASOURCE_PASSWORD=1234` 
- и меняем их на данные для подключения к бд
- Запускаем docker compose

## Запускаем приложение в docker (H2)
- Заходим в application.yml
- Смотрим откомментировал ли блок
- Заходим в docker-compose.h2.yml и смотрим на параметры подключения к бд
- Запускаем приложение