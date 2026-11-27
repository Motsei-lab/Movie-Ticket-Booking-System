package com.mecerintered.movie.Service;

import com.mecerintered.movie.DTOs.TicketRequest;
import com.mecerintered.movie.DTOs.TicketResponse;
import com.mecerintered.movie.Entities.ShowTime;
import com.mecerintered.movie.Entities.Tickets;
import com.mecerintered.movie.Exceptions.ResourceNotFoundException;
import com.mecerintered.movie.Repository.ShowTimeRepository;
import com.mecerintered.movie.Repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;
    private final ShowTimeRepository showTimeRepository;

    public TicketService(TicketRepository ticketRepository,ShowTimeRepository showTimeRepository){
        this.showTimeRepository =showTimeRepository;
        this.ticketRepository =ticketRepository;
    }

    public TicketResponse bookTicket(TicketRequest request){
        ShowTime showTime = showTimeRepository.findById(request.showTimeId()).orElseThrow(()-> new ResourceNotFoundException("ShowTime not found with id: " + request.showTimeId()));

        Tickets ticket = request.toEntity(showTime);
        Tickets saved = ticketRepository.save(ticket);
        return TicketResponse.fromEntity(saved);
    }

    public List<TicketResponse> getAllTickets(){
        return ticketRepository.findAll().stream().map(TicketResponse :: fromEntity).toList();
    }
}
