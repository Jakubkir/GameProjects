package com.example.gamesprojects.service;

import com.example.gamesprojects.domain.dto.ReferLibraryDto;
import com.example.gamesprojects.refer.ReferLibClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReferLibraryService {

    private final ReferLibClient referLibClient;

    public List<ReferLibraryDto> fetchRandomRefer() {
        return referLibClient.getRandomRefer();
    }
}
