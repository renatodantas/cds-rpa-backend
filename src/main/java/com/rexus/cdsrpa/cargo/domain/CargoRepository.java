package com.rexus.cdsrpa.cargo.domain;

import java.util.List;

public interface CargoRepository {

    List<Cargo> listar();
    void create(Cargo cargo);
    void update(Cargo cargo);
    void remove(int id);
    boolean isCargoExists(int id);

}