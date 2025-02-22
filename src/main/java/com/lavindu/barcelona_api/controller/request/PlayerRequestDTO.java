package com.lavindu.barcelona_api.controller.request;


import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PlayerRequestDTO {

        @NotBlank(message = "Name cannot be empty")
        @Pattern(regexp = "^[A-Za-z ]+$", message = "Name must contain only letters and spaces")
        private String name;

        @Min(value = 16, message = "Age must be at least 16")
        @Max(value = 45, message = "Age must not exceed 45")
        private int age;

        @NotBlank(message = "Position cannot be empty")
        @Pattern(regexp = "^(Forward|Midfielder|Defender|Goalkeeper)$", message = "Invalid position")
        private String position;

        @NotBlank(message = "Nationality cannot be empty")
        @Pattern(regexp = "^[A-Za-z ]+$", message = "Nationality must contain only letters and spaces")
        private String nationality;

        @Min(value = 1, message = "Jersey number must be at least 1")
        @Max(value = 99, message = "Jersey number must not exceed 99")
        private int jerseyNumber;

}
