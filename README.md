# AR_Test

Тестовое задание в компанию AR Soft

## Описание

1.	Создать сервис Rest Full, который на вход получает текст русского языка с абзацами.
На выходе нужно получить текст, где каждую букву исходного текста заменить ее порядковым номером в алфавите, при этом 
в одной строке печатать текст с двумя пробелами между буквами, в следующей строке внизу под каждой буквой печатать ее номер.
2.	Создать сервис Rest Full, который на вход получает XML список платежей следующего класса Payment записанного в виде XML.
Обрабатывает их, и пересчитывает баланс на конкретную дату, переданную в запросе в зависимости от того кредит или дебет задано в поле part (‘к’,’п’). А также считает отдельно элементы со статусом state в налоговую. И в результате отдает XML c классом Result, где записан баланс и с рассчитан процент налогов от баланса.
3.	Дополнительное задание: создать вэб-интерфейс пользователя для того, чтобы можно было подключится к этим сервисам и получить результат выполнения конкретной поставленной задачи. Оформить поля ввода и вывода текста и подачи запроса с примером для 2-го задания, где можно будет добавлять платежи.


## Подробнсти

### Используемые технологии

* Java SE 16
* Spring Framework
* Freemarker

### Запуск программы

Главная страница - localhost:8080/main

С главной страницы можно перейти с помощью соответствующих кнопок или с помощью навбара в первое или второе задание.

В каждом задании есть соответствующий интерфейс пользователя для выполнения поставленных задач. 

## Автор

Филинов Н.Ю. 
[@filinnick](https://vk.com/nickfilinov)

## Версии

* 1.0
    * Доработано второе задание и разработан веб-интерфейс взаимодействия пользователя с сервисами первого и второго задания.
* 0.5
    * Выполнены первые два задания
