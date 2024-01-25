package com.github.throyer.cars.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "kilometers")
    private Integer kilometers;

    @Column(name = "color", length = 150)
    private String color;

    @Column(name = "description", length = 300)
    private String description;

    @Column(name = "available")
    private Boolean available;

    @Column(name = "year")
    private Integer year;

    @JoinColumn(name = "model_id")
    @ManyToOne
    private Model model;

    @ManyToMany
    @JoinTable(
        name = "vehicle_optional",
        joinColumns = {@JoinColumn(name = "vehicle_id")},
        inverseJoinColumns = {@JoinColumn(name = "optional_id")}
    )
    private List<Optional> optionals;

    public Vehicle(Integer kilometers, String color, String description, Integer year, Model model) {
        this.kilometers = kilometers;
        this.color = color;
        this.description = description;
        this.available = true;
        this.year = year;
        this.model = model;
        this.optionals = List.of();
    }
}
