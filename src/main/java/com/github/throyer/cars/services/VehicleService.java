package com.github.throyer.cars.services;

import com.github.throyer.cars.dtos.CreteVehicleData;
import com.github.throyer.cars.dtos.UpdateVehicleData;
import com.github.throyer.cars.models.Vehicle;
import com.github.throyer.cars.pagination.Page;
import com.github.throyer.cars.repositories.ModelRepository;
import com.github.throyer.cars.repositories.VehicleRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
@AllArgsConstructor
public class VehicleService {
    private final VehicleRepository vehicleRepository;
    private final ModelRepository modelRepository;

    public Page<Vehicle> find(Pageable pageable) {
        var page = vehicleRepository.findAll(pageable);
        return new Page<>(page);
    }

    public Vehicle getById(Long id) {
        return vehicleRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "vehicle not found"));
    }

    public Vehicle create(CreteVehicleData data) {
        var model = modelRepository.findById(data.getModelId())
            .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "model not found"));

        var vehicle = new Vehicle(
            data.getKilometers(),
            data.getColor(),
            data.getDescription(),
            data.getYear(),
            model
        );

        vehicleRepository.save(vehicle);

        return vehicle;
    }

    public Vehicle update(UpdateVehicleData data, Long id) {

        var vehicle = vehicleRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "vehicle not found"));

        var model = modelRepository.findById(data.getModelId())
            .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "model not found"));

        vehicle.setKilometers(data.getKilometers());
        vehicle.setColor(data.getColor());
        vehicle.setDescription(data.getDescription());
        vehicle.setYear(data.getYear());
        vehicle.setModel(model);

        vehicleRepository.save(vehicle);

        return vehicle;
    }

    public void deleteById(Long id) {
        if (!vehicleRepository.existsById(id)) {
            throw new ResponseStatusException(NOT_FOUND, "vehicle not found");
        }

        vehicleRepository.deleteById(id);
    }
}
