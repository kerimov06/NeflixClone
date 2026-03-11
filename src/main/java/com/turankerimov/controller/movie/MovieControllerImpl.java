package com.turankerimov.controller.movie;

import com.turankerimov.dto.movie.MovieDtoIU;
import com.turankerimov.dto.movie.MovieResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/mvoie")
public class MovieControllerImpl implements IMovieController {


    @Override
    public MovieResponseDto saveMovie(MovieDtoIU saveMovie) {
        return null;
    }
}
