package com.example.gamesprojects.refer;

import com.example.gamesprojects.domain.ReferLib;
import com.example.gamesprojects.mapper.ReferLibraryMapper;
import com.example.gamesprojects.service.ReferLibraryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ReferLibFacade {
    @Autowired
    ReferLibraryService referLibraryService;

    @Autowired
    ReferLibraryMapper referLibraryMapper;

    public List<ReferLib> fetchRandomRefer() {
        return referLibraryMapper.mapToReferLibList(referLibraryService.fetchRandomRefer());
    }
}
}
