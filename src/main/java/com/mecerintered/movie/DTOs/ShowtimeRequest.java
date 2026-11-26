package com.mecerintered.movie.DTOs;

import com.mecerintered.movie.Entities.Movies;
import com.mecerintered.movie.Entities.ShowTime;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record ShowtimeRequest(
        @NotNull(message = "Start time is required")
        LocalDateTime startTime,
        @NotNull(message = "Screen room is required")
        String screenRoom,
        @NotNull(message = "Movie ID is required")
        Long movieId
) {
    // We pass the Movie entity in because the DTO only has the movieId, not the whole Movie object
    public ShowTime toEntity(Movies movie){
        ShowTime showTime = new ShowTime();
        showTime.setMovie(movie);
        showTime.setScreenRoom(screenRoom);
        showTime.setStartTime(startTime);

        return showTime;
    }
}
