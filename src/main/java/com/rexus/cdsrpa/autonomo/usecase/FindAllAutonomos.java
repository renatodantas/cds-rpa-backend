package com.rexus.cdsrpa.autonomo.usecase;

import com.rexus.cdsrpa.autonomo.dto.AutonomoIdDto;
import com.rexus.cdsrpa.autonomo.repository.AutonomoRepository;
import com.rexus.cdsrpa.shared.PaginationInput;
import com.rexus.cdsrpa.shared.PaginationOutput;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FindAllAutonomos {

    private final AutonomoRepository autonomoRepository;

    public FindAllAutonomos(AutonomoRepository autonomoRepository) {
        this.autonomoRepository = autonomoRepository;
    }

    public PaginationOutput<AutonomoIdDto> execute(PaginationInput pagination) {
        return autonomoRepository.findAllAutonomos(pagination);
    }
}