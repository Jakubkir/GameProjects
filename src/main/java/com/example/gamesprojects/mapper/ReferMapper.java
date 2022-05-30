package com.example.gamesprojects.mapper;

import com.example.gamesprojects.domain.Refer;
import com.example.gamesprojects.domain.dto.ReferDto;

import java.util.List;
import java.util.stream.Collectors;

public class ReferMapper {

    public Refer mapToRefer(final ReferDto referDto) {
        return new Refer(
                referDto.getId(),
                referDto.getAuthor(),
                referDto.getContent()
        );
    }

    public ReferDto mapToReferDto(final Refer refer) {
        return new ReferDto(
                refer.getId(),
                refer.getAuthor(),
                refer.getContent()
        );
    }

    public List<ReferDto> mapToReferDtoList(final List<Refer> referList) {
        return referList.stream()
                .map(this::mapToReferDto)
                .collect(Collectors.toList());
    }
}

