package org.example.kino_backend.service;

import org.example.kino_backend.model.Seat;
import org.example.kino_backend.repository.SeatRepository;
import org.springframework.stereotype.Service;

@Service
public class SeatService extends CrudServiceImpl<Seat, Long> {

    public SeatService(SeatRepository repository) {
        super(repository);
    }
}
