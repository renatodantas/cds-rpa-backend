package com.rexus.cdsrpa.cargo.repository;

import com.rexus.cdsrpa.cargo.dto.CargoDto;
import com.rexus.cdsrpa.cargo.dto.CargoIdDto;
import com.rexus.cdsrpa.shared.PaginationInput;
import com.rexus.cdsrpa.shared.PaginationOutput;

import java.util.Optional;

public interface CargoRepository {

    PaginationOutput<CargoIdDto> findAllCargos(PaginationInput pagination);
    Optional<CargoIdDto> findCargoById(int id);
    void createCargo(CargoDto cargo);
    void updateCargo(int id, CargoDto cargo);
    void removeCargo(int id);
    boolean isCargoExists(int id);

}