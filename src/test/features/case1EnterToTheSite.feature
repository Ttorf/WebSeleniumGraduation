# language: ru
@Scenario1
@authorization
Функция: Авторизация

  @fail
  Сценарий: Вход на сайт не удался
    Дано пользователь имеет логин "dava"
    Дано пользователь имеет пароль "123"
    Когда пользователь авторизуется
    Тогда пользователь получает сообщение "Логин или пароль неправильны."

  @success
  Сценарий: Успешный вход на сайт
    Дано пользователь имеет логин "Torf"
    Дано пользователь имеет пароль "654321ss"
    Когда пользователь авторизуется
    Тогда пользователь получит доступ к сайту
