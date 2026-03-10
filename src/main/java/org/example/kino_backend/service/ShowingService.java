package org.example.kino_backend.service;

import org.example.kino_backend.dto.CreateShowingRequest;
import org.example.kino_backend.dto.UpdateShowingRequest;
import org.example.kino_backend.model.Movie;
import org.example.kino_backend.model.Showing;
import org.example.kino_backend.model.Theatre;
import org.example.kino_backend.repository.MovieRepository;
import org.example.kino_backend.repository.ShowingRepository;
import org.example.kino_backend.repository.TheatreRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ShowingService extends CrudServiceImpl<Showing, Long> {

    private final ShowingRepository showingRepository;
    private final MovieRepository movieRepository;
    private final TheatreRepository theatreRepository;

    public ShowingService(
            ShowingRepository showingRepository,
            MovieRepository movieRepository,
            TheatreRepository theatreRepository
    ) {
        super(showingRepository);
        this.showingRepository = showingRepository;
        this.movieRepository = movieRepository;
        this.theatreRepository = theatreRepository;
    }

    public Showing create(CreateShowingRequest req) {

        Movie movie = loadMovie(req.movieId());
        Theatre theatre = loadTheatre(req.theatreId());
        validateStartTime(req.startTime());

        LocalDateTime start = req.startTime();
        LocalDateTime end = calculateEndTime(movie, start);

        validateNoOverlap(theatre, start, end, null);
        validatePrice(req.price());

        Showing showing = new Showing();
        showing.setMovie(movie);
        showing.setTheatre(theatre);
        showing.setStartTime(start);
        showing.setEndTime(end);
        showing.setPrice(req.price());

        return save(showing);
    }

    public Showing update(Long id, UpdateShowingRequest req) {

        Showing showing = showingRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Showing not found: " + id));

        Movie movie = loadMovie(req.movieId());
        Theatre theatre = loadTheatre(req.theatreId());
        validateStartTime(req.startTime());

        LocalDateTime start = req.startTime();
        LocalDateTime end = calculateEndTime(movie, start);

        validateNoOverlap(theatre, start, end, id);
        validatePrice(req.price());

        showing.setMovie(movie);
        showing.setTheatre(theatre);
        showing.setStartTime(start);
        showing.setEndTime(end);
        showing.setPrice(req.price());

        return showingRepository.save(showing);
    }

    private Movie loadMovie(Long movieId) {
        return movieRepository.findById(movieId)
                .orElseThrow(() -> new IllegalArgumentException("Movie not found: " + movieId));
    }

    private Theatre loadTheatre(Long theatreId) {
        return theatreRepository.findById(theatreId)
                .orElseThrow(() -> new IllegalArgumentException("Theatre not found: " + theatreId));
    }

    private void validateStartTime(LocalDateTime startTime) {
        if (startTime == null) {
            throw new IllegalArgumentException("Start time cannot be null");
        }
    }

    private LocalDateTime calculateEndTime(Movie movie, LocalDateTime start) {
        return start.plusMinutes(movie.getDuration());
    }

    private void validateNoOverlap(Theatre theatre, LocalDateTime start, LocalDateTime end, Long excludeId) {
        List<Showing> overlaps = showingRepository.findOverlappingShowings(theatre, start, end)
                .stream()
                .filter(s -> excludeId == null || !s.getId().equals(excludeId))
                .toList();

        if (!overlaps.isEmpty()) {
            throw new IllegalArgumentException(
                    "Showing overlaps with existing showing starting at " +
                            overlaps.get(0).getStartTime()
            );
        }
    }

    private void validatePrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price must be non-negative");
        }
    }
}
