package com.example.salary_vacation.validator;


import com.example.salary_vacation.dto.VacationRequest;

import java.time.LocalDate;

public class RequestValidator {

    public void validate(VacationRequest request)  {
        if (request == null) {
            throw new IllegalArgumentException("Запрос не может быть null");
        }

        if (request.getStartDate() == null) {
            throw new IllegalArgumentException("Не указана дата начала отпуска");
        }

        if (request.getEndDate() == null) {
            throw new IllegalArgumentException("Не указана дата окончания отпуска");
        }

        if (request.getStartDate().isAfter(request.getEndDate())) {
            throw new IllegalArgumentException("Дата начала отпуска должна быть раньше даты окончания отпуска");
        }

        if (request.getAverageSalary() <= 0) {
            throw new IllegalArgumentException("Средняя зарплата должна быть положительной");
        }

        if (request.getVacationDays() <= 0) {
            throw new IllegalArgumentException("Количество дней отпуска должно быть положительным");
        }
    }
}
