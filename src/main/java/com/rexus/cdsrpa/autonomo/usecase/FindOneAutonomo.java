package com.rexus.cdsrpa.autonomo.usecase;

import com.rexus.cdsrpa.autonomo.dto.AutonomoIdDto;
import com.rexus.cdsrpa.autonomo.repository.AutonomoRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;

@ApplicationScoped
public class FindOneAutonomo {

    private final AutonomoRepository autonomoRepository;

    public FindOneAutonomo(AutonomoRepository autonomoRepository) {
        this.autonomoRepository = autonomoRepository;
    }

    public Optional<AutonomoIdDto> execute(int id) {
        return autonomoRepository.findAutonomoById(id);
    }
}