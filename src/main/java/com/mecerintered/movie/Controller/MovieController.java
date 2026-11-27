package com.mecerintered.movie.Controller;

import com.mecerintered.movie.DTOs.MoviesRequest;
import com.mecerintered.movie.DTOs.MoviesResponse;
import com.mecerintered.movie.Service.MovieService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
@CrossOrigin(origins = "*")//I have annotated everything with @CrossOrigin(origins = "*") so your HTML frontend (when you connect it) won't have any CORS blocking issues.
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    public ResponseEntity<MoviesResponse> createMovie(@Valid @RequestBody MoviesRequest request){
        return ResponseEntity.ok(movieService.createMovie(request));
    }

    @GetMapping
    public ResponseEntity<List<MoviesResponse>> getAllMovies(){
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        movieService.deleteMovie(id);
        return ResponseEntity.noContent().build();
    }
}
