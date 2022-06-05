package com.example.gamesprojects.refer;

import com.example.gamesprojects.domain.Refer;
import com.example.gamesprojects.mapper.ReferMapper;
import com.example.gamesprojects.service.ReferLibraryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ReferLibFacade {
    @Autowired
    ReferLibraryService referLibraryService;

    @Autowired
    ReferMapper referMapper;

    public List<Refer> fetchRandomRefer() {
        return referMapper.mapToReferDtoList(referLibraryService.fetchRandomRefer());
    }
}
}
