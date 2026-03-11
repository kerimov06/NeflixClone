package com.turankerimov.controller.movie;

import com.turankerimov.dto.movie.MovieDtoIU;
import com.turankerimov.dto.movie.MovieResponseDto;
import org.springframework.http.ResponseEntity;

public interface IMovieController {

     public ResponseEntity<MovieResponseDto> saveMovie(MovieDtoIU saveMovie);
}
