package org.example.kino_backend.controller;

import org.example.kino_backend.model.Movie;
import org.example.kino_backend.service.MovieService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/movies")
public class MovieController extends CrudRestController<Movie, Long> {

    public MovieController(MovieService service) {
        super(service);
    }
}
