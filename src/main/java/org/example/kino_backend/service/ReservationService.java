package org.example.kino_backend.service;

import org.example.kino_backend.model.Reservation;
import org.example.kino_backend.repository.ReservationRepository;
import org.springframework.stereotype.Service;

@Service
public class ReservationService extends CrudServiceImpl<Reservation, Long> {

    public ReservationService(ReservationRepository repository) {
        super(repository);
    }
}
