package com.example.gamesprojects.controller;

import com.example.gamesprojects.domain.Refer;
import com.example.gamesprojects.domain.dto.ReferDto;
import com.example.gamesprojects.mapper.ReferMapper;
import com.example.gamesprojects.service.ReferService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/refer")
@RequiredArgsConstructor
public class ReferController {

    private final ReferService referService;
    private final ReferMapper referMapper;

    @GetMapping
    public ResponseEntity<List<ReferDto>> getRefers() {
        List<Refer> refers = referService.getAlRefers();
        return ResponseEntity.ok(referMapper.mapToReferDtoList(refers));
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<ReferDto> getRefer(@PathVariable Long id) throws ReferNotFoundException {
        return new ResponseEntity<>(referMapper.mapToReferDto(referService.getRefer(id)), HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<Void> deleteRefer(@PathVariable Long id) throws ReferNotFoundException {
        referService.deleteRefer(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ReferDto> updateRefer(@RequestBody ReferDto referDto) {
        Refer refer = referMapper.mapToRefer(referDto);
        Refer savedRefer = referService.saveRefer(refer);
        return ResponseEntity.ok(referMapper.mapToReferDto(savedRefer));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createRefer(@RequestBody ReferDto referDto) {
        Refer refer = referMapper.mapToRefer(referDto);
        referService.saveRefer(refer);
        return ResponseEntity.ok().build();
    }

}
