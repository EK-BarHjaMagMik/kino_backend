package org.example.kino_backend.controller;

import org.example.kino_backend.model.Seat;
import org.example.kino_backend.service.SeatService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/seats")
public class SeatController extends CrudRestController<Seat, Long> {

    public SeatController(SeatService service) {
        super(service);
    }
}
