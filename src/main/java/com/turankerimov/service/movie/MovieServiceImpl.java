package com.turankerimov.service.movie;

import com.turankerimov.dto.movie.MovieDtoIU;
import com.turankerimov.dto.movie.MovieResponseDto;
import com.turankerimov.entity.Movie;
import com.turankerimov.repository.movie.MovieRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements IMovieService{

     private  MovieRepository movieRepository;


    @Override
    public ResponseEntity<MovieResponseDto> saveMovie(MovieDtoIU saveMovie) {

         if (saveMovie==null) {
              throw new IllegalArgumentException("saveMovie is null");
         }
        Movie movie = new Movie();
        movie.setTitle(saveMovie.getTitle());
        movie.setDescription(saveMovie.getDescription());
        movie.setGenre(saveMovie.getGenre());
        movie.setReleaseYear(saveMovie.getReleaseYear());

         Movie savedMovie = movieRepository.save(movie);

         if (savedMovie==null) {
             throw new IllegalArgumentException("savedMovie is null");
         }
         MovieResponseDto movieResponseDto = new MovieResponseDto();

           movieResponseDto.setId(savedMovie.getId());
           movieResponseDto.setTitle(savedMovie.getTitle());
           movieResponseDto.setDescription(savedMovie.getDescription());
           movieResponseDto.setAverageRating(savedMovie.getAverageRating());
           movieResponseDto.setRatingCount(savedMovie.getRatingCount());
           movieResponseDto.setGenre(savedMovie.getGenre());
           movieResponseDto.setReleaseYear(savedMovie.getReleaseYear());

        return ResponseEntity.ok(movieResponseDto);
    }
}
