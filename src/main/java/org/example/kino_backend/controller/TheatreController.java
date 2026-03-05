package org.example.kino_backend.controller;

import org.example.kino_backend.model.Theatre;
import org.example.kino_backend.service.TheatreService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/theatres")
public class TheatreController extends CrudRestController<Theatre, Long> {

    public TheatreController(TheatreService service) {
        super(service);
    }
}
