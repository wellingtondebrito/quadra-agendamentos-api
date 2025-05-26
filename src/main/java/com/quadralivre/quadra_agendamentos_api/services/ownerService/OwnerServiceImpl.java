package com.quadralivre.quadra_agendamentos_api.services.ownerService;

import com.quadralivre.quadra_agendamentos_api.dtos.ownersDtos.OwnerRequestDto;
import com.quadralivre.quadra_agendamentos_api.dtos.ownersDtos.OwnerResponseDto;
import com.quadralivre.quadra_agendamentos_api.entities.owner.Owner;
import com.quadralivre.quadra_agendamentos_api.mappers.ownerMapper.OwnerMapper;
import com.quadralivre.quadra_agendamentos_api.repositories.owner.OwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class OwnerServiceImpl implements OwnerService{

    private final OwnerRepository ownerRepository;
    private final OwnerMapper ownerMapper;

    @Override
    public OwnerResponseDto createOwner(OwnerRequestDto dto) {
        Owner owner = new Owner();
        ownerMapper.createEntityFromDto(dto, owner);
        ownerRepository.save(owner);
        return ownerMapper.toDto(owner);
    }

    @Override
    public List<OwnerResponseDto> getAllOwners() {
        List<Owner> owners = ownerRepository.findAll();
        return ownerMapper.toDtoList(owners);
    }

    @Override
    public OwnerResponseDto getOwnerById(Long id) {
        Owner owner = ownerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Owner not found"));
        return ownerMapper.toDto(owner);
    }

    @Override
    public OwnerResponseDto updateOwner(Long id, OwnerRequestDto dto) {
        Owner owner = ownerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Owner not found"));
        ownerMapper.updateEntityFromDto(dto, owner);
        ownerRepository.save(owner);
        return ownerMapper.toDto(owner);
    }

    @Override
    public void deleteOwner(Long id) {
        Owner owner = ownerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Owner not found"));
        ownerRepository.delete(owner);
    }

    @Override
    public Owner getOwnerByIdEntity(Long id) {
        return ownerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Owner not found with id: " + id));
    }
}
