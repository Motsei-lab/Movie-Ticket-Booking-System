package com.mecerintered.movie.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="tickets")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Tickets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="custName",nullable =false)
    private String customerName;

    @Column(name="seatNumber",nullable = false)
    private int seatNumber;

    //many tickets belong to one showtime
    @ManyToOne
    @JoinColumn(name="showtime_id",nullable=false)
    private ShowTime showTime;
}
