package com.rexus.cdsrpa.cargo.api;

import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.BeanParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.rexus.cdsrpa.cargo.dto.CargoDto;
import com.rexus.cdsrpa.cargo.entity.Cargo;
import com.rexus.cdsrpa.cargo.repository.CargoRepository;
import com.rexus.cdsrpa.cargo.service.CreateCargo;
import com.rexus.cdsrpa.cargo.service.FindAllCargos;
import com.rexus.cdsrpa.cargo.service.FindOneCargo;
import com.rexus.cdsrpa.cargo.service.RemoveCargo;
import com.rexus.cdsrpa.cargo.service.UpdateCargo;
import com.rexus.cdsrpa.shared.PaginationInput;
import com.rexus.cdsrpa.shared.PaginationOutput;

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
    @Transactional
    public void createCargo(@Valid CargoDto cargo) {
        createCargo.execute(cargo);
    }

    @PATCH
    @Path("{id}")
    @Transactional
    public void updateCargo(@PathParam("id") int id, @Valid CargoDto cargoDto) {
        updateCargo.execute(id, cargoDto);
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public void removeCargo(@PathParam("id") int id) {
        removeCargo.execute(id);
    }
}