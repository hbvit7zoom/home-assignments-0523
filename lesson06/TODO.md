# Lesson 06 Java Collections Framework Part I

* Реализовать класс `CustomArrayImpl<T>`, который представляет динамический массив.
* Класс `CustomArrayImpl` реализует интерфейс CustomArray<T>
* Класс `CustomArrayImpl` может хранить объекты любого типа
* Класс `CustomArrayImpl` может динамически расширяться

## Конструкторы

* `CustomArrayImpl()`;
* `CustomArrayImpl(int capacity)`;
* `CustomArrayImpl(Collection<T> c)`;

# Критерии приемки

1. Создать ветку `feature/lesson06` от `develop` (после мержа изменений из `master` в `develop`)
2. Написать реализацию класса `CustomArrayImpl`
3. Предоставить на проверку Pull Request из ветки `feature/lesson06` в ветку develop
4. Каждый публичный метод класса CustomArrayImpl должен быть покрыт unit тестом
5. !!! Вносить правки в интерфейс CustomArray<T> нельзя