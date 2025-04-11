package com.example.salary_vacation;

import com.example.salary_vacation.dto.VacationRequest;
import com.example.salary_vacation.service.VacationService;
import com.example.salary_vacation.validator.RequestValidator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class SalaryVacationApplicationTests {

	private final VacationService vacationService = new VacationService();

	@Test
	public void testCalculateVacationPay() {
		double result = vacationService.calculateVacationPay(60000, 10);
		assertEquals(20000.0, result);
	}


	@Test
	void testValidate() {
	final RequestValidator validator = new RequestValidator();
		// Тестируем случай, когда запрос равен null
		assertThrows(IllegalArgumentException.class,
				() -> validator.validate(null),
				"Запрос не может быть null");

		// Тестируем случай, когда начальная дата отсутствует
		VacationRequest request = new VacationRequest(); // создаем объект без начальных данных
		assertThrows(IllegalArgumentException.class,
				() -> validator.validate(request),
				"Не указана дата начала отпуска");

		// Тестируем случай, когда конечная дата отсутствует
		request.setStartDate(LocalDate.now()); // устанавливаем начальную дату
		assertThrows(IllegalArgumentException.class,
				() -> validator.validate(request),
				"Не указана дата окончания отпуска");

		// Тестируем случай, когда начальная дата позже конечной
		request.setEndDate(LocalDate.now().minusDays(5)); // конечная дата раньше начальной
		assertThrows(IllegalArgumentException.class,
				() -> validator.validate(request),
				"Дата начала отпуска должна быть раньше даты окончания отпуска");

		// Тестируем случай, когда средняя зарплата равна нулю или отрицательна
		request.setEndDate(LocalDate.now().plusDays(5)); // исправляем даты
		request.setAverageSalary(0.0); // устанавливаем зарплату равной нулю
		assertThrows(IllegalArgumentException.class,
				() -> validator.validate(request),
				"Средняя зарплата должна быть положительной");

		// Тестируем случай, когда количество дней отпуска равно нулю или отрицательно
		request.setAverageSalary(50000.0); // исправляем зарплату
		request.setVacationDays(0); // устанавливаем количество дней равным нулю
		assertThrows(IllegalArgumentException.class,
				() -> validator.validate(request),
				"Количество дней отпуска должно быть положительным");

		// Положительный тестовый случай, когда все данные корректны
		request.setVacationDays(10); // устанавливаем положительное количество дней
		validator.validate(request); // Должно пройти без исключения
	}
}
