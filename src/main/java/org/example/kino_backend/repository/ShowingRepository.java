package org.example.kino_backend.repository;

import org.example.kino_backend.model.Showing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowingRepository extends JpaRepository<Showing, Long> {
}
