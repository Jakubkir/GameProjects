package com.example.gamesprojects.respository;

import com.example.gamesprojects.domain.Refer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface ReferRepository extends CrudRepository<Refer, Long> {

    @Override
    List<Refer> findAll();

    @Override
    Refer save(Refer refer);

    @Override
    Optional<Refer> findById(Long id);
}

