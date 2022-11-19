package com.rexus.cdsrpa.autonomo.repository;

import com.rexus.cdsrpa.autonomo.dto.AutonomoDto;
import com.rexus.cdsrpa.autonomo.dto.AutonomoIdDto;
import com.rexus.cdsrpa.autonomo.entity.Autonomo;
import com.rexus.cdsrpa.autonomo.mapper.AutonomoMapper;
import com.rexus.cdsrpa.shared.PaginationInput;
import com.rexus.cdsrpa.shared.PaginationOutput;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

@ApplicationScoped
public class PanacheAutonomoRepository implements AutonomoRepository, PanacheRepositoryBase<Autonomo, Integer> {

    @Override
    public PaginationOutput<AutonomoIdDto> findAllAutonomos(PaginationInput pagination) {
        final var sort = pagination.getSortOrDefault("nome");
        final var page = pagination.getPageOrDefault();
        final var itens = findAll(sort).page(page);
        final var total = itens.count();
        final var pageCount = itens.pageCount();
        return new PaginationOutput<>(
                itens.stream().map(AutonomoMapper.INSTANCE::toIdDto).toList(),
                page.index,
                page.size,
                pageCount,
                total
        );
    }

    @Override
    public Optional<AutonomoIdDto> findAutonomoById(int id) {
        return findByIdOptional(id).map(AutonomoMapper.INSTANCE::toIdDto);
    }

    @Override
    public void createAutonomo(AutonomoDto cargoDto) {
        final var cargo = AutonomoMapper.INSTANCE.toEntity(cargoDto);
        persist(cargo);
    }

    @Override
    public void updateAutonomo(int id, AutonomoDto dto) {
        final var db = findById(id);
        db.nome = dto.nome;
        db.cpf = dto.cpf;
        db.banco = dto.banco;
        db.agencia = dto.agencia;
        db.conta = dto.conta;
        db.operacao = dto.operacao;
        db.pix = dto.pix;
        // Salvo ao sair da transação
    }

    @Override
    public void removeAutonomo(int id) {
        deleteById(id);
    }

    @Override
    public boolean isAutonomoExists(int id) {
        return findByIdOptional(id).isPresent();
    }
}