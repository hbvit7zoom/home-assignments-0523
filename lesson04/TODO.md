# Lesson 04 Input. Output. Exceptions.

Написать программу частично дублирующую функционал Linux-программы `wc`.
[man wc](https://www.opennet.ru/man.shtml?topic=wc&category=1&russian=2)

Возможные параметры:

-l - количество строк
-w - количество слов
--help - печать информации по использованию программы
--version - version01, Фамилия разработчика

Класс `ru.sberbank.jd.WordCount` содержит только один метод `main`. 

Примеры вызовов:

* `java ru.sberbank.jd.WordCount` (печатается информация о строках и словах, которые пришли на стандартный ввод)
* `java ru.sberbank.jd.WordCount -l -w` (печатается информация о строках и словах, которые пришли на стандартный ввод)
* `java ru.sberbank.jd.WordCount -w -l` (печатается информация о строках и словах, которые пришли на стандартный ввод 
в том же порядке)
* `java ru.sberbank.jd.WordCount -lw` (результат тот же)
* `java ru.sberbank.jd.WordCount -wl` (результат тот же)
* `java ru.sberbank.jd.WordCount -l` (количество строк, которые пришли на стандартный ввод)
* `java ru.sberbank.jd.WordCount -w` (количество слов, которые пришли на стандартный ввод)

*  Пример вызова с указанием имен файлов по маске 
(считаем что в указанной папке есть `1.txt` и `2.txt`):

```
java ru.sberbank.jd.WordCount  ~/_repos/jd/*.txt
2       6 /home/user/_repos/jd/1.txt
2       6 /home/user/_repos/jd/2.txt
4      12 total
```


## Критерии приемки

1. Классы должен быть протестирован с помощью JUnit на предмет возвращаемых значений.
2. Прислать PR из ветви feature/lesson04 в ветку develop (созданную от master) в вашем репозитории.
3. Cсылку на PR отправить в личным сообщением в телеграмм @vmnaumov.
4. Ко всем методам и тестам должны быть написаны java docs - какой сценарий и что проверям.
