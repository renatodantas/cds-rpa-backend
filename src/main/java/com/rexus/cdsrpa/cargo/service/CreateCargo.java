package com.rexus.cdsrpa.cargo.service;

import com.rexus.cdsrpa.cargo.entity.Cargo;
import com.rexus.cdsrpa.cargo.repository.CargoRepository;
import com.rexus.cdsrpa.cargo.dto.CargoDto;

public class CreateCargo {

    final CargoRepository cargoRepository;

    public CreateCargo(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    public void execute(CargoDto dto) {
        final var cargo = new Cargo(dto.nome, dto.centroCustoCodigo, dto.centroCustoDescricao);
        cargoRepository.create(cargo);
    }
}