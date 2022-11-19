package com.rexus.cdsrpa.cargo.usecase;

import com.rexus.cdsrpa.cargo.repository.CargoRepository;
import com.rexus.cdsrpa.exception.RecordNotFoundException;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
public class RemoveCargo {

    final CargoRepository cargoRepository;

    public RemoveCargo(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    @Transactional
    public void execute(int id) {
        if (!cargoRepository.isCargoExists(id)) {
            throw new RecordNotFoundException("Cargo");
        }
        cargoRepository.removeCargo(id);
    }
}