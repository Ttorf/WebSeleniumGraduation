# language: ru
@Scenario1
@addSurvey
Функция: Добавление опроса

  @success
  Сценарий:Добавление опроса в тему обсуждения

    Дано у пользователя есть наименование вопроса голосования "Новый вопрос"
    Дано у пользователя есть длительность голосования в днях 3
    Дано у пользователя есть число разрешенных вариантов 2
    Дано у пользователя есть первый возможный вариант ответ "Первый"
    Дано у пользователя есть второй возможный вариант ответ "Второй"
    Когда пользователь заполняет форму и отправляет сообщение с голосованием
    Тогда пользователь видит сообщение "Голосование было опубликовано."
