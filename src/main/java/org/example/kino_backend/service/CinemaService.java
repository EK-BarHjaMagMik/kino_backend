package org.example.kino_backend.service;


import org.example.kino_backend.model.Cinema;
import org.example.kino_backend.repository.CinemaRepository;
import org.springframework.stereotype.Service;

@Service
public class CinemaService extends CrudServiceImpl<Cinema, Long> {

    public CinemaService(CinemaRepository repository) {
        super(repository);
    }
}