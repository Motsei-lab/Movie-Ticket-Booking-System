package com.mecerintered.movie.Controller;

import com.mecerintered.movie.DTOs.ShowtimeRequest;
import com.mecerintered.movie.DTOs.ShowtimeResponse;
import com.mecerintered.movie.Service.ShowTimeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/showtimes")
@CrossOrigin(origins = "*")
public class ShowTimeController {

    private final ShowTimeService showTimeService;

    public ShowTimeController(ShowTimeService showTimeService) {
        this.showTimeService = showTimeService;
    }

    @PostMapping
    public ResponseEntity<ShowtimeResponse> createShowTime(@Valid @RequestBody ShowtimeRequest request) {
        return ResponseEntity.ok(showTimeService.create(request));
    }

    @GetMapping
    public ResponseEntity<List<ShowtimeResponse>> getAllShowTimes() {
        return ResponseEntity.ok(showTimeService.getAllShowTimes());
    }
}