package com.rexus.cdsrpa.cargo.domain;

import com.rexus.cdsrpa.shared.PaginationInput;
import com.rexus.cdsrpa.shared.PaginationOutput;

import javax.transaction.Transactional;

public interface CargoRepository {

    PaginationOutput<Cargo> listar(PaginationInput pagination);
    @Transactional
    void create(Cargo cargo);
    void update(Cargo cargo);
    void remove(int id);
    boolean isCargoExists(int id);

}