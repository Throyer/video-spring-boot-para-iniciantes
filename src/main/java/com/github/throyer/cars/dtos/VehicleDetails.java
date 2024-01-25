package com.github.throyer.cars.dtos;

import com.github.throyer.cars.models.Manufacturer;
import com.github.throyer.cars.models.Model;
import com.github.throyer.cars.models.Optional;
import com.github.throyer.cars.models.Vehicle;
import lombok.Getter;

import java.util.List;

@Getter
public class VehicleDetails {
    private final Long id;
    private final Integer kilometers;
    private final String color;
    private final String description;
    private final Boolean available;
    private final Integer year;
    private final VehicleModel model;
    private final List<VehicleOptional> optionals;

    public VehicleDetails(Vehicle vehicle) {
        this.id = vehicle.getId();
        this.kilometers = vehicle.getKilometers();
        this.color = vehicle.getColor();
        this.description = vehicle.getDescription();
        this.available = vehicle.getAvailable();
        this.year = vehicle.getYear();
        this.model = new VehicleModel(vehicle.getModel());
        this.optionals = vehicle.getOptionals().stream().map(VehicleOptional::new).toList();
    }

    @Getter
    public static class VehicleModel {
        private final Long id;
        private final String name;
        private final VehicleManufacturer manufacturer;

        public VehicleModel(Model model) {
            this.id = model.getId();
            this.name = model.getName();
            this.manufacturer = new VehicleManufacturer(model.getManufacturer());
        }
    }

    @Getter
    public static class VehicleManufacturer {
        private final Long id;
        private final String name;

        public VehicleManufacturer(Manufacturer manufacturer) {
            this.id = manufacturer.getId();
            this.name = manufacturer.getName();
        }
    }

    @Getter
    public static class VehicleOptional {
        private final Long id;
        private final String name;

        public VehicleOptional(Optional optional) {
            this.id = optional.getId();
            this.name = optional.getName();
        }
    }
}
