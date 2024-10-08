# Платформа SberSobes
Данный проект направлен на решение проблемы проверки цифровых знаний кандидатов во время собеседования при помощи предоставления доступа к консоли кандидату, а также инструментов проверки знаний руководителя.

## Зачем это нужно
В текущих собеседованиях проверка цифровых знаний (работа с БД, администрирование Linux и т.д.) проверяются на словах: задают вопрос, получают от кандидата ответ.

Также дают задания на дом, но в таких случаях проверить самостоятельность решения практически невозможно и значительно замедляется процесс из-за необходимости ждать решения от кандидата.

Процесс можно улучшить добавив автоматическую проверку ответа кандидата на настоящих тестовых хостах. Это повышает точность проведения собеседования, результативность и скорость процесс проверки знаний.

## Сценарий взаимодействия с платформой

В данном проекте цели собеседования и используемый хост определены заранее, но общий процесс выглядит следующим образом.

Руководитель создаёт собеседование и определяет те знания, которые проверяются:
- Способность навигации по Linux системе;
- Способность написания запросов для получения информации от БД;
- Администрирование БД: создание, удаление таблиц;
- и т.д.

На основе требуемых знаний выбираются соответствующие хосты для подключения, с заранее определенными правами, данными, схемами, пользователями.

Во время собеседования руководитель отмечает начало проверки пункта знаний, после чего кандидат может вводить запросы и писать скрипты. Результат выполнения команд и скриптов возвращаются кандидату и руководителю для проверки корректности выполнения задания.

После этого руководитель может отметить корректно была решена задача кандидатом или нет, добавить комментарии к принятому решению.

В любой момент собеседования руководитель может посмотреть текущий процесс проверки кандидата в общем виде: сколько задач он решил, в каком качестве.

## Архитектура проекта

Общая структура продукта выглядит следующим образом:
(вставлю сюда схему позже)

На схеме:
- Общий сервер - на основе ЯП Java и фреймворка Spring Boot, передает формы кандидату и руководителю, является неким "коммутатором" для передачи команд от кандидата хостам и соответствующих ответов обратно, также хранит результаты проверки знаний для отображения руководителю;
- Внешние хосты - устройство, к которым идёт подключение и передача команд от кандидата, с возвратом ответа обратно, после окончания собеседования возвращаются в исходное положение перед следующим кандидатом;
- Руководитель - устройство сотрудника сбер, отсылает заявку на проведение проверки знаний с кандидатом;
- Кандидат - внешний пользователь, подключается к серверу для передачи команд и проверки знаний.

В текущем решении определен единственный внешний хост с готовым БД PostgreSQL и Linux сервером.

## Документация

Полный список функционала представлен в иерархическом виде в папке "ТЗ":
- Внутри папки может быть .md файл того же названия - описывает папку и её секцию;
- Во вложенных папках описывается подфункция по такому же правилу.

Документация и приложенные изображения составлены при помощи редактора личных записей с открытым исходным кодом: [TrilliumNext](https://github.com/TriliumNext/Notes).
