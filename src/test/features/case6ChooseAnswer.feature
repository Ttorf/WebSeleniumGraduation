# language: ru
@Scenario2
@ChooseAnswer
Функция: Выбор ответа из чекбокса

  @success
  Сценарий:Выбор ответа из чекбокса и сохранение результата

    Когда пользователь выбрал первый ответ и сохранил результат
    Тогда пользователь видит сообщение об удачном голосовании "Ваш голос был сохранен"
