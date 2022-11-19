package com.rexus.cdsrpa.autonomo.mapper;

import com.rexus.cdsrpa.autonomo.dto.AutonomoDto;
import com.rexus.cdsrpa.autonomo.dto.AutonomoIdDto;
import com.rexus.cdsrpa.autonomo.entity.Autonomo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(unmappedTargetPolicy = IGNORE)
public interface AutonomoMapper {

    AutonomoMapper INSTANCE = Mappers.getMapper(AutonomoMapper.class);

    AutonomoDto toDto(Autonomo entity);
    AutonomoIdDto toIdDto(Autonomo entity);
    Autonomo toEntity(AutonomoDto dto);
    Autonomo toEntity(AutonomoIdDto dto);

}