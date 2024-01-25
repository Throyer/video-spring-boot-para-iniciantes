package com.github.throyer.cars.controllers;

import com.github.throyer.cars.dtos.CreteVehicleData;
import com.github.throyer.cars.dtos.UpdateVehicleData;
import com.github.throyer.cars.dtos.VehicleDetails;
import com.github.throyer.cars.models.Vehicle;
import com.github.throyer.cars.pagination.Page;
import com.github.throyer.cars.services.VehicleService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehicles")
@AllArgsConstructor
public class VehicleController {
    private final VehicleService service;

    @GetMapping
    public Page<VehicleDetails> index(Pageable pageable) {
        var page = service.find(pageable);
        return page.map(VehicleDetails::new);
    }

    @GetMapping("/{id}")
    public VehicleDetails show(@PathVariable("id") Long id) {
        var vehicle = service.getById(id);
        return new VehicleDetails(vehicle);
    }

    @PostMapping
    public VehicleDetails create(@RequestBody @Validated CreteVehicleData data) {
        var vehicle = service.create(data);
        return new VehicleDetails(vehicle);
    }

    @PutMapping("/{id}")
    public VehicleDetails update(@PathVariable("id") Long id, @RequestBody @Validated UpdateVehicleData data) {
        var vehicle = service.update(data, id);
        return new VehicleDetails(vehicle);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        service.deleteById(id);
    }
}
