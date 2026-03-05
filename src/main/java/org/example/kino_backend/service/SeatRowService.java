package org.example.kino_backend.service;

import org.example.kino_backend.model.SeatRow;
import org.example.kino_backend.repository.SeatRowRepository;
import org.springframework.stereotype.Service;

@Service
public class SeatRowService extends CrudServiceImpl<SeatRow, Long> {

    public SeatRowService(SeatRowRepository repository) {
        super(repository);
    }
}
