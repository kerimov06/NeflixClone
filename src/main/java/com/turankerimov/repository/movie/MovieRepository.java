package com.turankerimov.repository.movie;

import com.turankerimov.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
        List<Movie> findByTitleContainingIgnoreCase(String title);

}
