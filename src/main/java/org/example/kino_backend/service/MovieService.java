package org.example.kino_backend.service;

import org.example.kino_backend.model.Movie;
import org.example.kino_backend.repository.MovieRepository;
import org.springframework.stereotype.Service;

@Service
public class MovieService extends CrudServiceImpl<Movie, Long> {

    public MovieService(MovieRepository repository) {
        super(repository);
    }
}
