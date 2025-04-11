package com.example.salary_vacation.controller;

import com.example.salary_vacation.dto.VacationRequest;
import com.example.salary_vacation.service.VacationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculate")
@RequiredArgsConstructor
public class Controller {
    private final VacationService vacationService;

    @Operation(
            summary = "Рассчитывает компенсацию за отпуск",
            description = "Метод принимает данные о зарплате и днях отпуска и рассчитывает компенсацию."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Успешный расчет компенсации."),
            @ApiResponse(responseCode = "400", description = "Некорректные данные в запросе."),
            @ApiResponse(responseCode = "500", description = "Ошибка сервера при обработке запроса.")
    })
    @PostMapping("")
    public double calculateVacation(@RequestBody VacationRequest request) {
        if (request.getStartDate() != null && request.getEndDate() != null) {
            request.validate();
            return vacationService.calculateVacationPayWithDates(
                    request.getAverageSalary(),
                    request.getStartDate(),
                    request.getEndDate()
            );
        } else {
            return vacationService.calculateVacationPay(
                    request.getAverageSalary(),
                    request.getVacationDays()
            );
        }
    }
}



