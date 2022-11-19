package com.rexus.cdsrpa.autonomo.usecase;

import com.rexus.cdsrpa.autonomo.dto.AutonomoDto;
import com.rexus.cdsrpa.autonomo.repository.AutonomoRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.validation.Valid;

@ApplicationScoped
public class CreateAutonomo {

    final AutonomoRepository autonomoRepository;

    public CreateAutonomo(AutonomoRepository autonomoRepository) {
        this.autonomoRepository = autonomoRepository;
    }

    @Transactional
    public void execute(@Valid AutonomoDto dto) {
        autonomoRepository.createAutonomo(dto);
    }
}