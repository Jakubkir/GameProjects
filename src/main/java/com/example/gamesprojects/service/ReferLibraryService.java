package com.example.gamesprojects.service;

import com.example.gamesprojects.domain.dto.ReferLibraryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReferLibraryService {

    private final ReferLibClient referLibClient;

    public List<ReferLibraryDtoDto> fetchRandomRefer() {
        return referLibClient.getRandomRefer();
    }
}
