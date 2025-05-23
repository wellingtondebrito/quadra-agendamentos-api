package com.quadralivre.quadra_agendamentos_api.services.ownerService;

import com.quadralivre.quadra_agendamentos_api.dtos.ownersDtos.OwnerRequestDto;
import com.quadralivre.quadra_agendamentos_api.dtos.ownersDtos.OwnerResponseDto;

import java.util.List;

public interface OwnerService {
    OwnerResponseDto createOwner(OwnerRequestDto dto);
    List<OwnerResponseDto> getAllOwners();
    OwnerResponseDto getOwnerById(Long id);
    OwnerResponseDto updateOwner(Long id, OwnerRequestDto dto);
    void deleteOwner(Long id);

}
