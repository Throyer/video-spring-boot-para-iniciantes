package com.github.throyer.cars.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreteVehicleData {
    @Min(value = 0)
    private Integer kilometers;

    @NotEmpty
    private String color;

    @NotEmpty
    private String description;

    @NotNull
    private Integer year;

    @NotNull
    private Long modelId;
}
