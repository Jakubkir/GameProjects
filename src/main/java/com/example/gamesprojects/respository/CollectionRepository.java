package com.example.gamesprojects.respository;

import com.example.gamesprojects.domain.Collection;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Repository
@Transactional
public interface CollectionRepository {

    @Override
    List<Collection> findAll();

    @Override
    Collection save(Collection collection);

    @Override
    Optional<Collection> findById(Long id);

    @Override
    void deleteById(Long id);
}
}
