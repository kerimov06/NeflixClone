package com.turankerimov.dto.movie;

import com.turankerimov.entity.Genre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieResponseDto {

    private Long id;
    private String title;
    private String description;
    private Integer releaseYear;
    private Genre genre;

    private Double averageRating;
    private Integer ratingCount;
}
