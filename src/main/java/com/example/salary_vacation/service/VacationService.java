package com.example.salary_vacation.service;


import com.example.salary_vacation.utils.DateUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Service
@RequiredArgsConstructor
@Slf4j
public class VacationService {

public double calculateVacationPay(double averageSalary, int vacationDays) {
    double dailySalary = averageSalary / 30;
    return dailySalary * vacationDays;
}

public double calculateVacationPayWithDates(double averageSalary, LocalDate startDate, LocalDate endDate) {

   // int totalDays = (int) ChronoUnit.DAYS.between(startDate, endDate) + 1;
    long totalWorkdays = 0;
    for (LocalDate date = startDate; !date.isAfter(endDate); date = date.plusDays(1)) {
        if (!DateUtils.isWeekend(date) && !DateUtils.isHoliday(date)) {
            totalWorkdays++;
        }
    }
    System.out.println(totalWorkdays);
    double dailySalary = averageSalary / 30;
    return dailySalary * totalWorkdays;}
}
