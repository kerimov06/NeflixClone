package com.turankerimov.service.movie;

import com.turankerimov.dto.movie.MovieDtoIU;
import com.turankerimov.dto.movie.MovieResponseDto;
import org.springframework.http.ResponseEntity;

public interface IMovieService {

    public ResponseEntity<MovieResponseDto> saveMovie(MovieDtoIU saveMovie);
}
