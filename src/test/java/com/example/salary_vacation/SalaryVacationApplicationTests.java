package com.example.salary_vacation;

import com.example.salary_vacation.service.VacationService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SalaryVacationApplicationTests {

	private final VacationService vacationService = new VacationService();

	@Test
	public void testCalculateVacationPay() {
		double result = vacationService.calculateVacationPay(60000, 10);
		assertEquals(20000.0, result);
	}

}
