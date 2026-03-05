package org.example.kino_backend.service;

import org.example.kino_backend.model.ReservationSeat;
import org.example.kino_backend.model.ReservationSeatId;
import org.example.kino_backend.repository.ReservationSeatRepository;
import org.springframework.stereotype.Service;

@Service
public class ReservationSeatService extends CrudServiceImpl<ReservationSeat, ReservationSeatId> {

    public ReservationSeatService(ReservationSeatRepository repository) {
        super(repository);
    }
}
