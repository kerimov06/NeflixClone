package com.turankerimov.service.movie;

import com.turankerimov.dto.movie.MovieDtoIU;
import com.turankerimov.dto.movie.MovieResponseDto;
import com.turankerimov.entity.Movie;
import com.turankerimov.excption.BaseException;
import com.turankerimov.excption.ErrorCode;
import com.turankerimov.repository.movie.MovieRepository;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements IMovieService{

    @Autowired
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
        MovieResponseDto movieResponseDto = getMovieResponseDto(savedMovie);

        return ResponseEntity.ok(movieResponseDto);
    }

    @Override
    public ResponseEntity<MovieResponseDto> getMovieById(Long id) {
             Movie movie = movieRepository.findById(id)
                     .orElseThrow(()-> new BaseException(ErrorCode.NOT_FOUND));

               MovieResponseDto movieResponseDto = getMovieResponseDto(movie);

        return ResponseEntity.ok(movieResponseDto);
    }

    @Override
    public ResponseEntity<List<MovieResponseDto>> getMovieByTitle(String title) {
               List<Movie> movies = movieRepository.findByTitleContainingIgnoreCase(title);

               if (movies.isEmpty()) {
                   return new ResponseEntity<>(HttpStatus.NOT_FOUND);
               }

               List<MovieResponseDto> movieResponseDto= movies.
                       stream()
                       .map(this::getMovieResponseDto).toList();

               return ResponseEntity.ok(movieResponseDto);
    }

    private @NonNull MovieResponseDto getMovieResponseDto(Movie savedMovie) {
        MovieResponseDto movieResponseDto = new MovieResponseDto();

        movieResponseDto.setId(savedMovie.getId());
        movieResponseDto.setTitle(savedMovie.getTitle());
        movieResponseDto.setDescription(savedMovie.getDescription());
        movieResponseDto.setAverageRating(savedMovie.getAverageRating());
        movieResponseDto.setRatingCount(savedMovie.getRatingCount());
        movieResponseDto.setGenre(savedMovie.getGenre());
        movieResponseDto.setReleaseYear(savedMovie.getReleaseYear());
        return movieResponseDto;
    }
}
