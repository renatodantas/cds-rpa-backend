package com.rexus.cdsrpa.cargo.usecase;

import com.rexus.cdsrpa.cargo.dto.CargoDto;
import com.rexus.cdsrpa.cargo.repository.CargoRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.validation.Valid;

@ApplicationScoped
public class CreateCargo {

    final CargoRepository cargoRepository;

    public CreateCargo(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    @Transactional
    public void execute(@Valid CargoDto cargoDto) {
        cargoRepository.createCargo(cargoDto);
    }
}