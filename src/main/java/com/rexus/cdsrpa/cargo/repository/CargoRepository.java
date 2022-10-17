package com.rexus.cdsrpa.cargo.repository;

import com.rexus.cdsrpa.cargo.entity.Cargo;
import com.rexus.cdsrpa.shared.PaginationInput;
import com.rexus.cdsrpa.shared.PaginationOutput;

import javax.transaction.Transactional;
import java.util.Optional;

public interface CargoRepository {

    PaginationOutput<Cargo> findAll(PaginationInput pagination);
    Optional<Cargo> findById(int id);
    @Transactional
    void create(Cargo cargo);
    void update(Cargo cargo);
    void remove(int id);
    boolean isCargoExists(int id);

}