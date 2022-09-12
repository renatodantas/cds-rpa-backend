package com.rexus.cdsrpa.cargo.usecase;

import com.rexus.cdsrpa.cargo.domain.Cargo;
import com.rexus.cdsrpa.cargo.domain.CargoRepository;
import com.rexus.cdsrpa.shared.PaginationInput;
import com.rexus.cdsrpa.shared.PaginationOutput;

public class FindAllCargos {

    private final CargoRepository cargoRepository;

    public FindAllCargos(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    public PaginationOutput<Cargo> execute(PaginationInput pagination) {
        return cargoRepository.listar(pagination);
    }
}