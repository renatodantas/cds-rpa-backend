package com.rexus.cdsrpa.cargo.service;

import com.rexus.cdsrpa.cargo.entity.Cargo;
import com.rexus.cdsrpa.cargo.repository.CargoRepository;

import java.util.Optional;

public class FindOneCargo {

    private final CargoRepository cargoRepository;

    public FindOneCargo(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    public Optional<Cargo> execute(int id) {
        return cargoRepository.findById(id);
    }
}