package org.example.kino_backend.repository;

import org.example.kino_backend.model.Showing;
import org.example.kino_backend.model.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowingRepository extends JpaRepository<Showing, Long> {
    List<Showing> findShowingByTheatre(Theatre theatre);
}
