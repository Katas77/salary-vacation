package com.example.salary_vacation.dto;

import com.example.salary_vacation.validator.RequestValidator;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VacationRequest {
    @Schema(description = "Средняя зарплата сотрудника.", example = "45000.0")
    private double averageSalary;

    @Schema(description = "Количество дней отпуска.", example = "14")
    private int vacationDays;

    @Schema(description = "Дата начала отпуска.", example = "2025-01-01")
    private LocalDate startDate;

    @Schema(description = "Дата окончания отпуска.", example = "2025-01-31")
    private LocalDate endDate;
    public void validate() {
        new RequestValidator().validate(this);
    }
}
