package com.quadralivre.quadra_agendamentos_api.controllers.athleteController;

import com.quadralivre.quadra_agendamentos_api.dtos.athleteDtos.AthleteRequestDto;
import com.quadralivre.quadra_agendamentos_api.dtos.athleteDtos.AthleteResponseDto;
import com.quadralivre.quadra_agendamentos_api.dtos.ownersDtos.OwnerRequestDto;
import com.quadralivre.quadra_agendamentos_api.dtos.ownersDtos.OwnerResponseDto;
import com.quadralivre.quadra_agendamentos_api.services.athleteService.AthleteService;
import com.quadralivre.quadra_agendamentos_api.services.ownerService.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/athletes")
public class AthleteController {

    private final AthleteService athleteService;

    @GetMapping
    public ResponseEntity<List<AthleteResponseDto>> getAllAthlete() {
        return ResponseEntity.status(HttpStatus.OK).body(athleteService.getAllAthlete());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AthleteResponseDto> getAthleteById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(athleteService.getAthleteById(id));
    }

    @PostMapping
    public ResponseEntity<AthleteResponseDto> createAthlete(@RequestBody AthleteRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(athleteService.createAthlete(dto));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<AthleteResponseDto> updateAthletePartial(@PathVariable Long id, @RequestBody AthleteRequestDto dto) {
        return ResponseEntity.status(HttpStatus.OK).body(athleteService.updateAthletePartial(id, dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AthleteResponseDto> updateAthlete(@PathVariable Long id, @RequestBody AthleteRequestDto dto) {
        return ResponseEntity.status(HttpStatus.OK).body(athleteService.updateAthlete(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAthlete(@PathVariable Long id) {
        athleteService.deleteAthlete(id);
        return ResponseEntity.ok("Atleta deletado com sucesso!");
    }
}
