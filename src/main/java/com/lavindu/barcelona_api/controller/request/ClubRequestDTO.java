package com.lavindu.barcelona_api.controller.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ClubRequestDTO {

    @NotBlank(message = "Name cannot be empty")
    private String name;

    @NotBlank(message = "Motto cannot be empty")
    private String motto;

    @NotBlank(message = "President cannot be empty")
    private String president;

    @NotBlank(message = "Manager cannot be empty")
    private String manager;

    @Min(value = 1800, message = "Founded year must be realistic")
    @Max(value = 2025, message = "Founded year cannot be in the future")
    private int foundedYear;
}
