package com.rexus.cdsrpa.cargo.usecase;

import com.rexus.cdsrpa.cargo.dto.CargoIdDto;
import com.rexus.cdsrpa.cargo.repository.CargoRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

@ApplicationScoped
public class FindOneCargo {

    private final CargoRepository cargoRepository;

    public FindOneCargo(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    public Optional<CargoIdDto> execute(int id) {
        return cargoRepository.findCargoById(id);
    }
}