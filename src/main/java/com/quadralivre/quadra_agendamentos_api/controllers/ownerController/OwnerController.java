package com.quadralivre.quadra_agendamentos_api.controllers.ownerController;

import com.quadralivre.quadra_agendamentos_api.dtos.ownersDtos.OwnerRequestDto;
import com.quadralivre.quadra_agendamentos_api.dtos.ownersDtos.OwnerResponseDto;
import com.quadralivre.quadra_agendamentos_api.services.ownerService.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/owners")
public class OwnerController {

    private final OwnerService ownerService;

    @GetMapping
    public ResponseEntity<List<OwnerResponseDto>> getAllOwners() {
        return ResponseEntity.status(HttpStatus.OK).body(ownerService.getAllOwners());
    }

    @PostMapping
    public ResponseEntity<OwnerResponseDto> createOwner(@RequestBody OwnerRequestDto ownerDto) {
        return ResponseEntity.status(201).body(ownerService.createOwner(ownerDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OwnerResponseDto> updateOwner(@PathVariable Long id, @RequestBody OwnerRequestDto ownerDto) {
        return ResponseEntity.status(HttpStatus.OK).body(ownerService.updateOwner(id, ownerDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOwner(@PathVariable Long id) {
        ownerService.deleteOwner(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
