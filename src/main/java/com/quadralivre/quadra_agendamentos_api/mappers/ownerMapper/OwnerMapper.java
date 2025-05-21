package com.quadralivre.quadra_agendamentos_api.mappers.ownerMapper;





import com.quadralivre.quadra_agendamentos_api.dtos.ownersDtos.OwnerRequestDto;
import com.quadralivre.quadra_agendamentos_api.dtos.ownersDtos.OwnerResponseDto;

import com.quadralivre.quadra_agendamentos_api.entities.owner.Owner;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

import java.util.List;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OwnerMapper {

   OwnerResponseDto toDto(Owner owner);

    List<OwnerResponseDto> toDtoList(List<Owner> owners);

    Owner toEntity(OwnerRequestDto dto);

    void updateEntityFromDto(OwnerRequestDto dto, @MappingTarget Owner owner);

}
