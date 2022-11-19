package com.rexus.cdsrpa.cargo.repository;

import com.rexus.cdsrpa.cargo.dto.CargoDto;
import com.rexus.cdsrpa.cargo.dto.CargoIdDto;
import com.rexus.cdsrpa.cargo.entity.Cargo;
import com.rexus.cdsrpa.cargo.mapper.CargoMapper;
import com.rexus.cdsrpa.shared.PaginationInput;
import com.rexus.cdsrpa.shared.PaginationOutput;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

@ApplicationScoped
public class PanacheCargoRepository implements CargoRepository, PanacheRepositoryBase<Cargo, Integer> {

    @Override
    public PaginationOutput<CargoIdDto> findAllCargos(PaginationInput pagination) {
        final var sort = pagination.getSortOrDefault("nome");
        final var page = pagination.getPageOrDefault();
        final var itens = findAll(sort).page(page);
        final var total = itens.count();
        final var pageCount = itens.pageCount();
        return new PaginationOutput<>(
                itens.stream().map(CargoMapper.INSTANCE::toIdDto).toList(),
                page.index,
                page.size,
                pageCount,
                total
        );
    }

    @Override
    public Optional<CargoIdDto> findCargoById(int id) {
        return findByIdOptional(id).map(CargoMapper.INSTANCE::toIdDto);
    }

    @Override
    public void createCargo(CargoDto cargoDto) {
        final var cargo = CargoMapper.INSTANCE.toEntity(cargoDto);
        persist(cargo);
    }

    @Override
    public void updateCargo(int id, CargoDto cargoDto) {
        final var db = findById(id);
        db.nome = cargoDto.nome;
        db.codigoCentroCusto = cargoDto.codigoCentroCusto;
        db.descricaoCentroCusto = cargoDto.descricaoCentroCusto;
        // Salvo ao sair da transação
    }

    @Override
    public void removeCargo(int id) {
        deleteById(id);
    }

    @Override
    public boolean isCargoExists(int id) {
        return findByIdOptional(id).isPresent();
    }
}