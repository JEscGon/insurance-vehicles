package com.dev.insurance_vehicles.application.service;

import com.dev.insurance_vehicles.application.domain.Vehicle;
import com.dev.insurance_vehicles.application.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    public void save(Vehicle vehicle) {
        vehicleRepository.save(vehicle);
    }

    public Optional<Vehicle> findById(Long id) {
        return vehicleRepository.findById(id);
    }

    public Optional<Vehicle> findByMatricula(String matricula) {
        return vehicleRepository.findByMatricula(matricula);
    }

    public List<Vehicle> findAll() {
        return vehicleRepository.findAll();
    }

    public void deleteVehicleById(String id) {
        vehicleRepository.deleteById(Long.valueOf(id));
    }

    public void updateVehicle(Long vehicleId, Vehicle vehicle) {
        vehicleRepository.save(vehicle);
    }
}
