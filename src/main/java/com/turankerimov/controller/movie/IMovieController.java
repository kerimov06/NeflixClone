package com.turankerimov.controller.movie;

import com.turankerimov.dto.movie.MovieDtoIU;
import com.turankerimov.dto.movie.MovieResponseDto;

public interface IMovieController {

     public MovieResponseDto saveMovie(MovieDtoIU saveMovie);
}
