package com.github.throyer.cars.repositories;

import com.github.throyer.cars.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> { }
