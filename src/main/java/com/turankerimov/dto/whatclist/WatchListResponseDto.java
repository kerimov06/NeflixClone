package com.turankerimov.dto.whatclist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WatchListResponseDto {

    private Long id;
    private Long movieId;
    private String movieTitle;
    private Integer releaseYear;
}
