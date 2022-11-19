package com.rexus.cdsrpa.autonomo.repository;

import com.rexus.cdsrpa.autonomo.dto.AutonomoDto;
import com.rexus.cdsrpa.autonomo.dto.AutonomoIdDto;
import com.rexus.cdsrpa.shared.PaginationInput;
import com.rexus.cdsrpa.shared.PaginationOutput;

import java.util.Optional;

public interface AutonomoRepository {

    PaginationOutput<AutonomoIdDto> findAllAutonomos(PaginationInput pagination);
    Optional<AutonomoIdDto> findAutonomoById(int id);
    void createAutonomo(AutonomoDto cargo);
    void updateAutonomo(int id, AutonomoDto cargo);
    void removeAutonomo(int id);
    boolean isAutonomoExists(int id);

}