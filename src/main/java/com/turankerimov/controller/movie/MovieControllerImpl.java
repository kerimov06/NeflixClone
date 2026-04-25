package com.turankerimov.controller.movie;

import com.turankerimov.dto.movie.MovieDtoIU;
import com.turankerimov.dto.movie.MovieResponseDto;
import com.turankerimov.service.movie.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/getMovieById/{id}")
    @Override
    public ResponseEntity<MovieResponseDto> getMovieById(@PathVariable(name = "id") Long id) {
        return movieService.getMovieById(id);
    }

    @GetMapping("/search")
    @Override
    public ResponseEntity<List<MovieResponseDto>> getMovieByTitle(@RequestParam(name = "title")
                                                                String title) {
        return movieService.getMovieByTitle(title);
    }
}
