package com.rexus.cdsrpa.autonomo.usecase;

import com.rexus.cdsrpa.autonomo.repository.AutonomoRepository;
import com.rexus.cdsrpa.exception.RecordNotFoundException;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
public class RemoveAutonomo {

    final AutonomoRepository autonomoRepository;

    public RemoveAutonomo(AutonomoRepository autonomoRepository) {
        this.autonomoRepository = autonomoRepository;
    }

    @Transactional
    public void execute(int id) {
        if (!autonomoRepository.isAutonomoExists(id)) {
            throw new RecordNotFoundException("Cargo");
        }
        autonomoRepository.removeAutonomo(id);
    }
}