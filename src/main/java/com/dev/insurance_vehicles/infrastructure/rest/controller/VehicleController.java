package com.dev.insurance_vehicles.infrastructure.rest.controller;

import com.dev.insurance_vehicles.application.domain.Vehicle;
import com.dev.insurance_vehicles.application.service.VehicleService;
import com.dev.insurance_vehicles.generated.api.VehiclesApi;
import com.dev.insurance_vehicles.generated.model.VehicleDto;
import com.dev.insurance_vehicles.infrastructure.rest.controller.mapper.VehicleDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class VehicleController implements VehiclesApi {

    private final VehicleService vehicleService;
    private final VehicleDtoMapper vehicleDtoMapper;

    @Override
    public ResponseEntity<Void> save(VehicleDto vehicleDto) {
        Vehicle vehicle = vehicleDtoMapper.fromDtoToDomain(vehicleDto);
        vehicleService.save(vehicle);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Void> deleteVehicleById(String Id){
        vehicleService.deleteVehicleById(Id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<VehicleDto> getVehicleById(String id) {
        try {
            Long vehicleId = Long.parseLong(id);
            return vehicleService.findById(vehicleId)
                    .map(vehicle -> new ResponseEntity<>(vehicleDtoMapper.fromDomainToDto(vehicle), HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (NumberFormatException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<Void> updateVehicle(String id, VehicleDto vehicleDto) {
        try {
            Long vehicleId = Long.parseLong(id);
            vehicleDto.setId(vehicleId.intValue());
            Vehicle vehicle = vehicleDtoMapper.fromDtoToDomain(vehicleDto);
            vehicleService.save(vehicle);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NumberFormatException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<List<VehicleDto>> getAllVehicles() {
        List<Vehicle> vehicles = vehicleService.findAll();
        List<VehicleDto> vehicleDtoList = vehicles.stream()
                .map(vehicleDtoMapper::fromDomainToDto)
                .collect(Collectors.toList());
        return new ResponseEntity<>(vehicleDtoList, HttpStatus.OK);
    }



}
