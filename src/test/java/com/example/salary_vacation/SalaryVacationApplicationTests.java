package com.example.salary_vacation;

import com.example.salary_vacation.dto.VacationRequest;
import com.example.salary_vacation.service.VacationService;
import com.example.salary_vacation.validator.RequestValidator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

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
		assertThrows(IllegalArgumentException.class,
				() -> validator.validate(null),
				"Запрос не может быть null");

		VacationRequest request = new VacationRequest();
		assertThrows(IllegalArgumentException.class,
				() -> validator.validate(request),
				"Не указана дата начала отпуска");

		request.setStartDate(LocalDate.now());
		assertThrows(IllegalArgumentException.class,
				() -> validator.validate(request),
				"Не указана дата окончания отпуска");

		request.setEndDate(LocalDate.now().minusDays(5));
		assertThrows(IllegalArgumentException.class,
				() -> validator.validate(request),
				"Дата начала отпуска должна быть раньше даты окончания отпуска");

		request.setEndDate(LocalDate.now().plusDays(5));
		request.setAverageSalary(0.0);
		assertThrows(IllegalArgumentException.class,
				() -> validator.validate(request),
				"Средняя зарплата должна быть положительной");

		request.setAverageSalary(50000.0);
		request.setVacationDays(0);
		assertThrows(IllegalArgumentException.class,
				() -> validator.validate(request),
				"Количество дней отпуска должно быть положительным");

		request.setVacationDays(10);
		assertDoesNotThrow(() -> {
			validator.validate(request);
		});

	}
}
