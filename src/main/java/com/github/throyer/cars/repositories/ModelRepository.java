package com.github.throyer.cars.repositories;

import com.github.throyer.cars.models.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Long> { }
