package com.quadralivre.quadra_agendamentos_api.controllers.sportCourtController;

import com.quadralivre.quadra_agendamentos_api.dtos.sportsCourtDtos.SportsCourtRequestDto;
import com.quadralivre.quadra_agendamentos_api.dtos.sportsCourtDtos.SportsCourtResponseDto;
import com.quadralivre.quadra_agendamentos_api.services.sportCourtSevice.SportCourtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/sport-courts")
public class SportCourtController {

    private final SportCourtService sportCourtService;

    @GetMapping
    public ResponseEntity<List<SportsCourtResponseDto>> getAllSportsCourts() {
        List<SportsCourtResponseDto> sportsCourtResponseDtos = sportCourtService.getAllSportsCourts();
        return ResponseEntity.ok(sportsCourtResponseDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SportsCourtResponseDto> getSportCourtById(@PathVariable Long id) {
        return ResponseEntity.ok(sportCourtService.getSportCourtById(id));
    }

    @PostMapping
    public ResponseEntity<SportsCourtResponseDto> createSportCourt(@RequestBody SportsCourtRequestDto sportsCourtDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(sportCourtService.createSportCourt(sportsCourtDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SportsCourtResponseDto> updateSportCourt(@PathVariable Long id, @RequestBody SportsCourtRequestDto sportsCourtDto) {
        return ResponseEntity.ok(sportCourtService.updateSportCourt(id, sportsCourtDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSportCourt(@PathVariable Long id) {
        sportCourtService.deleteSportCourt(id);
        return ResponseEntity.ok("Quadra esportiva deletada com sucesso!");
    }
}
