package com.dev.insurance_vehicles.infrastructure.rest.controller.mapper;

import com.dev.insurance_vehicles.application.domain.Vehicle;
import com.dev.insurance_vehicles.generated.model.VehicleDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VehicleDtoMapper {

    VehicleDto fromDomainToDto(Vehicle vehicleDomain);

    Vehicle fromDtoToDomain(VehicleDto vehicleDto);

}
