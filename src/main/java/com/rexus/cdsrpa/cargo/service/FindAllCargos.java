package com.rexus.cdsrpa.cargo.service;

import com.rexus.cdsrpa.cargo.entity.Cargo;
import com.rexus.cdsrpa.cargo.repository.CargoRepository;
import com.rexus.cdsrpa.shared.PaginationInput;
import com.rexus.cdsrpa.shared.PaginationOutput;

public class FindAllCargos {

    private final CargoRepository cargoRepository;

    public FindAllCargos(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    public PaginationOutput<Cargo> execute(PaginationInput pagination) {
        return cargoRepository.findAll(pagination);
    }
}