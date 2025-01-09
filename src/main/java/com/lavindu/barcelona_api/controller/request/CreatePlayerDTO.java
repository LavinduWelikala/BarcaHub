package com.lavindu.barcelona_api.controller.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreatePlayerDTO {


@NotNull(message = "Name is required")
private String name;

        @NotNull(message = "Age is required")
        private Integer age;

        @NotNull(message = "Position is required")
        private String position;

        @NotNull(message = "Jersey number is required")
        private Integer jerseyNumber;

        @NotNull(message = "Nationality is required")
        private String nationality;

        @NotNull(message = "Club ID is required")
        private Long clubId;


}
