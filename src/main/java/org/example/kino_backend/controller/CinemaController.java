package org.example.kino_backend.controller;


import org.example.kino_backend.model.Cinema;
import org.example.kino_backend.service.CinemaService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cinemas")
public class CinemaController extends CrudRestController<Cinema, Long> {

    public CinemaController(CinemaService service) {
        super(service);
    }
}