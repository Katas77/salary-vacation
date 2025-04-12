# Приложение "Калькулятор отпускных"
## Приложение "Калькулятор отпускных" — это микросервис, разработанный на базе SpringBoot и Java 11. Основная цель сервиса — вычисление суммы отпускных для сотрудников на основе их средней зарплаты и количества дней отпуска.

## Swagger
### При запущенном приложение вы можете выполнять запросы используя интерфейс Swagger. http://localhost:8080/swagger-ui/index.html
## Функциональность

- GET /calculate
- Описание: Принимает среднюю зарплату за 12 месяцев и количество дней отпуска, возвращает сумму отпускных, которые получит сотрудник.
- Параметры запроса:
- averageSalary (double) - Средняя зарплата за последние 12 месяцев.
- vacationDays (int) - Количество дней отпуска.
## Дополнительная функциональность
При отправке запроса, также можно указать точные даты начала и окончания отпуска. В этом случае, сервис проводит расчет с учетом праздников и выходных.


- **Пример запроса:**
```bash
GET http://localhost:8080/calculate?averageSalary=50000&vacationDays=10
```
# Минимальные требования
- Java: 17
- Spring Boot: 3.0.0
- Maven: 3.6.3 или выше
## В наличии  юнит-тесты  для проверки расчетов.
____
✉ Почта для обратной связи:
<a href="">krp77@mail.ru</a>
