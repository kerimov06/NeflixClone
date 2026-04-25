package com.turankerimov.controller.movie;

import com.turankerimov.dto.movie.MovieDtoIU;
import com.turankerimov.dto.movie.MovieResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IMovieController {

     public ResponseEntity<MovieResponseDto> saveMovie(MovieDtoIU saveMovie);
     public ResponseEntity<MovieResponseDto> getMovieById(Long id);
     public ResponseEntity<List<MovieResponseDto>> getMovieByTitle(String title);
}
