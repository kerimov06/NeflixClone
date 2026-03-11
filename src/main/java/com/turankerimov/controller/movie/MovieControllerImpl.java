package com.turankerimov.controller.movie;

import com.turankerimov.dto.movie.MovieDtoIU;
import com.turankerimov.dto.movie.MovieResponseDto;
import com.turankerimov.service.movie.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MovieControllerImpl implements IMovieController {


     @Autowired
     private  IMovieService movieService;

     @PostMapping("/saveMovie")
     @Override
    public ResponseEntity<MovieResponseDto> saveMovie(@RequestBody MovieDtoIU saveMovie) {
        return movieService.saveMovie(saveMovie);
    }
}
