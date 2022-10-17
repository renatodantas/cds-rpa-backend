package com.rexus.cdsrpa.cargo.api;

import com.rexus.cdsrpa.cargo.entity.Cargo;
import com.rexus.cdsrpa.cargo.repository.CargoRepository;
import com.rexus.cdsrpa.cargo.dto.CargoDto;
import com.rexus.cdsrpa.cargo.service.*;
import com.rexus.cdsrpa.shared.PaginationInput;
import com.rexus.cdsrpa.shared.PaginationOutput;

import javax.validation.Valid;
import javax.ws.rs.*;
import java.util.Optional;

@Path("cargos")
public class CargosApi {

    private final FindAllCargos findAllCargos;
    private final FindOneCargo findOneCargo;
    private final CreateCargo createCargo;
    private final UpdateCargo updateCargo;
    private final RemoveCargo removeCargo;

    CargosApi(final CargoRepository cargoRepository) {
        this.findAllCargos = new FindAllCargos(cargoRepository);
        this.findOneCargo = new FindOneCargo(cargoRepository);
        this.createCargo = new CreateCargo(cargoRepository);
        this.updateCargo = new UpdateCargo(cargoRepository);
        this.removeCargo = new RemoveCargo(cargoRepository);
    }

    @GET
    public PaginationOutput<Cargo> findAll(@BeanParam PaginationInput pagination) {
        return this.findAllCargos.execute(pagination);
    }

    @GET
    @Path("{id}")
    public Optional<Cargo> findOne(@PathParam("id") final int id) {
        return this.findOneCargo.execute(id);
    }

    @POST
    public void createCargo(@Valid CargoDto cargo) {
        createCargo.execute(cargo);
    }

    @PATCH
    @Path("{id}")
    public void updateCargo(@PathParam("id") int id, @Valid CargoDto cargoDto) {
        updateCargo.execute(id, cargoDto);
    }

    @DELETE
    @Path("{id}")
    public void removeCargo(@PathParam("id") int id) {
        removeCargo.execute(id);
    }
}