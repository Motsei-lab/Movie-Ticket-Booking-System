package com.mecerintered.movie.DTOs;

import com.mecerintered.movie.Entities.Tickets;

public record TicketResponse(Long id, String customerName, int seatNumber, Long showTimeId) {

    public static TicketResponse fromEntity(Tickets ticket){
        return new TicketResponse(
                ticket.getId(),
                ticket.getCustomerName(),
                ticket.getSeatNumber(),
                ticket.getShowTime().getId()
        );
    }
}
