package com.mecerintered.movie.Repository;

import com.mecerintered.movie.Entities.Movies;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movies,Long> {
}
