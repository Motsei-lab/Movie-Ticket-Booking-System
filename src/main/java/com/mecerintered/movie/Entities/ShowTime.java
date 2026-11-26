package com.mecerintered.movie.Entities;
// this class is a join table between movies and tickets thru many to many relationship
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="showTime")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ShowTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="startTime",nullable = false)
    private LocalDateTime startTime;

    @Column(name="screenRoom",nullable = false)
    private String screenRoom;

    // Many showTimes can belong to One movie
    @ManyToOne
    @JoinColumn(name="movie_id",nullable = false)
    private Movies movie;

    // One ShowTime can many Tickets
    @OneToMany(mappedBy = "showTime",cascade = CascadeType.ALL)
    private List<Tickets> tickets;
}
