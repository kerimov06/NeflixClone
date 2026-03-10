package com.turankerimov.dto.rating;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RatingResponseDto {

    private Long id;

    private Integer rating;
}
