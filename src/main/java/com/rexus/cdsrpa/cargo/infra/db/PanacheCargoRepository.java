package com.rexus.cdsrpa.cargo.infra.db;

import com.rexus.cdsrpa.cargo.domain.Cargo;
import com.rexus.cdsrpa.cargo.domain.CargoRepository;
import com.rexus.cdsrpa.shared.PaginationInput;
import com.rexus.cdsrpa.shared.PaginationOutput;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PanacheCargoRepository implements CargoRepository, PanacheRepositoryBase<Cargo, Integer> {

    @Override
    public PaginationOutput<Cargo> listar(PaginationInput pagination) {
        final var page = pagination.getPageOrDefault();
        final var itens = findAll(pagination
                .getSortOrDefault("nome"))
                .page(page);
        final var count = itens.pageCount();
        return new PaginationOutput<>(
                itens.list(),
                page.index,
                page.size,
                count,
                itens.count()
        );
    }

    @Override
    public void create(Cargo cargo) {
        persist(cargo);
    }

    @Override
    public void update(Cargo cargo) {
        final var db = findById(cargo.id);
        db.nome = cargo.nome;
        db.codigoCentroCusto = cargo.codigoCentroCusto;
        db.descricaoCentroCusto = cargo.descricaoCentroCusto;
        // Salvo ao sair da transação
    }

    @Override
    public void remove(int id) {
        deleteById(id);
    }

    @Override
    public boolean isCargoExists(int id) {
        return findByIdOptional(id).isPresent();
    }
}