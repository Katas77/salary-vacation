package com.example.salary_vacation.utils;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;

public class DateUtils {
    public final static LocalDate[] holidays = {
            // Нерабочие дни 2024 года
            LocalDate.of(2024, 1, 1), // Новый год
            LocalDate.of(2024, 1, 2), // Новый год
            LocalDate.of(2024, 1, 3), // Новый год
            LocalDate.of(2024, 1, 4), // Новый год
            LocalDate.of(2024, 1, 5), // Новый год
            LocalDate.of(2024, 1, 6), // Новый год
            LocalDate.of(2024, 1, 7), // Рождество Христово
            LocalDate.of(2024, 2, 24), // Суббота перед Днем защитника Отечества
            LocalDate.of(2024, 2, 25), // Воскресенье после Дня защитника Отечества
            LocalDate.of(2024, 3, 8), // Международный женский день
            LocalDate.of(2024, 3, 9), // Перенос выходного с субботы
            LocalDate.of(2024, 3, 10), // Воскресенье после Международного женского дня
            LocalDate.of(2024, 5, 1), // День весны и труда
            LocalDate.of(2024, 5, 2), // Перенос выходного с воскресенья
            LocalDate.of(2024, 5, 3), // Пятница между праздниками
            LocalDate.of(2024, 5, 4), // Суббота между праздниками
            LocalDate.of(2024, 5, 5), // Воскресенье между праздниками
            LocalDate.of(2024, 5, 9), // День Победы
            LocalDate.of(2024, 5, 10), // Перенос выходного с пятницы
            LocalDate.of(2024, 5, 11), // Суббота после Дня Победы
            LocalDate.of(2024, 5, 12), // Воскресенье после Дня Победы
            LocalDate.of(2024, 6, 12), // День России
            LocalDate.of(2024, 6, 15), // Суббота после Дня России
            LocalDate.of(2024, 6, 16), // Воскресенье после Дня России
            LocalDate.of(2024, 11, 2), // Суббота перед Днем народного единства
            LocalDate.of(2024, 11, 3), // Воскресенье перед Днем народного единства
            LocalDate.of(2024, 11, 4), // День народного единства
            LocalDate.of(2024, 12, 28), // Суббота перед предновогодними праздниками
            LocalDate.of(2024, 12, 29), // Воскресенье перед предновогодними праздниками
            LocalDate.of(2024, 12, 30), // Предновогодний выходной
            LocalDate.of(2024, 12, 31), // Предновогодний выходной

            // Нерабочие дни 2025 года
            LocalDate.of(2025, 1, 1), // Новый год
            LocalDate.of(2025, 1, 2), // Новый год
            LocalDate.of(2025, 1, 3), // Новый год
            LocalDate.of(2025, 1, 4), // Новый год
            LocalDate.of(2025, 1, 5), // Новый год
            LocalDate.of(2025, 1, 6), // Новый год
            LocalDate.of(2025, 1, 7), // Рождество Христово
            LocalDate.of(2025, 1, 8), // Новый год
            LocalDate.of(2025, 3, 8), // Международный женский день
            LocalDate.of(2025, 3, 9), // Перенос выходного с субботы
            LocalDate.of(2025, 5, 1), // День весны и труда
            LocalDate.of(2025, 5, 2), // Перенос выходного с воскресенья
            LocalDate.of(2025, 5, 8), // День Победы
            LocalDate.of(2025, 5, 9), // День Победы
            LocalDate.of(2025, 5, 10), // Перенос выходного с пятницы
            LocalDate.of(2025, 5, 11), // Суббота после Дня Победы
            LocalDate.of(2025, 5, 12), // Воскресенье после Дня Победы
            LocalDate.of(2025, 6, 12), // День России
            LocalDate.of(2025, 6, 14), // Суббота после Дня России
            LocalDate.of(2025, 6, 15), // Воскресенье после Дня России
            LocalDate.of(2025, 11, 1), // Суббота перед Днем народного единства
            LocalDate.of(2025, 11, 2), // Воскресенье перед Днем народного единства
            LocalDate.of(2025, 11, 3), // День народного единства
            LocalDate.of(2025, 11, 4), // Перенос выходного с понедельника
            LocalDate.of(2025, 12, 27), // Суббота перед предновогодними праздниками
            LocalDate.of(2025, 12, 28), // Воскресенье перед предновогодними праздниками
            LocalDate.of(2025, 12, 31) // Предновогодний выходной
    };

    public static boolean isHoliday(LocalDate date) {
        return Arrays.stream(holidays).anyMatch(date1 -> date1.isEqual(date));
    }

    public static boolean isWeekend(LocalDate date) {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY;
    }

}
