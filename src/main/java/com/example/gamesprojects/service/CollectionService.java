package com.example.gamesprojects.service;

import com.example.gamesprojects.domain.Collection;
import com.example.gamesprojects.exception.CollectionNotFoundException;
import com.example.gamesprojects.respository.CollectionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CollectionService {
    private final CollectionRepository collectionRepository;

    public List<Collection> getAllCollections() {
        return collectionRepository.findAll();
    }

    public Collection getCollection(final Long id) throws CollectionNotFoundException {
        return collectionRepository.findById(id).orElseThrow(CollectionNotFoundException::new);
    }

    public Collection saveCollection(final Collection collection) {
        return collectionRepository.save(collection);
    }

    public void deleteCollection(final Long id) throws CollectionNotFoundException {
        try {
            collectionRepository.deleteById(id);
        } catch (Exception e) {
            throw new CollectionNotFoundException();
        }
    }
}
