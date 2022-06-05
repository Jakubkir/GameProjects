package com.example.gamesprojects.mapper;

import com.example.gamesprojects.domain.Refer;
import com.example.gamesprojects.domain.ReferLib;
import com.example.gamesprojects.domain.dto.ReferLibraryDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReferLibraryMapper {

    public ReferLib mapToReferLib(final ReferLibraryDto referLibDto) {
        return new ReferLib(referLibDto.getRefer_text(), referLibDto.getAuthor());
    }

    public List<ReferLib> mapToReferLibList(final List<ReferLibraryDto> referLibDtoList) {
        return referLibDtoList.stream()
                .map(this::mapToReferLib)
                .collect(Collectors.toList());
    }

    public Refer mapToRefer(final ReferLib referLib) {
        return new Refer(referLib.getAuthor(), referLib.getRefer_text());
    }

    public List<Refer> mapToReferList(final List<ReferLib> referLibList) {
        return referLibList.stream()
                .map(this::mapToRefer)
                .collect(Collectors.toList());
    }
}
