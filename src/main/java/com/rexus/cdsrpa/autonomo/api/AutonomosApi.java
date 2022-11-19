package com.rexus.cdsrpa.autonomo.api;

import com.rexus.cdsrpa.autonomo.dto.AutonomoDto;
import com.rexus.cdsrpa.autonomo.dto.AutonomoIdDto;
import com.rexus.cdsrpa.autonomo.usecase.*;
import com.rexus.cdsrpa.shared.PaginationInput;
import com.rexus.cdsrpa.shared.PaginationOutput;

import javax.validation.Valid;
import javax.ws.rs.*;
import java.util.Optional;

@Path("autonomos")
public class AutonomosApi {

    private final FindAllAutonomos findAllAutonomos;
    private final FindOneAutonomo findOneAutonomo;
    private final CreateAutonomo createAutonomo;
    private final UpdateAutonomo updateAutonomo;
    private final RemoveAutonomo removeAutonomo;

    AutonomosApi(
            final FindAllAutonomos findAllAutonomos,
            final FindOneAutonomo findOneAutonomo,
            final CreateAutonomo createAutonomo,
            final UpdateAutonomo updateAutonomo,
            final RemoveAutonomo removeAutonomo) {
        this.findAllAutonomos = findAllAutonomos;
        this.findOneAutonomo = findOneAutonomo;
        this.createAutonomo = createAutonomo;
        this.updateAutonomo = updateAutonomo;
        this.removeAutonomo = removeAutonomo;
    }

    @GET
    public PaginationOutput<AutonomoIdDto> findAll(@BeanParam PaginationInput pagination) {
        return this.findAllAutonomos.execute(pagination);
    }

    @GET
    @Path("{id}")
    public Optional<AutonomoIdDto> findOne(@PathParam("id") final int id) {
        return this.findOneAutonomo.execute(id);
    }

    @POST
    public void create(@Valid AutonomoDto cargo) {
        createAutonomo.execute(cargo);
    }

    @PUT
    @Path("{id}")
    public void update(@PathParam("id") int id, @Valid AutonomoDto cargoDto) {
        updateAutonomo.execute(id, cargoDto);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") int id) {
        removeAutonomo.execute(id);
    }
}