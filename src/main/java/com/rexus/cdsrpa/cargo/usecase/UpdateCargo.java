package com.rexus.cdsrpa.cargo.usecase;

import com.rexus.cdsrpa.cargo.dto.CargoDto;
import com.rexus.cdsrpa.cargo.repository.CargoRepository;
import com.rexus.cdsrpa.exception.RecordNotFoundException;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.validation.Valid;

@ApplicationScoped
public class UpdateCargo {

    private final CargoRepository cargoRepository;

    public UpdateCargo(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    @Transactional
    public void execute(int id, @Valid CargoDto dto) {
        if (!cargoRepository.isCargoExists(id)) {
            throw new RecordNotFoundException("Cargo");
        }
        cargoRepository.updateCargo(id, dto);
    }
}