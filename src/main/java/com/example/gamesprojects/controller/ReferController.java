package com.example.gamesprojects.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
