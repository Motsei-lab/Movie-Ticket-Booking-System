package com.mecerintered.movie.Respository;

import com.mecerintered.movie.Entities.Movies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRespository extends JpaRepository<Movies,Long> {

}
