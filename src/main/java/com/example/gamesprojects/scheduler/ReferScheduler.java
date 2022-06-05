package com.example.gamesprojects.scheduler;

import com.example.gamesprojects.domain.Refer;
import com.example.gamesprojects.domain.ReferLib;
import com.example.gamesprojects.mapper.ReferLibraryMapper;
import com.example.gamesprojects.refer.ReferLibFacade;
import com.example.gamesprojects.service.ReferService;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

public class ReferScheduler {
    private final ReferLibFacade referLibFacade;
    private final ReferLibraryMapper referLibraryMapper;
    private final ReferService referService;

    public ReferScheduler() {
    }

    @Scheduled(cron = "0 0 12 * * *")
    public void updateRefer() {
        List<ReferLib> referLibList = referLibFacade.fetchRandomRefer();
        List<Refer> referList = referLibraryMapper.mapToReferList(referLibList);
        for (Refer refer : referList) {
            referService.saveRefer(refer);
        }
    }
}
