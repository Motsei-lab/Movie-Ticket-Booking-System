package com.mecerintered.movie.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "Movies")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Movies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "movieTitle", nullable = false)
    private String title;

    @Column(name = "movieGenre", nullable = false)
    private String genre;

    @Column(name = "durationMinutes", nullable = false)
    private int durationMinutes;

    @OneToMany(mappedBy = "movie",cascade = CascadeType.ALL)
    private List<ShowTime> showTimes;

}
