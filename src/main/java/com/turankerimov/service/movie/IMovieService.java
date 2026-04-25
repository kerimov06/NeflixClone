package com.turankerimov.service.movie;

import com.turankerimov.dto.movie.MovieDtoIU;
import com.turankerimov.dto.movie.MovieResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IMovieService {

    public ResponseEntity<MovieResponseDto> saveMovie(MovieDtoIU saveMovie);
    public ResponseEntity<MovieResponseDto> getMovieById(Long id);
    public ResponseEntity<List<MovieResponseDto>> getMovieByTitle(String title);
    public ResponseEntity<List<MovieResponseDto>> getAllMovies();


}
