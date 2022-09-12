package com.rexus.cdsrpa.cargo.usecase;

import com.rexus.cdsrpa.cargo.domain.Cargo;
import com.rexus.cdsrpa.cargo.domain.CargoRepository;

import java.util.Optional;

public class FindOneCargo {

    private final CargoRepository cargoRepository;

    public FindOneCargo(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    public Optional<Cargo> execute(int id) {
        return Optional.empty();
    }
}