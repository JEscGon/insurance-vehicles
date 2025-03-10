package com.dev.insurance_vehicles.application.repository;

import com.dev.insurance_vehicles.application.domain.Vehicle;

import java.util.List;
import java.util.Optional;

public interface VehicleRepository {
    public void save(Vehicle vehicle);
    public Optional<Vehicle> findById(Long id);
    public List<Vehicle> findAll();
    public void deleteById(Long id);
    public Optional<Vehicle> findByMatricula(String matricula);
}
