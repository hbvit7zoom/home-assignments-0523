# Module 9. Apache Tomcat Сервлеты. JSP-страницы
Ссылка: https://sberuniversity.online/programs/20613/item/1077840

## Описание задачи
Необходимо реализовать ToDoList (на сервлетах).

## Требования
1. Реализовать сервлет с url_path '/task' (app context можно сделать любым);
2. Метод POST создает задачу 
   1. URL: http://localhost:8080/task
   2. Запрос. В http body JSON, пример запроса `{"owner": "Nikita", "description": "Помыть посуду сегодня"}`
   3. Ответ. В http body JSON, пример ответа `{"id": "8df48b8c-c960-41eb-8c97-43e88b055cf6", "owner": "Nikita", "description": "Помыть посуду сегодня"}`
3. Метод GET возвращает задачу по ID
   1. В запросе параметр `id`. Пример URL: http://localhost:8080/task?id=8df48b8c-c960-41eb-8c97-43e88b055cf6
   2. Ответ JSON, пример ответа: `{"id": "8df48b8c-c960-41eb-8c97-43e88b055cf6", "owner": "Nikita", "description": "Помыть посуду сегодня"}`
4. Метод DELETE удаляет задачу по ID
   1. В запросе параметр `id`. Пример URL: http://localhost:8080/task?id=8df48b8c-c960-41eb-8c97-43e88b055cf6
   2. Ответ JSON, пример ответа: `{"id": "8df48b8c-c960-41eb-8c97-43e88b055cf6", "owner": "Nikita", "description": "Помыть посуду сегодня"}` 
   (возвращается удаленный объект)
5. Сделайте persistence слой in-memory.
6. Приложение должно запускаться из IDEA на Tomcat.

## Рекомендации
-  Для сериализации / десериализации используйте Jackson (библиотека), см. https://www.baeldung.com/jackson-object-mapper-tutorial
