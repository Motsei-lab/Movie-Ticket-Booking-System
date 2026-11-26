package com.mecerintered.movie.DTOs;

import com.mecerintered.movie.Entities.Movies;

public record MoviesResponse(
        Long id, String title, String genre, int durationMinutes
) {
    // MUST BE STATIC to be called as MoviesResponse.fromEntity(movie)
    public static MoviesResponse fromEntity(Movies movies){
        return new MoviesResponse(
                movies.getId(),
                movies.getTitle(),
                movies.getGenre(),
                movies.getDurationMinutes()
        );
    }
}
