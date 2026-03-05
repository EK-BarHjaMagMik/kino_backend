package org.example.kino_backend.service;

import org.example.kino_backend.model.Showing;
import org.example.kino_backend.repository.ShowingRepository;
import org.springframework.stereotype.Service;

@Service
public class ShowingService extends CrudServiceImpl<Showing, Long> {

    public ShowingService(ShowingRepository repository) {
        super(repository);
    }
}
