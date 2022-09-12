package com.rexus.cdsrpa.cargo.usecase;

import com.rexus.cdsrpa.cargo.domain.Cargo;
import com.rexus.cdsrpa.cargo.domain.CargoRepository;

import java.util.Collections;
import java.util.List;

public class FindAllCargos {

    private final CargoRepository cargoRepository;

    public FindAllCargos(final CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    public List<Cargo> execute() {
        return Collections.emptyList();
    }
}