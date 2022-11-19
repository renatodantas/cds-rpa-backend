package com.rexus.cdsrpa.cargo.mapper;

import com.rexus.cdsrpa.cargo.dto.CargoDto;
import com.rexus.cdsrpa.cargo.dto.CargoIdDto;
import com.rexus.cdsrpa.cargo.entity.Cargo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(unmappedTargetPolicy = IGNORE)
public interface CargoMapper {

    CargoMapper INSTANCE = Mappers.getMapper(CargoMapper.class);

    CargoDto toDto(Cargo entity);
    CargoIdDto toIdDto(Cargo entity);
    Cargo toEntity(CargoDto dto);
    Cargo toEntity(CargoIdDto dto);

}