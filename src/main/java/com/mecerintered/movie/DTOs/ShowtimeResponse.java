package com.mecerintered.movie.DTOs;

import com.mecerintered.movie.Entities.ShowTime;

public record ShowtimeResponse(
        Long id, String startTime, String screenRoom, Long movieId
) {
    public static ShowtimeResponse fromEntity(ShowTime showTime){
        return new ShowtimeResponse(
                showTime.getId(),
                showTime.getStartTime().toString(),
                showTime.getScreenRoom(),
                showTime.getMovie().getId()
        );
    }
}
