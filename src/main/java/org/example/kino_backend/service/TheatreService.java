package org.example.kino_backend.service;

import org.example.kino_backend.model.Theatre;
import org.example.kino_backend.repository.TheatreRepository;
import org.springframework.stereotype.Service;

@Service
public class TheatreService extends CrudServiceImpl<Theatre, Long> {

    public TheatreService(TheatreRepository repository) {
        super(repository);
    }
}
