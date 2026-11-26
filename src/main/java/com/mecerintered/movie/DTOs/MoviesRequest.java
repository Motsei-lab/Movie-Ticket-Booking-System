package com.mecerintered.movie.DTOs;

import com.mecerintered.movie.Entities.Movies;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MoviesRequest(
        @NotBlank(message="Title is required!")
        String title,
        @NotBlank(message="Genre is required")
        String genre,
        @NotNull(message="Duration is required")
        @Min(value = 1, message = "Duration must be at least 1 minute")
        int durationMinutes
) {
        public Movies toEntity(){
             Movies movie  = new Movies();
             movie.setGenre(genre);
             movie.setDurationMinutes(durationMinutes);
             movie.setTitle(title);

             return movie;
        }
}
