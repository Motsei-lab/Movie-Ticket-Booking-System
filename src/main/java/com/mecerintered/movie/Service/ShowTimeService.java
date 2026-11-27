package com.mecerintered.movie.Service;

import com.mecerintered.movie.DTOs.ShowtimeRequest;
import com.mecerintered.movie.DTOs.ShowtimeResponse;
import com.mecerintered.movie.Entities.Movies;
import com.mecerintered.movie.Entities.ShowTime;
import com.mecerintered.movie.Exceptions.ResourceNotFoundException;
import com.mecerintered.movie.Repository.MovieRepository;
import com.mecerintered.movie.Repository.ShowTimeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowTimeService {

    private final ShowTimeRepository showTimeRepository;
    private final MovieRepository movieRepository;


    public ShowTimeService(ShowTimeRepository showTimeRepository, MovieRepository movieRepository){
        this.showTimeRepository = showTimeRepository;
        this.movieRepository = movieRepository;
    }

    public ShowtimeResponse create(ShowtimeRequest request){
        Movies movie = movieRepository.findById(request.movieId()).orElseThrow(()-> new ResourceNotFoundException("Movie not found with id: " + request.movieId()));
        ShowTime showTime = request.toEntity(movie);
        ShowTime saved = showTimeRepository.save(showTime);

        return ShowtimeResponse.fromEntity(saved);
    }

    public List<ShowtimeResponse> getAllShowTimes(){
        return showTimeRepository.findAll().stream().map(ShowtimeResponse :: fromEntity).toList();
    }
}
