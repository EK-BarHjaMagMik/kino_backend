package org.example.kino_backend.controller;

import org.example.kino_backend.model.Showing;
import org.example.kino_backend.service.ShowingService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/showings")
public class ShowingController extends CrudRestController<Showing, Long> {

    public ShowingController(ShowingService service) {
        super(service);
    }
}
