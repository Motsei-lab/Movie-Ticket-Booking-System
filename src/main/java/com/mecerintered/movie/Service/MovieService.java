package com.mecerintered.movie.Service;

import com.mecerintered.movie.DTOs.MoviesRequest;
import com.mecerintered.movie.DTOs.MoviesResponse;
import com.mecerintered.movie.Entities.Movies;
import com.mecerintered.movie.Exceptions.ResourceNotFoundException;
import com.mecerintered.movie.Repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepositpry){
        this.movieRepository = movieRepositpry;
    }

    public MoviesResponse createMovie(MoviesRequest request){
        Movies movie = request.toEntity();
        Movies saved = movieRepository.save(movie);
         return MoviesResponse.fromEntity(saved);
    }

    public List<MoviesResponse> getAllMovies(){
        return movieRepository.findAll().stream().map(MoviesResponse :: fromEntity).toList();
    }

    public void deleteMovie(Long id){
        if(!movieRepository.existsById(id)){
            throw new ResourceNotFoundException("Movie not found with Id: "+ id);
        }
        movieRepository.deleteById(id);
    }
}
