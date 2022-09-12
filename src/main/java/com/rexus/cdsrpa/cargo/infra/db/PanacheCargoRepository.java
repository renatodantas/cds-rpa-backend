package com.rexus.cdsrpa.cargo.infra.db;

import com.rexus.cdsrpa.cargo.domain.Cargo;
import com.rexus.cdsrpa.cargo.domain.CargoRepository;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Sort;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class PanacheCargoRepository implements CargoRepository, PanacheRepositoryBase<Cargo, Integer> {

    @Override
    public List<Cargo> listar() {
        return listAll(Sort.by("nome"));
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