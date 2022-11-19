package com.rexus.cdsrpa.cargo.usecase;

import com.rexus.cdsrpa.cargo.dto.CargoIdDto;
import com.rexus.cdsrpa.cargo.repository.CargoRepository;
import com.rexus.cdsrpa.shared.PaginationInput;
import com.rexus.cdsrpa.shared.PaginationOutput;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FindAllCargos {

    private final CargoRepository cargoRepository;

    public FindAllCargos(final CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    public PaginationOutput<CargoIdDto> execute(PaginationInput pagination) {
        return cargoRepository.findAllCargos(pagination);
    }
}