package com.mecerintered.movie.DTOs;

import com.mecerintered.movie.Entities.ShowTime;
import com.mecerintered.movie.Entities.Tickets;
import jakarta.validation.constraints.NotNull;

public record TicketRequest(
        @NotNull(message = "Customer name is required") String customerName,
        @NotNull(message = "Seat number is required") Integer seatNumber,
        @NotNull(message = "ShowTime ID is required") Long showTimeId
) {
    public Tickets toEntity(ShowTime showTime){
        Tickets t = new Tickets();
        t.setShowTime(showTime);
        t.setCustomerName(customerName);
        t.setSeatNumber(seatNumber);

        return t;
    }
}
