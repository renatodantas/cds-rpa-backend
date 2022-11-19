package com.rexus.cdsrpa.cargo.api;

import com.rexus.cdsrpa.cargo.dto.CargoDto;
import com.rexus.cdsrpa.cargo.dto.CargoIdDto;
import com.rexus.cdsrpa.cargo.usecase.*;
import com.rexus.cdsrpa.shared.PaginationInput;
import com.rexus.cdsrpa.shared.PaginationOutput;

import javax.ws.rs.*;
import java.util.Optional;

@Path("cargos")
public class CargosApi {

    private final FindAllCargos findAllCargos;
    private final FindOneCargo findOneCargo;
    private final CreateCargo createCargo;
    private final UpdateCargo updateCargo;
    private final RemoveCargo removeCargo;

    CargosApi(
            final FindAllCargos findAllCargos,
            final FindOneCargo findOneCargo,
            final CreateCargo createCargo,
            final UpdateCargo updateCargo,
            final RemoveCargo removeCargo) {
        this.findAllCargos = findAllCargos;
        this.findOneCargo = findOneCargo;
        this.createCargo = createCargo;
        this.updateCargo = updateCargo;
        this.removeCargo = removeCargo;
    }

    @GET
    public PaginationOutput<CargoIdDto> findAll(@BeanParam PaginationInput pagination) {
        return this.findAllCargos.execute(pagination);
    }

    @GET
    @Path("{id}")
    public Optional<CargoIdDto> findOne(@PathParam("id") final int id) {
        return this.findOneCargo.execute(id);
    }

    @POST
    public void create(CargoDto cargo) {
        createCargo.execute(cargo);
    }

    @PUT
    @Path("{id}")
    public void update(@PathParam("id") int id, CargoDto cargoDto) {
        updateCargo.execute(id, cargoDto);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") int id) {
        removeCargo.execute(id);
    }
}