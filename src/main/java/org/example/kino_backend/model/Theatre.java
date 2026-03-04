package org.example.kino_backend.model;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Theatre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long theatreId;

    @Column(nullable = false)
    private int theatreNumber;

    @ManyToOne
    @JoinColumn(name = "cinema_id")
    private Cinema cinema;

    @OneToMany(mappedBy = "theatre")
    private Set<SeatRow> seatRows = new HashSet<>();

    @OneToMany(mappedBy = "theatre")
    private Set<Showing> showings = new HashSet<>();
}
