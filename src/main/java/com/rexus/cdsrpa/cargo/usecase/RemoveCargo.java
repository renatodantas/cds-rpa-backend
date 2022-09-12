package com.rexus.cdsrpa.cargo.usecase;

import com.rexus.cdsrpa.cargo.domain.CargoRepository;
import com.rexus.cdsrpa.exception.ItemNaoEncontradoException;

public class RemoveCargo {

    final CargoRepository cargoRepository;

    public RemoveCargo(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    public void execute(int id) {
        if (!cargoRepository.isCargoExists(id)) {
            throw new ItemNaoEncontradoException("Cargo");
        }
        cargoRepository.remove(id);
    }
}