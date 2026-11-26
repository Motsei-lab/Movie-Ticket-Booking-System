package com.mecerintered.movie.Repository;

import com.mecerintered.movie.Entities.Tickets;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Tickets,Long> {
}
