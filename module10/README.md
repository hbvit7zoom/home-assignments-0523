# Module 10. Spring Framework. XML Configuration. Configuration using annotations
Ссылка: https://sberuniversity.online/programs/20613/item/1077841

## Описание задачи
Необходимо написать SpringBoot приложение, которое вызывает произвольный http сервис (метод get, без параметров). При этом может работать в 2х режимах: реальном вызове и режиме эмуляции.

## Требования
1. У приложения должно быть 2 профиля (dev, prom)
2. В профиле prom приложение вызывает указанный http endpoint (метод get, без параметров)
   * В качестве http endpoint'а можно взять https://httpbin.org/get
3. В профиле dev приложение не вызывает реальный http endpoint, вместо этого использует stub bean
    * stub bean -- это заглушечный класс, который возвращает результат, без реального вызова сервиса.
4. Напишите конфигурацию приложения таким образом, чтобы stub bean создавался только в профиле dev, при этом реальный bean в данном профиле не создается
5. url для http endpoint'а должен быть параметризуемым и реализован через ConfigurationProperties.
6. Обратите внимание на структуризацию кода (model, service, controller)
7. Напишите unit-тесты на service классы (используйте SpringBootTest).