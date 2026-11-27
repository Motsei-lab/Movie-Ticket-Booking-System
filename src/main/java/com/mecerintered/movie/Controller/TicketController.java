package com.mecerintered.movie.Controller;

import com.mecerintered.movie.DTOs.TicketRequest;
import com.mecerintered.movie.DTOs.TicketResponse;
import com.mecerintered.movie.Service.TicketService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
@CrossOrigin(origins = "*")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping
    public ResponseEntity<TicketResponse> bookTicket(@Valid @RequestBody TicketRequest request) {
        return ResponseEntity.ok(ticketService.bookTicket(request));
    }

    @GetMapping
    public ResponseEntity<List<TicketResponse>> getAllTickets() {
        return ResponseEntity.ok(ticketService.getAllTickets());
    }
}