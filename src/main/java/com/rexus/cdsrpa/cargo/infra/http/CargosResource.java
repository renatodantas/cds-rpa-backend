package com.rexus.cdsrpa.cargo.infra.http;

import com.rexus.cdsrpa.cargo.domain.Cargo;
import com.rexus.cdsrpa.cargo.domain.CargoRepository;
import com.rexus.cdsrpa.cargo.dto.CargoDto;
import com.rexus.cdsrpa.cargo.usecase.*;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@Path("cargos")
public class CargosResource {

    private final FindAllCargos findAllCargos;
    private final FindOneCargo findOneCargo;
    private final CreateCargo createCargo;
    private final UpdateCargo updateCargo;
    private final RemoveCargo removeCargo;

    CargosResource(final CargoRepository cargoRepository) {
        this.findAllCargos = new FindAllCargos(cargoRepository);
        this.findOneCargo = new FindOneCargo(cargoRepository);
        this.createCargo = new CreateCargo(cargoRepository);
        this.updateCargo = new UpdateCargo(cargoRepository);
        this.removeCargo = new RemoveCargo(cargoRepository);
    }

    @GET
    public List<Cargo> findAll() {
        return this.findAllCargos.execute();
    }

    @GET
    @Path("{id}")
    public Optional<Cargo> findOne(@PathParam("id") final int id) {
        return this.findOneCargo.execute(id);
    }

    @POST
    public Response createCargo(@Valid CargoDto cargo) {
        createCargo.execute(cargo);
        return Response.status(Response.Status.CREATED).build();
    }

    @PATCH
    @Path("{id}")
    public void updateCargo(@PathParam("id") int id, @Valid CargoDto cargoDto) {
        updateCargo.execute(id, cargoDto);
    }
}