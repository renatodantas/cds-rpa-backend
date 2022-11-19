package com.rexus.cdsrpa.autonomo.usecase;

import com.rexus.cdsrpa.autonomo.dto.AutonomoDto;
import com.rexus.cdsrpa.autonomo.repository.AutonomoRepository;
import com.rexus.cdsrpa.exception.RecordNotFoundException;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.validation.Valid;

@ApplicationScoped
public class UpdateAutonomo {

    private final AutonomoRepository autonomoRepository;

    public UpdateAutonomo(AutonomoRepository autonomoRepository) {
        this.autonomoRepository = autonomoRepository;
    }

    @Transactional
    public void execute(int id, @Valid AutonomoDto dto) {
        if (!autonomoRepository.isAutonomoExists(id)) {
            throw new RecordNotFoundException("Autônomo");
        }
        autonomoRepository.updateAutonomo(id, dto);
    }
}