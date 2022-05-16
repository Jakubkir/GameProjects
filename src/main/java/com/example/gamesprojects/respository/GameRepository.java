package com.example.gamesprojects.respository;

import com.example.gamesprojects.domain.Game;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface GameRepository extends CrudRepository<Game, Long> {

    @Override
    List<Game> findAll();

    @Override
    Game save(Game game);

    @Override
    Optional<Game> findById(Long id);
}