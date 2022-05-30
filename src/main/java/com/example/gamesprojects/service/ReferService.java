package com.example.gamesprojects.service;

import com.example.gamesprojects.domain.Refer;
import com.example.gamesprojects.respository.ReferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ReferService {

    private final ReferRepository referRepository;

    public List<Refer> getAllRefers() {
        return referRepository.findAll();
    }

    public Refer getRefer(final Long id) throws ReferNotFoundException {
        return referRepository.findById(id).orElseThrow(ReferNotFoundException::new);
    }

    public Refer saveRefer(final Refer refer) {
        return referRepository.save(refer);
    }

    public void deleteRefer(final Long id) throws ReferNotFoundException {
        try {
            referRepository.deleteById(id);
        } catch (Exception e) {
            throw new ReferNotFoundException();
        }
    }
}
