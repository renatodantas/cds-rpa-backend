package com.rexus.cdsrpa.cargo.usecase;

import com.rexus.cdsrpa.cargo.domain.Cargo;
import com.rexus.cdsrpa.cargo.domain.CargoRepository;
import com.rexus.cdsrpa.cargo.dto.CargoDto;

public class CreateCargo {

    final CargoRepository cargoRepository;

    public CreateCargo(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    public void execute(CargoDto dto) {
        final var cargo = new Cargo(dto.nome, dto.codigoCentroCusto, dto.descricaoCentroCusto);
        cargoRepository.create(cargo);
    }
}