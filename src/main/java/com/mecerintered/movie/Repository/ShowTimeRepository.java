package com.mecerintered.movie.Repository;

import com.mecerintered.movie.Entities.ShowTime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowTimeRepository extends JpaRepository<ShowTime, Long> {
}
