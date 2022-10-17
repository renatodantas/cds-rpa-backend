package com.rexus.cdsrpa.cargo.service;

import com.rexus.cdsrpa.cargo.entity.Cargo;
import com.rexus.cdsrpa.cargo.repository.CargoRepository;
import com.rexus.cdsrpa.cargo.dto.CargoDto;
import com.rexus.cdsrpa.exception.ItemNaoEncontradoException;

public class UpdateCargo {

    private final CargoRepository cargoRepository;

    public UpdateCargo(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    public void execute(int id, CargoDto dto) {
        if (!cargoRepository.isCargoExists(id)) {
            throw new ItemNaoEncontradoException("Cargo");
        }
        final var cargo = new Cargo();
        cargo.id = id;
        cargo.nome = dto.nome;
        cargo.codigoCentroCusto = dto.centroCustoCodigo;
        cargo.descricaoCentroCusto = dto.centroCustoDescricao;
        cargoRepository.update(cargo);
    }
}